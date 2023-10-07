package store.users;

public class Login {
    public String firstName;
    public Boolean isAdmin;
    public String address;

    public Login(String address, String firstName, Boolean isAdmin) {
        this.address = address;
        this.firstName = firstName;
        this.isAdmin = isAdmin;
    }
}

