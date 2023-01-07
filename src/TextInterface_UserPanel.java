import java.util.Objects;
import java.util.Scanner;

public class TextInterface_UserPanel {
    public static final String USER_PANEL_RESULT_LOG_OUT = "Log Out";
    public static final String USER_PANEL_RESULT_FAILURE = "Failure";
    public static String userPanelMainScreen(){

        String yourOffersResult = TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_FAILURE;
        String trasactionsResult = TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_FAILURE;
        String searchForOffersResult = TextInterface_UserPanel_3_SearchForOffers.SEARCH_FOR_OFFERS_RESULT_FAILURE;
        String accoutSettingsResult = TextInterface_UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_FAILURE;


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

//        switch(index) {
//                case 1:
//                    while ( ! Objects.equals(yourOffersResult, TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_GO_BACK)) {
//                        yourOffersResult = TextInterface_UserPanel_1_YourOffers.yourOffersMainScreen();
//                    }
////                    yourOffersResult = TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_FAILURE;
//
//                case 2:
//                    while ( ! Objects.equals(trasactionsResult, TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_GO_BACK)) {
//                        trasactionsResult = TextInterface_UserPanel_2_Transactions.transactionsMainScreen();
//                    }
////                   trasactionsResult = TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_FAILURE;
//
//                case 3:
//                    while ( ! Objects.equals(searchForOffersResult, TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_GO_BACK)) {
//                        searchForOffersResult = TextInterface_UserPanel_3_SearchForOffers.searchOffersMainScreen();
//                    }
////                    searchForOffersResult = TextInterface_UserPanel_3_SearchForOffers.SEARCH_FOR_OFFERS_RESULT_FAILURE;
//
//                case 4:
//                    while ( ! Objects.equals(accoutSettingsResult, TextInterface_UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_GO_BACK)) {
//                        accoutSettingsResult = TextInterface_UserPanel_4_AccountSettings.accountSettingsMainScreen();
//                    }
////                    accoutSettingsResult = TextInterface_UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_FAILURE;
//
//                case 5:
//                    System.out.println("Logged out");
//                    return USER_PANEL_RESULT_LOG_OUT;
//                default:
//                    System.out.println("Wrong index number");
//                    return USER_PANEL_RESULT_FAILURE;
//        }

        if (index == 1) {
            while ( ! Objects.equals(yourOffersResult, TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_GO_BACK)) {
                yourOffersResult = TextInterface_UserPanel_1_YourOffers.yourOffersMainScreen();
            }
        }
        else if (index == 2) {
            while (!Objects.equals(trasactionsResult, TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_GO_BACK)) {
                trasactionsResult = TextInterface_UserPanel_2_Transactions.transactionsMainScreen();
            }
        }
        else if (index == 3) {
            while (!Objects.equals(searchForOffersResult, TextInterface_UserPanel_2_Transactions.TRANSACTIONS_RESULT_GO_BACK)) {
                searchForOffersResult = TextInterface_UserPanel_3_SearchForOffers.searchOffersMainScreen();
            }
        }
        else if (index == 4) {
            while (!Objects.equals(accoutSettingsResult, TextInterface_UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_GO_BACK)) {
                accoutSettingsResult = TextInterface_UserPanel_4_AccountSettings.accountSettingsMainScreen();
            }
        }
        else if (index == 5) {
            System.out.println("Logged out");
            return USER_PANEL_RESULT_LOG_OUT;
        }
        else {
            System.out.println("Wrong index number");
            return USER_PANEL_RESULT_FAILURE;
        }
       return null;
    }
}
