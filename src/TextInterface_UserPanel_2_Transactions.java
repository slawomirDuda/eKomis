import java.util.Scanner;

public class TextInterface_UserPanel_2_Transactions {

    public static final String TRANSACTIONS_RESULT_GO_BACK = "Go back";
    public static final String TRANSACTIONS_RESULT_FAILURE = "Failure";
    public static String transactionsMainScreen() {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("TRANSACTIONS:");
        System.out.println("Work in Progress");
        System.out.println("Type 'B' to go back");

        String index = "0";

        try{
            index = myScanner.nextLine();
        }catch (NumberFormatException e){
            System.out.println("WRONG INPUT");
        }

        if ("B".equals(index)) {
            return TRANSACTIONS_RESULT_GO_BACK;
        } else  {
            System.out.println("WRONG INPUT");
            return TRANSACTIONS_RESULT_FAILURE;
        }
    }
}
