package com.example.liudao.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.liudao.data.local.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MuscleGroupDao {
    @Query("SELECT * FROM muscle_groups")
    fun getMuscleGroup(): Flow<List<MuscleGroupEntity>>

    @Insert
    suspend fun insertMuscleGroup(muscleGroup: MuscleGroupEntity): Long
}