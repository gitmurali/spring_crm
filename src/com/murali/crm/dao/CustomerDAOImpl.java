package com.murali.crm.dao;

import com.murali.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muralinutalapati
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Customer> getCustomers() {
    Session currentSession = sessionFactory.getCurrentSession();
    Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
    return theQuery.getResultList();
  }

  @Override
  public void saveCustomer(Customer theCustomer) {
    Session currentSession = sessionFactory.getCurrentSession();
    currentSession.saveOrUpdate(theCustomer);
  }

  @Override
  public Customer getCustomer(int id) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.get(Customer.class, id);
  }

  @Override
  public void deleteCustomer(int id) {
    Session currentSession = sessionFactory.getCurrentSession();
    Query query = currentSession.createQuery("delete from Customer where id=:theCustomerId");
    query.setParameter("theCustomerId", id);
    query.executeUpdate();
  }

}
