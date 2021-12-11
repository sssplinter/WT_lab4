package by.bsuir.webtech.sementsova.lab4.repository.impl;

import by.bsuir.webtech.sementsova.lab4.builders.HotelRoomBuilder;
import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;
import by.bsuir.webtech.sementsova.lab4.repository.AbstractRepository;
import by.bsuir.webtech.sementsova.lab4.specification.Specification;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HotelRoomRepository extends AbstractRepository<HotelRoom> {
    private static final String TABLE_NAME = " `room` ";

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    private static final String SELECT_QUERY = "SELECT * FROM `room` ";

    public HotelRoomRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(HotelRoom item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(ROOM_NUMBER, item.getRoomNumber());
        values.put(OCCUPIED, item.getOccupied());
        values.put(ID, item.getId());

        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<HotelRoom> query(Specification specification) throws DBRepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParameters();
        return executeQueryForSingleResult(query, new HotelRoomBuilder(), params);
    }

    @Override
    public List<HotelRoom> queryAll(Specification specification) throws DBRepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParameters();
        return executeQuery(query, new HotelRoomBuilder(), params);
    }
}
