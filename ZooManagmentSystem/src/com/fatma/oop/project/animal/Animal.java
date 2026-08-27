package com.fatma.oop.project.animal;

public class Animal {

    private String name;
    private int age;
    private String species;
    private double weight;
    private boolean inHealth;

    //All arg constructor
    public Animal(String name, int age, String species, double weight, boolean inHealth) {
      this.setName(name);
      this.setWeight(weight);
      this.setAge(age);
      this.setSpecies(species);
      this.setWeight(weight);
      this.setInHealth(inHealth);
    }

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()|| name == null){
            System.out.println("Error: name can not be null.\n You should enter name.");
            return;
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=0 || age >50){
            System.out.println("Error: age must be grater than 0 and smaller than 50.");
            return;
        }
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species.isEmpty()){
            System.out.println("Error: species can not be null.\n You should enter species.");
            return;
        }
        this.species = species;
    }

    public double getweight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight<=0){
            System.out.println("Error: Wight must be grater than 0.");
            return;
        }

        this.weight = weight;
    }

    public boolean isInHealth() {
        return inHealth;
    }

    public void setInHealth(boolean inHealth) {
        this.inHealth = inHealth;
    }

    //methods
    public void eat() {
        System.out.println(name+" is eating.");
    }
    public void sleep(){
        System.out.println(name+" is sleeping.");
    }
    public void makeSound(){
        System.out.println(name+" makes a sound.");
    }
    public void move(){
        System.out.println(name+" is moving.");
    }
    public void displayInfo(){

        System.out.println(
                "Animal name is : "+name
                        +"\n age is : "+age
                        +"\n species is : "+species
                        +"\n weight is : "+weight
                        +"\n in health is : "+inHealth
        );
    }
}
