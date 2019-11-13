package com.edu.ua.kh.hetman.utils;

import com.edu.ua.kh.hetman.db.dto.WorkerDTO;

import javax.servlet.http.HttpServletRequest;

public class WorkerDTOCreator {
    public static WorkerDTO createWorkerDTOFromRequest(HttpServletRequest request) {
        WorkerDTO workerDTO = new WorkerDTO();

        workerDTO.setId(request.getParameter("workerId") == null ? String.valueOf(0) : request.getParameter("workerId"));
        workerDTO.setDepartmentId(request.getParameter("depId"));
        workerDTO.setName(request.getParameter("name"));
        workerDTO.setEmail(request.getParameter("email"));
        workerDTO.setDate(request.getParameter("date"));
        workerDTO.setSalary(request.getParameter("salary"));
        workerDTO.setOldEmail(request.getParameter("hiddenWorkerOldEmail") == null ?
                String.valueOf(0) : request.getParameter("hiddenWorkerOldEmail"));

        return workerDTO;
    }
}
