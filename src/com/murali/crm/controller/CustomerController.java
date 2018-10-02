package com.murali.crm.controller;

import com.murali.crm.dao.CustomerDAO;
import com.murali.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author muralinutalapati
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

  private CustomerDAO customerDAO;

  @Autowired
  public CustomerController(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  @RequestMapping("/list")
  public String listCustomers(Model theModel) {
    List<Customer> customers = customerDAO.getCustomers();
    theModel.addAttribute("customers", customers);
    return "list-customers";
  }

}
