package com.fatma.oop.project.animal;

public class Bird extends Animal {

    private double wingSpan;
    private boolean canFly;

    public Bird(String name, int age, String species, double weight, boolean inHealth,double wingSpan,boolean canFly) {
        super(name, age, species, weight, inHealth);
        setCanFly(canFly);
        setWingSpan(wingSpan);
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        if (wingSpan<=0){
            System.out.println("Error:Wing span should be greater than 0");
            return;
        }
        this.wingSpan = wingSpan;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public void makeSound(){
        System.out.println(this.getName()+" says: Tweet! Tweet!");
    }
    @Override
    public void move(){
        if(this.canFly){
            System.out.println(this.getName()+" is flying");
        }else{
            System.out.println(this.getName()+" is hopping");
        }
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println(
                "Wing span : "+this.wingSpan
                +"\nflight is : "+this.canFly
        );
    }
    public void chirp(){
        System.out.println(this.getName()+" is chirping melodiously");
    }
    public void fly(){
        if(!this.canFly){
            System.out.println(this.getName()+" is chirping melodiously");
        }else{
            System.out.println(this.getName()+" cannot fly");
        }
    }
    public void buildNest(){
        System.out.println(this.getName()+" is building a nest");
    }
}
