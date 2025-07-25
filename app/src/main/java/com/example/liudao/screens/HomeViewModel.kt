package com.example.liudao.screens

import androidx.compose.runtime.mutableStateListOf
import com.example.liudao.data.local.entities.Exercise
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _exercises = mutableStateListOf<Exercise>()
    val exercises: List<Exercise> = _exercises

    fun addExercise(name: String) {
        _exercises.add(Exercise(name = name))
    }
}