package by.epam.havansky.entity;

import by.epam.havansky.service.builder.HotelSpecificationBuilder;

public class HotelSpecification {
    private int starsNumber;
    private MealType mealType;
    private int numberOfRooms;
    private boolean airCondition;
    private boolean tv;
    private boolean wifi;
    private boolean parking;

    public HotelSpecification(HotelSpecificationBuilder builder) {
        this.starsNumber = builder.getStarsNumber();
        this.mealType = builder.getMealType();
        this.numberOfRooms = builder.getNumberOfRooms();
        this.airCondition = builder.isAirCondition();
        this.tv = builder.isTv();
        this.wifi = builder.isWifi();
        this.parking = builder.isParking();
    }

    public HotelSpecification() {

    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "HotelSpecification{" +
                "starsNumber=" + starsNumber +
                ", mealType=" + mealType +
                ", numberOfRooms=" + numberOfRooms +
                ", airCondition=" + airCondition +
                ", tv=" + tv +
                ", wifi=" + wifi +
                ", parking=" + parking +
                '}';
    }
}
