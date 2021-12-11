package by.bsuir.webtech.sementsova.lab4.controllers.commands;

import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
