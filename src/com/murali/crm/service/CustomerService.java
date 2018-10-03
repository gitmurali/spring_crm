package com.murali.crm.service;

import com.murali.crm.entity.Customer;
import java.util.List;

public interface CustomerService {
  List<Customer> getCustomers();

  void saveCustomer(Customer theCustomer);

  Customer getCustomer(int id);
}
