package by.bsuir.webtech.sementsova.lab4.controllers.commands.admin;

import by.bsuir.webtech.sementsova.lab4.controllers.commands.Command;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.CommandResult;
import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;
import by.bsuir.webtech.sementsova.lab4.services.HotelRoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowHotelRoomsCommand implements Command {
    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String MESSAGE = "message";
    private static final String NOTIFY_MESSAGE = "notifyMessage";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        List<HotelRoom> fullHotelRoomList = hotelRoomService.findAll();
        request.setAttribute(ROOM_LIST, fullHotelRoomList);

        String notifyMessage = request.getParameter(MESSAGE);
        if (notifyMessage != null) {
            request.setAttribute(NOTIFY_MESSAGE, notifyMessage);
        }

        return CommandResult.forward(ROOMS_PAGE);
    }
}
