package Text_Interface;

import java.util.Scanner;

public class UserPanel_2_Transactions {

    //    public static final String TRANSACTIONS_RESULT_GO_BACK = "Go back";
//    public static final String TRANSACTIONS_RESULT_WORKING = "Working";
//    public static String trasactionsResult = TRANSACTIONS_RESULT_WORKING;
    public static void transactionsMainScreen() {

        while (true) {

            Scanner myScanner = new Scanner(System.in);
            System.out.println("TRANSACTIONS PANEL:");
            System.out.println("WORK IN PROGRESS...");
            System.out.println("Type 'B' to go back");

            String index = "0";

            try {
                index = myScanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("WRONG INPUT");
                continue;
            }

            if ("B".equals(index)) {
                break;
            } else {
                System.out.println("WRONG INPUT");
            }
        }
    }
}
