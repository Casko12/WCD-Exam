package com.example.wcdexam.servlet;

import com.example.wcdexam.dao.EmployeeDAO;
import com.example.wcdexam.dao.impl.EmployeeDAOImpl;
import com.example.wcdexam.entity.EmployeeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(value = "/employee-list")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            EmployeeEntity st = new EmployeeEntity(
                    req.getParameter("fullName"),
                    dateFormat.parse(req.getParameter("birthday")),
                    req.getParameter("address"),
                    req.getParameter("position"),
                    req.getParameter("department")
            );
            employeeDAO.createEmployee(st);
            resp.sendRedirect("employee-servlet");
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
}
