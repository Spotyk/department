package com.edu.ua.kh.hetman.utils;

import com.edu.ua.kh.hetman.db.dto.WorkerDTO;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.DEP_ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.EMAIL;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.NAME;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.OLD_WORKER_EMAIL;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.SALARY;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.SPACE;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.WORKER_ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.WORK_DATE;

public class WorkerDTOCreator {

    public static WorkerDTO createWorkerDTOFromRequest(HttpServletRequest request) {
        WorkerDTO workerDTO = new WorkerDTO();

        workerDTO.setId(request.getParameter(WORKER_ID) == null ? String.valueOf(0) : request.getParameter(WORKER_ID));
        workerDTO.setDepartmentId(StringUtils.isBlank(request.getParameter(DEP_ID)) ? SPACE : request.getParameter(DEP_ID));
        workerDTO.setName(StringUtils.isBlank(request.getParameter(NAME)) ? SPACE : request.getParameter(NAME));
        workerDTO.setEmail(StringUtils.isBlank(request.getParameter(EMAIL)) ? SPACE : request.getParameter(EMAIL));
        workerDTO.setDate(StringUtils.isBlank(request.getParameter(WORK_DATE)) ? SPACE : request.getParameter(WORK_DATE));
        workerDTO.setSalary(StringUtils.isBlank(request.getParameter(SALARY)) ? SPACE : request.getParameter(SALARY));
        workerDTO.setOldEmail(request.getParameter(OLD_WORKER_EMAIL) == null ?
                String.valueOf(0) : request.getParameter(OLD_WORKER_EMAIL));
        return workerDTO;
    }
}
