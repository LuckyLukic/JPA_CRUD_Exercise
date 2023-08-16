package Practice.JpaCRUD.DAO;

import java.util.List;

import Practice.JpaCRUD.Entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	
	void update (Student theStudent);
	
	void delete(Integer id);
	
	int deleteAll();

}
