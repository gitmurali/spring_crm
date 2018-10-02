package com.murali.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author muralinutalapati
 */
public class DbTestServlet extends javax.servlet.http.HttpServlet {

  @Override
  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    String pass = "root";
    String user = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/murali?useSSL=false";
    try {
      Class.forName(driver);
      try (Connection ignored = DriverManager.getConnection(jdbcUrl, user, pass)) {
        out.println("connection successful");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

