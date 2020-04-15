package by.epam.havansky.service.builder;

import by.epam.havansky.entity.MealType;

public class HotelSpecificationBuilder {

    private int starsNumber;
    private MealType mealType;
    private int numberOfRooms;
    private boolean airCondition;
    private boolean tv;
    private boolean wifi;
    private boolean parking;

    public HotelSpecificationBuilder buildStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
        return this;
    }

    public HotelSpecificationBuilder buildMealType(MealType mealType) {
        this.mealType = mealType;
        return this;
    }

    public HotelSpecificationBuilder buildNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        return this;
    }

    public HotelSpecificationBuilder buildAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
        return this;
    }

    public HotelSpecificationBuilder buildTv(boolean tv) {
        this.tv = tv;
        return this;
    }

    public HotelSpecificationBuilder buildWifi(boolean wifi) {
        this.wifi = wifi;
        return this;
    }

    public HotelSpecificationBuilder buildParking(boolean parking) {
        this.parking = parking;
        return this;
    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public MealType getMealType() {
        return mealType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public boolean isTv() {
        return tv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean isParking() {
        return parking;
    }
}
