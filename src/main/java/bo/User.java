package bo;

public class User {
    private String username, password;
    private int userid;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
            return password;
    }

}
