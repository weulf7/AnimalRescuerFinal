package org.example;


import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Game {
    public static Scanner scanner=new Scanner(System.in);

    //Initializing objects
    Animal animal=new Animal();
    Adopter adopter = new Adopter();
    Animal dog=new Dog();
    Animal cat=new Cat();

//Creating Lists
    Animal[]availableAnimals=new Animal[2];
    AnimalFood[]availableFood=new AnimalFood[6];
    EntertainmentActivity[]availableActivity=new EntertainmentActivity[4];


//Start method
    public  void start(){
//        System.out.println("Welcome to AnimalRescuer 1.0");
//        System.out.println("Greetings!!In order to continue you have to choose a username for yourself.\r");
//        System.out.println();
//        initRescuer();
//        System.out.println();
//        userAge();
//        System.out.println();
//        gender();
//        System.out.println();
        initAnimals();
//        System.out.println();
//        nameOfAnimal();
//        displayMenu();
//        feeding();
        System.out.println(dog.getFavoriteActivity());


    }









    //User information


    public String initRescuer(){
        System.out.println("Please enter a username for yourself:");
        String userName = scanner.nextLine();
        adopter.setName(userName);
        if (!userName.isEmpty()){
            System.out.println("Thank you,and welcome "+adopter.getName());
        }else {
            System.out.println("This field cannot be empty");
            return initRescuer();
        }
        return userName;

    }



    public int userAge(){
        System.out.println("In order to continue you must be at least 10 years old.");
        System.out.println(adopter.getName()+",please enter your age:");
        int age = scanner.nextInt();
        if (age>=10){
            System.out.println(adopter.getName()+" so you have "+age+",you can continue.");
        }else {
            System.out.println("You don't have at least 10 years old.");
            return userAge();
        }
return 0;

    }

    public char gender(){
        System.out.println("We are almost done "+adopter.getName()+",we just need your gender.");
        System.out.println("Please select your gender(f/m):");
        String genderOption = scanner.next();
        if (genderOption=="m" ||!genderOption.isEmpty()){
            System.out.println(adopter.getName()+",so you are a boy.");
        }else if (genderOption=="f"){
            System.out.println(adopter.getName()+",so you are a girl.");
        }else{
            System.out.println("Invalid option.Please try again");
            return gender();
        }

    return 0;

    }





//Animal interactions

    public static void makingActivity(){

    }
    public void feeding(){
        animal.setHungerState(1);
        if (animal.getHungerState()>0){
            System.out.println("Your animal is hungry,you must feed him.her.You wanna feed her?:");
            String option = scanner.next();

        }else {
            System.out.println("Your animal isn t hungry");
        }

    }



//Setting up animals to user to choose

    //
    public  String nameOfAnimal(){
        System.out.println("So,"+adopter.getName()+" the next step would be to give a name to your new buddy.");
        System.out.println("Please enter the name of your pet:");
        String animalName = scanner.next();
        animal.setName(animalName);
        if (!animalName.isEmpty()){
            System.out.println(adopter.getName()+",welcome your buddy,"+animal.getName()+"!");
        }else if (animalName.isEmpty()){
            System.out.println("This field cannot be empty!");
            return nameOfAnimal();
        }
        return animalName;


    }





    //Initializing animals/food/activity

    public void initAnimals(){
        Animal dog=new Animal();
        dog.setType("Dog");
        dog.setHungerState(1);
        dog.setAge(1);
        dog.setFavoriteActivity("Walking");
        dog.setFavoriteFood("Bone");
        dog.setSpiritState(8);
        dog.setHealthState( ThreadLocalRandom.current().nextInt(0,10));
        availableAnimals[0]=dog;

        Animal cat=new Animal();
        cat.setType("Cat");
        cat.setHungerState(1);
        cat.setAge(1);
        cat.setFavoriteActivity("Playing with ball");
        cat.setFavoriteFood("Milk");
        cat.setSpiritState(8);
        cat.setHealthState(ThreadLocalRandom.current().nextInt(0,10));
        availableAnimals[1]=cat;

        displayAnimals();
        Animal selectedAnimal = getSelectedAnimal();
        System.out.println("You selected a "+selectedAnimal.getType()+".");
    }
    //initFood

    public void initFood(){
        AnimalFood animalFood1=new AnimalFood();
        animalFood1.setName("BioBone");
        animalFood1.setPrice(8);
        availableFood[0]=animalFood1;

        AnimalFood animalFood2=new AnimalFood();
        animalFood2.setName("Pedigree");
        animalFood2.setPrice(10);
        availableFood[1]=animalFood2;

        AnimalFood animalFood3=new AnimalFood();
        animalFood3.setName("Bone");
        animalFood3.setPrice(5);
        availableFood[2]=animalFood3;

        AnimalFood animalFood4=new AnimalFood();
        animalFood4.setName("Whiskas");
        animalFood4.setPrice(10);
        availableFood[3]=animalFood4;

        AnimalFood animalFood5=new AnimalFood();
        animalFood5.setName("Fish");
        animalFood5.setPrice(8);
        availableFood[4]=animalFood5;


        AnimalFood animalFood6=new AnimalFood();
        animalFood6.setName("Milk");
        animalFood6.setPrice(5);
        availableFood[5]=animalFood6;

        displayFood();
        AnimalFood selectedFood = getSelectedFood();
        System.out.println("you have selected "+selectedFood.getName()+".");

    }
    public void displayMenu() {
        char option = '\0';
        System.out.println("Available categories to select:");
        System.out.println("A.Feeding your pet.");
        System.out.println("B.Making some activity with your pet.");
        System.out.println("C.Exit application.");

        do {
            System.out.println("======================================================================");
            System.out.println("Enter an option");
            System.out.println("======================================================================");

           option = scanner.next().charAt(0);
            System.out.println('\n');

            switch (option) {
                case 'A':
                    System.out.println("-------------------------------------");
                    System.out.println("You choose feeding!");
                    System.out.println("-------------------------------------");
                    initFood();
                    break;
                case 'B':
                    System.out.println("-------------------------------------");
                    System.out.println("you choose making activity!");
                    System.out.println("-------------------------------------");
                    initActivity();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }



        }

        while (option != 'C');
        System.out.println("Thank you for playing AnimalRescuer!");

    }





    //initActivity

    public void initActivity(){
        EntertainmentActivity entertainmentActivity=new EntertainmentActivity();
        entertainmentActivity.setName("Walking");
        availableActivity[0]=entertainmentActivity;

        EntertainmentActivity entertainmentActivity1=new EntertainmentActivity();
        entertainmentActivity1.setName("Playing with stick");
        availableActivity[1]=entertainmentActivity1;

        EntertainmentActivity entertainmentActivity2=new EntertainmentActivity();
        entertainmentActivity2.setName("Grooming");
        availableActivity[2]=entertainmentActivity2;


        EntertainmentActivity entertainmentActivity3=new EntertainmentActivity();
        entertainmentActivity3.setName("Playing with a ball");
        availableActivity[3]=entertainmentActivity3;

        displayActivities();
        EntertainmentActivity selectedActivity = getSelectedActivity();
        System.out.println("You have selected "+selectedActivity.getName());


    }




    //DISPLAYING ANIMALS,FOOD,ACTIVITY

    //Display animals
    public void displayAnimals(){
        System.out.println("You can select between the following animals:");
        for (int i=0;i<availableAnimals.length;i++){
            System.out.println(i+1+"."+availableAnimals[i].getType());
        }
    }

    //Display food
    public void displayFood() {
        System.out.println("Available foods at the moment:");
        for (int i = 0; i < availableFood.length; i++) {
            if (availableFood[i] != null)
                System.out.println(i + 1 + "." + availableFood[i].getName() + "-price:$" + availableFood[i].getPrice());
        }
    }


//Display activities

    public void displayActivities(){
        System.out.println("You can choose between the following activities:");
        for (int i=0;i<availableActivity.length;i++){
            if (availableActivity[i]!=null){
                System.out.println(i+1+"."+availableActivity[i].getName()+".");
            }
        }
    }

    //user selectors
    public Animal getSelectedAnimal(){
        System.out.println("Please select an animal to adopt(1/2):");
        int selector = scanner.nextInt();
        return availableAnimals[selector-1];
    }
    public AnimalFood getSelectedFood(){
        System.out.println("Select a food:");
        int selector = scanner.nextInt();
        return availableFood[selector-1];
    }

    public EntertainmentActivity getSelectedActivity(){
        System.out.println("Select an activity:");
        int selector = scanner.nextInt();
        return availableActivity[selector-1];
    }









    }











