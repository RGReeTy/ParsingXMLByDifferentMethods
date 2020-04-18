package by.epam.havansky.service.builder;

import by.epam.havansky.entity.TouristVoucher;
import by.epam.havansky.entity.TransportType;
import by.epam.havansky.entity.HotelSpecification;
import by.epam.havansky.entity.VoucherType;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTouristVoucherBuilder {
    protected Set<TouristVoucher> touristVoucherSet;
    private String id;
    private VoucherType voucherType;
    private String country;
    private Date date;
    private int numberDays;
    private TransportType transportType;
    private HotelSpecification hotelSpecification;
    private BigDecimal price;

    public AbstractTouristVoucherBuilder() {
        touristVoucherSet = new HashSet<>();
    }

    public AbstractTouristVoucherBuilder(Set<TouristVoucher> touristVoucherSet) {
        this.touristVoucherSet = touristVoucherSet;
    }

    public Set<TouristVoucher> getTouristVoucherSet() {
        return touristVoucherSet;
    }

    public abstract void buildSetTouristVouchers(InputStream file) throws ParseException;

    public AbstractTouristVoucherBuilder buildDate(Date date) {
        this.date = date;
        return this;
    }

    public AbstractTouristVoucherBuilder buildDaysNumber(int numberDays) {
        this.numberDays = numberDays;
        return this;
    }

    public AbstractTouristVoucherBuilder buildCountry(String country) {
        this.country = country;
        return this;
    }

    public AbstractTouristVoucherBuilder buildTransportType(TransportType transportType) {
        this.transportType = transportType;
        return this;
    }

    public AbstractTouristVoucherBuilder buildPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public AbstractTouristVoucherBuilder buildId(String id) {
        this.id = id;
        return this;
    }

    public AbstractTouristVoucherBuilder buildVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
        return this;
    }

    public AbstractTouristVoucherBuilder buildHotelSpecification(HotelSpecification hotelSpecification) {
        this.hotelSpecification = hotelSpecification;
        return this;
    }

    public String getId() {
        return id;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public String getCountry() {
        return country;
    }

    public Date getDate() {
        return date;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public HotelSpecification getHotelSpecification() {
        return hotelSpecification;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
