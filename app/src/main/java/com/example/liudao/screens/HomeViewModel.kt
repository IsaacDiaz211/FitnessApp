package com.example.liudao.screens

import androidx.compose.runtime.mutableStateListOf
import com.example.liudao.domain.models.Exercise
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _exercises = mutableStateListOf<Exercise>()
    val exercises: List<Exercise> = _exercises

    fun addExercise(name: String) {
        // Agregar un nuevo ejercicio a la lista_exercises.add(Exercise(name = name))
    }
}