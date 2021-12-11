package by.bsuir.webtech.sementsova.lab4.entity;

import java.util.Objects;

public class HotelRoom implements Entity {

    private Integer id;
    private String roomNumber;
    private Boolean occupied;

    public HotelRoom(Integer id, String roomNumber, Boolean occupied) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.occupied = occupied;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return id.equals(hotelRoom.id) && roomNumber.equals(hotelRoom.roomNumber) && occupied.equals(hotelRoom.occupied);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, occupied);
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", occupied=" + occupied +
                '}';
    }
}
