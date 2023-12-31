package com.example.multipletables.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.multipletables.dao.SchoolDao
import com.example.multipletables.entities.Director
import com.example.multipletables.entities.School
import com.example.multipletables.entities.Student
import com.example.multipletables.entities.Subject
import com.example.multipletables.relations.StudentSubjectCrossRef


@Database(
    entities = [School::class,Student::class,Director::class,Subject::class,StudentSubjectCrossRef::class],
    version = 1
)
abstract class SchoolDatabase:RoomDatabase() {

    abstract fun getSchoolDao():SchoolDao


    companion object{
        @Volatile
        private var Instance:SchoolDatabase?= null

        fun getInstance(context: Context):SchoolDatabase{
            synchronized(this){
                return Instance?:Room.databaseBuilder(
                    context.applicationContext,SchoolDatabase::class.java,"schoolDb"
                ).build().also {
                    Instance=it
                }

            }
        }




    }
}