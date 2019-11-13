package com.edu.ua.kh.hetman.entity.impl;

import com.edu.ua.kh.hetman.entity.Department;
import com.edu.ua.kh.hetman.entity.EntityExtractor;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.edu.ua.kh.hetman.constant.Constant.Entity.ID;
import static com.edu.ua.kh.hetman.constant.Constant.Entity.NAME;
import static com.edu.ua.kh.hetman.constant.Constant.Sql.RESULTSET_NOT_CREATED;

public class DepartmentEntityExtractorImpl implements EntityExtractor<Department> {
    private static final Logger LOGGER = Logger.getLogger(DepartmentEntityExtractorImpl.class);

    @Override
    public Department extractEntity(ResultSet resultSet) {
        try {
            return new Department(
                    resultSet.getInt(ID),
                    resultSet.getString(NAME)
            );
        } catch (SQLException e) {
            LOGGER.error(RESULTSET_NOT_CREATED, e);
        }
        return null;
    }
}
