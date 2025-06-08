package STUM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO student (id,name,class,score1,score2,score3,score4,score5) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getClassName());
            ps.setDouble(4, s.getScore1());
            ps.setDouble(5, s.getScore2());
            ps.setDouble(6, s.getScore3());
            ps.setDouble(7, s.getScore4());
            ps.setDouble(8, s.getScore5());
            ps.executeUpdate();
        }
    }
    public void update(Student s) throws SQLException {
        String sql = "UPDATE student SET name=?,class=?,score1=?,score2=?,score3=?,score4=?,score5=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,s.getName());
            ps.setString(2,s.getClassName());
            ps.setDouble(3,s.getScore1());
            ps.setDouble(4,s.getScore2());
            ps.setDouble(5,s.getScore3());
            ps.setDouble(6,s.getScore4());
            ps.setDouble(7,s.getScore5());
            ps.setString(8,s.getId());
            ps.executeUpdate();
        }
    }
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,id);
            ps.executeUpdate();
        }
    }
    public Student findById(String id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return mapRow(rs);
            return null;
        }
    }
    public List<Student> findAll() throws SQLException {
        String sql = "SELECT * FROM student";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }
    private Student mapRow(ResultSet rs) throws SQLException {
        return new Student(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("class"),
            rs.getDouble("score1"),
            rs.getDouble("score2"),
            rs.getDouble("score3"),
            rs.getDouble("score4"),
            rs.getDouble("score5")
        );
    }
}
