package com.example.multipletables.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.multipletables.entities.School
import com.example.multipletables.entities.Student

data class SchoolWithStudent(
     @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
       entityColumn = "schoolName"
    )
    val students:List<Student>
)