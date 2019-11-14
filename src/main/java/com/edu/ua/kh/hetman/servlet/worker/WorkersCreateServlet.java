package com.edu.ua.kh.hetman.servlet.worker;

import com.edu.ua.kh.hetman.db.dto.WorkerDTO;
import com.edu.ua.kh.hetman.entity.Worker;
import com.edu.ua.kh.hetman.service.WorkerService;
import com.edu.ua.kh.hetman.utils.ResponseWriter;
import com.edu.ua.kh.hetman.utils.Validator;
import com.edu.ua.kh.hetman.utils.WorkerDTOConverter;
import com.edu.ua.kh.hetman.utils.WorkerDTOCreator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.NOT_FOUND;
import static com.edu.ua.kh.hetman.constant.Constant.ServerStatus.OK;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.WORKER_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servlet.WORKER_CREATE_SERVLET;

@WebServlet(WORKER_CREATE_SERVLET)
public class WorkersCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        WorkerService workerService = (WorkerService) httpServletRequest.getServletContext().getAttribute(WORKER_SERVICE);
        Validator validator = new Validator(workerService);
        ResponseWriter responseWriter = new ResponseWriter();

        WorkerDTO workerDTO = WorkerDTOCreator.createWorkerDTOFromRequest(httpServletRequest);
        if (validator.isWorkerValid(workerDTO) && !workerService.isWorkerEmailExist(workerDTO.getEmail())) {
            Worker worker = WorkerDTOConverter.convertCooperatorDTOToCooperator(workerDTO);
            workerService.createWorker(worker);
            httpServletResponse.setStatus(OK);
            return;
        }
        List<String> errors = validator.validatingWorker(workerDTO);

        errors.forEach(string -> responseWriter.responseWrite(string, httpServletResponse));

        httpServletResponse.setStatus(NOT_FOUND);
    }
}
