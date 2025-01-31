package com.example.ecommerce;

import java.sql.ResultSet;

public class Login {

    public Customer customerLogin(String userName, String password) {
        String loginQuery = "select * from customer where email = '" + userName + "'  AND password='" + password + "'";
        // Formulating the SQL query to check if a customer exists with the given username and password
        com.example.ecomm.DbConnection conn = new com.example.ecomm.DbConnection();// Creating a database connection object

        ResultSet rs = conn.getQueryTable(loginQuery);// Executing the query and getting the result set
        try {
            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("mobile"));
                /*If a customer with the provided credentials is found in the database,
                 the method returns a Customer object representing the authenticated customer.*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("vishwagnavikassai@gmail.com", "abc123");
        System.out.println("Welcome : "+customer.getName());//we have created customer class and had a getmethod

    }
}