package by.epam.xmlparsing.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
    }

    public static ActionFactory getInstance() {
        return instance;
    }

    public Command defineCommand(HttpServletRequest request) {
        Command current = null;
        String command = null;
        command = request.getParameter("VALUE");

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", command + "Something went wrong");
        }
        return current;
    }
}