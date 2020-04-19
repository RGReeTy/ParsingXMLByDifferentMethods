package by.epam.havansky.service.factory;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.xml_parsing_command.DomParseCommand;
import by.epam.havansky.controller.command.xml_parsing_command.ErrorMessageCommand;
import by.epam.havansky.controller.command.xml_parsing_command.SaxParseCommand;
import by.epam.havansky.controller.command.xml_parsing_command.StaxParseCommand;

public class TouristVoucherBuilderFactory {

    private TouristVoucherBuilderFactory() {
    }

    private static class TouristVoucherBuilderFactorySingleton {
        private static final TouristVoucherBuilderFactory INSTANCE = new TouristVoucherBuilderFactory();
    }

    public static TouristVoucherBuilderFactory getInstance() {
        return TouristVoucherBuilderFactorySingleton.INSTANCE;
    }

    public Command chooseParseCommand(String builderName) {
        switch (builderName) {
            case "SAX_PARSER":
                return new SaxParseCommand();
            case "STAX_PARSER":
                return new StaxParseCommand();
            case "DOM_PARSER":
                return new DomParseCommand();
            default:
                return new ErrorMessageCommand();
        }
    }
}

