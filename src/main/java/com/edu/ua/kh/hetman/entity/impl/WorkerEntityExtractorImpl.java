package com.edu.ua.kh.hetman.entity.impl;

import com.edu.ua.kh.hetman.entity.EntityExtractor;
import com.edu.ua.kh.hetman.entity.Worker;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.DEPARTMENT_ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.EMAIL;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.NAME;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.SALARY;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.WORK_DATE;
import static com.edu.ua.kh.hetman.constant.Constant.Sql.RESULTSET_NOT_CREATED;

public class WorkerEntityExtractorImpl implements EntityExtractor<Worker> {
    private static final Logger LOGGER = Logger.getLogger(WorkerEntityExtractorImpl.class);

    @Override
    public Worker extractEntity(ResultSet resultSet) {
        try {
            return new Worker(
                    resultSet.getInt(ID),
                    resultSet.getInt(DEPARTMENT_ID),
                    resultSet.getString(NAME),
                    resultSet.getString(EMAIL),
                    resultSet.getInt(SALARY),
                    resultSet.getDate(WORK_DATE)
            );
        } catch (SQLException e) {
            LOGGER.error(RESULTSET_NOT_CREATED, e);
        }
        return null;
    }
}
