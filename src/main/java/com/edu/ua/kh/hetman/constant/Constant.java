package com.edu.ua.kh.hetman.constant;

public class Constant {
    public class Sql {
        public static final String RESULTSET_NOT_CREATED = "Couldn`t create resultset";
    }

    public class Entity {
        public static final String ID = "id";
        public static final String WORKER_ID = "workerId";
        public static final String NAME = "name";
        public static final String SALARY = "salary";
        public static final String WORK_DATE = "date";
        public static final String EMAIL = "email";
        public static final String DEPARTMENT_ID = "departmentId";
        public static final String DEP_ID = "depId";
        public static final String LIST = "list";
        public static final String OLD_WORKER_EMAIL = "hiddenWorkerOldEmail";
        public static final String SPACE = " ";
    }

    public class Servlet {
        public static final String DEPARTMENT_LIST_PAGE = "/WEB-INF/department/department.jsp";

        public static final String WORKER_LIST_PAGE = "/WEB-INF/worker/worker.jsp";

        public static final String DEPARTMENT_LIST_SERVLET = "/departments";
        public static final String DEPARTMENT_CREATE_SERVLET = "/createDepartment";
        public static final String DEPARTMENT_UPDATE_SERVLET = "/updateDepartment";
        public static final String DEPARTMENT_DELETE_SERVLET = "/deleteDepartment";

        public static final String WORKER_LIST_SERVLET = "/workers";
        public static final String WORKER_CREATE_SERVLET = "/createWorker";
        public static final String WORKER_UPDATE_SERVLET = "/updateWorker";
        public static final String WORKER_DELETE_SERVLET = "/deleteWorker";
    }

    public class ServerStatus {
        public static final int NOT_FOUND = 404;
        public static final int OK = 200;

    }

    public class Service {
        public static final String WORKER_SERVICE = "workerService";
        public static final String DEPARTMENT_SERVICE = "depService";

    }
}
