
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { showMenu();}

    public static void showMenu(){
        Scanner scanner =new Scanner(System.in);
        String selectedOption = null;

        do{
            System.out.println("Welcome to the Sweet Smart Home Application! \n" +
                    "Please select a machine on the menu\n"+
                    "******************************************\n"+
                    "1. Air Conditioner\n" +
                    "2. Dish washer \n" +
                    "3. Fridge\n"+
                    "4. Washing machine\n"+
                    "5. Exit\n"+
                    "******************************************"
                    );
            selectedOption = scanner.nextLine();
            switch (selectedOption){
                case "1" :
                    //TODO Airconditioner menu
                    break;

                case "2" :
                    //TODO Dishwasher menu
                    break;

                case "3" :
                    //TODO Fridge menu
                    break;

                case "4" :
                    //TODO Washing machine menu

                default:
                    System.out.println("Invalid action!");
                    break;

            }
        }while(!selectedOption.equals("5"));

    }




}
