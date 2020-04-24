package by.epam.havansky.service.builder.stax;

import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.entity.TourSpecification;
import by.epam.havansky.entity.TourType;
import by.epam.havansky.entity.TransportType;
import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;
import by.epam.havansky.service.builder.TouristOrderEnum;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class TourOrderSTAXBuilder extends AbstractTouristOrderBuilder {
    private static final Logger logger = Logger.getLogger(TourOrderSTAXBuilder.class);
    private static final int ID_ATTRIBUTE_POSITION = 0;
    private XMLInputFactory inputFactory;

    public TourOrderSTAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetTourOrders(InputStream source) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            reader = inputFactory.createXMLStreamReader(source);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TouristOrderEnum.valueOf(name.toUpperCase()) == TouristOrderEnum.TOURISTORDER) {
                        TourOrder tourOrder = buildTourOrder(reader);
                        tourOrderSet.add(tourOrder);
                    }
                }
            }
        } catch (ParseException | XMLStreamException e) {
            logger.error(e);
        } finally {
            try {
                if (source != null) {
                    source.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    private TourOrder buildTourOrder(XMLStreamReader reader) throws XMLStreamException, ParseException {
        TourOrder tourOrder = new TourOrder();
        tourOrder.setId(reader.getAttributeValue(ID_ATTRIBUTE_POSITION));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristOrderEnum.valueOf(name.toUpperCase())) {
                        case FIRSTNAME:
                            tourOrder.setFirstname(getXMLText(reader));
                            break;
                        case LASTNAME:
                            tourOrder.setLastname(getXMLText(reader));
                            break;
                        case STARTDATE:
                            tourOrder.setDate(LocalDate.parse(getXMLText(reader)));
                            //tourOrder.setDate((new SimpleDateFormat("yyyy-MM-dd").parse(getXMLText(reader))));
                            break;
                        case TOURSPECIFICATION:
                            tourOrder.setTourSpecification(getXMLTourSpecification(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristOrderEnum.valueOf(name.toUpperCase()) == TouristOrderEnum.TOURISTORDER) {
                        return tourOrder;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag tourOrder");
    }

    private TourSpecification getXMLTourSpecification(XMLStreamReader reader) throws XMLStreamException {
        TourSpecification tourSpecification = new TourSpecification();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristOrderEnum.valueOf(name.toUpperCase())) {
                        case TOUR:
                            tourSpecification.setTourDescription(getXMLText(reader));
                            break;
                        case TOURTYPE:
                            tourSpecification.setTourType(TourType.valueOf(getXMLText(reader)));
                            break;
                        case NUMBEROFDAYS:
                            tourSpecification.setNumberOfDays(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TRANSPORT:
                            tourSpecification.setTransportType(TransportType.valueOf(getXMLText(reader)));
                            break;
                        case COUNTRY:
                            tourSpecification.setCountry(getXMLText(reader));
                            break;
                        case PRICE:
                            tourSpecification.setPrice(new BigDecimal(getXMLText(reader)));
                            break;
                        case VISANEEDED:
                            tourSpecification.setVisaNeeded(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristOrderEnum.valueOf(name.toUpperCase()) == TouristOrderEnum.TOURSPECIFICATION) {
                        return tourSpecification;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag 'TourSpecification'");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
