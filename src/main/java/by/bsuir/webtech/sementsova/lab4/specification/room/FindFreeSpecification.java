package by.bsuir.webtech.sementsova.lab4.specification.room;

import by.bsuir.webtech.sementsova.lab4.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindFreeSpecification implements Specification {

    public FindFreeSpecification() {
    }

    @Override
    public String toSql() {
        return "WHERE occupied = 'false'";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
