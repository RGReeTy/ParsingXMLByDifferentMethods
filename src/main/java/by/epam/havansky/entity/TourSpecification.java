package by.epam.havansky.entity;

import by.epam.havansky.service.builder.TourSpecificationBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TourSpecification implements Serializable {

    private String tourDescription;
    private TourType tourType;
    private int numberOfDays;
    private TransportType transportType;
    private String country;
    private BigDecimal price;
    private boolean visaNeeded;

    public TourSpecification(TourSpecificationBuilder builder) {
        this.tourDescription = builder.getTourDescription();
        this.tourType = builder.getTourType();
        this.numberOfDays = builder.getNumberOfDays();
        this.transportType = builder.getTransportType();
        this.country = builder.getCountry();
        this.price = builder.getPrice();
        this.visaNeeded = builder.isVisaNeeded();
    }

    public TourSpecification() {

    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isVisaNeeded() {
        return visaNeeded;
    }

    public void setVisaNeeded(boolean visaNeeded) {
        this.visaNeeded = visaNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpecification that = (TourSpecification) o;
        return numberOfDays == that.numberOfDays &&
                visaNeeded == that.visaNeeded &&
                Objects.equals(tourDescription, that.tourDescription) &&
                tourType == that.tourType &&
                transportType == that.transportType &&
                Objects.equals(country, that.country) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourDescription, tourType, numberOfDays, transportType, country, price, visaNeeded);
    }

    @Override
    public String toString() {
        return "TourSpecification{" +
                "tourDescription='" + tourDescription + '\'' +
                ", tourType=" + tourType +
                ", numberOfDays=" + numberOfDays +
                ", transportType=" + transportType +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", visaNeeded=" + visaNeeded +
                '}';
    }


}
