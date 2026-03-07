package com.assignment.main;

import java.time.LocalDate;
import java.util.List;

import com.assignment.dao.CustomerDAO;
import com.assignment.dao.OrderDAO;
import com.assignment.daoimpl.CustomerDAOImpl;
import com.assignment.daoimpl.OrderDAOImpl;
import com.assignment.entity.Customer;
import com.assignment.entity.Order;

public class MainApp {

    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();

        Order order = new Order("ORD102","Mobile",2,30000,LocalDate.now());

        Customer customer =
                new Customer("Rahul","rahul@gmail.com",
                        "Male",9876543211L,LocalDate.now());

        customer.setOrder(order);
        order.setCustomer(customer);

        System.out.println(customerDAO.saveCustomer(customer));

        Customer c = customerDAO.getCustomerById(1);
        System.out.println("Customer Name: " + c.getCustomerName());

        List<Customer> list = customerDAO.getAllCustomers();

        for(Customer cust : list)
        {
            System.out.println(cust);
        }

        c.setCustomerName("Rahul Sharma");
        customerDAO.updateCustomer(c);

        Order o = orderDAO.getOrderById(1);
        System.out.println("Product: " + o.getProductName());

        o.setPrice(35000);
        orderDAO.updateOrder(o);

        customerDAO.deleteCustomerById(2);

    }
}