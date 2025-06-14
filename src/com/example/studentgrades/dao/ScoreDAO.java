package com.example.studentgrades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDAO {
    /**
     * 插入一名学生的五门成绩
     */
    public void insertScores(String studentId, double[] scores) throws SQLException {
        String sql = "INSERT INTO score (student_id, subject_no, score) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < scores.length; i++) {
                ps.setString(1, studentId);
                ps.setInt(2, i + 1);
                ps.setDouble(3, scores[i]);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    /**
     * 更新一名学生的五门成绩
     */
    public void updateScores(String studentId, double[] scores) throws SQLException {
        String sql = "UPDATE score SET score = ? WHERE student_id = ? AND subject_no = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < scores.length; i++) {
                ps.setDouble(1, scores[i]);
                ps.setString(2, studentId);
                ps.setInt(3, i + 1);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    /**
     * 删除一名学生的所有成绩（如删除学生时使用）
     */
    public void deleteScoresByStudent(String studentId) throws SQLException {
        String sql = "DELETE FROM score WHERE student_id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentId);
            ps.executeUpdate();
        }
    }

    /**
     * 查询一名学生五门成绩，按 subject_no 升序返回长度为 5 的数组
     */
    public double[] findScoresByStudent(String studentId) throws SQLException {
        String sql = "SELECT subject_no, score FROM score WHERE student_id = ? ORDER BY subject_no";
        double[] scores = new double[Config.MAX_SUBJECT];
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int no = rs.getInt("subject_no");
                if (no >= 1 && no <= Config.MAX_SUBJECT) {
                    scores[no - 1] = rs.getDouble("score");
                }
            }
        }
        return scores;
    }
}
