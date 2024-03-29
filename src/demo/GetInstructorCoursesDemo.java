package demo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            //get the instructor from DB
            int theID = 1;
            Instructor tempInstructor = session.get(Instructor.class,theID);

            System.out.println("Instructor: " + tempInstructor);

            //get course for the instructor
             System.out.println("Courses: " + tempInstructor.getCourses());


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {

            //clean up code: close session and factory
            session.close();
            factory.close();
        }

    }
}
