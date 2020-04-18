package by.epam.havansky.service.factory;

import by.epam.havansky.controller.command.parsecommand.DomParseCommand;
import by.epam.havansky.controller.command.parsecommand.ErrorMessageCommand;
import by.epam.havansky.controller.command.parsecommand.SaxParseCommand;
import by.epam.havansky.controller.command.parsecommand.StaxParseCommand;
import by.epam.havansky.controller.command.Command;

public class TouristVoucherBuilderFactory {

    private TouristVoucherBuilderFactory() {
    }

    private static class TouristVoucherBuilderFactoryHolder {
        private static final TouristVoucherBuilderFactory INSTANCE = new TouristVoucherBuilderFactory();
    }

    public static TouristVoucherBuilderFactory getInstance() {
        return TouristVoucherBuilderFactoryHolder.INSTANCE;
    }

    public Command chooseParseCommand(String builderName) {
        switch (builderName) {
            case "DOM_PARSER":
                return new DomParseCommand();
            case "SAX_PARSER":
                return new SaxParseCommand();
            case "STAX_PARSER":
                return new StaxParseCommand();
            default:
                return new ErrorMessageCommand();
        }
    }
}

