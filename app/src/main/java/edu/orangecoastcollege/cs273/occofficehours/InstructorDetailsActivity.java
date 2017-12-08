package edu.orangecoastcollege.cs273.occofficehours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class InstructorDetailsActivity extends AppCompatActivity {

    private TextView mNameTextView;
    private TextView mEmailTextView;
    private TextView mDepartmentTextView;
    private TextView mOfficeRoomTextView;

    private TextView mMondayHoursTextView;
    private TextView mTuesdayHoursTextView;
    private TextView mWednesdayHoursTextView;
    private TextView mThursdayHoursTextView;
    private TextView mFridayHoursTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_details);

        // Get intent information being sent from SearchByInstructorActivity.java
        Intent detailsIntent = getIntent();
        String fullName = detailsIntent.getStringExtra("Name");
        String email = detailsIntent.getStringExtra("Email");
        String department = detailsIntent.getStringExtra("Department");
        String building = detailsIntent.getStringExtra("Building");
        String room = detailsIntent.getStringExtra("Room");

        final String monday = detailsIntent.getStringExtra("Monday");
        final String tuesday = detailsIntent.getStringExtra("Tuesday");
        final String wednesday = detailsIntent.getStringExtra("Wednesday");
        final String thursday = detailsIntent.getStringExtra("Thursday");
        final String friday = detailsIntent.getStringExtra("Friday");

        // Get the IDs of the TextViews
        mNameTextView = (TextView) findViewById(R.id.nameTextView);
        mEmailTextView = (TextView) findViewById(R.id.emailTextView);
        mDepartmentTextView = (TextView) findViewById(R.id.departmentTextView);
        mOfficeRoomTextView = (TextView) findViewById(R.id.officeRoomTextView);

        mMondayHoursTextView = (TextView) findViewById(R.id.mondayHoursTextView);
        mTuesdayHoursTextView = (TextView) findViewById(R.id.tuesdayHoursTextView);
        mWednesdayHoursTextView = (TextView) findViewById(R.id.wednesdayHoursTextView);
        mThursdayHoursTextView = (TextView) findViewById(R.id.thursdayHoursTextView);
        mFridayHoursTextView = (TextView) findViewById(R.id.fridayHoursTextView);

        // Update the TextViews
        mNameTextView.setText(fullName);
        mEmailTextView.setText("Email: " + email);
        mDepartmentTextView.setText("Departments: " + department);
        mOfficeRoomTextView.setText("Room: " + building + " " + room);

        mMondayHoursTextView.setText(" " + monday);
        mTuesdayHoursTextView.setText(" " + tuesday);
        mWednesdayHoursTextView.setText(" " + wednesday);
        mThursdayHoursTextView.setText(" " + thursday);
        mFridayHoursTextView.setText(" " + friday);

        // Get the IDs of the buttons

        Button mondayBotton = (Button) findViewById(R.id.mondayButton);
        Button tuesdayBotton = (Button) findViewById(R.id.tuesdayButton);
        Button wednesdayBotton = (Button) findViewById(R.id.wednesdayButton);
        Button thursdayBotton = (Button) findViewById(R.id.thursdayButton);
        Button fridayBotton = (Button) findViewById(R.id.fridayButton);

        // Create a new intent to send information relating to the email
        final Intent newIntent = new Intent(InstructorDetailsActivity.this, EmailActivity.class);
        newIntent.putExtra("Recipient", email);

        if (!monday.equals("NA")) {
            mondayBotton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    // Start EmailActivity.class
                    newIntent.putExtra("Monday", monday);
                    startActivity(newIntent);
                }
            });
        }

        if (!tuesday.equals("NA")) {
            tuesdayBotton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    // Start EmailActivity.class
                    newIntent.putExtra("Tuesday", tuesday);
                    startActivity(newIntent);
                }
            });
        }

        if (!wednesday.equals("NA")) {
            wednesdayBotton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    // Start EmailActivity.class
                    newIntent.putExtra("Wednesday", wednesday);
                    startActivity(newIntent);
                }
            });
        }

        if (!thursday.equals("NA")) {
            thursdayBotton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    // Start EmailActivity.class
                    newIntent.putExtra("Thursday", thursday);
                    startActivity(newIntent);
                }
            });
        }

        if (!friday.equals("NA")) {
            fridayBotton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    // Start EmailActivity.class
                    newIntent.putExtra("Friday", friday);
                    startActivity(newIntent);
                }
            });
        }
    }
}
