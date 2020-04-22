package by.epam.havansky.service.builder;

public enum TouristOrderEnum {
    TOURISTORDERS("touristOrders"),
    TOURISTORDER("touristOrder"),
    ID("id"),
    FIRSTNAME("firstname"),
    LASTNAME("lastname"),
    STARTDATE("startDate"),

    TOUR("tour"),
    TOURTYPE("tourType"),
    NUMBEROFDAYS("numberOfDays"),
    TRANSPORT("transport"),
    COUNTRY("country"),
    PRICE("price"),
    VISANEEDED("visaNeeded"),

    TOURSPECIFICATION("tourSpecification");


    private String value;

    TouristOrderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
