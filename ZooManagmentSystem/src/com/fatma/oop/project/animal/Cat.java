package com.fatma.oop.project.animal;

public class Cat extends Animal {
    private String furColor;
    private boolean isIndoor;

    public Cat(String name, int age, String species, double weight, boolean inHealth,String furColor,boolean isIndoor) {
        super(name, age, species, weight, inHealth);
        setFurColor(furColor);
        setIndoor(isIndoor);
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        if(furColor == null || furColor.isBlank()){
            System.out.println("Error: FurColor must not be empty.");
            return;
        }
        this.furColor = furColor;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {

        isIndoor = indoor;
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" says: Meow!");
    }

    @Override
    public void move() {
        System.out.println(getName()+" is sneaking quietly");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(
                " FurColor is : "+furColor
                +"\n indoor is : "+isIndoor
        );
    }

    public void meow(){
        System.out.println(getName()+" is meowing softly");
    }
    public void purr(){
        System.out.println(getName()+" is purring contentedly");
    }
    public void scratch(){
        System.out.println(getName()+" is scratching the post");
    }
}
