package com.example.wcdexam.servlet;

import com.example.wcdexam.dao.EmployeeDAO;
import com.example.wcdexam.dao.impl.EmployeeDAOImpl;
import com.example.wcdexam.entity.EmployeeEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String birthdayStr = req.getParameter("birthday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dateFormat.parse(req.getParameter("birthday"));
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(name);
        employee.setBirthday(birthday);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setDepartment(department);
        try{
            employeeDAO.createEmployee(employee);
        }catch(Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("list.jsp");
    }
}
