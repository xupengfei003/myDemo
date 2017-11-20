package com.chatRobot.domain;

/**
 * Created by XuPengFei on 2017/8/2.
 */
public class TeacherInfo {
    private Integer tId;
    private  String tName;
    private String tLesson;
    private String tNo;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettLesson() {
        return tLesson;
    }

    public void settLesson(String tLesson) {
        this.tLesson = tLesson;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }
}
