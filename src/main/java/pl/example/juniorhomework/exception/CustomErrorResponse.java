package pl.example.juniorhomework.exception;


public class CustomErrorResponse {

    private String status;
    private String Message;

    public CustomErrorResponse(String status, String Message) {
        super();
        this.status = status;
        this.Message = Message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
