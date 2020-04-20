package by.epam.havansky.entity;

import by.epam.havansky.service.builder.AbstractTouristOrderBuilder;

import java.util.Date;
import java.util.Objects;

public class TourOrder {

    private String id;
    private String firstname;
    private String lastname;
    private Date date;
    private TourSpecification tourSpecification;

    public TourOrder(AbstractTouristOrderBuilder builder) {
        this.id = builder.getId();
        this.firstname = builder.getFirstname();
        this.lastname = builder.getLastname();
        this.date = builder.getDate();
        this.tourSpecification = builder.getTourSpecification();
    }


    public TourOrder() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TourSpecification getTourSpecification() {
        return tourSpecification;
    }

    public void setTourSpecification(TourSpecification tourSpecification) {
        this.tourSpecification = tourSpecification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourOrder tourOrder = (TourOrder) o;
        return Objects.equals(id, tourOrder.id) &&
                Objects.equals(firstname, tourOrder.firstname) &&
                Objects.equals(lastname, tourOrder.lastname) &&
                Objects.equals(date, tourOrder.date) &&
                Objects.equals(tourSpecification, tourOrder.tourSpecification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, date, tourSpecification);
    }

    @Override
    public String toString() {
        return "TourOrder{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", date=" + date +
                ", tourSpecification=" + tourSpecification +
                '}';
    }
}
