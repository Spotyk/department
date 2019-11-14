package com.edu.ua.kh.hetman.db;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbManager {
    private static final Logger LOGGER = Logger.getLogger(DbManager.class);

    private DataSource dataSource;

    public DbManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection con) {
        try {
            LOGGER.info("Closing connection.");
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Cant close connection.", e);
        }
    }

    public void rollback(Connection con) {
        LOGGER.error("Error occured. Rollback.");
        try {
            if (con != null) {
                con.rollback();
            }
        } catch (SQLException ex) {
            LOGGER.error("Cant rollback connection.", ex);
        }
    }
}
