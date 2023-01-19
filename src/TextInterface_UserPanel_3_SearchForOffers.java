import java.util.Objects;
import java.util.Scanner;
public class TextInterface_UserPanel_3_SearchForOffers {

//    public static final String SEARCH_FOR_OFFERS_RESULT_GO_BACK = "Go back";
//    public static final String SEARCH_FOR_OFFERS_RESULT_WORKING = "Working";
//    public static String searchForOffersResult = SEARCH_FOR_OFFERS_RESULT_WORKING;
    public static void searchOffersMainScreen() {

        while (true) {

            Scanner myScanner = new Scanner(System.in);
            System.out.println("SEARCH FOR OFFERS PANEL:");
            System.out.println("WORK IN PROGRESS...");
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
