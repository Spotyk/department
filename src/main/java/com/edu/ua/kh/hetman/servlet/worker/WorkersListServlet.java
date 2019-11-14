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
import java.util.ArrayList;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.LIST;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.WORKER_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.WORKER_LIST_PAGE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.WORKER_LIST_SERVLET;

@WebServlet(WORKER_LIST_SERVLET)
public class WorkersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService depService = (DepartmentService) request.getServletContext().getAttribute(DEPARTMENT_SERVICE);
        Validator validator = new Validator(new ArrayList<>(), depService);
        String departmentID = request.getParameter("depId");
        if (departmentID == null) {
            response.setStatus(400);
            return;
        }

        if (validator.isNumber(departmentID) && depService.isDepartmentIdExist(Integer.parseInt(departmentID))) {
            WorkerService workerService = (WorkerService) request.getServletContext().getAttribute(WORKER_SERVICE);
            request.setAttribute(LIST, workerService.getAllWorkersByDepartmentId(Integer.parseInt(departmentID)));
            request.setAttribute("depId", departmentID);
            request.getRequestDispatcher(WORKER_LIST_PAGE).forward(request, response);
            response.setStatus(200);
            return;
        }
        response.setStatus(400);
        return;

    }
}
