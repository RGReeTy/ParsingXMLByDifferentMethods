package by.epam.havansky.service.builder.dom;

import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.entity.TourSpecification;
import by.epam.havansky.entity.TourType;
import by.epam.havansky.entity.TransportType;
import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;
import by.epam.havansky.service.builder.TourSpecificationBuilder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TourOrdersDOMBuilder extends AbstractTouristOrderBuilder {
    private static final Logger logger = Logger.getLogger(TourOrdersDOMBuilder.class);
    private DocumentBuilder documentBuilder;

    public TourOrdersDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        logger.debug("constructor TourOrdersDOMBuilder");
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildSetTourOrders(InputStream source) throws ParseException {
        Document document = null;

        try {
            document = documentBuilder.parse(source);
            Element root = document.getDocumentElement();
            NodeList tourOrders = root.getElementsByTagName("touristOrder");

            for (int i = 0; i < tourOrders.getLength(); i++) {
                Element tourOrdersElement = (Element) tourOrders.item(i);
                TourOrder example = buildTourOrders(tourOrdersElement);
                tourOrderSet.add(example);
                logger.debug("after cr8 TourOrder: " + example.toString());
            }
        } catch (SAXException | IOException e) {
            logger.error(e);
        }
    }

    private TourOrder buildTourOrders(Element element) throws ParseException {
        TourSpecificationBuilder tourSpecificationBuilder = new TourSpecificationBuilder()
                .buildTourDescription(String.valueOf(getElementTextContent(element, "tour")))
                .buildTourType(TourType.valueOf(getElementTextContent(element, "tourType")))
                .buildNumberOfDays(Integer.parseInt(getElementTextContent(element, "numberOfDays")))
                .buildTransportType(TransportType.valueOf(getElementTextContent(element, "transport")))
                .buildCountry(String.valueOf(getElementTextContent(element, "country")))
                .buildPrice(new BigDecimal(getElementTextContent(element, "price")))
                .buildVisaNeeded(Boolean.parseBoolean(getElementTextContent(element, "visaNeeded")));
        TourSpecification tourSpecification = new TourSpecification(tourSpecificationBuilder);
        logger.debug("after tourSpecification " + tourSpecification.toString());

        AbstractTouristOrderBuilder builder = new TourOrdersDOMBuilder()
                .buildId(element.getAttribute("id"))
                .buildFirstname(String.valueOf(getElementTextContent(element, "firstname")))
                .buildLastname(String.valueOf(getElementTextContent(element, "lastname")))
                .buildDate(new SimpleDateFormat("yyyy-MM-dd").parse(getElementTextContent(element, "startDate")))
                .buildTourSpecification(tourSpecification);
        logger.debug("after buildTourSpecification ");

        return new TourOrder(builder);
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
