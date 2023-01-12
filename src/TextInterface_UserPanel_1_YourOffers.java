import java.util.Scanner;
public class TextInterface_UserPanel_1_YourOffers {

//    public static final String YOUR_OFFERS_RESULT_GO_BACK = "Go Back";
//    public static final String YOUR_OFFERS_RESULT_WORKING = "Working";
//    public static String yourOffersResult = YOUR_OFFERS_RESULT_WORKING;
    public static void yourOffersMainScreen() {

        while (true) {

            Scanner myScanner = new Scanner(System.in);
            System.out.println("YOUR OFFERS:");
            System.out.println("You have no offers yet");
            System.out.println("Type 'B' to go back");

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

