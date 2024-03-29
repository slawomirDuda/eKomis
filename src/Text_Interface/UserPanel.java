package Text_Interface;

import Main_Package.Main;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class UserPanel {
    public static final String USER_PANEL_RESULT_LOG_OUT = "Log Out";
    public static final String USER_PANEL_RESULT_WORKING = "Working";
    public static String userPanelResult = USER_PANEL_RESULT_WORKING;
    public static void userPanelMainScreen() throws IOException {

        while (Objects.equals(userPanelResult, UserPanel.USER_PANEL_RESULT_WORKING) ) {

            UserPanel_1_YourOffers.yourOffersResult = UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_WORKING;
//            TextInterface.TextInterface_UserPanel_2_Transactions.trasactionsResult = TextInterface.TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_WORKING;
//            TextInterface.TextInterface_UserPanel_3_SearchForOffers.searchForOffersResult = TextInterface.TextInterface_UserPanel_3_SearchForOffers.SEARCH_FOR_OFFERS_RESULT_WORKING;
            UserPanel_4_AccountSettings.accountSettingsResult = UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_WORKING;

            Scanner myScanner = new Scanner(System.in);

            System.out.println("Logged Objects.User: " + Main.loggedUser.username);
            System.out.println("USER PANEL:");
            System.out.println("1.Your offers");
            System.out.println("2.Transactions");
            System.out.println("3.Search for offers");
            System.out.println("4.Account settings");
            System.out.println("5.Log Out");
            System.out.println("Enter index number");

            int index = 0;

            try {
                index = Integer.parseInt(myScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("WRONG INPUT");
                continue;
            }

            switch (index) {
                case 1 -> UserPanel_1_YourOffers.yourOffersMainScreen();
                case 2 -> UserPanel_2_Transactions.transactionsMainScreen();
                case 3 -> UserPanel_3_SearchForOffers.searchOffersMainScreen();
                case 4 -> UserPanel_4_AccountSettings.accountSettingsMainScreen();
                case 5 -> {
                    System.out.println("LOGGED OUT");
                    userPanelResult = USER_PANEL_RESULT_LOG_OUT;
                }
                default -> {
                    System.out.println("WRONG INDEX NUMBER");
                    userPanelResult = USER_PANEL_RESULT_WORKING;
                }
            }
        }
    }
}
