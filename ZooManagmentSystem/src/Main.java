import com.fatma.oop.project.animal.*;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scan=new Scanner(System.in);
    private static ArrayList<Animal> animals=new ArrayList<>();
    private static Zoo zoo;
    public static void main(String[] args) {
        zoo=new Zoo(animals,"Rakan");
        Animal dog1 = new Dog("Max", 3, "Dog", 25.5, true, "German Shepherd");

        Animal dog2 = new Dog("Rocky", 7, "Dog", 18.0, false, "Labrador");

        Animal cat1 = new Cat("Luna", 2, "Cat", 4.5, true, "White", true);

        Animal cat2 = new Cat("Simba", 5, "Cat", 6.2, false, "Orange", false);

        Animal bird1 = new Bird("Rio", 1, "Bird", 0.5, true, 25.0, true);

        Animal bird2 = new Bird("Kiwi", 4, "Bird", 0.8, false, 15.0, false);

        zoo.addAnimal(dog1);
        zoo.addAnimal(dog2);
        zoo.addAnimal(cat1);
        zoo.addAnimal(cat2);
        zoo.addAnimal(bird1);
        zoo.addAnimal(bird2);

        start();
    }

    public static void displayMenu(){
        System.out.println("==========================Zoo Management System is opened===============================");
        System.out.println("1-Add animal");
        System.out.println("2-Display all Animal");
        System.out.println("3-Search animal by name");
        System.out.println("4-Remove animal");
        System.out.println("5-Feed all animals");
        System.out.println("6-Make all animals sound");
        System.out.println("7-Move all animals");
        System.out.println("8-Display Statistics");
        System.out.println("9-Search by species");
        System.out.println("10-Show healthy animals");
        System.out.println("11-Animal actions menu");
        System.out.println("0-Exit");
    }

    public static void start(){

        while (true){
            displayMenu();
            System.out.print("Enter number of action : ");
            int num=Integer.parseInt(scan.nextLine());

            switch(num){
                case 1:
                    addAnimal();
                    break;
                case 2:
                    displayAllAnimals();
                    break;
                case 3:
                    searchAnimalByName();
                    break;
                case 4:
                    removeAnimal();
                    break;
                case 5:
                    feedAllAnimals();
                    break;
                case 6:
                    makeSounds();
                    break;
                case 7:
                    moveAnimals();
                    break;
                case 8:
                    displayStatistics();
                    break;
                case 9:
                    searchBySpecies();
                    break;
                case 10:
                    showHealthyAnimals();
                    break;
                case 11:
                    getAnimalActionMenu();
                    break;
                case 0:
                    return;

        }


        }

    }

    public static void addAnimal(){
        System.out.print("Enter species Dog , Cat , Bird : ");
        String species=scan.nextLine();
        if (species.isEmpty()){
            System.out.println("Error: species can not be null.\n You should enter species.");
            return;
        }
        System.out.print("Enter animal name : ");
        String name=scan.nextLine();
        if (name == null||name.isBlank()){
            System.out.println("Error: name can not be null.\n You should enter name.");
            return;
        }
        System.out.print("Enter animal age : ");
        int age= scan.nextInt();
        scan.nextLine();
        if (age<=0 || age >50){
            System.out.println("Error: age must be grater than 0 and smaller than 50.");
            return;
        }
        System.out.print("Enter animal weight : ");
        double weight=Double.parseDouble(scan.nextLine());
        if (weight<=0){
            System.out.println("Error: Weight must be grater than 0.");
            return;
        }
        System.out.print("Enter animal health : ");
        boolean inHealth=Boolean.parseBoolean(scan.nextLine());

        if(species.equalsIgnoreCase("Dog")){
            System.out.print("Enter Breed for dog : ");
            String breed=scan.nextLine();
            if(breed==null || breed.isBlank()){
                System.out.println("Error: breed must not be empty.");
                return;
            }
            Dog dog=new Dog(name,age,species,weight,inHealth,breed);
            zoo.addAnimal(dog);
        }
        else if(species.equalsIgnoreCase("Cat")){
            System.out.print("Enter fur color for cat : ");
            String furColor=scan.nextLine();
            if(furColor == null || furColor.isBlank()){
                System.out.println("Error: FurColor must not be empty.");
                return;
            }
            System.out.print("Cat is in door : ");
            boolean inDoor=Boolean.parseBoolean(scan.nextLine());
            Cat cat=new Cat(name,age,species,weight,inHealth,furColor,inDoor);
            zoo.addAnimal(cat);
        }
        else if(species.equalsIgnoreCase("Bird")){
            System.out.print("Enter bird wing span true/false : ");
            double wingSpan=Double.parseDouble(scan.nextLine());
            if (wingSpan<=0){
                System.out.println("Error:Wing span should be greater than 0");
                return;
            }
            System.out.print("Bird is fly true/false: ");
            boolean canFly=Boolean.parseBoolean(scan.nextLine());
            Bird bird=new Bird(name,age,species,weight,inHealth,wingSpan,canFly);
            zoo.addAnimal(bird);
        }
    }

    public static void displayAllAnimals(){
        zoo.displayAllAnimals();
    }

    public static void searchAnimalByName(){
        System.out.print("Enter animal name : ");
        String name=scan.nextLine();
        Animal animal=zoo.findAnimalByName(name);
        if(animal!=null){
            animal.displayInfo();
        }else {
            System.out.println("Animal not found");
        }
    }

    public static void removeAnimal(){
        System.out.print("Enter animal name : ");
        String name=scan.nextLine();
        zoo.removeAnimalByName(name);
    }

    public static void feedAllAnimals(){
        zoo.feedAllAnimals();
    }

    public static void makeSounds(){
        zoo.makeAllAnimalsSound();
    }

    public static void moveAnimals(){
        zoo.moveAllAnimals();
    }

    public static void displayStatistics(){
        zoo.displayStatistics();
    }

    public static void searchBySpecies(){
        System.out.print("Species search : Cat , Dog , Bird");
        String species=scan.nextLine();
        zoo.searchBySpecies(species);
    }

    public static void showHealthyAnimals(){
        ArrayList<Animal>healthyAnimals=zoo.getHealthyAnimals();
        for (Animal animal:healthyAnimals){
            animal.displayInfo();
        }
    }

    public static void getAnimalActionMenu(){
        System.out.print("Enter animal name : ");
        String name=scan.nextLine();
        Animal animal=zoo.findAnimalByName(name);
        if (animal==null){
            System.out.println("This animal not found");
            return;
        }
        if (animal instanceof Dog){
            Dog dog=(Dog) animal;
            System.out.println("========== Dog Actions ==========");
            System.out.println("1- Bark");
            System.out.println("2- Fetch");
            System.out.println("3- Wag Tail");
            System.out.println("0- Back");

            System.out.print("Choose action: ");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    dog.bark();
                    break;

                case 2:
                    dog.fetch();
                    break;

                case 3:
                    dog.wagTail();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid action.");
            }
        }
        else if (animal instanceof Bird){
            Bird bird = (Bird) animal;

            System.out.println("========== Bird Actions ==========");
            System.out.println("1- Chirp");
            System.out.println("2- Fly");
            System.out.println("3- Build Nest");
            System.out.println("0- Back");

            System.out.print("Choose action: ");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    bird.chirp();
                    break;

                case 2:
                    bird.fly();
                    break;

                case 3:
                    bird.buildNest();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid action.");
            }
        }

        else if (animal instanceof Cat){
            Cat cat = (Cat) animal;

            System.out.println("========== Cat Actions ==========");
            System.out.println("1- Meow");
            System.out.println("2- Purr");
            System.out.println("3- Scratch");
            System.out.println("0- Back");

            System.out.print("Choose action: ");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    cat.meow();
                    break;

                case 2:
                    cat.purr();
                    break;

                case 3:
                    cat.scratch();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid action.");
            }
        }
    }


}