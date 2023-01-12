import java.util.Objects;
import java.util.Scanner;
public class TextInterface_UserPanel_4_AccountSettings {
    public static final String ACCOUNT_SETTINGS_RESULT_GO_BACK = "Go back";
    public static final String ACCOUNT_SETTINGS_RESULT_WORKING = "Working";
    public static String accountSettingsResult = ACCOUNT_SETTINGS_RESULT_WORKING;
    public static void accountSettingsMainScreen() {

        while ( ! Objects.equals(TextInterface_UserPanel_4_AccountSettings.accountSettingsResult, TextInterface_UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_GO_BACK)) {

            System.out.println("1.Change username");
            System.out.println("2.Change password");
            System.out.println("3.Delete your account");
            System.out.println("4.Go back");
            System.out.println("Enter index number:");

            Scanner myScanner = new Scanner(System.in);
            int index = 0;

            try {
                index = Integer.parseInt(myScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("WRONG INPUT");
                continue;
            }

            switch (index) {
                case 1:
                    System.out.println("WORK IN PROGRESS");
                    continue;
                case 2:
                    System.out.println("WORK IN PROGRESS");
                    continue;
                case 3:
                    System.out.println("WORK IN PROGRESS");
                    continue;
                case 4:
                    accountSettingsResult = ACCOUNT_SETTINGS_RESULT_GO_BACK;
                    break;
                default:
                    System.out.println("WRONG INDEX NUMBER");
                    accountSettingsResult = ACCOUNT_SETTINGS_RESULT_WORKING;
            }
        }
    }
}
