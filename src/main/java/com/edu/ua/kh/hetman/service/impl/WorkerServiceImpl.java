package com.edu.ua.kh.hetman.service.impl;

import com.edu.ua.kh.hetman.entity.Worker;
import com.edu.ua.kh.hetman.repository.WorkerRepository;
import com.edu.ua.kh.hetman.service.WorkerService;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> getAllWorkersByDepartmentId(int id) {
        return workerRepository.getAllWorkersByDepartmentId(id);
    }

    @Override
    public void deleteWorkerById(int id) {
        workerRepository.deleteWorkerById(id);
    }

    @Override
    public void createWorker(Worker worker) {
        workerRepository.createWorker(worker);
    }

    @Override
    public void updateWorker(Worker worker) {
        workerRepository.updateWorker(worker);
    }

    @Override
    public boolean isWorkerEmailExist(String email) {
        return workerRepository.isWorkerEmailExist(email);
    }

    @Override
    public boolean isWorkerIdExist(int id) {
        return workerRepository.isWorkerIdExist(id);
    }
}
