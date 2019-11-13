package com.edu.ua.kh.hetman.listener;

import com.edu.ua.kh.hetman.db.DbManager;
import com.edu.ua.kh.hetman.repository.impl.DepartmentRepositoryImpl;
import com.edu.ua.kh.hetman.repository.impl.WorkerRepositoryImpl;
import com.edu.ua.kh.hetman.service.DepartmentService;
import com.edu.ua.kh.hetman.service.WorkerService;
import com.edu.ua.kh.hetman.service.impl.DepartmentServiceImpl;
import com.edu.ua.kh.hetman.service.impl.WorkerServiceImpl;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import static com.edu.ua.kh.hetman.constant.Constant.Servis.DEPARTMENT_SERVICE;
import static com.edu.ua.kh.hetman.constant.Constant.Servis.WORKER_SERVICE;

public class ContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DbManager dbManager = new DbManager(initDataSource());
        ServletContext ctx = servletContextEvent.getServletContext();

        ctx.setAttribute(DEPARTMENT_SERVICE, initDepartmentService(dbManager));
        ctx.setAttribute(WORKER_SERVICE, initWorkerService(dbManager));
    }

    private DataSource initDataSource() {
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");

            return (DataSource) envContext.lookup("jdbc/mysql");
        } catch (NamingException e) {
            LOGGER.error("Cannot obtain DataSource");
            throw new RuntimeException("Cannot obtain DataSource");
        }
    }


    private DepartmentService initDepartmentService(DbManager dbManager) {
        return new DepartmentServiceImpl(new DepartmentRepositoryImpl(dbManager));
    }

    private WorkerService initWorkerService(DbManager dbManager) {
        return new WorkerServiceImpl(new WorkerRepositoryImpl(dbManager));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("Context destroyed");
    }
}

