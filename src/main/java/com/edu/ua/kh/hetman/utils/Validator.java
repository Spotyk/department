package com.edu.ua.kh.hetman.utils;

import com.edu.ua.kh.hetman.db.dto.WorkerDTO;
import com.edu.ua.kh.hetman.service.DepartmentService;
import com.edu.ua.kh.hetman.service.WorkerService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String NUMBER_PATTERN = "^[0-9]+";
    private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";

    private List<String> errors;
    private DepartmentService departmentService;
    private WorkerService workerService;

    public Validator(List<String> errors, DepartmentService departmentService) {
        this.errors = errors;
        this.departmentService = departmentService;
    }

    public Validator(List<String> errors, WorkerService workerService) {
        this.errors = errors;
        this.workerService = workerService;
    }

    public List<String> validatingDepartment(String name) {
        if (departmentService.isDepartmentNameExist(name)) {
            errors.add(".duplicateName");
        }
        if (!isValidString(name)) {
            errors.add(".notValidName");
        }
        return errors;
    }

    public List<String> validatingWorker(WorkerDTO workerDTO) {
        if (!workerDTO.getOldEmail().equals(workerDTO.getEmail())
                && workerService.isWorkerEmailExist(workerDTO.getEmail())) {
            errors.add(".duplicateEmail");
        }
        if (!isValidString(workerDTO.getName())) {
            errors.add(".notValidName");
        }
        if (!isEmail(workerDTO.getEmail())) {
            errors.add(".notValidEmail");
        }
        if (!isDate(workerDTO.getDate())) {
            errors.add(".notValidDate");
        }
        if (!isNumber(workerDTO.getSalary())) {
            errors.add(".notValidNumber");
        }
        return errors;
    }

    public boolean isNumber(String number) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches() && number.length() < 10;
    }

    public boolean isEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() && email.length() < 50;
    }

    public boolean isValidString(String string) {
        return string != null && !string.isEmpty() && string.length() > 3 && string.length() < 50;
    }

    public boolean isDate(String date) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public boolean isWorkerValid(WorkerDTO worker) {
        return isNumber(worker.getSalary()) && isEmail(worker.getEmail())
                && isValidString(worker.getName()) && isDate(worker.getDate());
    }
}
