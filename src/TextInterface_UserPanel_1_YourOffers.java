import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class TextInterface_UserPanel_1_YourOffers {

    public static final String YOUR_OFFERS_RESULT_GO_BACK = "Go Back";
    public static final String YOUR_OFFERS_RESULT_WORKING = "Working";
    public static String yourOffersResult = YOUR_OFFERS_RESULT_WORKING;
    public static void yourOffersMainScreen() throws IOException {

        while ( ! Objects.equals(TextInterface_UserPanel_1_YourOffers.yourOffersResult,
                TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_GO_BACK)
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
                    showOffersProcedure();
                }
                case 3 -> yourOffersResult = YOUR_OFFERS_RESULT_GO_BACK;
                default -> {
                    System.out.println("WRONG INDEX NUMBER");
                    yourOffersResult = YOUR_OFFERS_RESULT_WORKING;
                }
            }
        }
    }
    public static void showOffersProcedure() throws IOException {

        while(true){

            System.out.println("YOUR OFFERS:");
            BackEndMethods.showYourOffers(Main.loggedUser);

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

