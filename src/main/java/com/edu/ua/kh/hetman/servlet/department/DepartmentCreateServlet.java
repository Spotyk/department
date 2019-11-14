package com.edu.ua.kh.hetman.servlet.department;

import com.edu.ua.kh.hetman.service.DepartmentService;
import com.edu.ua.kh.hetman.utils.ResponseWriter;
import com.edu.ua.kh.hetman.utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.NAME;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.NOT_FOUND;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.OK;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.DEPARTMENT_CREATE_SERVLET;

@WebServlet(DEPARTMENT_CREATE_SERVLET)
public class DepartmentCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        DepartmentService departmentService = (DepartmentService) httpServletRequest.getServletContext().getAttribute(DEPARTMENT_SERVICE);
        ResponseWriter responseWriter = new ResponseWriter();
        Validator validator = new Validator(new ArrayList<>(), departmentService);

        String depName = httpServletRequest.getParameter(NAME);
        if (validator.isValidString(depName) && !departmentService.isDepartmentNameExist(depName)) {
            departmentService.createDepartment(depName);
            httpServletResponse.setStatus(OK);
            return;
        }
        ArrayList<String> errors = (ArrayList<String>) validator.validatingDepartment(depName);

        errors.forEach(string -> responseWriter.responseWrite(string, httpServletResponse));

        httpServletResponse.setStatus(NOT_FOUND);
    }
}
