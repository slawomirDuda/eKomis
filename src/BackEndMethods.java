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
            if(splitted[0].contentEquals(userName)){
                return splitted;
            }
        }
        return null;
    }
    public static void createUser(String userName, String password) throws IOException {
        FileWriter myWriter = new FileWriter("src\\Data\\Users.csv",true);
        myWriter.write("\n" + userName + ",");
        myWriter.write(password);
        myWriter.close();
    }
}
