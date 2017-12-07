package edu.orangecoastcollege.cs273.occofficehours;

/**
 * Created by on 12/1/2017.
 */
public class Offering{
    private int mCRN;
    private int mSemesterCode;
    private Course mCourse;
    private Instructor mInstructor;

    public Offering(int CRN, int semesterCode, Course course, Instructor instructor) {
        mCRN = CRN;
        mSemesterCode = semesterCode;
        mCourse = course;
        mInstructor = instructor;
    }


    public int getCRN() {
        return mCRN;
    }

    public void setCRN(int crn) {
        mCRN = crn;
    }

    public int getSemesterCode() {
        return mSemesterCode;
    }

    public void setSemesterCode(int semesterCode) {
        mSemesterCode = semesterCode;
    }

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        mCourse = course;
    }

    public Instructor getInstructor() {
        return mInstructor;
    }

    public void setInstructor(Instructor instructor) {
        mInstructor = instructor;
    }

    @Override
    public String toString() {
        return "Offering{" +
                "CRN=" + mCRN +
                ", SemesterCode=" + mSemesterCode +
                ", Course=" + mCourse +
                ", Instructor=" + mInstructor +
                '}';
    }
}
