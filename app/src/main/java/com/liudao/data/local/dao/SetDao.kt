package com.example.liudao.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.liudao.data.local.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SetDao {
    @Query("SELECT * FROM sets")
    fun getSets(): Flow<List<SetEntity>>

    @Insert
    suspend fun insertSet(set: SetEntity): Long

    @Query("SELECT * FROM sets WHERE routineId = :routine ORDER BY `order` DESC")
    fun getSetsByRoutine(routine: Int): Flow<List<SetEntity>>
}