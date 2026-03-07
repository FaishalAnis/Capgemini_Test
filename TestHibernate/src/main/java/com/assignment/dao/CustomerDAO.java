package com.assignment.dao;

import java.util.List;
import com.assignment.entity.Customer;

public interface CustomerDAO {

    String saveCustomer(Customer customer);

    String updateCustomer(Customer customer);

    String deleteCustomerById(int id);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer getCustomerByEmail(String email);
}