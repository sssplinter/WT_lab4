package by.bsuir.webtech.sementsova.lab4.builders;

import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws DBRepositoryException;
}
