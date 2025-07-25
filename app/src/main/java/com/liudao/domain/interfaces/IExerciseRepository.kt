package com.example.liudao.domain.interfaces

import com.example.liudao.domain.models.Exercise
import kotlinx.coroutines.flow.Flow

interface IExerciseRepository {
        fun getAll(): Flow<List<Exercise>>
        suspend fun insert(exercise: Exercise): Long
        suspend fun delete(exercise: Exercise)
}