package Text_Interface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import Main_Package.BackEndMethods;
import Main_Package.DataBase;
import Main_Package.Main;
import Objects.*;

public class UserPanel_1_YourOffers {

    public static final String YOUR_OFFERS_RESULT_GO_BACK = "Go Back";
    public static final String YOUR_OFFERS_RESULT_WORKING = "Working";
    public static String yourOffersResult = YOUR_OFFERS_RESULT_WORKING;
    public static void yourOffersMainScreen() throws IOException {

        while ( ! Objects.equals(UserPanel_1_YourOffers.yourOffersResult,
                UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_GO_BACK)
        ) {

            System.out.println("YOUR OFFERS PANEL:");
            System.out.println("1.Add Offer");
            System.out.println("2.Show Your Offers");
            System.out.println("3.Go back");

            Scanner myScanner = new Scanner(System.in);
            int index = 0;

            try {
                index = Integer.parseInt(myScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("WRONG INPUT");
                continue;
            }

            switch (index) {
                case 1 -> {
                    addOffer();
                }
                case 2 -> {
                    showOffers();
                }
                case 3 -> yourOffersResult = YOUR_OFFERS_RESULT_GO_BACK;
                default -> {
                    System.out.println("WRONG INDEX NUMBER");
                    yourOffersResult = YOUR_OFFERS_RESULT_WORKING;
                }
            }
        }
    }
    public static void showOffers() throws IOException {

        while(true){

            System.out.println("YOUR OFFERS:");
            HashMap<Integer, Offer> myOffers = BackEndMethods.getOffersByUserID(Main.loggedUser.id);
            for (Offer myOffer : myOffers.values()){
                System.out.println(myOffer);
            }
            System.out.println("Type 'B' to go back");
            Scanner myScanner = new Scanner(System.in);
            String index = "0";

            try {
                index = myScanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("WRONG INPUT");
                continue;
            }

            if ("B".equals(index)) {
                break;
            } else {
                System.out.println("WRONG INPUT");
            }
        }
    }

    public static void addOffer() throws IOException {

        Scanner myScanner = new Scanner(System.in);

        String id = String.valueOf(BackEndMethods.idGen("Offer"));
        String username_id = String.valueOf(Main.loggedUser.id);

        System.out.print("Enter the offer price: ");
        String price = myScanner.next();

        System.out.print("Enter brand name: ");
        String brand = myScanner.next();

        System.out.print("Enter model name: ");
        String model = myScanner.next();

        System.out.println("Choose body type: ");
        System.out.println("1.Hatchback");
        System.out.println("2.Wagon");
        System.out.println("3.SUV");
        System.out.println("4.Sedan");
        System.out.println("5.Coupe");
        System.out.println("6.VAN");
        System.out.println("7.Other");

        String type = null;
        Scanner myScanner2 = new Scanner(System.in);
        int index = 0;

        try {
            index = Integer.parseInt(myScanner2.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("WRONG INPUT");
        }

        switch (index) {
            case 1 -> {
                type = "Hatchback";
            }
            case 2 -> {
                type = "Wagon";
            }
            case 3 -> {
                type = "SUV";
            }
            case 4 -> {
                type = "Sedan";
            }
            case 5 -> {
                type = "Coupe";
            }
            case 6 -> {
                type = "VAN";
            }
            case 7 -> {
                type = "Other";
            }
            default -> {
                System.out.println("WRONG INDEX NUMBER");
            }
        }

        System.out.print("Enter production year: ");
        String year = myScanner.next();

        System.out.print("Enter engine capacity:");
        String engine = myScanner.next();

        System.out.println("Choose fuel type: ");
        System.out.println("1.Benzine");
        System.out.println("2.Benzine + LPG");
        System.out.println("3.Diesel");
        System.out.println("4.Other type");

        String fuelType = null;
        Scanner myScanner3 = new Scanner(System.in);
        int index2 = 0;

        try {
            index2 = Integer.parseInt(myScanner3.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("WRONG INPUT");
        }

        switch (index2) {
            case 1 -> {
                fuelType = "Hatchback";
            }
            case 2 -> {
                fuelType = "Wagon";
            }
            case 3 -> {
                fuelType = "SUV";
            }
            default -> {
                System.out.println("WRONG INDEX NUMBER");
            }
        }

        System.out.print("Enter horsepower number: ");
        String horsepower = myScanner.next();

        String[] csvLine = new String[]{id,username_id,price,brand,model,type,year,engine,fuelType,horsepower};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < csvLine.length; i++) {
            sb.append(csvLine[i]);
            if (i != csvLine.length - 1) {
                sb.append(",");
            }
        }
        String csvLineFinal = sb.toString();
//        System.out.println("csvLineFinal: " + csvLineFinal);
        Offer newOffer = new Offer(csvLineFinal);
//        System.out.println("newOffer: " + newOffer);
        DataBase.OffersMap.put(Integer.parseInt(id), newOffer);
//        System.out.println("Readed from Database after put: " + DataBase.OffersMap.get(Integer.parseInt(id)));
        BackEndMethods.addNewLineToFile(csvLineFinal,Offer.FILEPATH);

        System.out.println("Done. New Offer has been added");
    }
}

