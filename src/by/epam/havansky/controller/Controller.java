package by.epam.havansky.controller;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.CommandType;
import by.epam.havansky.service.factory.VouchersFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);

    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter(CommandType.COMMAND.getValue());
        Command command = VouchersFactory.getInstance().chooseParseCommand(name);
        String forwardPage = command.execute(request, response);
        request.getRequestDispatcher(forwardPage).forward(request, response);
    }
}
