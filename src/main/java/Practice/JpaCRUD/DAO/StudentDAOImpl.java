package Practice.JpaCRUD.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Practice.JpaCRUD.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private EntityManager entityManager;
	
	

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	

	@Override
	public Student findById(Integer id) {
		
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order lastName", Student.class);
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student theStudent) {
				entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}


	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}

}
