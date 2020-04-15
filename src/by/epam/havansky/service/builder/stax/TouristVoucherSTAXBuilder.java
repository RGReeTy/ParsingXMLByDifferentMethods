package by.epam.havansky.service.builder.stax;

import by.epam.havansky.entity.*;
import by.epam.havansky.service.builder.AbstractTouristVoucherBuilder;
import by.epam.havansky.service.builder.TouristVoucherEnum;
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

public class TouristVoucherSTAXBuilder extends AbstractTouristVoucherBuilder {

    private static final Logger logger = Logger.getLogger(TouristVoucherSTAXBuilder.class);
    private static final int ID_ATTRIBUTE_POSITION = 0;
    private XMLInputFactory inputFactory;

    public TouristVoucherSTAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetTouristVouchers(InputStream source) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            reader = inputFactory.createXMLStreamReader(source);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.valueOf(name.toUpperCase()) == TouristVoucherEnum.TOURISTVOUCHER) {
                        TouristVoucher touristVoucher = buildTouristVoucher(reader);
                        touristVoucherSet.add(touristVoucher);
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

    private TouristVoucher buildTouristVoucher(XMLStreamReader reader) throws XMLStreamException, ParseException {
        TouristVoucher touristVoucher = new TouristVoucher();
        touristVoucher.setId(reader.getAttributeValue(ID_ATTRIBUTE_POSITION));

        String name;
        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristVoucherEnum.valueOf(name.toUpperCase())) {
                        case TYPE:
                            touristVoucher.setVoucherType(VoucherType.valueOf(getXMLText(reader)));
                            break;
                        case COUNTRY:
                            touristVoucher.setCountry(getXMLText(reader));
                            break;
                        case STARTDATE:
                            touristVoucher.setDate((new SimpleDateFormat("yyyy-MM-dd").parse(getXMLText(reader))));
                            break;
                        case NUMBERDAYSNIGHTS:
                            touristVoucher.setNumberDays(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TRANSPORT:
                            touristVoucher.setTransportType(TransportType.valueOf(getXMLText(reader)));
                            break;
                        case HOTELSPECIFICATION:
                            touristVoucher.setHotelSpecification(getXMLHotelSpecification(reader));
                            break;
                        case PRICE:
                            touristVoucher.setPrice(new BigDecimal(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.valueOf(name.toUpperCase()) == TouristVoucherEnum.TOURISTVOUCHER) {
                        return touristVoucher;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag touristVoucher");
    }

    private HotelSpecification getXMLHotelSpecification(XMLStreamReader reader) throws XMLStreamException {
        HotelSpecification hotelSpecification = new HotelSpecification();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristVoucherEnum.valueOf(name.toUpperCase())) {
                        case STARS:
                            hotelSpecification.setStarsNumber(Integer.parseInt(getXMLText(reader)));
                            break;
                        case MEALS:
                            hotelSpecification.setMealType(MealType.valueOf(getXMLText(reader)));
                            break;
                        case NUMBEROFROOMS:
                            hotelSpecification.setNumberOfRooms(Integer.parseInt(getXMLText(reader)));
                            break;
                        case AIRCONDITION:
                            hotelSpecification.setAirCondition(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case TV:
                            hotelSpecification.setTv(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case WIFI:
                            hotelSpecification.setWifi(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case PARKING:
                            hotelSpecification.setParking(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.valueOf(name.toUpperCase()) == TouristVoucherEnum.HOTELSPECIFICATION) {
                        return hotelSpecification;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag HotelSpecification");
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
