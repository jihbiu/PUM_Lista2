package com.example.pum_lista2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Crime {
    private int id;
    private boolean solved;
    private Date date;
    private String description;
    private int studentId;

    public Crime(int id, boolean solved, Date date, int studentId) {
        this.id = id;
        this.solved = solved;
        this.date = date;
        this.studentId = studentId;
    }

    public Crime(int id, boolean solved, Date date, String description, int studentId) {
        this.id = id;
        this.solved = solved;
        this.date = date;
        this.description = description;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }
    public String getIdString(){
        return Integer.toString(id);
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isSolved() {
        return solved;
    }
    public String isSolvedString(){
        if(solved != true){
            return "false";
        }
        else
            return "true";
    }

    public void setsolved(boolean solved) {
        this.solved = solved;
    }

    public Date getDate() {
        return date;
    }
    public String getDateString(){
        String day = String.format("%02d", date.getDay());
        String month = String.format("%02d", date.getMonth());
        String year = Integer.toString( date.getYear());
        return day + "." + month + "." + year;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", solved=" + solved +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
