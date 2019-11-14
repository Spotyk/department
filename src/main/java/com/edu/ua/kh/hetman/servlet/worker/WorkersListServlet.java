package com.edu.ua.kh.hetman.servlet.worker;

import com.edu.ua.kh.hetman.service.DepartmentService;
import com.edu.ua.kh.hetman.service.WorkerService;
import com.edu.ua.kh.hetman.utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.DEP_ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.LIST;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.OK;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.WORKER_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.DEPARTMENT_LIST_SERVLET;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.WORKER_LIST_PAGE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.WORKER_LIST_SERVLET;

@WebServlet(WORKER_LIST_SERVLET)
public class WorkersListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService depService = (DepartmentService) request.getServletContext().getAttribute(DEPARTMENT_SERVICE);
        Validator validator = new Validator(depService);
        String departmentID = request.getParameter(DEP_ID);
        if (departmentID == null) {
            response.sendRedirect(DEPARTMENT_LIST_SERVLET);
            return;
        }

        if (validator.isNumber(departmentID) && depService.isDepartmentIdExist(Integer.parseInt(departmentID))) {
            WorkerService workerService = (WorkerService) request.getServletContext().getAttribute(WORKER_SERVICE);
            request.setAttribute(LIST, workerService.getAllWorkersByDepartmentId(Integer.parseInt(departmentID)));
            request.setAttribute(DEP_ID, departmentID);
            request.getRequestDispatcher(WORKER_LIST_PAGE).forward(request, response);
            response.setStatus(OK);
            return;
        }
        response.sendRedirect(DEPARTMENT_LIST_SERVLET);
    }
}
