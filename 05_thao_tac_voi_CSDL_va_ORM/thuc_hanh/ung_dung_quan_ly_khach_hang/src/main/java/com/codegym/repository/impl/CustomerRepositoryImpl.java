package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery("select s from customer s", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery("select s from customer s where id = :idStudent", Customer.class);
        typedQuery.setParameter("idStudent", id);

        return typedQuery.getSingleResult();
//        return BaseRepository.entityManager.find(Student.class, id);
    }

    @Override
    public void save(Customer student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }
}
