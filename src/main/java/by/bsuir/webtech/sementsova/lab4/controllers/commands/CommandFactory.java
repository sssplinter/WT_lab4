package by.bsuir.webtech.sementsova.lab4.controllers.commands;

import by.bsuir.webtech.sementsova.lab4.controllers.commands.admin.AddHotelRoomCommand;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.admin.RidHotelRoomCommand;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.admin.ShowHotelRoomsCommand;
import by.bsuir.webtech.fourth.task.controller.command.common.*;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.user.MainPageCommand;
import by.bsuir.webtech.sementsova.lab4.controllers.commands.user.MakeOrderCommand;

public class CommandFactory {
    private static final CommandFactory INSTANCE = new CommandFactory();
    private static final String MAIN_PAGE = "mainPage";
    private static final String MAKE_ORDER = "makeOrder";
    private static final String LOGIN = "login";
    private static final String SHOW_ROOMS = "showRooms";
    private static final String CHANGE_LANGUAGE = "changeLanguage";
    private static final String ADD_ROOM = "addRoom";
    private static final String DEOCCUPY_ROOM = "deoccupyRoom";
    private static final String LOG_OUT = "signOut";
    private static final String SIGN_UP = "signUp";
    private static final String START_PAGE = "startPage";
    private static final String START_LOGIN = "startLogin";

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public Command getCommand(String command) {
        switch (command) {
            case LOGIN:
                return new LoginCommand();
            case SHOW_ROOMS:
                return new ShowHotelRoomsCommand();
            case MAIN_PAGE:
                return new MainPageCommand();
            case CHANGE_LANGUAGE:
                return new ChangeLanguageCommand();
            case ADD_ROOM:
                return new AddHotelRoomCommand();
            case MAKE_ORDER:
                return new MakeOrderCommand();
            case DEOCCUPY_ROOM:
                return new RidHotelRoomCommand();
            case LOG_OUT:
                return new LogOutCommand();
            case START_PAGE:
                return new StartPageCommand();
            case SIGN_UP:
                return new SignUpCommand();
            case START_LOGIN:
                return new StartLoginCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
