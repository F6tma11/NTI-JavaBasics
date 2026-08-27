package com.fatma.oop.project.animal;

public class Dog extends Animal {

    private String breed;


    public Dog(String name, int age, String species, double weight, boolean inHealth,String breed) {
        super(name, age, species, weight, inHealth);
        setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        if(breed==null || breed.isBlank()){
            System.out.println("Error: breed must not be empty.");
            return;
        }
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" says: Woof! Woof");
    }

    @Override
    public void move() {
        System.out.println(getName()+" is running");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" the breed "+this.breed);
    }

    public void bark(){
        System.out.println(getName()+" is barking loudly!");
    }
    public void fetch() {
        System.out.println(getName()+" is fetching the ball");
    }
    public void wagTail(){
        System.out.println(getName()+" is wagging tail happily!");
    }

}
