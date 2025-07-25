package com.example.liudao.domain.interfaces

import com.example.liudao.domain.models.Routine
import kotlinx.coroutines.flow.Flow

interface IRoutineRepository {
    fun getAll(): Flow<List<Routine>>
    suspend fun insert(routine: Routine): Long
    suspend fun delete(id: Long)
}