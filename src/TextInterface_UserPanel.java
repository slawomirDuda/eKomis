import java.util.Objects;
import java.util.Scanner;

public class TextInterface_UserPanel {
    public static final String USER_PANEL_RESULT_LOG_OUT = "Log Out";
    public static final String USER_PANEL_RESULT_FAILURE = "Failure";
    public static String userPanelMainScreen(){

        Scanner myScanner = new Scanner(System.in);

        System.out.println("USER PANEL:");
        System.out.println("1.Your offers");
        System.out.println("2.Transactions");
        System.out.println("3.Search for offers");
        System.out.println("4.Account settings");
        System.out.println("5.Log Out");
        System.out.println("Enter index number");

        int index = 0;

        try{
            index = Integer.parseInt(myScanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("WRONG INPUT");
            return USER_PANEL_RESULT_FAILURE;
        }

        switch(index) {
                case 1:
                    TextInterface_UserPanel_1_YourOffers.yourOffersMainScreen();
                case 2:
                    TextInterface_UserPanel_2_Transactions.transactionsMainScreen();
                case 3:
                    TextInterface_UserPanel_3_SearchForOffers.searchOffersMainScreen();
                case 4:
                    TextInterface_UserPanel_4_AccountSettings.accountSettingsMainScreen();
                case 5:
                    System.out.println("Logged out");
                    return USER_PANEL_RESULT_LOG_OUT;
                default:
                    System.out.println("Wrong index number");
                    return USER_PANEL_RESULT_FAILURE;
        }
    }
}
