package by.epam.xmlparsing.controller.command;


import by.epam.xmlparsing.controller.command.xml_parsing.XMLParsing_DOM;
import by.epam.xmlparsing.controller.command.xml_parsing.XMLParsing_SAX;
import by.epam.xmlparsing.controller.command.xml_parsing.XMLParsing_StAX;

public enum CommandEnum {

    DOM {
        {
            this.command = new XMLParsing_DOM();
        }
    },
    SAX {
        {
            this.command = new XMLParsing_SAX();
        }
    },
    StAX {
        {
            this.command = new XMLParsing_StAX();
        }
    },
    GO_TO_PAGE {
        {
            this.command = new GoToPageCommand();
        }
    };

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}