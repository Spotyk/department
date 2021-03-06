package com.edu.ua.kh.hetman.servlet.department;

import com.edu.ua.kh.hetman.service.DepartmentService;
import com.edu.ua.kh.hetman.utils.ResponseWriter;
import com.edu.ua.kh.hetman.utils.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.NAME;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.NOT_FOUND;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.OK;
import static com.edu.ua.kh.hetman.constant.Constant.Service.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.DEPARTMENT_UPDATE_SERVLET;

@WebServlet(DEPARTMENT_UPDATE_SERVLET)
public class DepartmentUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        DepartmentService departmentService = (DepartmentService) httpServletRequest.getServletContext().getAttribute(DEPARTMENT_SERVICE);
        ResponseWriter responseWriter = new ResponseWriter();
        Validator validator = new Validator(departmentService);

        String depName = httpServletRequest.getParameter(NAME);
        String depId = httpServletRequest.getParameter("hiddenDepId");

        if (depId == null || !validator.isNumber(depId)) {
            return;
        }

        int departmentId = Integer.parseInt(depId);
        if (validator.isNumber(depId)
                && validator.isValidString(depName)
                && !departmentService.isDepartmentNameExist(depName)
                && departmentService.isDepartmentIdExist(departmentId)) {

            departmentService.updateDepartment(departmentId, depName);
            httpServletResponse.setStatus(OK);
            return;
        }
        List<String> errors = validator.validatingDepartment(depName);

        errors.forEach(string -> responseWriter.responseWrite(string, httpServletResponse));
        httpServletResponse.setStatus(NOT_FOUND);
    }
}
