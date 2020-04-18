package by.epam.havansky.service.builder.dom;

import by.epam.havansky.entity.*;
import by.epam.havansky.service.builder.AbstractTouristVoucherBuilder;
import by.epam.havansky.service.builder.HotelSpecificationBuilder;
import by.epam.javatraining.xmlandwebparser.entity.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TouristVouchersDOMBuilder extends AbstractTouristVoucherBuilder {
    private static final Logger logger = Logger.getLogger(TouristVouchersDOMBuilder.class);
    private DocumentBuilder documentBuilder;

    public TouristVouchersDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildSetTouristVouchers(InputStream source) throws ParseException {
        Document document = null;

        try {
            document = documentBuilder.parse(source);
            Element root = document.getDocumentElement();
            NodeList touristVoucher = root.getElementsByTagName("touristVoucher");

            for (int i = 0; i < touristVoucher.getLength(); i++) {
                Element touristVoucherElement = (Element) touristVoucher.item(i);
                TouristVoucher example = buildTouristVoucher(touristVoucherElement);
                touristVoucherSet.add(example);
            }
        } catch (SAXException | IOException e) {
            logger.error(e);
        }
    }

    private TouristVoucher buildTouristVoucher(Element element) throws ParseException {
        HotelSpecificationBuilder hotelBuilder = new HotelSpecificationBuilder()
                .buildStarsNumber(Integer.parseInt(getElementTextContent(element, "stars")))
                .buildMealType(MealType.valueOf(getElementTextContent(element, "meals")))
                .buildNumberOfRooms(Integer.parseInt(getElementTextContent(element, "numberOfRooms")))
                .buildAirCondition(Boolean.parseBoolean(getElementTextContent(element, "airCondition")))
                .buildTv(Boolean.parseBoolean(getElementTextContent(element, "tv")))
                .buildWifi(Boolean.parseBoolean(getElementTextContent(element, "wifi")))
                .buildParking(Boolean.parseBoolean(getElementTextContent(element, "parking")));
        HotelSpecification hotelSpecification = new HotelSpecification(hotelBuilder);

        AbstractTouristVoucherBuilder builder = new TouristVouchersDOMBuilder()
                .buildId(element.getAttribute("id"))
                .buildVoucherType(VoucherType.valueOf(getElementTextContent(element, "type")))
                .buildCountry(getElementTextContent(element, "country"))
                .buildDate(new SimpleDateFormat("yyyy-MM-dd").parse(getElementTextContent(element, "startDate")))
                .buildDaysNumber(Integer.parseInt(getElementTextContent(element, "numberDaysNights")))
                .buildTransportType(TransportType.valueOf(getElementTextContent(element, "transport")))
                .buildHotelSpecification(hotelSpecification)
                .buildPrice(new BigDecimal(getElementTextContent(element, "price")));

        return new TouristVoucher(builder);
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
