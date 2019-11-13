package com.edu.ua.kh.hetman.utils;

import com.edu.ua.kh.hetman.db.DbManager;
import com.edu.ua.kh.hetman.db.dto.WorkerDTO;
import com.edu.ua.kh.hetman.entity.Worker;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WorkerDTOConverter {
    private static final Logger LOGGER = Logger.getLogger(DbManager.class);

    public static Worker convertCooperatorDTOToCooperator(WorkerDTO workerDTO) {
        Worker worker = new Worker();
        worker.setId(Integer.parseInt(workerDTO.getId()));
        worker.setName(workerDTO.getName());
        worker.setEmail(workerDTO.getEmail());
        worker.setDepartmentId(Integer.parseInt(workerDTO.getDepartmentId()));
        worker.setSalary(Integer.parseInt(workerDTO.getSalary()));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            worker.setDate(dateFormat.parse(workerDTO.getDate()));
        } catch (ParseException ex) {
            LOGGER.error("Cant convert date!", ex);
        }

        return worker;
    }
}
