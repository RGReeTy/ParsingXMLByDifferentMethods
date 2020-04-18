package by.epam.havansky.controller.command;

public enum CommandType {
    COMMAND("command"),
    ERROR("error"),
    FILE("file");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
