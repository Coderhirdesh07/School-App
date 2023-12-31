package com.example.multipletables.entities

import androidx.room.Entity

@Entity
data class Student(
    val studentName:String,
    val semester:Int,
    val schoolName:String
)
