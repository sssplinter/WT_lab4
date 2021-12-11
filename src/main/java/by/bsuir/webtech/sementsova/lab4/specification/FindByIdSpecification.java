package by.bsuir.webtech.sementsova.lab4.specification;

import by.bsuir.webtech.sementsova.lab4.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByIdSpecification implements Specification {

    private final Integer id;

    public FindByIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "where id = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(id);
    }
}
