package com.example.studentgrades.model;

public class Student {
    private String id;
    private String name;
    private String className;
    // private double score1;
    // private double score2;
    // private double score3;
    // private double score4;
    // private double score5;
    private double[] scores = new double[com.example.studentgrades.dao.Config.MAX_SUBJECT];

    public Student() {}
    public Student(String id, String name, String className, double[] scores) {
        this.id = id;
        this.name = name;
        this.className = className;
        // this.score1 = score1;
        // this.score2 = score2;
        // this.score3 = score3;
        // this.score4 = score4;
        // this.score5 = score5;
        if (scores.length != com.example.studentgrades.dao.Config.MAX_SUBJECT) {
            throw new IllegalArgumentException("Scores array must have " + com.example.studentgrades.dao.Config.MAX_SUBJECT + " elements");
        }
        this.scores = scores;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    // public double getScore1() { return score1; }
    // public void setScore1(double score1) { this.score1 = score1; }
    // public double getScore2() { return score2; }
    // public void setScore2(double score2) { this.score2 = score2; }
    // public double getScore3() { return score3; }
    // public void setScore3(double score3) { this.score3 = score3; }
    // public double getScore4() { return score4; }
    // public void setScore4(double score4) { this.score4 = score4; }
    // public double getScore5() { return score5; }
    // public void setScore5(double score5) { this.score5 = score5; }
    public double[] getScores() {
        return this.scores;
    }
    public void setScores(double[] scores) {
        if (scores.length != com.example.studentgrades.dao.Config.MAX_SUBJECT) throw new IllegalArgumentException("Scores array must have " + com.example.studentgrades.dao.Config.MAX_SUBJECT +" elements");
        this.scores = scores;
    }
}
