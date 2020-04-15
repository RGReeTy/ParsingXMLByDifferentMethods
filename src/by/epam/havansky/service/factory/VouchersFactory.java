package by.epam.havansky.service.factory;


import by.epam.havansky.controller.command.Command;
import by.epam.havansky.controller.command.command_impl.ErrorMessage;
import by.epam.havansky.controller.command.command_impl.XMLParseDOM;
import by.epam.havansky.controller.command.command_impl.XMLParseSAX;
import by.epam.havansky.controller.command.command_impl.XMLParseStAX;

public class VouchersFactory {

    private VouchersFactory() {
    }

    private static class VouchersFactoryHolder {
        private static final VouchersFactory INSTANCE = new VouchersFactory();
    }

    public static VouchersFactory getInstance() {
        return VouchersFactoryHolder.INSTANCE;
    }

    public Command chooseParseCommand(String builderName) {
        switch (builderName) {
            case "DOM":
                return new XMLParseDOM();
            case "SAX":
                return new XMLParseSAX();
            case "STAX":
                return new XMLParseStAX();
            default:
                return new ErrorMessage();
        }
    }

}
