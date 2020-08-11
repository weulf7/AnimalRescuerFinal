package org.example;









import java.util.InputMismatchException;
import java.util.Scanner;



public class Game {
    public static Scanner scanner=new Scanner(System.in);

    //Initializing objects
    Animal animal=new Animal();
    Adopter adopter = new Adopter();


//Creating Lists
    Animal[]availableAnimals=new Animal[2];
    AnimalFood[]availableFood=new AnimalFood[6];
    EntertainmentActivity[]availableActivity=new EntertainmentActivity[4];




//Start method
    public  void start() throws Exception {




        System.out.println("Welcome to AnimalRescuer 1.0");
        System.out.println();
        System.out.println("Some instructions before we start.To win the game your pet must reach spirit level 10,or hunger state 0.If your pet meet 1 of these conditions you win the game.");
        System.out.println();
        System.out.println("Greetings!!In order to continue you have to choose a username for yourself.\r");
        System.out.println();
        initRescuer();
        System.out.println();
        userAge();
        System.out.println();
        gender();
        System.out.println();
        initAnimals();
        System.out.println();
        initializeNewAnimal();
        feedingOption();
        displayMenu();


    }









    //User information

    public String initRescuer()  {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Please enter a username for yourself:");
        String name = scanner.nextLine();
        adopter.setName(name);

        while(!name.matches("[a-zA-Z]+")){
            System.out.println("Please enter a valid username using only words!");
            name = scanner.nextLine();
        }
        System.out.println("Welcome "+adopter.getName()+",enjoy the game!");
        return name;
    }



    public int userAge() {
        System.out.println("Please enter your age:");
        Scanner scanner = new Scanner(System.in);

        try{
            int option = scanner.nextInt();
            System.out.println("Your age is "+option+",is a valid age,you can continue!");
            return option;
        }catch (InputMismatchException exception){
            System.out.println("Please enter valid numbers!!!");
            return userAge();
        }
    }



    public char gender(){
        System.out.println("We are almost done "+adopter.getName()+",we just need your gender.");
        System.out.println("Please select your gender(f/m):");
        char genderOption = scanner.next().charAt(0);
        if(genderOption=='m'){
            System.out.println(adopter.getName()+",so you are a boy!");
        }else if (genderOption=='f'){
            System.out.println(adopter.getName()+",so you are a girl");
        }else {
            System.out.println("Invalid option,please try again!");
            return gender();
        }

    return 0;

    }





//Animal interactions








//Setting up animals to user to choose


    public String initializeNewAnimal(){

        animal.setHungerState(10);
        animal.setHealthState(10);
        System.out.println("So,"+adopter.getName()+" the next step would be to give a name to your new buddy.");
        System.out.println(adopter.getName()+",please enter the name of your pet:");
        String animalName = scanner.next();
        animal.setName(animalName);
        System.out.println(animal.getHungerState());
        if (!animalName.isEmpty()){
            System.out.println(adopter.getName()+",welcome your new buddy "+animal.getName());
        }else if (animalName.isEmpty()){
            System.out.println("This field cannot be empty!!!");
            return initializeNewAnimal();
        }
        return animalName;

    }




    public char feedingOption(){
        System.out.println(animal.getName()+"'s  hunger level is "+animal.getHungerState()+",you must feed "+animal.getName()+ "!!!");
        System.out.println("You wanna feed "+animal.getName() +"?(y/n)");
        char feedOption = scanner.next().charAt(0);
        if (feedOption=='y'){
            initFood();
        }else if (feedOption=='n'){
            System.out.println(animal.getName()+" will die if u don't feed him!Are you sure about that?(y/n)");
            char feedOption2 = scanner.next().charAt(0);
            if (feedOption2=='y'){
                initFood();
            }else if (feedOption2=='n'){
                System.out.println(animal.getName()+" has died because of hunger!!We warned you!");
                System.out.println("Game Over!!!");
                System.exit(0);
            }
        }else {
            System.out.println("Invalid option!!");
            return feedingOption();
        }
        return 0;
    }

    public char activityOption(){
        System.out.println(animal.getName()+"'s spirit level is very low.You must play with "+animal.getName()+"(y/n).");
        char option = scanner.next().charAt(0);
        if (option=='y'){
            initActivity();
        }else if (option=='n'){
            System.out.println("Are you sure,"+animal.getName()+"'s spirit level will dicrease,and it will cause your pet's death.Are you sure about that?(y/n)");
            char option3 = scanner.next().charAt(0);
            if (option3=='y'){
                initActivity();
            }else if (option3=='n'){
                System.out.println(animal.getName()+" died because it's spirit state decreased under 0.You lost the game!");
                System.exit(0);
            }else {
                System.out.println("Invalid option!!!");
                return activityOption();
            }
        }
        return 0;
    }





    //Initializing animals/food/activity

    public void initAnimals() throws Exception {
        Animal dog=new Animal();
        dog.setType("Dog");
        availableAnimals[0]=dog;

        Animal cat=new Animal();
        cat.setType("Cat");
        availableAnimals[1]=cat;

        displayAnimals();
        Animal selectedAnimal = getAnimalSelected();
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
        animal.hungerState-=5;
        System.out.println("Current hunger state of the animal:"+animal.getHungerState());

        if (animal.getHungerState()==0){
            System.out.println("Congratulations "+adopter.getName()+",you have won the game!!!");
            System.out.println("Thank you for playing Animal Rescuer!");
            System.exit(0);
        }



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
                    System.out.println("You choose making activity!");
                    System.out.println("-------------------------------------");
                    initActivity();
                    break;

                case 'C':
                    System.out.println("You choose to exit the game!");
                    System.exit(0);

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

        animal.spiritState+=2;

        if (animal.spiritState==10){
            System.out.println("Your animal has reached the highest spirit state.Congratulations,you won the game!!!!");
        }


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

    public Animal getAnimalSelected() throws Exception {
        System.out.println("Please select an animal to adopt(1/2)");
        Scanner scanner = new Scanner(System.in);
        try{
            char option = scanner.next().charAt(0);
            System.out.println("You have selected "+availableAnimals[option-1]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have entered invalid number");
            return getAnimalSelected();
        }
        return animal;
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











