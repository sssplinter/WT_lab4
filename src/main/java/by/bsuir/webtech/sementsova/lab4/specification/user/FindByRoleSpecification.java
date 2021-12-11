package by.bsuir.webtech.sementsova.lab4.specification.user;

import by.bsuir.webtech.sementsova.lab4.entity.roles.Role;
import by.bsuir.webtech.sementsova.lab4.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByRoleSpecification implements Specification {

    private final Role role;

    public FindByRoleSpecification(Role role) {
        this.role = role;
    }

    @Override
    public String toSql() {
        return "WHERE role = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(role);
    }
}
