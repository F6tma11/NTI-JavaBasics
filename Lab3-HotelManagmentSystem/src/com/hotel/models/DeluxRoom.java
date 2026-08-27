package com.hotel.models;

public class DeluxRoom extends Room{
    public DeluxRoom(String roomNumber, int baseRate) {
        super(roomNumber, baseRate);
    }

    @Override
    public String getDescription() {
        return "Delux Room";
    }
}
