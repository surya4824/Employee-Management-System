package com.hibernate.project.EmpManagementApp;

import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {
	
	 private static  Scanner sc = new Scanner(System.in);
     
     private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();;
     
     
    public static void main(String[] args) {
       
       System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
       
       System.out.println("press 1 ------> READ EMPLOYEE");
       System.out.println("press 2 ------> ADD EMPLOYEE");
       System.out.println("press 3 ------> REMOVE EMPLOYEE");
       System.out.println("press 4 ------> UPDATE EMPLOYEE DETAILS");
       System.out.println("Any other number to stop");
       
       
       int choice = sc.nextInt();
       
       switch(choice) {
       case 1 -> readEmployee();
       case 2 -> addEmployee();
       case 3 -> removeEmployee();
       case 4 -> updateEmployee();
       default -> {
    	   System.out.println("Choose from the given only");
    	   return;
       }
       }
    }
       private static void readEmployee() {   
    	   System.out.println("Enter the employee id to see details:");
    	   int n = sc.nextInt();
    	   Session session = factory.openSession();
    	   Transaction transact = session.beginTransaction();
    	   
    	   Employee e1 = session.get(Employee.class, n);
    	   
    	   if(e1 != null) {
    		   System.out.println("Employee ID: "+ e1.getEmpID());
    		   System.out.println("Employee NAME: "+ e1.getEmpName());
    		   System.out.println("Employee DEPT: "+ e1.getEmpDept());
    		   System.out.println("Employee SALARY: "+ e1.getEmpSalary());
    		   System.out.println("Employee JOINED DATE: "+ e1.getJoinDate());
    		   System.out.println("Employee PHONE NUMBER: "+ e1.getEmpNumber());
    	   }
    	   else {
    		   System.out.println("There is no employees with this id");
    	   }
    	   transact.commit();
    	   session.close();
    	   sc.close();
       }
       
       private static void addEmployee() {
    	   Session session = factory.openSession();
    	   Transaction transact = session.beginTransaction();
    	   
    	
    	   System.out.println("Enter the employee, id, name, department, salary, joining date(yyyy-mm-dd), phone number ");
    	   
    	   int id = sc.nextInt();
    	   String name = sc.next();
    	   String dept = sc.next();
    	   int salary = sc.nextInt();
    	   String joindate = sc.next();
    	   long numb = sc.nextLong();
    	   
    	   Employee e2 = new Employee();
    	   e2.setEmpID(id);
    	   e2.setEmpName(name);
    	   e2.setEmpDept(dept);
    	   e2.setEmpSalary(salary);
    	   e2.setJoinDate(joindate);
    	   e2.setEmpNumber(numb);
    	   
    	   session.persist(e2);
    	   
    	   transact.commit();
    	   session.close();
    	   sc.close();
    	   System.out.println("Details are added, check you database");
       }
       
       public static void removeEmployee() {
    	   Session session = factory.openSession();
    	   Transaction transact = session.beginTransaction();
    	   
    	   System.out.println("Enter the employee id to be deleted");
    	   
    	   int n = sc.nextInt();
    	   
    	   Employee e3 = session.get(Employee.class, n);
    	   
    	   if(e3 != null) {
    		   session.remove(e3);
    		   System.out.println("Employee details deleted successfully");
    	   }
    	   else {
    		   System.out.println("There is no such employee with this id");
    	   }
    	   transact.commit();
    	   session.close();
    	   sc.close();
       }
       
       public static void updateEmployee() {
    	   Session session = factory.openSession();
    	   Transaction transact = session.beginTransaction();
    	   
    	   System.out.println("Enter the employee id to be updated");
    	   int n = sc.nextInt();
    	   
    	   Employee e4 = session.get(Employee.class, n);
    	   
    	   if(e4 != null) {
    	   
    	   System.out.println("Enter the new employee name, dept, salary, joining date(yyyy-mm-dd), number");
    	   
    	   String name = sc.next();
    	   String dept = sc.next();
    	   int salary = sc.nextInt();
    	   String date = sc.next();
    	   long numb = sc.nextLong();
    	   
    	   e4.setEmpName(name);
    	   e4.setEmpDept(dept);
    	   e4.setEmpSalary(salary);
    	   e4.setJoinDate(date);
    	   e4.setEmpNumber(numb);
    	   
    	   session.update(e4);
    	   
    	   transact.commit();
    	   session.close();
    	   sc.close();
    	   
    	   System.out.println("New details are updated , check the database");
    	   }
    	   else {
    		   System.out.println("There is no such employee with this id");
    	   }
    	}
}
