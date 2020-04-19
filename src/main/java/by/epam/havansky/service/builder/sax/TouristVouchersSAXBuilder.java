package by.epam.havansky.service.builder.sax;

import by.epam.havansky.service.builder.AbstractTouristVoucherBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class TouristVouchersSAXBuilder extends AbstractTouristVoucherBuilder {
    private static final Logger logger = Logger.getLogger(TouristVouchersSAXBuilder.class);
    private TouristVoucherHandler touristVoucherHandler;
    private XMLReader reader;

    public TouristVouchersSAXBuilder() {
        touristVoucherHandler = new TouristVoucherHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(touristVoucherHandler);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildSetTouristVouchers(InputStream source) {
        try {
            reader.parse(new InputSource(source));
        } catch (IOException | SAXException e) {
            logger.error(e);
        }

        touristVoucherSet = touristVoucherHandler.getTouristVoucherSet();
    }
}
