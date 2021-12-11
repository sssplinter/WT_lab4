package by.bsuir.webtech.sementsova.lab4.controllers.commands.admin;

import by.bsuir.webtech.sementsova.lab4.controllers.commands.Command;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.CommandResult;
import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;
import by.bsuir.webtech.sementsova.lab4.services.HotelRoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RidHotelRoomCommand implements Command {
    private static final String MAIN_PAGE = "controller?command=showRooms";
    private static final String ROOM_LIST = "roomList";
    private static final String ROOM_ID = "roomId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomId = request.getParameter(ROOM_ID);

        HotelRoomService hotelRoomService = new HotelRoomService();
        hotelRoomService.changeStatus(Integer.valueOf(roomId), false);

        List<HotelRoom> hotelRoomList = hotelRoomService.findAll();
        request.setAttribute(ROOM_LIST, hotelRoomList);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
