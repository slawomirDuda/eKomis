package Text_Interface;

import Main_Package.BackEndMethods;
import Main_Package.DataBase;
import Objects.*;
import Main_Package.Main;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UserPanel_4_AccountSettings {
    public static final String ACCOUNT_SETTINGS_RESULT_GO_BACK = "Go back";
    public static final String ACCOUNT_SETTINGS_RESULT_WORKING = "Working";
    public static String accountSettingsResult = ACCOUNT_SETTINGS_RESULT_WORKING;

    public static void accountSettingsMainScreen() throws IOException {

        while (!Objects.equals(UserPanel_4_AccountSettings.accountSettingsResult,
                UserPanel_4_AccountSettings.ACCOUNT_SETTINGS_RESULT_GO_BACK)
        ) {

            System.out.println("ACCOUNT SETTINGS PANEL:");
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
                    changePassword();
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

    public static void changeUsername() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        String newUsername = "0";
        String oldUsername = Main.loggedUser.username;

        System.out.println("Set your new username:");
        newUsername = myScanner.nextLine();

        BackEndMethods.updateFile(
            Main.loggedUser.id,
            Main.loggedUser.id + "," + newUsername + "," + Main.loggedUser.password,
            User.FILEPATH
        );

        User myUser = DataBase.UsersMap.get(Main.loggedUser.id);
        myUser.username = newUsername;
        DataBase.UsersMap.replace(Main.loggedUser.id, myUser);

        System.out.println("Done. Your username '" + oldUsername + "' has been changed to '" + newUsername + "'");
    }
    public static void changePassword() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        String newPassword = "0";

        System.out.println("Set your new password:");

        newPassword = myScanner.nextLine();

        BackEndMethods.updateFile(
            Main.loggedUser.id,
            Main.loggedUser.id + "," + Main.loggedUser.username + "," + newPassword,
            User.FILEPATH
        );

        User myUser = DataBase.UsersMap.get(Main.loggedUser.id);
        myUser.password = newPassword;
        DataBase.UsersMap.replace(Main.loggedUser.id, myUser);

        System.out.println("Done. Your password has been changed.");
    }
    public static void deleteAccount() throws IOException {

        Scanner myScanner = new Scanner(System.in);
        String userChoice = "0";

        System.out.println("Are you sure? Y/N:");

        userChoice = myScanner.nextLine();

        if ("Y".equals(userChoice)) {

            BackEndMethods.deleteLineFromFile(User.FILEPATH, Main.loggedUserLine);
            DataBase.UsersMap.remove(Main.loggedUser.id);
            System.out.println("LOGGED OUT");
            System.out.println("Done. Your account has been completely removed.");
            UserPanel.userPanelResult = UserPanel.USER_PANEL_RESULT_LOG_OUT;
            accountSettingsResult = ACCOUNT_SETTINGS_RESULT_GO_BACK;

        } else if ("N".equals(userChoice)) {
            System.out.println("Keep browsing");
        } else {
            System.out.println("WRONG INPUT");
            deleteAccount();
        }
    }
}
