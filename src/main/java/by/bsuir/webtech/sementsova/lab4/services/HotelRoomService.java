package by.bsuir.webtech.sementsova.lab4.services;

import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;
import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;
import by.bsuir.webtech.sementsova.lab4.repository.creator.RepositoryCreator;
import by.bsuir.webtech.sementsova.lab4.repository.impl.HotelRoomRepository;
import by.bsuir.webtech.sementsova.lab4.specification.FindByIdSpecification;
import by.bsuir.webtech.sementsova.lab4.specification.room.FindAllSpecification;
import by.bsuir.webtech.sementsova.lab4.specification.room.FindFreeSpecification;

import java.util.List;
import java.util.Optional;

public class HotelRoomService {

    public List<HotelRoom> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            HotelRoomRepository hotelRoomRepository = repositoryCreator.getRoomRepository();
            return hotelRoomRepository.queryAll(new FindAllSpecification());
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<HotelRoom> findFree() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            HotelRoomRepository hotelRoomRepository = repositoryCreator.getRoomRepository();
            return hotelRoomRepository.queryAll(new FindFreeSpecification());
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void saveRoom(Integer id, String roomNumber, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            HotelRoomRepository hotelRoomRepository = repositoryCreator.getRoomRepository();
            HotelRoom hotelRoom = new HotelRoom(id, roomNumber, occupied);
            hotelRoomRepository.save(hotelRoom);
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void changeStatus(Integer id, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            HotelRoomRepository hotelRoomRepository = repositoryCreator.getRoomRepository();
            Optional<HotelRoom> room = hotelRoomRepository.query(new FindByIdSpecification(id));
            if (room.isPresent()) {
                room.get().setOccupied(occupied);
                hotelRoomRepository.save(room.get());
            } else {
                throw new ServiceException("No such room id");
            }
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
