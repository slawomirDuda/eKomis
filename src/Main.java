import java.io.*;
import java.util.Objects;

public class Main {
    public static String loggedUser;
    public static String loggedUserPassword;
    public static int loggedUserLine;
    public static void main(String[] args) throws IOException {

        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;

        while ( ! Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION)) {

            loginResult = TextInterface_Login.loginMainScreen();
            TextInterface_UserPanel.userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_WORKING;

            if (Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS)) {

                TextInterface_UserPanel.userPanelMainScreen();

            }
        }
    }
}
// TODO
//  ZNAJDZ NA STRONIE INTELIJ SHORTCUTY, SCREEN NA 20 PRZYDATNYCH SHORTCUTOW
//  AJDIKI
//  przemapowac przetrzymywanie na obiekty, dla lepszego dostepu do danych
//  OFFERS (SHOW, ADD, DELETE, SEARCH/BROWSE)
//  DOPRACOWAC DELETE ACCOUNT
//  ZMIANY ZACHODZA DOPIERO PO ZAKONCZENIU DZIALANIA
//  JAK ZROBIC RESTART ALBO EXIT INSTANT
//  NIE MOZNA ZA JEDNYM ZALOGOWANIEM ZMIENIC HASLA I USERNAME
//  sortowanie/wyszukiwanie
//  DODAC AUTORYZACJE
//  OGARNAC CZYSZCZENIE KONSOLI
//  EW. DODAC NP ZE HASLO MUSI SIE SKLADAC Z OKRESLONEJ LICZBY ZNAKOW I MA ZAWIERAC JAKIES CYFRY I ZNAKI SPECJALNE (password policy)
//  CRED = CREATE, READ, EDIT/UPDATE, DELETE
//  Junction object
