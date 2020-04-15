package by.epam.xmlparsing.controller.command;

import javax.servlet.http.HttpServletRequest;

public class GoToPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String page = request.getParameter("page");
		//return ConfigurationManager.getProperty(page);
		return "";
	}
}
