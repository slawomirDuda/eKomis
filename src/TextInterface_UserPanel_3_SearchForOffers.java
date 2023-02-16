import java.io.IOException;
import java.util.Scanner;
import Objects.*;

public class TextInterface_UserPanel_3_SearchForOffers {

//    public static final String SEARCH_FOR_OFFERS_RESULT_GO_BACK = "Go back";
//    public static final String SEARCH_FOR_OFFERS_RESULT_WORKING = "Working";
//    public static String searchForOffersResult = SEARCH_FOR_OFFERS_RESULT_WORKING;
    public static void searchOffersMainScreen() throws IOException {

        while (true) {

            Scanner myScanner = new Scanner(System.in);
            System.out.println("SEARCH FOR OFFERS:");

            for (Offer myOffer : DataBase.OffersMap.values()){
                System.out.println(myOffer);
            }

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
