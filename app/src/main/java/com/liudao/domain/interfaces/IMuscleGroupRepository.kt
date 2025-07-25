package com.example.liudao.domain.interfaces

import com.example.liudao.domain.models.MuscleGroup
import kotlinx.coroutines.flow.Flow

interface IMuscleGroupRepository {
    fun getAll(): Flow<List<MuscleGroup>>
    suspend fun insert(group: MuscleGroup): Long
    suspend fun delete(id: Long)
}