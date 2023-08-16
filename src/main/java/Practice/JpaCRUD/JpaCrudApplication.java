package Practice.JpaCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import Practice.JpaCRUD.DAO.StudentDAO;
import Practice.JpaCRUD.Entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class JpaCrudApplication {

	public static void main(String[] args) { SpringApplication.run(JpaCrudApplication.class, args); }
		
		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			/*return runner -> {
            	System.out.println("hello world");	
			};*/
			
			return runner -> {
				createStudent(studentDAO);
			};
		}
		
		/*@Bean
		public CommandLineRunner commandLineRunnerReader(StudentDAO studentDAO) {
		
			
			return runner -> {
				readStudent(studentDAO);
			};	
		}
		
		@Bean
		public CommandLineRunner commandLineRunnerQuery(StudentDAO studentDAO) {
		
			
			return runner -> {
				queryForStudent(studentDAO);
			};	
		}
		
		@Bean
		public CommandLineRunner commandLineRunnerUpdate(StudentDAO studentDAO) {
		
			
			return runner -> {
				updateStudent(studentDAO);
			};	
		}
		
		@Bean
		public CommandLineRunner commandLineRunnerDelete(StudentDAO studentDAO) {
		
			
			return runner -> {
				deleteStudent(studentDAO);
			};	
		}
		
		@Bean
		public CommandLineRunner commandLineRunnerDeleteAll(StudentDAO studentDAO) {
		
			
			return runner -> {
				deleteAllStudent(studentDAO);
			};	
		}
		*/
		
		
			
		private void deleteAllStudent(StudentDAO studentDAO) {
			int numRowsDeleted = studentDAO.deleteAll();
			System.out.println("Deleted row count: " + numRowsDeleted);
			
		}
		

		private void deleteStudent(StudentDAO studentDAO) {
			
			int studentId  = 1;
			studentDAO.delete (studentId);		
		}
		

		private void createStudent(StudentDAO studentDAO) {
			
		System.out.println("creating new student...");
		Student student = new Student("Luca", "Iannice", "luca@gmail.com");
		
		System.out.println("saving student...");
		studentDAO.save(student);
		
		System.out.println("student saved with id " + student.getId());
		
		}
		
		
		private void readStudent(StudentDAO studentDAO) {
			@SuppressWarnings("unused")
			Student myStudent = studentDAO.findById(1);
		}
		
		
		private void queryForStudent(StudentDAO studentDAO) {
			List <Student> theStudents =  studentDAO.findAll();
			
			for (Student student : theStudents) {
				System.out.println(student);
			}
		}
		
		private void updateStudent(StudentDAO studentDAO) {
			int studentId = 1;
			System.out.println("getting student with id: " + studentId);
			Student myStudent = studentDAO.findById(studentId);
		
		    myStudent.setFirstName("Scooby");
		    studentDAO.update(myStudent);
		    System.out.println("Updated student: " + myStudent);
		}

}
