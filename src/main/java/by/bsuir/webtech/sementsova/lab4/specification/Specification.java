package by.bsuir.webtech.sementsova.lab4.specification;

import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParameters();
}
