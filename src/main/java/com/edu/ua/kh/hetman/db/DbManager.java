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

    public void closeAndCommit(Connection con) {
        try {
            LOGGER.info("Closing connection and committing.");
            if (con != null && !con.isClosed()) {
                con.commit();
                con.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Cant close connection and commit it.", e);
        }
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

    public void rollbackAndClose(Connection con) {
        LOGGER.error("Error occured. Rollback.");
        try {
            if (con != null) {
                con.rollback();
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
