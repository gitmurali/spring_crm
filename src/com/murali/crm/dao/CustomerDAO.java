package com.murali.crm.dao;

import com.murali.crm.entity.Customer;

import java.util.List;

/**
 * @author muralinutalapati
 */
public interface CustomerDAO {
  List<Customer> getCustomers();

  void saveCustomer(Customer theCustomer);
}
