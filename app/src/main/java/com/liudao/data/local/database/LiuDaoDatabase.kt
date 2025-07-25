package com.example.liudao.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.liudao.data.local.entities.*
import com.example.liudao.data.local.dao.*

@Database(
    entities = [
        SupplementEntity::class,
        RoutineEntity::class,
        MuscleGroupEntity::class,
        ExerciseEntity::class,
        SetEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class LiuDaoDatabase: RoomDatabase() {
    abstract fun supplementDao(): SupplementDao
    abstract fun routineDao(): RoutineDao
    abstract fun muscleGroupDao(): MuscleGroupDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun setDao(): SetDao

}