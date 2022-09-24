package pl.example.juniorhomework.exception;

public class UsernameNotFoundException extends RuntimeException{
   public UsernameNotFoundException() {
        super ("whyHasItHappened");
    }
}
