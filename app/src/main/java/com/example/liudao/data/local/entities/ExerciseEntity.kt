package com.example.liudao.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "exercises",
    foreignKeys = [ForeignKey(
        entity = MuscleGroupEntity::class,
        parentColumns = ["id"],
        childColumns = ["idMuscleGroup"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val idMuscleGroup: Int
)