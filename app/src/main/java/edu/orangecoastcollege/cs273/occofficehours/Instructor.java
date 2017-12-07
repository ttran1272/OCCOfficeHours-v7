package edu.orangecoastcollege.cs273.occofficehours;

/**
 * Created by on 12/1/2017.
 */

public class Instructor {
    private long mId;
    private String mLastName;
    private String mFirstName;
    private String mEmail;
    private String mDepartment;
    private String mBuilding;
    private String mRoom;
    private String mMonday;
    private String mTuesday;
    private String mWednesday;
    private String mThursday;
    private String mFriday;

    public Instructor(long id, String lastName, String firstName, String email, String department,String building,String room,String monday,String tuesday, String wednesday,String thursday,String friday) {
        mId = id;
        mLastName = lastName;
        mFirstName = firstName;
        mEmail = email;
        mDepartment = department;
        mBuilding = building;
        mRoom = room;
        mMonday=monday;
        mTuesday = tuesday;
        mWednesday = wednesday;
        mThursday = thursday;
        mFriday = friday;


    }

    public Instructor(String lastName, String firstName, String email, String department,String building,String room,String monday,String tuesday, String wednesday,String thursday,String friday) {
        this(-1, lastName, firstName, email, department,building,room,monday,tuesday,wednesday,thursday,friday);
    }

    public long getId() {
        return mId;
    }

    void setId(int id)
    {
        mId = id;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFullName() {
        return mFirstName + " " + mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getDepartment() { return mDepartment; }

    public void setDepartment(String departments) { mDepartment = departments; }

    public String getBuilding() {
        return mBuilding;
    }

    public void setBuilding(String building) {
        mBuilding = building;
    }

    public String getRoom() {
        return mRoom;
    }

    public void setRoom(String room) {
        mRoom = room;
    }

    public String getMonday() {
        return mMonday;
    }

    public void setMonday(String monday) {
        mMonday = monday;
    }

    public String getTuesday() {
        return mTuesday;
    }

    public void setTuesday(String tuesday) {
        mTuesday = tuesday;
    }

    public String getWednesday() {
        return mWednesday;
    }

    public void setWednesday(String wednesday) {
        mWednesday = wednesday;
    }

    public String getThursday() {
        return mThursday;
    }

    public void setThursday(String thursday) {
        mThursday = thursday;
    }

    public String getFriday() {
        return mFriday;
    }

    public void setFriday(String friday) {
        mFriday = friday;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "Id=" + mId +
                ", LastName='" + mLastName + '\'' +
                ", FirstName='" + mFirstName + '\'' +
                ", Email='" + mEmail + '\'' +
                ", Department='" + mDepartment + '\'' +
                ", Building='" + mBuilding + '\'' +
                ", Room='" + mRoom + '\'' +
                ", Monday='" + mMonday + '\'' +
                ", Tuesday='" + mTuesday + '\'' +
                ", Wednesday='" + mWednesday + '\'' +
                ", Thursday='" + mThursday + '\'' +
                ", Friday='" + mFriday + '\'' +
                '}';
    }
}
