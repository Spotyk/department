package com.edu.ua.kh.hetman.servlet.department;

import com.edu.ua.kh.hetman.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.LIST;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.DEPARTMENT_LIST_PAGE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.DEPARTMENT_LIST_SERVLET;

@WebServlet(DEPARTMENT_LIST_SERVLET)
public class DepartmentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        DepartmentService departmentService = (DepartmentService) httpServletRequest.getServletContext().getAttribute(DEPARTMENT_SERVICE);

        httpServletRequest.setAttribute(LIST, departmentService.getAllDepartments());
        httpServletRequest.getRequestDispatcher(DEPARTMENT_LIST_PAGE).forward(httpServletRequest, httpServletResponse);
    }
}
