package org.idk.instructorcrud;

import org.idk.instructorcrud.dao.AppDao;
import org.idk.instructorcrud.enitity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InstructorCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructorCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao theAppDao) {
        return runner -> {
//            save(theAppDao);
//            findById(theAppDao);
//            deleteInstructorById(theAppDao);
//            findInstructorDetailById(theAppDao);
//            deleteInstructorDetailById(theAppDao);
//            findCoursesByInstructorId(theAppDao);
//            findInstructorByIdJoinFetch(theAppDao);
//            updateInstructor(theAppDao);
//            updateCourse(theAppDao);
//            deleteCourseById(theAppDao);
//            createCourse(theAppDao);
//            findCourseByJoinFetch(theAppDao);
//            createCourseAndStudent(theAppDao);
//            findCourseWithStudentsById(theAppDao);
//            findStudentWithCourseById(theAppDao);
//            createStudentWithMultiCourse(theAppDao);
            deleteStudentById(theAppDao);
        };
    }
    private void createCourseAndStudent(AppDao theAppDao) {
        Course theCourse = new Course("Hoc tieng ga kieu");

        Student student1 = new Student("Son", "goku", "sonfogu@gamil.com");
        Student student2 = new Student("Son2", "goku2", "sonfogu2@gamil.com");
        Student student3 = new Student("Son3", "goku3", "sonfogu3@gamil.com");

        theCourse.addStudent(student1);
        theCourse.addStudent(student2);
        theCourse.addStudent(student3);

        theAppDao.saveCourse(theCourse);

        System.out.println("theCourse: " + theCourse);
        System.out.println("All Student: " + theCourse.getStudents());
    }

    private void createStudentWithMultiCourse(AppDao theAppDao) {
        Student theStudent = theAppDao.findStudentWithCourseById(1);

        Course theCourse1 = new Course("Say love");
        Course theCourse2 = new Course("Say i ");
        Course theCourse3 = new Course("say i love you");

        theStudent.addCourse(theCourse1);
        theStudent.addCourse(theCourse2);
        theStudent.addCourse(theCourse3);

        theAppDao.updateStudent(theStudent);

        System.out.println("theStudent: " + theStudent);
        System.out.println("All course: " + theStudent.getCourses());
    }
    private void findCourseWithStudentsById(AppDao theAppDao) {
        Course tempCourse = theAppDao.findCourseWithStudentsById(10);

        System.out.println("theCourse: " + tempCourse);
        System.out.println("All Student: " + tempCourse.getStudents());
    }
    private void findStudentWithCourseById(AppDao theAppDao) {
        Student tempStudent = theAppDao.findStudentWithCourseById(1);

        System.out.println("tempStudent " + tempStudent);
        System.out.println("All course: " + tempStudent.getCourses());
    }
    private void deleteStudentById(AppDao theAppDao) {
        theAppDao.deleteStudentById(1);
        System.out.println("Delete Success");
    }
    private void createCourse(AppDao theAppDao) {
        Course theCourse = new Course("Hoc tieng meo kieu");

        theCourse.addReview(new Review("Hhehe, boys"));
        theCourse.addReview(new Review("My wish is one day i can talk with my cat"));

        theAppDao.saveCourse(theCourse);

        System.out.println("theCourse: " + theCourse);
        System.out.println("All review: " + theCourse.getReviews());
    }

    private void findCourseByJoinFetch(AppDao theAppDao) {
        Course theCourse = theAppDao.findCourseByJoinFetch(10);

        System.out.println("theCourse: " + theCourse);
        System.out.println("All review: " + theCourse.getReviews());
    }
    private void save(AppDao theAppDao) {
        InstructorDetail theInstructorDetail = new InstructorDetail(
        "https://www.youtube.com/watch?v=FBhEqQwRZqs",
        "Lear programing"
        );

        Instructor theInstructor = new Instructor(
            "Ly",
            "tieu",
            "Long@gmail.com"
        );

        Course course1 = new Course("Course 1");
        Course course2 = new Course("Course 2");
        Course course3 = new Course("Course 3");
        Course course4 = new Course("Course 4");

        theInstructor.addCourse(course1);
        theInstructor.addCourse(course2);
        theInstructor.addCourse(course3);
        theInstructor.addCourse(course4);

        theInstructor.setInstructorDetail(theInstructorDetail);

        System.out.println("theInstructor: " + theInstructor);
        System.out.println("theInstructorDetail: " + theInstructorDetail);
        theAppDao.save(theInstructor);
    }
    private void findById(AppDao theAppDao) {
        Instructor theInstructor = theAppDao.findById(1);

        System.out.println("theInstructor : " + theInstructor);
        System.out.println("theInstructorDetail : " + theInstructor.getInstructorDetail());
    }

    private void deleteInstructorById(AppDao theAppDao) {
        theAppDao.deleteInstructorById(7);
        System.out.println("Delete success");
    }

    public void findInstructorDetailById(AppDao theAppDao) {
        InstructorDetail instructorDetail = theAppDao.findInstructorDetailById(3);

        System.out.println("instructorDetail : " + instructorDetail);
        System.out.println("instructor: " + instructorDetail.getInstructor());
    }
    public void deleteInstructorDetailById(AppDao theAppDao) {
        theAppDao.deleteInstructorDetailById(3);

        System.out.print("Delete success");
    }

    public void findCoursesByInstructorId(AppDao theAppDao) {
        List<Course> courses = theAppDao.findCoursesByInstructorId(3);

        for (Course temCourse : courses) {
            System.out.println("course: " + temCourse);
        }
    }

    public void findInstructorByIdJoinFetch(AppDao theAppDao) {
        Instructor instructor = theAppDao.findInstructorByIdJoinFetch(3);
        System.out.println("instructor: " + instructor);
        for (Course temCourse : instructor.getCourses()) {
            System.out.println("course: " + temCourse);
        }
    }
    public void updateInstructor(AppDao theAppDao) {
        Instructor instructor = theAppDao.findById(3);
        instructor.setEmail("change@gmail.com");
        instructor.setFirstName("Adams");
        instructor.setLastName("Le");

        theAppDao.updateInstructor(instructor);
        System.out.println("instructor: " + instructor);
    }

    public void updateCourse(AppDao theAppDao) {
        Instructor tempInstructor = theAppDao.findById(1);
        Course tempCourse = theAppDao.findCourseById(12);

        tempCourse.setTitle("meo meo meo");
        tempCourse.setInstructor(tempInstructor);

        theAppDao.updateCourse(tempCourse);

        System.out.println("tempCourse: " + tempCourse);
        System.out.println("ttempCourse.getInstructor(): " + tempCourse.getInstructor());
    }

    public void deleteCourseById(AppDao theAppDao) {
        theAppDao.deleteCourseById(10);
        System.out.println("Delete success");
    }
}



