package Text_Interface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import Main_Package.BackEndMethods;
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
                    System.out.println("Adding Offer");
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
}

