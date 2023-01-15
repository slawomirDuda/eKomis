import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class TextInterface_UserPanel_4_AccountSettings {
    public static final String ACCOUNT_SETTINGS_RESULT_GO_BACK = "Go back";
    public static final String ACCOUNT_SETTINGS_RESULT_WORKING = "Working";
    public static String accountSettingsResult = ACCOUNT_SETTINGS_RESULT_WORKING;
    public static void accountSettingsMainScreen() throws IOException {

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
                    changeUsername();
                    continue;
                case 2:
                    changePasswordProcedure();
                    continue;
                case 3:
                    deleteAccount();
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

    public static void changePasswordProcedure() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        String newPassword = "0";

        System.out.println("Set your new password:");

        try {
            newPassword = myScanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("WRONG INPUT");
        }

        int currentLine = BackEndMethods.findCurrentLine(Main.loggedUser);
        BackEndMethods.overwriteData(currentLine, Main.loggedUser + "," + newPassword);

        System.out.println("Done. Your password will change after application restart.");
    }

    public static void changeUsername() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        String newUsername = "0";

        System.out.println("Set your new username:");

        try {
            newUsername = myScanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("WRONG INPUT");
        }

        int currentLine = BackEndMethods.findCurrentLine(Main.loggedUser);
        BackEndMethods.overwriteData(currentLine, newUsername + "," + Main.loggedUserPassword);

        System.out.println("Done. Your username will change after application restart.");
    }

    public static void deleteAccount() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        String userChoice = "0";

        System.out.println("Are you sure? Y/N:");

        try {
            userChoice = myScanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("WRONG INPUT");
        }

        if ("Y".equals(userChoice)) {
            int currentLine = BackEndMethods.findCurrentLine(Main.loggedUser);
            BackEndMethods.overwriteData(currentLine, null);
            System.out.println("Done. Your account will be completely removed after application restart. ");
        } else if ("N".equals(userChoice)) {
            System.out.println("Keep browsing");
        } else {
            System.out.println("WRONG INPUT");
            deleteAccount();
        }
    }
}
