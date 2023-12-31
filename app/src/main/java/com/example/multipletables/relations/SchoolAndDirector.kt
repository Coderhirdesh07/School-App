package com.example.multipletables.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.multipletables.entities.Director
import com.example.multipletables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)