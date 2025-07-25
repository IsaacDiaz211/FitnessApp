package com.example.liudao.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.liudao.data.local.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplementDao {
    @Query("SELECT * FROM supplements")
    fun getSupplements(): Flow<List<SupplementEntity>>

    @Insert
    suspend fun insertSupplement(supplement: SupplementEntity): Long
}