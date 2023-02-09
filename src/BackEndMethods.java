import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
            if (splitted[User.USER_CSV_MAPPINGS.get(User.USERNAME_COLUMN_NAME)].contentEquals(userName)) {
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
    public static void overwriteData(int lineNumber, String data, String filepath) throws IOException {

        Path path = Paths.get(filepath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public static void showYourOffers(String userName) throws IOException {

        File Offers = new File("src\\Data\\Offers.csv");
        Scanner myReader = new Scanner(Offers);
        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));

        //myReader.nextLine();       //todo tu do wyjebania??
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

        File Offers = new File("src\\Data\\Offers.csv");
        Scanner myReader = new Scanner(Offers);
        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));

       // myReader.nextLine();       //todo a tu?
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

    public static String getOfferCsv(String csv_offer_id) throws IOException {

        File Offers = new File("src\\Data\\Offers.csv");
        Scanner myReader = new Scanner(Offers);
        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));

//        myReader.nextLine();   todo//nie do konca czaje czemu to jest niepotrzebne
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            String line = r.readLine();

            if (splitted[0].contentEquals(csv_offer_id)) {
                return line;
            }
        }
        return null;
    }
    public static String getUserCsv(String csv_user_id) throws IOException {

        File Users = new File("src\\Data\\Users.csv");
        Scanner myReader = new Scanner(Users);
        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Users.csv"));

//        myReader.nextLine();   //todo nie do konca czaje czemu to jest niepotrzebne
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            String line = r.readLine();

            if (splitted[User.USER_CSV_MAPPINGS.get(User.ID_COLUMN_NAME)].contentEquals(csv_user_id)) {
                return line;
            }
        }
        return null;
    }
    public static void updateCSV (int id, String csvLine, String filepath) throws IOException {
        overwriteData(findCurrentLine(id,filepath), csvLine, filepath);
    }

    public static int findCurrentLine(int id, String filepath) throws IOException {

        File Users = new File(filepath);
        Scanner myReader = new Scanner(Users);
        int counter = 0;

        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split(",");
            counter++;
            if (splitted[0].contentEquals(String.valueOf(id))) {
                return counter;
            }
        }
        return 0;
    }

//    public static void updateOffer (Offer myOffer) throws IOException {
//        String[] splitted = new String[10];
//        splitted[0] = myOffer.username;;
//        splitted[1] = String.valueOf(myOffer.price);
//        splitted[2] = myOffer.brand;
//        splitted[3] = myOffer.model;
//        splitted[4] = myOffer.type;
//        splitted[5] = String.valueOf(myOffer.year);
//        splitted[6] = String.valueOf(myOffer.engine);
//        splitted[7] = myOffer.fuelType;
//        splitted[8] = String.valueOf(myOffer.horsepower);
//        splitted[9] = String.valueOf(myOffer.id);  // to jest final, nie do zmiany
//
//        String line = Arrays.toString(splitted);
//        System.out.println("BackEndMethods 152: " + line);                        //skad te spacje do kurwy!!!???
//        line = line.replaceAll(" ","");
//        line = line.replace("[", "");
//        line = line.replace("]", "");
//        System.out.println("BackEndMethods 156: " + line);                       //po usunieciu spacji i brackets
//
//        overwriteData(myOffer.id + 1, line, "src\\Data\\Offers.csv");
//    }
//    public static void csvToObjects(String filepath) throws IOException {
//
//        File myFile = new File(filepath);
//        Scanner myReader = new Scanner(myFile);
//
//        HashMap<Integer, Offer> OffersMap = new HashMap<>();
//        HashMap<Integer, User> UsersMap = new HashMap<>();
//        myReader.nextLine();
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            if (filepath.equals("src\\Data\\Offers.csv")) {
//                Offer myOffer = new Offer(data);
//                OffersMap.put(myOffer.id, myOffer);
//
//            } else if (filepath.equals("src\\Data\\Users.csv")) {
//                User myUser = new User(data);
//                UsersMap.put(myUser.id, myUser);
//            }
//        }
//    }

//    public static void test(String filepath) throws IOException {
//
//        File myFile = new File(filepath);
//        Scanner myReader = new Scanner(myFile);
//
//        HashMap<Integer, Offer> OffersMap = new HashMap<>();
//        HashMap<Integer, User> UsersMap = new HashMap<>();
//
//        for ( int i = 0 ; i < countLineBufferedReader(filepath) ; i++ ) {
//            String data = myReader.nextLine();
//            String csvUser = getUserCsv(String.valueOf(i));
//
//        }
//    }
//    public static long countLineBufferedReader(String fileName) {
//
//        long lines = 0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            while (reader.readLine() != null) lines++;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//
//    }
//
//    public static boolean testPRINT() throws IOException {
//
//        File Offers = new File("src\\Data\\Offers.csv");
//        Scanner myReader = new Scanner(Offers);
//
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            System.out.println(data);
//        }
//        return false;
//    }


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