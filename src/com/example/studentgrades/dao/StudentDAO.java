package com.example.studentgrades.dao;

import com.example.studentgrades.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private ScoreDAO scoreDAO = new ScoreDAO();

    /** 插入学生基本信息及成绩 */
    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO student (id, name, class) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getClassName());
            ps.executeUpdate();
        }
        // 再插入成绩
        scoreDAO.insertScores(s.getId(), new double[]{
            s.getScore1(), s.getScore2(), s.getScore3(), s.getScore4(), s.getScore5()
        });
    }

    /** 更新学生基本信息及成绩 */
    public void update(Student s) throws SQLException {
        String sql = "UPDATE student SET name = ?, class = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getClassName());
            ps.setString(3, s.getId());
            ps.executeUpdate();
        }
        // 再更新成绩
        scoreDAO.updateScores(s.getId(), new double[]{
            s.getScore1(), s.getScore2(), s.getScore3(), s.getScore4(), s.getScore5()
        });
    }

    /** 删除学生及其成绩（级联） */
    public void delete(String id) throws SQLException {
        // score 表已设 ON DELETE CASCADE，可直接删除 student
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }
    }

    /** 根据学号查询学生及其成绩 */
    public Student findById(String id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = mapStudent(rs);
                // 填充成绩
                double[] scores = scoreDAO.findScoresByStudent(id);
                s.setScore1(scores[0]);
                s.setScore2(scores[1]);
                s.setScore3(scores[2]);
                s.setScore4(scores[3]);
                s.setScore5(scores[4]);
                return s;
            }
            return null;
        }
    }

    /** 查询所有学生及其成绩 */
    public List<Student> findAll() throws SQLException {
        String sql = "SELECT * FROM student";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Student s = mapStudent(rs);
                double[] scores = scoreDAO.findScoresByStudent(s.getId());
                s.setScore1(scores[0]);
                s.setScore2(scores[1]);
                s.setScore3(scores[2]);
                s.setScore4(scores[3]);
                s.setScore5(scores[4]);
                list.add(s);
            }
        }
        return list;
    }

    /** 仅映射学生基本信息，不包含成绩 */
    private Student mapStudent(ResultSet rs) throws SQLException {
        return new Student(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("class"),
            0, 0, 0, 0, 0  // 成绩稍后填充
        );
    }

    /** 根据姓名模糊查询学生 */
    public List<Student> searchByName(String name) throws SQLException {
        String sql = "SELECT * FROM student WHERE name LIKE ?";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = mapStudent(rs);
                double[] scores = scoreDAO.findScoresByStudent(s.getId());
                s.setScore1(scores[0]);
                s.setScore2(scores[1]);
                s.setScore3(scores[2]);
                s.setScore4(scores[3]);
                s.setScore5(scores[4]);
                list.add(s);
            }
        }
        return list;
    }

}
