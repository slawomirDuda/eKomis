import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BackEndMethods {
    public static String[] findUser(String userName) throws FileNotFoundException {

        File Users = new File("src\\Data\\Users.csv");
        Scanner myReader = new Scanner(Users);
        int counter = 0;

        myReader.nextLine();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            counter++;
            if (splitted[0].contentEquals(userName)) {
                Main.loggedUserLine = counter;
                return splitted;
            }
        }
        return null;
    }
    public static void createUser(String userName, String password) throws IOException {

        FileWriter myWriter = new FileWriter("src\\Data\\Users.csv", true);
        myWriter.write("\n" + userName + ",");
        myWriter.write(password + "," + idGen("src\\Data\\Users.csv"));
        myWriter.close();
    }
    public static void overwriteData(int lineNumber, String data) throws IOException {

        Path path = Paths.get("src\\Data\\Users.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
    public static void showYourOffers(String userName) throws IOException {

        File Users = new File("src\\Data\\Offers.csv");
        Scanner myReader = new Scanner(Users);
        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));

        myReader.nextLine();
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            String line = r.readLine();

            if (splitted[0].contentEquals(userName)) {
                System.out.print(line + "\n");
//                System.out.print(data + "\n");
//                for (int i = 1 ; i < splitted.length ; i++) {
//                    System.out.print(splitted[i] + ",");
//                    System.out.println();
//                }
            }
        }
    }
    public static void showOthersOffers(String userName) throws IOException {

        File Users = new File("src\\Data\\Offers.csv");
        Scanner myReader = new Scanner(Users);
        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));

        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            String line = r.readLine();

            if (!splitted[0].contentEquals(userName)) {
                System.out.print(line + "\n");
            }
        }
    }

    private static int idGen(String filepath) throws FileNotFoundException {
        File Users = new File(filepath);
        Scanner myReader = new Scanner(Users);
        int counter = 0;

        while (myReader.hasNextLine()) {
            myReader.nextLine();
            counter++;
        }
        return counter;
//        System.out.println("Count : " + counter);
    }


    //    public static void showOffers(String userName) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));
//        String line = reader.readLine();
//
//        try {
//
//            while (line != null) {
//
//                if (line.contains(userName)) {
//
//                    System.out.println(line);
//                    // read next line
//                    line = reader.readLine();
//                }
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void showOffers(String userName) throws IOException {
//
//        File Users = new File("src\\Data\\Offers.csv");
//        Scanner myReader = new Scanner(Users);
//        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));
//
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            String[] splitted = data.split(",");
//
//            if (splitted[0].contentEquals(userName)) {
//
//                int i = 1;
//                try {
//                    String line = r.readLine();
//                    while (line != null) {
//                        if (line.contains(userName)) {
//                            System.out.print("\n" + line);
//                        }
//                        line = r.readLine();
//                        i++;
//                    }
//                } finally {
//                    r.close();                                  // Free up file descriptor resources
//                }
//            }
//        }
//    }


//    public static int findCurrentLine(String userName) throws IOException {
//
//        File Users = new File("src\\Data\\Users.csv");
//        Scanner myReader = new Scanner(Users);
//        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Users.csv"));
//
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            String[] splitted = data.split(",");
//
//            if (splitted[0].contentEquals(userName)) {
//
//                int i = 1;
//                try {
//                    String line = r.readLine();
//                    while (line != null) {
//                        if (line.contains(userName) ) {
////                            System.out.print("Line " + i + line); // print all lines
//                            return i;
//                        }
//                        line = r.readLine();
//                        i++;
//                    }
//                } finally {
//                    r.close();                                  // Free up file descriptor resources
//                }
//            }
//        }
//        return 0;
//    }

}