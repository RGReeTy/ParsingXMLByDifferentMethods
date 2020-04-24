package by.epam.havansky.service;

import by.epam.havansky.controller.command.CommandType;
import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;
import by.epam.havansky.service.validator.XSDValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

public class ParserXML {
    private static final Logger logger = Logger.getLogger(ParserXML.class);

    private ParserXML() {
        logger.info("ParserXML constructor");
    }

    private static class ParserXMLHolder {
        private static final ParserXML INSTANCE = new ParserXML();
    }

    public static ParserXML getInstance() {
        return ParserXMLHolder.INSTANCE;
    }

    public Set<TourOrder> parseXML(HttpServletRequest request, AbstractTouristOrderBuilder builder) throws ServiceException {
        try {
            XSDValidator xsdValidator = XSDValidator.getInstance();
            xsdValidator.validateXMLSchema(request);
            Part filePart = request.getPart(CommandType.FILE.getValue());
            InputStream fileContent = filePart.getInputStream();
            builder.buildSetTourOrders(fileContent);
        } catch (IOException | ServletException | ParseException e) {
            logger.error(e);
            throw new ServiceException(e);
        }
        return builder.getTourOrderSet();
    }
}
