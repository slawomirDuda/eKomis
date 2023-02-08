import java.util.Map;

import static java.util.Map.entry;

public class User {
    private static final Map<String, Integer> USER_CSV_MAPPINGS = Map.ofEntries(
            entry("id", 0),
            entry("username", 1),
            entry("password", 2)
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
                ", user_id=" + id +
                '}';
    }
}
