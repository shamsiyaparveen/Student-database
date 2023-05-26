package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import dto.StudentDto;

public class StudentDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public void save(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.persist(studentDto);
		entityTransaction.commit();
	}
	public StudentDto fetch(String email)
	{
		List<StudentDto>list=entityManager.createQuery("select x from StudentDto x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty())
		return null;
		else
			return list.get(0);
	}
	public StudentDto fetch(long mobile)
	{
		List<StudentDto>list=entityManager.createQuery("select x from StudentDto x where mobil=?1").setParameter(1, mobile).getResultList();
		if(list.isEmpty())
			return null;
		else{
			return list.get(0);
	}

	}

public List<StudentDto>fetch()
{
	List<StudentDto>list=entityManager.createQuery("select x from StudentDto x ").getResultList();
	return list;
}

public void delete(int id){
	entityTransaction.begin();
	
	entityManager.remove(entityManager.find(StudentDto.class, id));
	entityTransaction.commit();
}

public StudentDto fetch(int id){
	return entityManager.find(StudentDto.class, id);
	
}
public void update(StudentDto StudentDto){
	entityTransaction.begin();
	
	entityManager.merge(StudentDto);
	entityTransaction.commit();
}



}

