package ui;

public class UserInfo {
    int userID;
    String name;

    public UserInfo(int userID, String name){
        this.userID = userID;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }
}
