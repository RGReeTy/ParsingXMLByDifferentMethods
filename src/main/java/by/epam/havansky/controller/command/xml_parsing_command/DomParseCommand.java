package by.epam.havansky.controller.command.xml_parsing_command;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.PageType;
import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.service.ParserXML;
import by.epam.havansky.service.ServiceException;
import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;
import by.epam.havansky.service.builder.dom.TourOrdersDOMBuilder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class DomParseCommand implements Command {
    private static final Logger logger = Logger.getLogger(DomParseCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("Executing DomParseCommand");
            AbstractTouristOrderBuilder builder = new TourOrdersDOMBuilder();
            Set<TourOrder> orderSet = ParserXML.getInstance().parseXML(request, builder);
            logger.info("after parsing and returning set EXECUTE " + orderSet.size());
            request.setAttribute("OrdersSet", orderSet);
            logger.debug(request.getAttribute("OrdersSet").toString());
            return PageType.PARSE_RESULT_PAGE.getValue();
        } catch (ServiceException e) {
            logger.error(e);
            return PageType.ERROR_PAGE.getValue();
        }
    }
}
