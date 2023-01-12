import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BackEndMethods {
    public static String[] findUser(String userName) throws FileNotFoundException {
        File Users = new File("src\\Data\\Users.csv");
        Scanner myReader = new Scanner(Users);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            if (splitted[0].contentEquals(userName)) {
                return splitted;
            }
        }
        return null;
    }

    public static void createUser(String userName, String password) throws IOException {
        FileWriter myWriter = new FileWriter("src\\Data\\Users.csv", true);
        myWriter.write("\n" + userName + ",");
        myWriter.write(password);
        myWriter.close();
    }

//    public static void changePassword(String password) throws IOException {
//        FileWriter myWriter = new FileWriter("src\\Data\\Users.csv",true);
//        myWriter.write(password);
//        myWriter.close();
//    }
}

//    public static void signUp(){
//        try {
//            Scanner myScanner = new Scanner(System.in);
//            System.out.println("Enter Username:");
//            String userName = myScanner.nextLine();
//            System.out.println("Enter Password:");
//            String password = myScanner.nextLine();
//            BackEndMethods.createUser(userName,password);
//            System.out.println("Account successfully created, you can now log in");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//    public static String logIn() throws FileNotFoundException {
//        Scanner myScanner = new Scanner(System.in);
//        System.out.println("Enter Username:");
//        String userName = myScanner.nextLine();
//        String[] splitted = BackEndMethods.findUser(userName);
//        if(splitted != null){
//            System.out.println("Enter Password:");
//            String password = myScanner.nextLine();
//            if(splitted[1].contentEquals(password)){
//                System.out.println("Access Granted");
//                Main.loggedUser = userName;
//                return LOGIN_SCREEN_RESULT_LOGIN_SUCCESS;
//            } else {
//                System.out.println("Wrong Password");
//            }
//        } else {
//            System.out.println("User name not found");
//        }
//        return LOGIN_SCREEN_RESULT_LOGIN_FAILURE;

