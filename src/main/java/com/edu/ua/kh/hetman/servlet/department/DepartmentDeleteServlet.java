package com.edu.ua.kh.hetman.servlet.department;

import com.edu.ua.kh.hetman.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.ID;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.NOT_FOUND;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.OK;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.DEPARTMENT_DELETE_SERVLET;

@WebServlet(DEPARTMENT_DELETE_SERVLET)
public class DepartmentDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        DepartmentService departmentService = (DepartmentService) httpServletRequest.getServletContext().getAttribute(DEPARTMENT_SERVICE);
        String depId = httpServletRequest.getParameter(ID);
        int departmentId = Integer.parseInt(depId);

        if (departmentService.isDepartmentIdExist(departmentId)) {
            departmentService.deleteDepartmentById(departmentId);
            httpServletResponse.setStatus(OK);
            return;
        }
        httpServletResponse.setStatus(NOT_FOUND);
    }
}
