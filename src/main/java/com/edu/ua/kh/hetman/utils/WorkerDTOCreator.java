package com.edu.ua.kh.hetman.utils;

import com.edu.ua.kh.hetman.db.dto.WorkerDTO;

import javax.servlet.http.HttpServletRequest;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.DEP_ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.EMAIL;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.NAME;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.OLD_WORKER_EMAIL;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.SALARY;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.WORKER_ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.WORK_DATE;

public class WorkerDTOCreator {

    public static WorkerDTO createWorkerDTOFromRequest(HttpServletRequest request) {
        WorkerDTO workerDTO = new WorkerDTO();

        workerDTO.setId(request.getParameter(WORKER_ID) == null ? String.valueOf(0) : request.getParameter(WORKER_ID));
        workerDTO.setDepartmentId(request.getParameter(DEP_ID));
        workerDTO.setName(request.getParameter(NAME));
        workerDTO.setEmail(request.getParameter(EMAIL));
        workerDTO.setDate(request.getParameter(WORK_DATE));
        workerDTO.setSalary(request.getParameter(SALARY));
        workerDTO.setOldEmail(request.getParameter(OLD_WORKER_EMAIL) == null ?
                String.valueOf(0) : request.getParameter(OLD_WORKER_EMAIL));
        return workerDTO;
    }
}
