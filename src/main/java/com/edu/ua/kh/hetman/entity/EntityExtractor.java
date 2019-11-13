package com.edu.ua.kh.hetman.entity;

import java.sql.ResultSet;

public interface EntityExtractor<T> {
    T extractEntity(ResultSet resultSet);
}
