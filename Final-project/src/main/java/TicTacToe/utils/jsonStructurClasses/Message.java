package TicTacToe.utils.jsonStructurClasses;

import com.google.gson.annotations.Expose;

public class Message {
    @Expose
    private String message;
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
