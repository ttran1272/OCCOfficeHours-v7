package edu.orangecoastcollege.cs273.occofficehours;

/**
 * Created by on 12/1/2017.
 */
public class Course {
    private long mId;
    private String mAlpha;
    private String mNumber;
    private String mTitle;

    public Course(long id, String alpha, String number, String title) {
        mId = id;
        mAlpha = alpha;
        mNumber = number;
        mTitle = title;
    }

    public Course(String alpha, String number, String title) {
        this(-1, alpha, number, title);
    }

    public long getId() {
        return mId;
    }

    void setId(int id)
    {
        mId = id;
    }

    public String getAlpha() {
        return mAlpha;
    }

    public void setAlpha(String alpha) {
        mAlpha = alpha;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public String getFullName() {
        return mAlpha + " " + mNumber + " " + mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + mId +
                ", Alpha='" + mAlpha + '\'' +
                ", Number='" + mNumber + '\'' +
                ", Title='" + mTitle + '\'' +
                '}';
    }
}
