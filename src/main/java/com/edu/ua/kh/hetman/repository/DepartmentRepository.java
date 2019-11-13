package com.edu.ua.kh.hetman.repository;

import com.edu.ua.kh.hetman.entity.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getAllDepartments();

    boolean isDepartmentNameExist(String name);

    boolean isDepartmentIdExist(int id);

    void createDepartment(String name);

    void updateDepartment(int depId, String newName);

    void deleteDepartmentById(int id);
}
