public class User {

    public String username;
    public String password;
    public int user_id;

    public User (String csvLine) {
        String[] splitted = csvLine.split(",");
        this.username = splitted[0];
        this.password = splitted[1];
        this.user_id = Integer.parseInt(splitted[2]);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
