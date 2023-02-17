package Text_Interface;

import Main_Package.BackEndMethods;
import Main_Package.Main;
import Objects.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Login_Panel {

    public static final String LOGIN_SCREEN_RESULT_LOGIN_SUCCESS = "Login Success";
    public static final String LOGIN_SCREEN_RESULT_LOGIN_FAILURE = "Login Failure";
    public static final String LOGIN_SCREEN_RESULT_EXIT_APPLICATION = "Exit";

    public static String loginMainScreen() throws IOException {


        System.out.println("1.Log in" );
        System.out.println("2.Sign up" );
        System.out.println("3.Exit Application" );
        System.out.println("Enter index number" );

        Scanner myScanner = new Scanner(System.in);
        int index = 0;

        try {
            index = Integer.parseInt(myScanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("WRONG INPUT" );
            return LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        }

        switch (index) {
            case 1:
                return logIn();
            case 2:
                signUp();
                return LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
            case 3:
                System.out.println("GOOD BYE!" );
                return LOGIN_SCREEN_RESULT_EXIT_APPLICATION;
            default:
                System.out.println("WRONG INDEX NUMBER" );
                return LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        }
    }

    public static void signUp() {
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter Username:" );
            String userName = myScanner.nextLine();
            System.out.println("Enter Password:" );
            String password = myScanner.nextLine();

            User myUser = new User(BackEndMethods.idGen(User.FILEPATH), userName, password);
            BackEndMethods.addNewLineToFile(myUser.getObjectAsCSVLine(), User.FILEPATH);
//            BackEndMethods.createUser(userName, password);
            System.out.println("Account successfully created, you can now log in" );
        } catch (IOException e) {
            System.out.println("An error occurred." );
            e.printStackTrace();
        }
    }

    public static String logIn() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter Username:" );
        String username = myScanner.nextLine();
        User foundUser = BackEndMethods.findUser(username);

        if (foundUser != null) {

            System.out.println("Enter Password:" );
            String password = myScanner.nextLine();

            if (foundUser.password.contentEquals(password)) {
                System.out.println("Access Granted" );
                Main.loggedUser = foundUser;
                Main.loggedUserLine = BackEndMethods.findLineNumber(Main.loggedUser.id, User.FILEPATH);
                return LOGIN_SCREEN_RESULT_LOGIN_SUCCESS;
            } else {
                System.out.println("Wrong Password" );
            }
        } else {
            System.out.println("User name not found" );
        }
        return LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
    }


}
