import java.util.Scanner;

public class TextInterface_UserPanel_4_AccountSettings {

    public static final String ACCOUNT_SETTINGS_RESULT_GO_BACK = "Go back";
    public static final String ACCOUNT_SETTINGS_RESULT_FAILURE = "Failure";
    public static String accountSettingsMainScreen() {

        System.out.println("1.Change username");
        System.out.println("2.Change password");
        System.out.println("3.Delete your account");
        System.out.println("4.Go back");

        Scanner myScanner = new Scanner(System.in);
        int index = 0;

        try{
            index = Integer.parseInt(myScanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("WRONG INPUT");
            return ACCOUNT_SETTINGS_RESULT_FAILURE;
        }

        switch (index) {
            case 1:
                System.out.println("WORK IN PROGRESS");
                return ACCOUNT_SETTINGS_RESULT_FAILURE;
            case 2:
                System.out.println("WORK IN PROGRESS");
                return ACCOUNT_SETTINGS_RESULT_FAILURE;
            case 3:
                System.out.println("WORK IN PROGRESS");
                return ACCOUNT_SETTINGS_RESULT_FAILURE;
            case 4:
                return ACCOUNT_SETTINGS_RESULT_GO_BACK;
            default:
                System.out.println("Wrong index number");
                return ACCOUNT_SETTINGS_RESULT_FAILURE;
        }
    }
}
