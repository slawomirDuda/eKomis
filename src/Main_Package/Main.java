package Main_Package;

import java.io.*;
import java.util.Objects;
import Objects.*;
import Text_Interface.Login_Panel;
import Text_Interface.UserPanel;


public class Main {
    public static User loggedUser;
    public static int loggedUserLine;
    public static void main(String[] args) throws IOException {

        String loginResult = Login_Panel.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        BackEndMethods.loadObjectsFromFiles(Offer.FILEPATH);
        BackEndMethods.loadObjectsFromFiles(User.FILEPATH);

        while ( ! Objects.equals(loginResult, Login_Panel.LOGIN_SCREEN_RESULT_EXIT_APPLICATION)) {

            loginResult = Login_Panel.loginMainScreen();
            UserPanel.userPanelResult = UserPanel.USER_PANEL_RESULT_WORKING;

            if (Objects.equals(loginResult, Login_Panel.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS)) {

                UserPanel.userPanelMainScreen();

            }
        }
    }
}
// TODO
//  OFFERS (SHOW, ADD, DELETE, SEARCH/BROWSE)
//  sortowanie/wyszukiwanie
//  DODAC AUTORYZACJE
//  HASLO MUSI SIE SKLADAC Z OKRESLONEJ LICZBY ZNAKOW I MA ZAWIERAC JAKIES CYFRY I ZNAKI SPECJALNE (password policy)
//  OGARNAC CZYSZCZENIE KONSOLI
//  Junction object | CRED

// DONE:
//  różnica miedzy readerami i scannerami
//  NIE MOZNA ZA JEDNYM ZALOGOWANIEM ZMIENIC HASLA I USERNAME
//  ACCOUNT SETTINGS przerobic
//  CRED = CREATE, READ, EDIT/UPDATE, DELETE
//  DOPRACOWAC DELETE ACCOUNT
//  ZMIANY ZACHODZA DOPIERO PO ZAKONCZENIU DZIALANIA
//  scalic overwrite i update do jednej metody i sprawic zeby update mogl dzialac dla kazdego obiektu
//  dodac final stringi do nazw kolumn CSV w klasach Objects.Offer i Objects.User
//  GetOfferCsv i GetUserCsv scalić(albo wyjebac) i dać ajdiki na poczatek
//  AJDIKI
//  przerobic na jednogo readera w backendmethods
//  przemapowac przetrzymywanie na obiekty, dla lepszego dostepu do danych
//  START z przerabianiem wszystkiego na korzystanie z obiektow