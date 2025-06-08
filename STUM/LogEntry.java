package STUM;

import java.sql.Timestamp;

public class LogEntry {
    private long id;
    private Timestamp timestamp;
    private String user;
    private String action;
    private String detail;
    public LogEntry() {}
    public LogEntry(Timestamp timestamp, String user, String action, String detail) {
        this.timestamp = timestamp; this.user=user; this.action=action; this.detail=detail;
    }
    // getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
}
