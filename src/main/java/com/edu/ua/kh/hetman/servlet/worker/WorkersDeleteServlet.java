package com.edu.ua.kh.hetman.servlet.worker;

import com.edu.ua.kh.hetman.service.WorkerService;
import com.edu.ua.kh.hetman.utils.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.ID;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.NOT_FOUND;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.OK;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.WORKER_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.WORKER_DELETE_SERVLET;

@WebServlet(WORKER_DELETE_SERVLET)
public class WorkersDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        WorkerService workerService = (WorkerService) httpServletRequest.getServletContext().getAttribute(WORKER_SERVICE);
        Validator validator = new Validator(workerService);
        String workId = httpServletRequest.getParameter(ID);
        if (workId == null || !validator.isNumber(workId)) {
            httpServletResponse.setStatus(NOT_FOUND);
            return;
        }
        int workerId = Integer.parseInt(workId);

        if (workerService.isWorkerIdExist(workerId)) {
            workerService.deleteWorkerById(workerId);
            httpServletResponse.setStatus(OK);
            return;
        }
        httpServletResponse.setStatus(NOT_FOUND);
    }
}
