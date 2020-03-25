package pl.aogiri.tmm.test.ui.messages;

public enum AlertMessages {
    SUCCESSFUL_REGISTER("Successfully registered!\nCheck e-mail inbox to activate your account\n(You will be redirected to login page in 5 secounds)"),
    LOGIN_IS_TAKEN("Given login is already taken");

    private String message;

    AlertMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
