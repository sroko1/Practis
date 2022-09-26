package pl.example.juniorhomework.exception;

public class UsernameNotFoundException extends RuntimeException {
    private String login;
    public UsernameNotFoundException(String login) {

    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
