package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.EmployeeService;

public class TestApp {

    public static void main(String[] args) {

    	ApplicationContext context =
    	        new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

        EmployeeService service =
                (EmployeeService) context.getBean("employeeService");

        service.addEmployee();
        service.getEmployee();
        service.updateEmployee();
        service.deleteEmployee();
    }
}

//Output:
//Employee Added Successfully
/*Employee ID: 101
Name: Mike
Email: mike@gmail.com
Age: 28
Salary: 60000.0
City: Bangalore
State: Karnataka
Country: India
Pincode: 560001
Employee Updated
Employee Deleted*/