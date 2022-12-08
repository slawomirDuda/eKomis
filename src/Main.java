import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;

        while (loginResult != TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION) {
            loginResult = TextInterface_Login.loginMainScreen();
            if (loginResult == TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS){
                TextInterface_UserPanel.userPanelMainScreen();
            }
        }
    }
}