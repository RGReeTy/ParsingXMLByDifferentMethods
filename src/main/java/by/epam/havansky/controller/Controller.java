package by.epam.havansky.controller;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.CommandType;
import by.epam.havansky.service.factory.TouristOrderBuilderFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Controller.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter(CommandType.COMMAND.getValue());
        logger.debug("request.getParameter: " + name);
        Command command = TouristOrderBuilderFactory.getInstance().chooseParseCommand(name);
        String forwardPage = command.execute(request, response);
        try {
            request.getRequestDispatcher(forwardPage).forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error(e);
        }
    }
}
