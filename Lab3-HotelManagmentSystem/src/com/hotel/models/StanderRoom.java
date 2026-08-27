package com.hotel.models;

public class StanderRoom extends Room{
    public StanderRoom(String roomNumber, int baseRate) {
        super(roomNumber, baseRate);
    }

    @Override
    public String getDescription() {
        return "Stander Room";
    }
}
