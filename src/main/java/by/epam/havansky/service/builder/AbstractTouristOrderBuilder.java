package by.epam.havansky.service.builder;

import by.epam.havansky.entity.TourOrder;
import by.epam.havansky.entity.TourSpecification;

import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTouristOrderBuilder {
    protected Set<TourOrder> tourOrderSet;
    private String id;
    private String firstname;
    private String lastname;
    private LocalDate date;
    private TourSpecification tourSpecification;


    public AbstractTouristOrderBuilder() {
        tourOrderSet = new HashSet<>();
    }

    public AbstractTouristOrderBuilder(Set<TourOrder> tourOrderSet) {
        this.tourOrderSet = tourOrderSet;
    }

    public Set<TourOrder> getTourOrderSet() {
        return tourOrderSet;
    }

    public abstract void buildSetTourOrders(InputStream file) throws ParseException;

    public AbstractTouristOrderBuilder buildId(String id) {
        this.id = id;
        return this;
    }

    public AbstractTouristOrderBuilder buildFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public AbstractTouristOrderBuilder buildLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public AbstractTouristOrderBuilder buildDate(LocalDate date) {
        this.date = date;
        return this;
    }


    public AbstractTouristOrderBuilder buildTourSpecification(TourSpecification tourSpecification) {
        this.tourSpecification = tourSpecification;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDate() {
        return date;
    }

    public TourSpecification getTourSpecification() {
        return tourSpecification;
    }
}
