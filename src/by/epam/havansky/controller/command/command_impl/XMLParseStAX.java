package by.epam.havansky.controller.command.command_impl;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.PageType;
import by.epam.havansky.entity.TouristVoucher;
import by.epam.havansky.service.ParserXML;
import by.epam.havansky.service.ServiceException;
import by.epam.havansky.service.builder.AbstractTouristVoucherBuilder;
import by.epam.havansky.service.builder.sax.TouristVouchersSAXBuilder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class XMLParseStAX implements Command {

    private static final Logger logger = Logger.getLogger(XMLParseStAX.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            AbstractTouristVoucherBuilder builder = new TouristVouchersSAXBuilder();
            Set<TouristVoucher> voucherSet = ParserXML.getInstance().parseXML(request, builder);
            request.setAttribute("resultSet", voucherSet);
            return PageType.PARSE_RESULT_PAGE.getValue();
        } catch (ServiceException e) {
            logger.error(e);
            return PageType.ERROR_PAGE.getValue();
        }
    }
}
