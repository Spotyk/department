package com.edu.ua.kh.hetman.service.impl;

import com.edu.ua.kh.hetman.entity.Department;
import com.edu.ua.kh.hetman.repository.DepartmentRepository;
import com.edu.ua.kh.hetman.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public boolean isDepartmentNameExist(String name) {
        return departmentRepository.isDepartmentNameExist(name);
    }

    @Override
    public boolean isDepartmentIdExist(int id) {
        return departmentRepository.isDepartmentIdExist(id);
    }


    @Override
    public void createDepartment(String name) {
        departmentRepository.createDepartment(name);
    }

    @Override
    public void updateDepartment(int depId, String newName) {
        departmentRepository.updateDepartment(depId, newName);
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.deleteDepartmentById(id);
    }
}
