package by.epam.havansky.service.validator;

import by.epam.havansky.controller.command.CommandType;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class XSDValidator extends DefaultHandler {
    private static final Logger logger = Logger.getLogger(XSDValidator.class);

    private static final String TEMP_XML_FILE_FOR_SAVING = "tempXmlFile.xml";
    private static final String XSD_VALIDATION_FILE = "touristOrders.xsd";

    private XSDValidator() {
        logger.info("XSDValidator constructor ");
    }

    private static class XSDValidatorHolder {
        private static final XSDValidator INSTANCE = new XSDValidator();
    }

    public static XSDValidator getInstance() {
        return XSDValidatorHolder.INSTANCE;
    }

    public void validateXMLSchema(HttpServletRequest request) {
        logger.info("validateXMLSchema starts (XSDValidator.kava) ");
        try {
            File targetFile = writeTemporaryFile(request);
            File xsdFile = new File(getTourOrdersXsdPath());
            logger.info("getTourOrdersXsdPath return the temp file (XSDValidator.java) ");
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            logger.info("SchemaFactory cr8 (XSDValidator.java) ");
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(targetFile));
        } catch (IOException | ServletException | SAXException e) {
            logger.error(e);
        }
    }

    private String getTourOrdersXsdPath() {
        logger.info("getTourOrdersXsdPath starts (XSDValidator.java) ");
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource(XSD_VALIDATION_FILE).getPath();
    }

    private File writeTemporaryFile(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart(CommandType.FILE.getValue());
        logger.info("Loading filepart from request");
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        File tempFile = new File(TEMP_XML_FILE_FOR_SAVING);
        OutputStream outputStream = new FileOutputStream(tempFile);
        outputStream.write(buffer);

        return tempFile;
    }
}
