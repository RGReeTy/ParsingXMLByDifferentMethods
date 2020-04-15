package by.epam.xmlparsing.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	final static Logger LOGGER = LogManager.getLogger();

	//UserReceiver USER_RECEIVER = UserReceiver.getInstance();
	//OrderReceiver ORDER_RECEIVER = OrderReceiver.getInstance();

	String execute(HttpServletRequest request);
}
