package com.edu.ua.kh.hetman.service;

import com.edu.ua.kh.hetman.entity.Worker;

import java.util.List;

public interface WorkerService {

    List<Worker> getAllWorkersByDepartmentId(int id);

    void deleteWorkerById(int id);

    void createWorker(Worker worker);

    void updateWorker(Worker worker);

    boolean isWorkerEmailExist(String email);

    boolean isWorkerIdExist(int id);
}
