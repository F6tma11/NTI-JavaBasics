package com.hotel.models;

import com.hotel.services.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Room {

    private String roomNumber ;
    private int baseRate;
    private ArrayList<Service> services;
    private boolean isBooked;
    private Customer customer;

    public Room(String roomNumber,int baseRate) {
        services=new ArrayList<>();
        if (roomNumber==null||roomNumber.isBlank()){
            System.out.println("Room number can not be empty");
            throw new IllegalArgumentException("Room number can not be empty");
        }
        if (baseRate<=0){
            System.out.println("Room base rate should be greater than zero");
            throw new IllegalArgumentException("Room base rate should be greater than zero");
        }
        this.roomNumber=roomNumber;
        this.baseRate=baseRate;
    }

    public abstract String getDescription();

    public void addService(Service service){
        if (isBooked){
            services.add(service);
        }else {
            System.out.println("Cannot add service: room is not booked");
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void addMultipleServices(Service... services){
        if (services!=null){
            for (Service service:services){
               addService(service);
            }
        }
    }

    public double getTotalCost(){
        double totalCost=baseRate;
        for(Service service:services){
            totalCost+=service.getCost();
        }
        return totalCost;
    }

    public void bookRoom(Customer customer){
         if (isBooked){
             System.out.println("Room is already booked.");
             return;
         }

         isBooked=true;
         this.customer=customer;

    }

    public List<Service> getServices(){

        return new ArrayList<>(services);
    }

    public String getBookingDetails(){
        StringBuilder details=new StringBuilder();
        details.append("Room number : ")
                .append(roomNumber)
                .append("\nDescription room")
                .append(getDescription())
                .append("\nServices : \n");

        for (Service service:services){
            details.append("- ")
                    .append(service.getName())
                    .append(": $")
                    .append(service.getCost())
                    .append("\n");
        }

        details.append("\nTotal cost : $")
                .append(getTotalCost());
        return  details.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && isBooked == room.isBooked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, isBooked);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", baseRate=" + baseRate +
                ", services=" + services +
                ", isBooked=" + isBooked +
                ", customer=" + customer +
                '}';
    }
}
