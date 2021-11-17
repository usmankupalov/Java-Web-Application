package mvc;

public class Message {
    private String username;
    private String title;
    private String message;
    private String datetimestamp;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetimestamp() {
		return datetimestamp;
	}
	public void setDatetimestamp(String datetimestamp) {
		this.datetimestamp = datetimestamp;
	}
    
    public Message() {
    	
    }
}
