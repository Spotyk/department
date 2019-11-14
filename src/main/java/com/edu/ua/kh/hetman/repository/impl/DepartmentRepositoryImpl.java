package com.edu.ua.kh.hetman.repository.impl;

import com.edu.ua.kh.hetman.db.DbManager;
import com.edu.ua.kh.hetman.entity.Department;
import com.edu.ua.kh.hetman.entity.impl.DepartmentEntityExtractorImpl;
import com.edu.ua.kh.hetman.repository.DepartmentRepository;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static final Logger LOGGER = Logger.getLogger(DepartmentRepository.class);

    private DbManager dbManager;

    public DepartmentRepositoryImpl(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        Statement statement;
        ResultSet rs;
        DepartmentEntityExtractorImpl mapper = new DepartmentEntityExtractorImpl();
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM departments");
            while (rs.next()) {
                departments.add(mapper.extractEntity(rs));
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        } finally {
            dbManager.closeConnection(connection);
            return departments;
        }
    }

    @Override
    public boolean isDepartmentNameExist(String name) {
        PreparedStatement statement;
        ResultSet rs;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            statement = connection.prepareStatement("SELECT * FROM departments where name=?");
            statement.setString(1, name);
            rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean isDepartmentIdExist(int id) {
        PreparedStatement statement;
        ResultSet rs;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            statement = connection.prepareStatement("SELECT * FROM departments where id=?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void createDepartment(String name) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO departments(id,name) VALUES (DEFAULT,?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            dbManager.rollback(connection);
            LOGGER.error("SQL exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
    }

    @Override
    public void updateDepartment(int depId, String newName) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE departments SET name=? WHERE id=?");
            int i = 1;
            preparedStatement.setString(i++, newName);
            preparedStatement.setInt(i++, depId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            dbManager.rollback(connection);
            LOGGER.error("SQL exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
    }

    @Override
    public void deleteDepartmentById(int id) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM departments where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
    }
}
