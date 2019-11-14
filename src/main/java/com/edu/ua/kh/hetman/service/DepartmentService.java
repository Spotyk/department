package com.edu.ua.kh.hetman.service;

import com.edu.ua.kh.hetman.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    boolean isDepartmentNameExist(String name);

    boolean isDepartmentIdExist(int id);

    void createDepartment(String name);

    void updateDepartment(int depId, String newDepartmentName);

    void deleteDepartmentById(int id);
}
