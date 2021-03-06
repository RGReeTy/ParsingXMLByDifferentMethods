package by.epam.havansky.controller.command.xml_parsing;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.PageType;
import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.service.ParserXML;
import by.epam.havansky.service.ServiceException;
import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;
import by.epam.havansky.service.builder.stax.TourOrderSTAXBuilder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class StaxParseCommand implements Command {
    private static final Logger logger = Logger.getLogger(StaxParseCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("Executing StaxParseCommand");
            AbstractTouristOrderBuilder builder = new TourOrderSTAXBuilder();
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
