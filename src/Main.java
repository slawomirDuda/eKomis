import java.io.FileNotFoundException;
import java.util.Objects;

public class Main {

    public static String loggedUser;
    public static void main(String[] args) throws FileNotFoundException {

        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        String userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_FAILURE;

        while ( ! Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION)) {
            loginResult = TextInterface_Login.loginMainScreen();

            if (Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS)) {

                while ( ! Objects.equals(userPanelResult, TextInterface_UserPanel.USER_PANEL_RESULT_LOG_OUT)) {
                    userPanelResult = TextInterface_UserPanel.userPanelMainScreen();
                }
                userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_FAILURE;
            }
        }
    }
}