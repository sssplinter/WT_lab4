package by.bsuir.webtech.sementsova.lab4.controllers.commands.admin;

import by.bsuir.webtech.sementsova.lab4.controllers.commands.Command;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.CommandResult;
import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;
import by.bsuir.webtech.sementsova.lab4.services.HotelRoomService;
import by.bsuir.webtech.sementsova.lab4.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddHotelRoomCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=showRooms";
    private static final String ROOM_NUMBER = "roomNumber";
    private static final String ROOM_LIST = "roomList";
    private static final String ADDING_ROOM = "added";
    private static final String MESSAGE = "&message=";
    private static final String ERROR_MESSAGE = "invalidRoom";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomNumber = request.getParameter(ROOM_NUMBER);

        Validator validator = new Validator();
        Map<String, String> values = new HashMap<>();
        values.put(ROOM_NUMBER, roomNumber);
        if (validator.isNotValid(values)) {
            return CommandResult.redirect(MAIN_PAGE + MESSAGE + ERROR_MESSAGE);
        }

        HotelRoomService hotelRoomService = new HotelRoomService();
        hotelRoomService.saveRoom(null, roomNumber, false);

        List<HotelRoom> hotelRoomList = hotelRoomService.findAll();
        request.setAttribute(ROOM_LIST, hotelRoomList);

        return CommandResult.redirect(MAIN_PAGE + MESSAGE + ADDING_ROOM);
    }
}
