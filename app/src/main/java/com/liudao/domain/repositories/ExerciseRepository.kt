package com.example.liudao.domain.repositories

import com.example.liudao.data.local.dao.ExerciseDao
import com.example.liudao.data.local.entities.ExerciseEntity
import com.example.liudao.domain.interfaces.IExerciseRepository
import com.example.liudao.domain.models.Exercise
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val dao: ExerciseDao
) : IExerciseRepository {

    override fun getAll(): Flow<List<Exercise>> =
        dao.getExercises().map { list -> list.map { it.toDomain() } }

    override suspend fun insert(exercise: Exercise): Long =
        dao.insert(exercise.toEntity())

    override suspend fun delete(exercise: Exercise) =
        dao.delete(exercise.toEntity())
}

//Mappers
fun ExerciseEntity.toDomain() = Exercise(id, name, idMuscleGroup)
fun Exercise.toEntity() = ExerciseEntity(id, name, muscleGroupId)