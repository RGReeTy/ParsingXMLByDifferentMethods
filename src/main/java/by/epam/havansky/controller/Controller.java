package by.epam.havansky.controller;

import by.epam.havansky.controller.command.Command;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("handleRequest");
        //String name = request.getParameter(CommandType.COMMAND.getValue());
        String name = request.getParameter("command");
        //String name = request.getParameter("value");
        logger.info("request.getParameter: " + name);
        Command command = TouristOrderBuilderFactory.getInstance().chooseParseCommand(name);
        logger.info("after choosing command" + command.toString());
        String forwardPage = command.execute(request, response);
        logger.info("after command.execute" + forwardPage);
        request.getRequestDispatcher(forwardPage).forward(request, response);
    }
}
