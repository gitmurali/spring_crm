package com.murali.crm.controller;

import com.murali.crm.entity.Customer;
import com.murali.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/showFormForAdd")
  public String addCustomer(Model theModel) {
    Customer customer = new Customer();
    theModel.addAttribute("customer", customer);
    return "customer-form";
  }

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
    customerService.saveCustomer(theCustomer);
    return "redirect:/customer/list";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
    Customer customer = customerService.getCustomer(id);
    theModel.addAttribute("customer", customer);
    return "customer-form";
  }

  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int id) {
    customerService.deleteCustomer(id);
    return "redirect:list";
  }

}
