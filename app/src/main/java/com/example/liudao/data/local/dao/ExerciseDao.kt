package com.example.liudao.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.liudao.data.local.entities.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises WHERE date = :date")
    fun getExercisesForDate(date: LocalDate): Flow<List<Exercise>>

    @Insert
    suspend fun insertExercise(exercise: Exercise): Long

    @Query("SELECT * FROM sets WHERE exerciseId = :exerciseId ORDER BY `order`")
    fun getSetsForExercise(exerciseId: Int): Flow<List<SetEntity>>

    @Insert
    suspend fun insertSet(set: SetEntity)
}