package by.bsuir.webtech.sementsova.lab4.repository;

import by.bsuir.webtech.sementsova.lab4.builders.Builder;
import by.bsuir.webtech.sementsova.lab4.entity.Entity;
import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;
import by.bsuir.webtech.sementsova.lab4.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T extends Entity> implements Repository<T> {

    private final Connection connection;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    public List<T> executeQuery(String sql, Builder<T> builder, List<Object> params) throws DBRepositoryException {
        List<T> objects = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            QueryHelper.prepare(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T item = builder.build(resultSet);
                objects.add(item);
            }
        } catch (SQLException ex) {
            throw new DBRepositoryException(ex.getMessage());
        }
        return objects;
    }

    public Optional<T> executeQueryForSingleResult(String query, Builder<T> builder, List<Object> params) throws DBRepositoryException {
        List<T> items = executeQuery(query, builder, params);

        return items.size() == 1 ?
                Optional.of(items.get(0)) :
                Optional.empty();
    }

    public void save(T item) throws DBRepositoryException {
        try {
            String sql;
            if (item.getId() != null) {
                sql = QueryHelper.makeUpdateQuery(getFields(item), getTableName());
            } else {
                sql = QueryHelper.makeInsertQuery(getFields(item), getTableName());
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            QueryHelper.prepare(preparedStatement, getFields(item));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DBRepositoryException(ex.getMessage());
        }
    }
}
