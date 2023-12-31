package com.example.multipletables.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.example.multipletables.entities.Director
import com.example.multipletables.entities.School
import com.example.multipletables.entities.Student
import com.example.multipletables.entities.Subject
import com.example.multipletables.relations.SchoolAndDirector
import com.example.multipletables.relations.SchoolWithStudent
import com.example.multipletables.relations.StudentSubjectCrossRef
import com.example.multipletables.relations.StudentWithSubject
import com.example.multipletables.relations.SubjectWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = REPLACE)
   suspend fun insertSchool(school: School)

    @Insert(onConflict = REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Insert(onConflict = REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("Select * from school Where schoolName=:schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("Select * from school Where schoolName = :schoolName")
    suspend fun getStudentNameWithSchoolName(schoolName: String):List<SchoolWithStudent>

    @Transaction
    @Query("Select * from subject Where subjectName = :subjectName")
    suspend fun getStudentOfSubject(subjectName:String):List<SubjectWithStudents>

    @Transaction
    @Query("Select * from student Where studentName=:studentName")
    suspend fun getSubjectOfStudent(studentName:String):List<StudentWithSubject>


}