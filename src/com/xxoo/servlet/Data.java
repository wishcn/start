package com.xxoo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by xxstop on 14-6-24.
 */

/**
 * use test;
 * create table Employees
 * (
 * id int not null,
 * age int not null,
 * first varchar (255),
 * last varchar (255)
 * );
 * INSERT INTO Employees VALUES (100, 18, 'Zara', 'Ali');
 * INSERT INTO Employees VALUES (101, 25, 'Mahnaz', 'Fatma');
 * INSERT INTO Employees VALUES (102, 30, 'Zaid', 'Khan');
 * INSERT INTO Employees VALUES (103, 28, 'Sumit', 'Mittal');
 */
public class Data extends HttpServlet {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;

        String title = "Database Result";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

        try{
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                out.println("ID: " + id + "<br>");
                out.println(", Age: " + age + "<br>");
                out.println(", First: " + first + "<br>");
                out.println(", Last: " + last + "<br>");
            }
            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        } //end try
    }
}
