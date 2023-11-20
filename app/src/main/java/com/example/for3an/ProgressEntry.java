package com.example.for3an;

public class ProgressEntry {

    private String marks;
    private String date;

    public ProgressEntry() {
        // Default constructor required for Firebase
    }

    public ProgressEntry(String marks, String date) {
        this.marks = marks;
        this.date = date;
    }

    public String getMarks() {
        return marks;
    }

    public String getDate() {
        return date;
    }
}

