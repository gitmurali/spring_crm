package com.murali.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author muralinutalapati
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

  @RequestMapping("/list")
  public String listCustomers(Model theModel) {
      return "list-customers";
  }
}
