import java.util.Scanner;
public class TextInterface_UserPanel_1_YourOffers {

    public static final String YOUR_OFFERS_RESULT_GO_BACK = "Go Back";
    public static final String YOUR_OFFERS_RESULT_FAILURE = "Failure";
    public static String yourOffersMainScreen() {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("YOUR OFFERS:");
        System.out.println("You have no offers yet");
        System.out.println("Type 'B' to go back");

        String index = "0";

        try{
            index = myScanner.nextLine();
        }catch (NumberFormatException e){
            System.out.println("WRONG INPUT");
        }

        if ("B".equals(index)) {
            return YOUR_OFFERS_RESULT_GO_BACK;
        } else  {
            System.out.println("WRONG INPUT");
            return YOUR_OFFERS_RESULT_FAILURE;
        }
    }

}

