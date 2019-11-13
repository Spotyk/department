package com.edu.ua.kh.hetman.repository;

import com.edu.ua.kh.hetman.entity.Worker;

import java.util.List;

public interface WorkerRepository {

    List<Worker> getAllWorkersByDepartmentId(int id);

    void deleteWorkerById(int id);

    void createWorker(Worker worker);

    void updateWorker(Worker worker);

    boolean isWorkerEmailExist(String email);

    boolean isWorkerIdExist(int id);

}
