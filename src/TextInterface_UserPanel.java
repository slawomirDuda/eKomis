import java.util.Scanner;

public class TextInterface_UserPanel {

    public static final String USER_PANEL_RESULT_OPEN_YOUR_OFFERS = "Open offers";
    public static final String USER_PANEL_RESULT_OPEN_TRANSACTIONS = "Open Transactions";
    public static final String USER_PANEL_RESULT_OPEN_SEARCH_FOR_OFFERS = "Open Search";
    public static final String USER_PANEL_RESULT_OPEN_ACCOUNT_SETTINGS = "Open Settings";
    public static final String USER_PANEL_RESULT_LOG_OUT = "Log Out";
    public static final String USER_PANEL_RESULT_FAILURE = "Failure";
    public static String userPanelMainScreen(){

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

        switch(index) {
            case 1:
                return USER_PANEL_RESULT_OPEN_YOUR_OFFERS;
            case 2:
                return USER_PANEL_RESULT_OPEN_TRANSACTIONS;
            case 3:
                return USER_PANEL_RESULT_OPEN_SEARCH_FOR_OFFERS;
            case 4:
                return USER_PANEL_RESULT_OPEN_ACCOUNT_SETTINGS;
            case 5:
                System.out.println("Logged out");
                return USER_PANEL_RESULT_LOG_OUT;
            default:
                System.out.println("Wrong index number");
                return USER_PANEL_RESULT_FAILURE;
        }
    }
}
