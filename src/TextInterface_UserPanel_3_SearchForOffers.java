import java.util.Scanner;

public class TextInterface_UserPanel_3_SearchForOffers {

    public static final String SEARCH_FOR_OFFERS_RESULT_GO_BACK = "Go back";
    public static final String SEARCH_FOR_OFFERS_RESULT_FAILURE = "Failure";
    public static String searchOffersMainScreen() {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("SEARCH FOR OFFERS:");
        System.out.println("Work in Progress");
        System.out.println("Type 'B' to go back");

        String index = "0";

        try{
            index = myScanner.nextLine();
        }catch (NumberFormatException e){
            System.out.println("WRONG INPUT");
        }

        if ("B".equals(index)) {
            return SEARCH_FOR_OFFERS_RESULT_GO_BACK;
        } else  {
            System.out.println("WRONG INPUT");
            return SEARCH_FOR_OFFERS_RESULT_FAILURE;
        }
    }
}
