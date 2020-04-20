package by.epam.havansky.service.builder.sax;

import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;

public class TouristOrdersSAXBuilder extends AbstractTouristOrderBuilder {
    private static final Logger logger = Logger.getLogger(TouristOrdersSAXBuilder.class);
    private TouristOrderHandler touristOrderHandler;
    private XMLReader reader;

    public TouristOrdersSAXBuilder() {
        touristOrderHandler = new TouristOrderHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(touristOrderHandler);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildSetTourOrders(InputStream source) {
        try {
            reader.parse(new InputSource(source));
        } catch (IOException | SAXException e) {
            logger.error(e);
        }
        tourOrderSet = touristOrderHandler.getTouristOrderSet();
    }
}
