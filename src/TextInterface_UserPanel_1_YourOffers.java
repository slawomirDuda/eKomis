import java.util.Scanner;
public class TextInterface_UserPanel_1_YourOffers {
    public static void yourOffersMainScreen() {

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
            TextInterface_UserPanel.userPanelMainScreen();
        } else  {
            System.out.println("WRONG INPUT");
            TextInterface_UserPanel_1_YourOffers.yourOffersMainScreen();
        }
    }

}

