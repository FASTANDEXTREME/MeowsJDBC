import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option;
        boolean isRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {


            System.out.println("********************");
            System.out.println("******JDBC MENU*****");
            System.out.println("********************");
            System.out.println("1. Insert values into Table");
            System.out.println("2. Retrieve all records");
            System.out.println("3. Exit the app");
            System.out.print("Select option to Perform: ");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    Insertion insert = new Insertion();
                    insert.insert();
                }
                case 2 -> {
                    Retrieval retrieve = new Retrieval();
                    retrieve.retrieve();
                }
                case 3 -> {
                    System.out.println("Thank you!!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }
}






