package com.example.liudao.domain.interfaces

import com.example.liudao.domain.models.Set
import kotlinx.coroutines.flow.Flow

interface ISetRepository {
    fun getAll(): Flow<List<Set>>
    fun getByRoutine(routine: Int): Flow<List<Set>>
    suspend fun insert(set: Set): Long
    suspend fun delete(set: Set)
}