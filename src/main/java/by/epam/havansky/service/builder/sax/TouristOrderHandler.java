package by.epam.havansky.service.builder.sax;

import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.entity.TourSpecification;
import by.epam.havansky.entity.TourType;
import by.epam.havansky.entity.TransportType;
import by.epam.havansky.service.builder.TouristOrderEnum;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TouristOrderHandler extends DefaultHandler {
    private static final Logger logger = Logger.getLogger(TouristOrderHandler.class);
    private Set<TourOrder> touristOrderSet;
    private TourOrder current = null;
    private TouristOrderEnum currentEnum = null;
    private EnumSet<TouristOrderEnum> withText;

    public TouristOrderHandler() {
        touristOrderSet = new HashSet<>();
        withText = EnumSet.range(TouristOrderEnum.FIRSTNAME, TouristOrderEnum.VISANEEDED);
    }

    public Set<TourOrder> getTouristOrderSet() {
        return touristOrderSet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        //if ("touristOrder".equals(localName)) {
        if (TouristOrderEnum.TOURISTORDER.getValue().equals(localName)) {
            current = new TourOrder();
            current.setTourSpecification(new TourSpecification());
            current.setId(attrs.getValue(0));
        } else {
            TouristOrderEnum tempEnum = TouristOrderEnum.valueOf(localName.toUpperCase());
            if (withText.contains(tempEnum)) {
                currentEnum = tempEnum;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (TouristOrderEnum.TOURISTORDER.getValue().equals(localName)) {
            touristOrderSet.add(current);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String valueOfElement = new String(chars, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case FIRSTNAME:
                    current.setFirstname(valueOfElement);
                    break;
                case LASTNAME:
                    current.setLastname(valueOfElement);
                    break;
                case STARTDATE:
                    try {
                        current.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(valueOfElement));
                    } catch (ParseException e) {
                        logger.error(e);
                    }
                    break;
                case TOUR:
                    current.getTourSpecification().setTourDescription(valueOfElement);
                    break;
                case TOURTYPE:
                    current.getTourSpecification().setTourType(TourType.valueOf(valueOfElement));
                    break;
                case NUMBEROFDAYS:
                    current.getTourSpecification().setNumberOfDays(Integer.parseInt(valueOfElement));
                    break;
                case TRANSPORT:
                    current.getTourSpecification().setTransportType(TransportType.valueOf(valueOfElement));
                    break;
                case COUNTRY:
                    current.getTourSpecification().setCountry(valueOfElement);
                    break;
                case PRICE:
                    current.getTourSpecification().setPrice(new BigDecimal(valueOfElement));
                    break;
                case VISANEEDED:
                    current.getTourSpecification().setVisaNeeded(Boolean.parseBoolean(valueOfElement));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
