package org.idk.instructorcrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.idk.instructorcrud.enitity.Course;
import org.idk.instructorcrud.enitity.Instructor;
import org.idk.instructorcrud.enitity.InstructorDetail;
import org.idk.instructorcrud.enitity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{
    private EntityManager theEntityManager;
    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        theEntityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        theEntityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int id) {
        return theEntityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor theInstructor = theEntityManager.find(Instructor.class, id);
        theInstructor.getInstructorDetail().setInstructor(null);
        for (Course tempCourse : theInstructor.getCourses()) {
            tempCourse.setInstructor(null);
        }

        theEntityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return theEntityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail = theEntityManager.find(InstructorDetail.class,id);

//        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        theEntityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course>  findCoursesByInstructorId(int theId) {
        String sql = "FROM Course Where instructor.id = :data";
        TypedQuery<Course> query = theEntityManager.createQuery(sql, Course.class);
        query.setParameter("data", theId);
        List<Course> courseList = query.getResultList();

        return courseList;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        String sql = "Select i From Instructor i " +
                "Join fetch i.courses " +
                "Join fetch i.instructorDetail " +
                "Where i.id = :data";
        TypedQuery<Instructor> query = theEntityManager.createQuery(sql, Instructor.class);

        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        theEntityManager.merge(theInstructor);
    }

    @Override
    public Course findCourseById(Integer id) {
        return theEntityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        theEntityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course temCourse = theEntityManager.find(Course.class, id);

        theEntityManager.remove(temCourse);
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        theEntityManager.persist(theCourse);
    }

    @Override
    public Course findCourseByJoinFetch(int id) {
        String sql = "Select c From Course c " +
                    "Join fetch c.reviews " +
                    "Where c.id = :data";
        TypedQuery<Course> query = theEntityManager.createQuery(sql, Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseWithStudentsById(int id) {
        String sql = "Select c From Course c " +
                "Join fetch c.students " +
                "Where c.id = :data";
        TypedQuery<Course> query = theEntityManager.createQuery(sql, Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentWithCourseById(int id) {
        String sql = "Select s From Student s " +
                "Join fetch s.courses " +
                "Where s.id = :data";
        TypedQuery<Student> query = theEntityManager.createQuery(sql, Student.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        theEntityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student theStudent = theEntityManager.find(Student.class, id);
        theEntityManager.remove(theStudent);
    }
}
