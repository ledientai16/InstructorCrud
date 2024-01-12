package org.idk.instructorcrud;

import org.idk.instructorcrud.dao.AppDao;
import org.idk.instructorcrud.enitity.Instructor;
import org.idk.instructorcrud.enitity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            findInstructorDetailById(theAppDao);
        };
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
        theAppDao.deleteInstructorById(2);
        System.out.println("Delete success");

    }

    public void findInstructorDetailById(AppDao theAppDao) {
        InstructorDetail instructorDetail = theAppDao.findInstructorDetailById(3);

        System.out.println("instructorDetail : " + instructorDetail);
        System.out.println("instructor: " + instructorDetail.getInstructor());
    }
}
