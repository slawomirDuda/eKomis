import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TextInterface_Login {
    public static void loginMainScreen() throws FileNotFoundException {

        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object

        System.out.println("1.Log in");
        System.out.println("2.Sign up");
        System.out.println("Enter index number");
        int index = Integer.parseInt(myScanner.nextLine());

        if (index == 1) {
            logIn();
        } else {
            signUp();
        }

    }
    public static void signUp(){
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("CREATE ACCOUNT:");
            System.out.println("Enter Username:");
            String userName = myScanner.nextLine();
            System.out.println("Enter Password:");
            String password = myScanner.nextLine();
            BackEndMethods.createUser(userName,password);
            System.out.println("Account succesfully created, you can now log in");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void logIn() throws FileNotFoundException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("LOG IN:");
        System.out.println("Enter Username:");
        String userName = myScanner.nextLine();
        String[] splitted = BackEndMethods.findUser(userName);
        if(splitted != null){
            System.out.println("Enter Password:");
            String password = myScanner.nextLine();
            if(splitted[1].contentEquals(password)){
                System.out.println("Acces Granted");
                TextInterface_UserPanel.userPanelMainScreen();
            } else {
                System.out.println("Wrong Password");
            }
        } else {
            System.out.println("User name not found");
        }
    }


}
