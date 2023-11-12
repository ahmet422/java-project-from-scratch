package com.example.springboot.demo.myCoolApp.dao;

import com.example.springboot.demo.myCoolApp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // specialized annotation for repositories, supports component scanning,
// translates JDBC exceptions, a sub annotation of @Component
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    // inject field
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

 //   @Transactional // from spring framework. @Transactional annotation/
    /*
    in Spring is used to demarcate a transaction, which is a group of database operations that are treated as a single unit.
    When a method is annotated with @Transactional, Spring will automatically start a transaction before the method is invoked
     and commit the transaction after the method returns. If an exception is thrown, Spring will rollback the transaction.
    The @Transactional annotation can be used at the class level or the method level. When used at the class level,
    all methods in the class will be executed within a transaction. When used at the method level, only the annotated method
    will be executed within a transaction.
    The @Transactional annotation has a number of attributes that can be used to customize the behavior of the transaction.
    These attributes include:
    isolation: The isolation level of the transaction. The default isolation level is READ_COMMITTED.
    propagation: The propagation behavior of the transaction. The default propagation behavior is REQUIRED.
    timeout: The timeout of the transaction in seconds. The default timeout is -1, which means that there is no timeout.
    read-only: Whether the transaction is read-only. The default value is false.
    rollback-for: A list of exceptions
    that will cause the transaction to be rolled back. The default value is an empty list.
    no-rollback-for: A list of exceptions that will not cause the transaction to be rolled back. The default value is an empty list.
    The @Transactional annotation is a powerful tool that can be used to manage transactions in Spring applications.
    It can help to ensure the consistency and integrity of your data.
*/
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {                                                   //  lastName is name of JPA entity, not the db column
        TypedQuery<Student> theQuery1 = entityManager.createQuery("From Student order by lastName desc", Student.class);
                                                                        // Student is name of JPA entity, not a table name
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);
        return theQuery1.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
                                                                                            // JPQL named parameter are prefixed with :
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:theData" , Student.class);
        query.setParameter("theData",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(Student student) {
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rows = entityManager.createQuery("DELETE from Student").executeUpdate();
        return rows;
    }
}
