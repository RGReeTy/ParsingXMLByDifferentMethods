package by.epam.havansky.controller.command;

public enum PageType {
    DEFAULT_PAGE("/index.jsp"),
    PARSE_RESULT_PAGE("/resultTable.jsp"),
    ERROR_PAGE("/error.jsp");

    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
