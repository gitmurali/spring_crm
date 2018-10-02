package com.murali.crm.controller;

import com.murali.crm.entity.Customer;
import com.murali.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author muralinutalapati
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomers(Model theModel) {
    List<Customer> customers = customerService.getCustomers();
    theModel.addAttribute("customers", customers);
    return "list-customers";
  }

}
