package by.epam.havansky.service.builder;

import by.epam.havansky.entity.TourType;
import by.epam.havansky.entity.TransportType;

import java.math.BigDecimal;

public class TourSpecificationBuilder {
    private String tourDescription;
    private TourType tourType;
    private int numberOfDays;
    private TransportType transportType;
    private String country;
    private BigDecimal price;
    private boolean visaNeeded;

    public TourSpecificationBuilder buildTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
        return this;
    }

    public TourSpecificationBuilder buildTourType(TourType tourType) {
        this.tourType = tourType;
        return this;
    }

    public TourSpecificationBuilder buildNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    public TourSpecificationBuilder buildTransportType(TransportType transportType) {
        this.transportType = transportType;
        return this;
    }

    public TourSpecificationBuilder buildCountry(String country) {
        this.country = country;
        return this;
    }

    public TourSpecificationBuilder buildPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TourSpecificationBuilder buildVisaNeeded(boolean visaNeeded) {
        this.visaNeeded = visaNeeded;
        return this;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public TourType getTourType() {
        return tourType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public String getCountry() {
        return country;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isVisaNeeded() {
        return visaNeeded;
    }

}
