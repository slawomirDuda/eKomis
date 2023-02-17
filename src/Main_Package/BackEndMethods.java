package Main_Package;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import Objects.*;

public class BackEndMethods {

    public static User findUser(String username) throws FileNotFoundException {

        for (User myUser : DataBase.UsersMap.values()) {
            if (Objects.equals(myUser.username, username)) {
                return myUser;
            }
        }
        return null;
    }

    public static int idGen(String objectName) throws IOException {

        String filepath = "src\\Data\\ID_Counter.csv";
        File myFile = new File(filepath);
        Scanner myReader = new Scanner(myFile);
        myReader.nextLine();

        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] splitted = data.split(",");

            if (splitted[1].contentEquals(objectName)) {
                int id = Integer.parseInt(splitted[0]);
                int i = Integer.parseInt(splitted[2]);
                String newData = splitted[0] + "," + splitted[1] + "," + (i + 1);
                updateFile(id, newData, filepath);
                return i + 1;
            }
        }
        return 0;
    }

    public static void addNewLineToFile(String data, String filepath) {

        try {

            FileWriter writer = new FileWriter(filepath, true);
            writer.write(data);
            writer.close();

        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }

    public static void deleteLineFromFile(String filepath, int lineNumber) {

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String data;
            while ((data = reader.readLine()) != null) {
                lines.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.remove(lineNumber - 1);
        } else {
            System.out.println("Line: '" + lineNumber + "' not found.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (String data : lines) {
                writer.write(data + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFile(int id, String data, String filepath) throws IOException {

        int lineNumber = findLineNumber(id, filepath);
        Path path = Paths.get(filepath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public static int findLineNumber(int id, String filepath) throws IOException {

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

    public static void loadObjectsFromFiles(String filepath) throws IOException {

        File myFile = new File(filepath);
        Scanner myReader = new Scanner(myFile);

        myReader.nextLine();
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();

            switch (filepath) {
                case Offer.FILEPATH -> {
                    Offer myOffer = new Offer(data);
                    DataBase.OffersMap.put(myOffer.id, myOffer);
                }
                case User.FILEPATH -> {
                    User myUser = new User(data);
                    DataBase.UsersMap.put(myUser.id, myUser);
                }
                default -> {
                    System.out.println("Filepath: " + "'" + filepath + "' " + "not found");
                }
            }
        }
    }

    public static HashMap<Integer, Offer> getOffersByUserID(int userID) {

        HashMap<Integer, Offer> yourOffers = new HashMap<>();

        for (Offer myOffer : DataBase.OffersMap.values()) {
            if (Objects.equals(myOffer.username_id, userID)) {
                yourOffers.put(myOffer.id, myOffer);
            }
        }
        return yourOffers;
    }


}
