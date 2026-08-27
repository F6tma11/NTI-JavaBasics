package com.fatma.oop.project.animal;

import java.util.ArrayList;

public class Zoo {


    private ArrayList<Animal> animals;
    private String zooName;

    public Zoo(ArrayList<Animal> animals, String zooName) {
        this.animals = animals;
        setZooName(zooName);
    }


    public void addAnimal(Animal animal) {

        this.animals.add(animal);
        System.out.println(animal.getName()+" has been added "+this.zooName+"!");
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        if (zooName ==null || zooName.isBlank()){
            System.out.println("Zoo name empty ");
            return;
        }
        this.zooName = zooName;
    }

    public void  displayAllAnimals(){
        if (this.animals.isEmpty()){
            System.out.printf("Error: %s zoo is empty!",this.zooName);
            return;
        }

        for (Animal animal:this.animals){
            animal.displayInfo();
            System.out.println("=====================================================");
        }

    }

    public Animal findAnimalByName(String name){
        for(Animal animal:this.animals){
            if (animal.getName().equalsIgnoreCase(name)){
                return animal;
            }
        }
        return null;
    }

    public void removeAnimalByName(String name){
        Animal animal=this.findAnimalByName(name);

        if (animal==null){
            System.out.println("Animal not found");
            return;
        }

        this.animals.remove(animal);
        System.out.printf("%s removed from  %s zoo",animal.getName(),this.zooName);
    }

    public void feedAllAnimals(){
        for (Animal animal:this.animals){
            animal.eat();
        }
    }

    public void makeAllAnimalsSound(){
        for (Animal animal:this.animals){
            animal.makeSound();
        }
    }

    public void moveAllAnimals(){
        for (Animal animal:this.animals){
            animal.move();
        }
    }

    public int getTotalAnimals(){
        return this.animals.size();
    }

    public double getAverageAge(){
        double sum=0;
        if (this.animals.isEmpty()){
            System.out.println("Error: zoo ia empty");
            return 0;
        }
        for (Animal animal:this.animals){
            sum+=animal.getAge();
        }
        return sum/animals.size();
    }

    public void displayStatistics(){
        int catCount=0;
        int dogCount=0;
        int birdCount=0;
        int animalHealth=0;
        if(animals.isEmpty()){
            System.out.println("No animals in a zoo");
            return ;
        }
        System.out.println("Zoo name : "+this.zooName);
        System.out.println("Total animals : "+this.getTotalAnimals());
        System.out.println("Average age : "+this.getAverageAge());
        for (Animal animal:animals){
            if (animal.getSpecies().equalsIgnoreCase("Dog")){
                dogCount++;
            }else if(animal.getSpecies().equalsIgnoreCase("Cat")){
                catCount++;
            } else if (animal.getSpecies().equalsIgnoreCase("Bird")) {
                birdCount++;
            }

            if (animal.isInHealth()){
                animalHealth++;
            }
        }
        System.out.println("Cat : "+catCount+" Dog "+dogCount+" Bird "+birdCount);
        System.out.println("Healthy animals : "+animalHealth);
    }

    public void searchBySpecies(String species){
        if(animals.isEmpty()){
            System.out.println("No animals in a zoo");
            return ;
        }
        int count=0;
        for (Animal animal:this.animals){
            if (animal.getSpecies().equalsIgnoreCase(species)){
                animal.displayInfo();
                count++;
            }
        }

        if (count==0){
            System.out.println("Error:not found equal species.");
            return;
        }
        System.out.println(species+" is "+count);
    }

    public ArrayList<Animal> getHealthyAnimals(){
        if(animals.isEmpty()){
            System.out.println("No animals in a zoo");
            return new ArrayList<>();
        }
        ArrayList<Animal> healthyAnimal=new ArrayList<>();
        for (Animal animal:this.animals){
            if (animal.isInHealth()){
                healthyAnimal.add(animal);
            }
        }

        return healthyAnimal;
    }

    public ArrayList<Animal> getAnimalsByAgeRange(int minAge, int maxAge){
        ArrayList<Animal> inRangeAnimal=new ArrayList<>();

        if(animals.isEmpty()){
            System.out.println("No animals in a zoo");
            return new ArrayList<>();
        }

        for (Animal animal:this.animals){
            if (animal.getAge()>minAge && animal.getAge()<maxAge){
                inRangeAnimal.add(animal);
            }
        }

        return inRangeAnimal;
    }

}
