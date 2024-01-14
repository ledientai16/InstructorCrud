package org.idk.instructorcrud.dao;

import org.idk.instructorcrud.enitity.Course;
import org.idk.instructorcrud.enitity.Instructor;
import org.idk.instructorcrud.enitity.InstructorDetail;
import org.idk.instructorcrud.enitity.Student;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
    void updateInstructor(Instructor theInstructor);

    Course findCourseById(Integer id);
    void updateCourse(Course tempCourse);
    void deleteCourseById(int id);
    void saveCourse(Course theCourse);
    Course findCourseByJoinFetch(int id);

    Course findCourseWithStudentsById(int id);
    Student findStudentWithCourseById(int id);
    void updateStudent(Student theStudent);
    void deleteStudentById(int id);
}
