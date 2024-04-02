package classes;

import Interfaces.User;

public class simpleUser implements User {
    private String username;

    public simpleUser(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isLibrarian() {
        return false;
    }
}
