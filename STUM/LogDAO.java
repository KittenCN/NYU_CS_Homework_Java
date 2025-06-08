package STUM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {
    public void insert(LogEntry log) throws SQLException {
        String sql = "INSERT INTO log_entry (timestamp,user,action,detail) VALUES(?,?,?,?)";
        try(Connection conn = DatabaseManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, log.getTimestamp());
            ps.setString(2, log.getUser());
            ps.setString(3, log.getAction());
            ps.setString(4, log.getDetail());
            ps.executeUpdate();
        }
    }
    public List<LogEntry> findByPeriod(Timestamp from, Timestamp to) throws SQLException {
        String sql = "SELECT * FROM log_entry WHERE timestamp BETWEEN ? AND ?";
        List<LogEntry> list = new ArrayList<>();
        try(Connection conn = DatabaseManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, from);
            ps.setTimestamp(2, to);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                LogEntry log = new LogEntry();
                log.setId(rs.getLong("id"));
                log.setTimestamp(rs.getTimestamp("timestamp"));
                log.setUser(rs.getString("user"));
                log.setAction(rs.getString("action"));
                log.setDetail(rs.getString("detail"));
                list.add(log);
            }
        }
        return list;
    }
}
