package edu.orangecoastcollege.cs273.occofficehours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchInstructors(View v)
    {
        Intent searchByInstructorsIntent = new Intent(this, SearchByInstructorActivity.class);
        startActivity(searchByInstructorsIntent);
    }

    public void searchCourses(View v)
    {
        Intent searchByCourse = new Intent(this, SearchByCourseActivity.class);
        startActivity(searchByCourse);
    }


    public void searchDepartments(View v)
    {
        Intent searchByDepartmentIntent = new Intent(this, SearchByDepartmentActivity.class);
        startActivity(searchByDepartmentIntent);
    }


    public void showMap(View v)
    {
        Intent occMapIntent = new Intent(this, OCCMapActivity.class);
        startActivity(occMapIntent);
    }
}