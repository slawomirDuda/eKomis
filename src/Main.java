import java.io.FileNotFoundException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        String userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_FAILURE;

        while (loginResult != TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION) {
            loginResult = TextInterface_Login.loginMainScreen();

            if (loginResult == TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS) {

                while (userPanelResult != TextInterface_UserPanel.USER_PANEL_RESULT_LOG_OUT) {
                    userPanelResult = TextInterface_UserPanel.userPanelMainScreen();

//                    switch (userPanelResult) {
//                        case TextInterface_UserPanel.USER_PANEL_RESULT_OPEN_YOUR_OFFERS:
//                            TextInterface_UserPanel_1_YourOffers.yourOffersMainScreen();
//                        case TextInterface_UserPanel.USER_PANEL_RESULT_OPEN_TRANSACTIONS:
//                            TextInterface_UserPanel_2_Transactions.transactionsMainScreen();
//                        case TextInterface_UserPanel.USER_PANEL_RESULT_OPEN_SEARCH_FOR_OFFERS:
//                            TextInterface_UserPanel_3_SearchForOffers.searchOffersMainScreen();
//                        case TextInterface_UserPanel.USER_PANEL_RESULT_OPEN_ACCOUNT_SETTINGS:
//                            TextInterface_UserPanel_4_AccountSettings.accountSettingsMainScreen();
//                        default:
//                            userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_FAILURE;
//                            System.out.println();
//                            System.out.println("Something went wrong");
//                    }
                }

            }
        }
    }
}