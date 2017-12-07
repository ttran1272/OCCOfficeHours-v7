package edu.orangecoastcollege.cs273.occofficehours;

/**
 * Created by AnhTran on 12/4/2017.
 */

public class Department {
    private int mId;
    private String mDepartment;

    public Department(int id, String department) {
        mId = id;
        mDepartment = department;
    }

    public Department(String department) {
        this(-1,department);
    }

    public long getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public void setDepartment(String department) {
        mDepartment = department;
    }

    public String toString() {
        return "Department{" + "Id=" + mId +" Department=" + mDepartment + '}';
    }
}
