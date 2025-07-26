package com.example.liudao.domain.repositories

import com.example.liudao.data.local.dao.MuscleGroupDao
import com.example.liudao.data.local.entities.ExerciseEntity
import com.example.liudao.data.local.entities.MuscleGroupEntity
import com.example.liudao.domain.interfaces.IMuscleGroupRepository
import com.example.liudao.domain.models.Exercise
import com.example.liudao.domain.models.MuscleGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MuscleGroupRepository @Inject constructor(
    private val dao: MuscleGroupDao
): IMuscleGroupRepository {
    override fun getAll(): Flow<List<MuscleGroup>> =
        dao.getMuscleGroups().map { list -> list.map { it.toDomain() } }
    override suspend fun insert(group: MuscleGroup): Long =
        dao.insert(group.toEntity())
    override suspend fun delete(group: MuscleGroup) =
        dao.delete(group.toEntity())
}

//Mappers
fun MuscleGroupEntity.toDomain() = MuscleGroup(id, name)
fun MuscleGroup.toEntity() = MuscleGroupEntity(id, name)