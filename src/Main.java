import java.io.*;
import java.util.Objects;

public class Main {
    public static String loggedUser;
    public static String loggedUserPassword;
    public static int loggedUserLine;

    public static void main(String[] args) throws IOException {

//        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
//
//        while ( ! Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION)) {
//
//            loginResult = TextInterface_Login.loginMainScreen();
//            TextInterface_UserPanel.userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_WORKING;
//
//            if (Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS)) {
//
//                TextInterface_UserPanel.userPanelMainScreen();
//
//            }
//        }
        String csvOffer = BackEndMethods.getOfferCsv("2");
//        String csvOffer2 = BackEndMethods.getOffersCsvs(username);
//        Offer myOffer1 = new Offer("Slawek,14900,Audi,A4,Wagon,1997,2.8,Benzine+LPG,193,2");
        Offer myOffer1 = new Offer(csvOffer);
        System.out.println(myOffer1);

        myOffer1.model = "A6";
        System.out.println(myOffer1);
        BackEndMethods.updateOffer(myOffer1);

    }
}
// TODO
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
