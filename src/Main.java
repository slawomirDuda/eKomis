import java.io.*;
import java.util.Objects;

public class Main {
    public static String loggedUser;
    public static String loggedUserPassword;
    public static int loggedUserLine;

    public static void main(String[] args) throws IOException {

        String loginResult = TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_FAILURE;
        BackEndMethods.csvToObjects(Offer.FILEPATH);   //todo w tym miejscu?
        BackEndMethods.csvToObjects(User.FILEPATH);   //todo startuejmy z przerabianiem wszystkiego na korzystanie z obiektow

        while ( ! Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_EXIT_APPLICATION)) {

            loginResult = TextInterface_Login.loginMainScreen();
            TextInterface_UserPanel.userPanelResult = TextInterface_UserPanel.USER_PANEL_RESULT_WORKING;

            if (Objects.equals(loginResult, TextInterface_Login.LOGIN_SCREEN_RESULT_LOGIN_SUCCESS)) {

                TextInterface_UserPanel.userPanelMainScreen();

            }
        }

//         System.out.println(BackEndMethods.findCurrentLine(3,Offer.FILEPATH));
//        BackEndMethods.updateCSV(2,"2,Slawek,14900,Audi,A4,Wagon,1997,2.8,Benzine+LPG,193",Offer.FILEPATH);
//        BackEndMethods.updateCSV(1,"1,Slawek,hehe",User.FILEPATH);
//        System.out.println(BackEndMethods.getCsvLine(2,Offer.FILEPATH));

//        //users to object
//        System.out.println("USERS:");
//
//        String csvUser = BackEndMethods.getUserCsv(String.valueOf(1));
//        User myUser1 = new User(csvUser);                                    //Alt+shift+Enter = assert !=   ???
//        System.out.println("Main 34: " + myUser1);
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
////        TextInterface_UserPanel.userPanelMainScreen();
    }
}
// TODO
//  rozdzielic metode login
//  różnica miedzy readerami i scannerami
//  START z przerabianiem wszystkiego na korzystanie z obiektow
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

// DONE:
//  scalic overwrite i update do jednej metody i sprawic zeby update mogl dzialac dla kazdego obiektu //todo do weryfikacji
//  dodac final stringi do nazw kolumn CSV w klasach Offer i User
//  GetOfferCsv i GetUserCsv scalić(albo wyjebac) i dać ajdiki na poczatek
//  AJDIKI
//  przerobic na jednogo readera w backendmethods
//  przemapowac przetrzymywanie na obiekty, dla lepszego dostepu do danych