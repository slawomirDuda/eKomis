import java.util.Map;

import static java.util.Map.entry;

public class User {
    public static final String ID_COLUMN_NAME = "id";
    public static final String USERNAME_COLUMN_NAME = "username";
    public static final String PASSWORD_COLUMN_NAME = "password";
    public static final Map<String, Integer> USER_CSV_MAPPINGS = Map.ofEntries(
            entry(ID_COLUMN_NAME, 0),
            entry(USERNAME_COLUMN_NAME, 1),
            entry(PASSWORD_COLUMN_NAME, 2)
    );

    public int id;
    public String username;
    public String password;

    public User (String csvLine) {
//        String[] splitted = csvLine.split(",");
//        this.username = splitted[0];
//        this.password = splitted[1];
//        this.user_id = Integer.parseInt(splitted[2]);

        String[] splitted = csvLine.split(",");
        this.id = Integer.parseInt(splitted[USER_CSV_MAPPINGS.get("id")]);
        this.username = splitted[USER_CSV_MAPPINGS.get("username")];
        this.password = splitted[USER_CSV_MAPPINGS.get("password")];

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
