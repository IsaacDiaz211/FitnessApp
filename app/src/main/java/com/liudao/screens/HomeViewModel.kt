package com.example.liudao.screens

import androidx.compose.runtime.mutableStateListOf
import com.example.liudao.domain.models.Exercise
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liudao.domain.models.Routine
import com.example.liudao.domain.models.Set
import com.example.liudao.domain.repositories.ExerciseRepository
import com.example.liudao.domain.repositories.RoutineRepository
import com.example.liudao.domain.repositories.SetRepository
import com.example.liudao.domain.repositories.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

data class PendingSet(
    val exerciseId: Long,
    val exerciseName: String,
    val weight: Float,
    val reps: Int
)

data class HomeUiState(
    val pendingSets: List<PendingSet> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val routineRepo: RoutineRepository,
    private val setRepo: SetRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun addSet(exerciseId: Long, exerciseName: String, peso: Float, reps: Int) {
        _uiState.update { current ->
            current.copy(
                pendingSets = current.pendingSets + PendingSet(
                    exerciseId = exerciseId,
                    exerciseName = exerciseName,
                    weight = peso,
                    reps = reps
                )
            )
        }
    }

    fun finishRoutine() = viewModelScope.launch {
        val newRoutine = Routine(date = LocalDate.now())
        val routine_id = routineRepo.insert(newRoutine)
        val setsRoutine = _uiState.value.pendingSets.mapIndexed { index, set ->
            Set(
                exerciseId = set.exerciseId,
                weight = set.weight,
                reps = set.reps,
                order = index + 1,
                routineId = routine_id
            )
        }
        setRepo.insertAll(setsRoutine)
        _uiState.update { it.copy(pendingSets = emptyList()) }
    }
}