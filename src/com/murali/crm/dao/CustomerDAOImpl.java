package com.murali.crm.dao;

import com.murali.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author muralinutalapati
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    Session currentSession = sessionFactory.getCurrentSession();
    Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
    return theQuery.getResultList();
  }
}
