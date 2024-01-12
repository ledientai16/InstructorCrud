package org.idk.instructorcrud.dao;

import org.idk.instructorcrud.enitity.Instructor;
import org.idk.instructorcrud.enitity.InstructorDetail;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
}
