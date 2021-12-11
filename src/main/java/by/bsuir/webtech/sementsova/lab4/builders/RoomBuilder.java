package by.bsuir.webtech.sementsova.lab4.builders;

import by.bsuir.webtech.sementsova.lab4.entity.Room;
import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomBuilder implements Builder<Room> {

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    @Override
    public Room build(ResultSet resultSet) throws DBRepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            String roomNumber = resultSet.getString(ROOM_NUMBER);
            Boolean occupied = resultSet.getBoolean(OCCUPIED);

            return new Room(id, roomNumber, occupied);
        } catch (SQLException e) {
            throw new DBRepositoryException(e.getMessage());
        }
    }
}
