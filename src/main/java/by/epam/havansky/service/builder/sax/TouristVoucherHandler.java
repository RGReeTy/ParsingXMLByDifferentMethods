package by.epam.havansky.service.builder.sax;

import by.epam.havansky.entity.*;
import by.epam.havansky.service.builder.TouristVoucherEnum;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TouristVoucherHandler extends DefaultHandler {
    private static final Logger logger = Logger.getLogger(TouristVoucherHandler.class);
    private Set<TouristVoucher> touristVoucherSet;
    private TouristVoucher current = null;
    private TouristVoucherEnum currentEnum = null;
    private EnumSet<TouristVoucherEnum> withText;

    public TouristVoucherHandler() {
        touristVoucherSet = new HashSet<>();
        withText = EnumSet.range(TouristVoucherEnum.TYPE, TouristVoucherEnum.PRICE);
    }

    public Set<TouristVoucher> getTouristVoucherSet() {
        return touristVoucherSet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("touristVoucher".equals(localName)) {
            current = new TouristVoucher();
            current.setHotelSpecification(new HotelSpecification());
            current.setId(attrs.getValue(0));
        }
        else {
            TouristVoucherEnum tempEnum = TouristVoucherEnum.valueOf(localName.toUpperCase());
            if (withText.contains(tempEnum)) {
                currentEnum = tempEnum;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("touristVoucher".equals(localName)) {
            touristVoucherSet.add(current);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String charsBtwTeg = new String(chars, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TYPE:
                    current.setVoucherType(VoucherType.valueOf(charsBtwTeg));
                    break;
                case COUNTRY:
                    current.setCountry(charsBtwTeg);
                    break;
                case STARTDATE:
                    try {
                        current.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(charsBtwTeg));
                    } catch (ParseException e) {
                        logger.error(e);
                    }
                    break;
                case NUMBERDAYSNIGHTS:
                    current.setNumberDays(Integer.parseInt(charsBtwTeg));
                    break;
                case TRANSPORT:
                    current.setTransportType(TransportType.valueOf(charsBtwTeg));
                    break;
                case STARS:
                    current.getHotelSpecification().setStarsNumber(Integer.parseInt(charsBtwTeg));
                    break;
                case MEALS:
                    current.getHotelSpecification().setMealType(MealType.valueOf(charsBtwTeg));
                    break;
                case NUMBEROFROOMS:
                    current.getHotelSpecification().setNumberOfRooms(Integer.parseInt(charsBtwTeg));
                    break;
                case AIRCONDITION:
                    current.getHotelSpecification().setAirCondition(Boolean.parseBoolean(charsBtwTeg));
                    break;
                case TV:
                    current.getHotelSpecification().setTv(Boolean.parseBoolean(charsBtwTeg));
                    break;
                case WIFI:
                    current.getHotelSpecification().setWifi(Boolean.parseBoolean(charsBtwTeg));
                    break;
                case PARKING:
                    current.getHotelSpecification().setParking(Boolean.parseBoolean(charsBtwTeg));
                    break;
                case PRICE:
                    current.setPrice(new BigDecimal(charsBtwTeg));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
