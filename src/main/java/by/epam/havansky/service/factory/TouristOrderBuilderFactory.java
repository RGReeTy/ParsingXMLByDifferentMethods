package by.epam.havansky.service.factory;

import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.xml_parsing.DomParseCommand;
import by.epam.havansky.controller.command.xml_parsing.ErrorMessageCommand;
import by.epam.havansky.controller.command.xml_parsing.SaxParseCommand;
import by.epam.havansky.controller.command.xml_parsing.StaxParseCommand;

public class TouristOrderBuilderFactory {

    private TouristOrderBuilderFactory() {
    }

    private static class TouristOrderBuilderFactorySingleton {
        private static final TouristOrderBuilderFactory INSTANCE = new TouristOrderBuilderFactory();
    }

    public static TouristOrderBuilderFactory getInstance() {
        return TouristOrderBuilderFactorySingleton.INSTANCE;
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

