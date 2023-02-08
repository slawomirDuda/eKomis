import java.io.*;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

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


//        //users to object
//        System.out.println("USERS:");
//
//        String csvUser = BackEndMethods.getUserCsv(String.valueOf(1));
//        User myUser1 = new User(csvUser);                                    //Alt+shift+Enter = assert !=   ???
//        System.out.println("Main 34: " + myUser1);
//
//
//        //offers to object
//        System.out.println("OFFERS:");
//
//        String csvOffer = BackEndMethods.getOfferCsv(String.valueOf(2));
////        String csvOffer2 = BackEndMethods.getOffersCsvs(username);
//        Offer myOffer1 = new Offer(csvOffer);
//        System.out.println("Main 43: " + myOffer1);
//
//        myOffer1.model = "A6";
//        System.out.println("Main 46: " + myOffer1);
//        BackEndMethods.updateOffer(myOffer1);
//        TextInterface_UserPanel.userPanelMainScreen();

        BackEndMethods.csvToObjects("src\\Data\\Offers.csv");
        BackEndMethods.csvToObjects("src\\Data\\Users.csv");

//        System.out.println(BackEndMethods.test("src\\Data\\Users.csv"));
//        System.out.println(BackEndMethods.countLineBufferedReader("src\\Data\\Users.csv"));
    }
}
// TODO
//  różnica miedzy readerami i scannerami
//  przerobic na jednogo readera w backendmethods
//  GetOfferCsv i GetUserCsv scalić(albo wyjebac) i dać ajdiki na poczatek
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
