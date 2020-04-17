package by.epam.havansky.controller;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.CommandType;
import by.epam.havansky.service.factory.VouchersFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mainServlet")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DELETE
        System.out.println("doPost method");
        handleRequest(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);

    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //DELETE
        System.out.println("handleRequest starts");
        //String name = request.getParameter(CommandType.COMMAND.getValue());
        String name = request.getParameter("value");
        System.out.println("after request.getParameter");
        Command command = VouchersFactory.getInstance().chooseParseCommand("DOM");
        System.out.println("after 'VouchersFactory.getInstance().chooseParseCommand(name)' ");
        String forwardPage = command.execute(request, response);
        System.out.println("after 'command.execute(request, response)' ");

        request.getRequestDispatcher(forwardPage).forward(request, response);
    }
}
