import java.io.FileNotFoundException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        String userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_FAILURE;
        String yourOffersResult = TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_FAILURE;

        while ( ! Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION)) {
            loginResult = TextInterface_Login.loginMainScreen();

            if (Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS)) {

                while ( ! Objects.equals(userPanelResult, TextInterface_UserPanel.USER_PANEL_RESULT_LOG_OUT)) {
                    userPanelResult = TextInterface_UserPanel.userPanelMainScreen();

                    if(Objects.equals(userPanelResult, TextInterface_UserPanel.USER_PANEL_RESULT_OPEN_YOUR_OFFERS)) {

                        while ( ! Objects.equals(yourOffersResult, TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_GO_BACK)) {
                            yourOffersResult = TextInterface_UserPanel_1_YourOffers.yourOffersMainScreen();
                        }
                        yourOffersResult = TextInterface_UserPanel_1_YourOffers.YOUR_OFFERS_RESULT_FAILURE;
                    }
                }
                userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_FAILURE;
            }
        }
    }
}