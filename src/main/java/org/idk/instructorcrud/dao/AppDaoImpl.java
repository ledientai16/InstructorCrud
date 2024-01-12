package org.idk.instructorcrud.dao;

import jakarta.persistence.EntityManager;
import org.idk.instructorcrud.enitity.Instructor;
import org.idk.instructorcrud.enitity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        Instructor theInstructor = findById(id);

        theEntityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return theEntityManager.find(InstructorDetail.class, id);
    }
}
