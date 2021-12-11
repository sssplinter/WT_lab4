package by.bsuir.webtech.sementsova.lab4.repository;

import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;
import by.bsuir.webtech.sementsova.lab4.specification.Specification;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface Repository<T> {


    Optional<T> query(Specification specification) throws DBRepositoryException;


    List<T> queryAll(Specification specification) throws DBRepositoryException;


    void save(T item) throws DBRepositoryException;

    String getTableName();


    Map<String, Object> getFields(T item);
}
