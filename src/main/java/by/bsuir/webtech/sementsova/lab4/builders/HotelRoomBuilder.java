package by.bsuir.webtech.sementsova.lab4.builders;

import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelRoomBuilder implements Builder<HotelRoom> {

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    @Override
    public HotelRoom build(ResultSet resultSet) throws DBRepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            String roomNumber = resultSet.getString(ROOM_NUMBER);
            Boolean occupied = resultSet.getBoolean(OCCUPIED);

            return new HotelRoom(id, roomNumber, occupied);
        } catch (SQLException e) {
            throw new DBRepositoryException(e.getMessage());
        }
    }
}
