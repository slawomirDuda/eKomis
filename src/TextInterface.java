import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextInterface {
    public static void main(){
        System.out.println("1.Log in");
        System.out.println("2.Sign up");

        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter index number");

        int index = Integer.parseInt(myScanner.nextLine());


        if (index == 1){
            System.out.println("LOG IN:");
            System.out.println("Enter Username:");
            String userName = myScanner.nextLine();
            System.out.println("Enter Password:");
            String password = myScanner.nextLine();
        } else{
            try {
                System.out.println("CREATE ACCOUNT:");
                System.out.println("Enter Username:");
                FileWriter myWriter = new FileWriter("src\\Data\\Users.csv",true);
                String userName = myScanner.nextLine();
                myWriter.write("\n" + userName + ",");

                System.out.println("Enter Password:");
                String password = myScanner.nextLine();
                myWriter.write(password);
                myWriter.close();
                System.out.println("Account succesfully created, you can now log in");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
