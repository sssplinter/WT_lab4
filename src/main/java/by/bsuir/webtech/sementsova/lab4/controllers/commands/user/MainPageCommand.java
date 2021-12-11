package by.bsuir.webtech.sementsova.lab4.controllers.commands.user;

import by.bsuir.webtech.sementsova.lab4.controllers.commands.Command;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.CommandResult;
import by.bsuir.webtech.sementsova.lab4.entity.HotelRoom;
import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;
import by.bsuir.webtech.sementsova.lab4.services.HotelRoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        List<HotelRoom> freeHotelRoomList = hotelRoomService.findFree();
        request.setAttribute(ROOM_LIST, freeHotelRoomList);
        return CommandResult.forward(MAIN_PAGE);
    }
}
