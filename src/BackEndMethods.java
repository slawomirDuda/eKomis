import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import Objects.*;

public class BackEndMethods {
    public static String[] findUserCSV(String username) throws FileNotFoundException {

        File Users = new File(User.FILEPATH);
        Scanner myReader = new Scanner(Users);
        int counter = 1;

        myReader.nextLine();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splitted = data.split("," );
            counter++;
            if (splitted[User.USER_CSV_MAPPINGS.get(User.USERNAME_COLUMN_NAME)].contentEquals(username)) {
                Main.loggedUserLine = counter;
                Main.loggedUserID = Integer.parseInt(splitted[0]);
                return splitted;
            }
        }
        return null;
    }
    public static User findUser(String username) throws FileNotFoundException {

        for (User myUser : DataBase.UsersMap.values()){
            if (Objects.equals(myUser.username, username)){
                Main.loggedUserID = myUser.id;
                return myUser;
            }
        }
        return null;
    }
    public static void createUser(String username, String password) throws IOException {

        FileWriter myWriter = new FileWriter(User.FILEPATH, true);
        myWriter.write("\n"+ idGen(User.FILEPATH) + "," +  username + "," );
        myWriter.write(password);
        myWriter.close();
    }

    private static int idGen(String filepath) throws FileNotFoundException {

        File myFile = new File(filepath);
        Scanner myReader = new Scanner(myFile);
        int counter = 0;

        while (myReader.hasNextLine()) {
            myReader.nextLine();
            counter++;
        }
        return counter;
    }

    public static void updateCSV(int id, String data, String filepath) throws IOException {
        int lineNumber = findCurrentLine(id,filepath);
        Path path = Paths.get(filepath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public static int findCurrentLine(int id, String filepath) throws IOException {

        File Users = new File(filepath);
        Scanner myReader = new Scanner(Users);
        int counter = 0;

        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split("," );
            counter++;
            if (splitted[0].contentEquals(String.valueOf(id))) {
                return counter;
            }
        }
        return 0;
    }
    public static void loadObjectsFromCsvFiles(String filepath) throws IOException {

        File myFile = new File(filepath);
        Scanner myReader = new Scanner(myFile);


        myReader.nextLine();
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();

            if (filepath.equals(Offer.FILEPATH)) {        //todo SWITCH!!!

                Offer myOffer = new Offer(data);
                DataBase.OffersMap.put(myOffer.id, myOffer);

            } else if (filepath.equals(User.FILEPATH)) {

                User myUser = new User(data);
                DataBase.UsersMap.put(myUser.id, myUser);
            }
        }
//        System.out.println(OffersMap);
//        System.out.println(UsersMap);
    }

    public static HashMap<Integer, Offer> getOffersByUserID(int userID) {

        HashMap<Integer, Offer> yourOffers = new HashMap<>();

        for (Offer myOffer : DataBase.OffersMap.values()){
            if (Objects.equals(myOffer.username_id, userID)){
                yourOffers.put(myOffer.id, myOffer);
            }
        }
        return yourOffers;
    }

//    public static void showOthersOffers() {
//
//        HashMap<Integer, Objects.Offer> othersOffers = new HashMap<>();
//
//        for (Objects.Offer myOffer : DataBase.OffersMap.values()){
//            if (!Objects.equals(myOffer.username_id, Main.loggedUser)){
//                System.out.println(myOffer);
//            }
//        }
//    }
//    public static String getCsvLine(int id, String filepath) throws IOException {
//
//        File Users = new File(filepath);
//        Scanner myReader = new Scanner(Users);
//
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            String[] splitted = data.split("," );
//
//            if (splitted[0].contentEquals(String.valueOf(id))) {
//                return data;
//            }
//        }
//        return null;
//    }
//    public static void showYourOffersCSV() throws IOException {
//
//        File Offers = new File(Objects.Offer.FILEPATH);
//        Scanner myReader = new Scanner(Offers);
//
//        myReader.nextLine();
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            String[] splitted = data.split("," );
//
//            if (splitted[Objects.Offer.OFFER_CSV_MAPPINGS.get(Objects.Offer.USERNAME_COLUMN_NAME)].contentEquals(Main.loggedUser)) {
//                System.out.print(data + "\n");
//            }
//        }
//    }
//
//    public static void showOthersOffersCSV() throws IOException {
//
//        File Offers = new File(Objects.Offer.FILEPATH);
//        Scanner myReader = new Scanner(Offers);
//
//        myReader.nextLine();
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            String[] splitted = data.split("," );
//
//            if (!splitted[Objects.Offer.OFFER_CSV_MAPPINGS.get(Objects.Offer.USERNAME_COLUMN_NAME)].contentEquals(Main.loggedUser)) {
//                System.out.print(data + "\n");
//            }
//        }
//    }
//
//    public static String getOfferCsv(String csv_offer_id) throws IOException {
//
//        File Offers = new File("src\\Data\\Offers.csv");
//        Scanner myReader = new Scanner(Offers);
//        BufferedReader r = new BufferedReader(new FileReader("src\\Data\\Offers.csv"));
//
////        myReader.nextLine();
//        while (myReader.hasNextLine()) {
//
//            String data = myReader.nextLine();
//            String[] splitted = data.split(",");
//            String line = r.readLine();
//
//            if (splitted[0].contentEquals(csv_offer_id)) {
//                return line;
//            }
//        }
//        return null;
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

//    public static void updateOffer (Objects.Offer myOffer) throws IOException {
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
//

//       public static boolean testPRINT() throws IOException {
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