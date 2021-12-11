package by.bsuir.webtech.sementsova.lab4.specification.user;

import by.bsuir.webtech.sementsova.lab4.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByUsernameSpecification implements Specification {

    private final String username;

    public FindByUsernameSpecification(String username) {
        this.username = username;
    }

    @Override
    public String toSql() {
        return "WHERE username=?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(username);
    }
}
