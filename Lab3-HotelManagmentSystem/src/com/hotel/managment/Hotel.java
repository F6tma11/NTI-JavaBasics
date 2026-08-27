package com.hotel.managment;

import com.hotel.models.Customer;
import com.hotel.models.Room;
import com.hotel.services.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

    private HashMap<String , Room> rooms;
    private String hotelName;

    public Hotel() {
        rooms=new HashMap<>();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void addRoom(Room room){

        if (rooms.get(room.getRoomNumber())!=null){
            System.out.println("Room number can not duplicated.This room is already exist.");
            return;
        }
        rooms.put(room.getRoomNumber(),room);
    }

    public Room getRoom(String roomNum){
        return rooms.get(roomNum);
    }

    public void bookRoom(String roomNumber, Customer customer, Service...services){
        Room room=rooms.get(roomNumber);
        if (room==null){
            System.out.println("This room not exist.");
            return;
        }

        if (room.isBooked()){
            System.out.println("This room already booked");
            return;
        }
        room.bookRoom(customer);
        room.addMultipleServices(services);
    }

    public void displayBookingDetails(String roomNumber){
        System.out.println(rooms.get(roomNumber).getBookingDetails());
    }

    public void displayAllRooms(){
        for (Map.Entry<String,Room> room:rooms.entrySet()){
            System.out.println(room.getValue().toString());
        }
    }

    public List<Room> getAvailableRoom(){
        List<Room> availableRoom=new ArrayList<>();
        for (Map.Entry<String,Room> room:rooms.entrySet()){
            if (room.getValue().isBooked()){
                continue;
            }
            availableRoom.add(room.getValue());
        }
        return availableRoom;
    }


}
