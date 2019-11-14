package com.edu.ua.kh.hetman.repository.impl;

import com.edu.ua.kh.hetman.db.DbManager;
import com.edu.ua.kh.hetman.entity.Worker;
import com.edu.ua.kh.hetman.entity.impl.WorkerEntityExtractorImpl;
import com.edu.ua.kh.hetman.repository.WorkerRepository;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerRepositoryImpl implements WorkerRepository {
    private static final Logger LOGGER = Logger.getLogger(WorkerRepository.class);

    private DbManager dbManager;

    public WorkerRepositoryImpl(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public List<Worker> getAllWorkersByDepartmentId(int id) {
        List<Worker> workers = new ArrayList<>();
        PreparedStatement statement;
        ResultSet rs;
        WorkerEntityExtractorImpl mapper = new WorkerEntityExtractorImpl();
        Connection connection;
        try {
            connection = dbManager.getConnection();
            statement = connection.prepareStatement("SELECT * FROM workers WHERE departmentId=?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                workers.add(mapper.extractEntity(rs));
            }
        } catch (SQLException e) {
            LOGGER.error("Sql exception", e);
        }
        return workers;
    }

    @Override
    public void deleteWorkerById(int id) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM workers where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error("Sql exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
    }

    @Override
    public void createWorker(Worker worker) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement("INSERT into workers(name,departmentId,salary,date,email,id)" +
                    " VALUES (?,?,?,?,?,DEFAULT)");
            int i = 1;
            preparedStatement.setString(i++, worker.getName());
            preparedStatement.setInt(i++, worker.getDepartmentId());
            preparedStatement.setInt(i++, worker.getSalary());
            preparedStatement.setDate(i++, new java.sql.Date(worker.getDate().getTime()));
            preparedStatement.setString(i++, worker.getEmail());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            dbManager.rollback(connection);
            LOGGER.error("Sql exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
    }

    @Override
    public void updateWorker(Worker worker) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE workers SET name=?,departmentId=?,salary=?,date=?,email=? WHERE id=?");
            int i = 1;
            preparedStatement.setString(i++, worker.getName());
            preparedStatement.setInt(i++, worker.getDepartmentId());
            preparedStatement.setInt(i++, worker.getSalary());
            preparedStatement.setDate(i++, new java.sql.Date(worker.getDate().getTime()));
            preparedStatement.setString(i++, worker.getEmail());
            preparedStatement.setInt(i++, worker.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            dbManager.rollback(connection);
            LOGGER.error("Sql exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
    }

    @Override
    public boolean isWorkerEmailExist(String email) {
        PreparedStatement statement;
        ResultSet rs;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            statement = connection.prepareStatement("SELECT * FROM workers where email=?");
            statement.setString(1, email);
            rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error("Sql exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean isWorkerIdExist(int id) {
        PreparedStatement statement;
        ResultSet rs;
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            statement = connection.prepareStatement("SELECT * FROM workers where id=?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error("Sql exception", e);
        } finally {
            dbManager.closeConnection(connection);
        }
        return false;
    }
}
