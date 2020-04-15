package by.epam.havansky.controller.command.command_impl;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.PageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorMessage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageType.ERROR_PAGE.getValue();
    }
}
