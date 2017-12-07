package edu.orangecoastcollege.cs273.occofficehours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
//import android.widget.ThemedSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchByDepartmentActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Instructor> allInstructorsList;
    private List<Offering> allOfferingsList;
    private List<Offering> filteredOfferingsList;
    private OfferingListAdapter offeringListAdapter;

    private Spinner instructorSpinner;
    private ListView offeringsListView;

    private OfferingListAdapter offeringsListAdapter;

    // Shake animation, used when the user clicks the reset button
    private Animation shakeAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_department);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);

        db.importCoursesFromCSV("courses.csv");
        db.importInstructorsFromCSV("instructors2.csv");
        db.importOfferingsFromCSV("offerings.csv");
        //db.importDepartmentFromCSV("departments.csv");

        allOfferingsList = db.getAllOfferings();
        filteredOfferingsList = new ArrayList<>(allOfferingsList);
        allInstructorsList = db.getAllInstructors();


        Log.i("Number of instructors: ", "" + allInstructorsList.size());

        instructorSpinner = (Spinner) findViewById(R.id.departmentSpinner);

        offeringsListView = (ListView) findViewById(R.id.offeringsListView);
        offeringListAdapter =
                new OfferingListAdapter(this, R.layout.offering_list_item, filteredOfferingsList);
        offeringsListView.setAdapter(offeringListAdapter);


        //TODO (1): Construct instructorSpinnerAdapter using the method getInstructorNames()
        //TODO: to populate the spinner.
        ArrayAdapter<String> instructorSpinnerAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getDepartments());
        instructorSpinner.setAdapter(instructorSpinnerAdapter);
        instructorSpinner.setOnItemSelectedListener(instructorSpinnerListener);
    }

    private String[] getDepartments()
    {
        ArrayList<String> departments = new ArrayList<>();
        for (int i = 0; i < allInstructorsList.size(); ++i)
        {
            String department = allInstructorsList.get(i).getDepartment();
            if (!departments.contains(department)) {
                departments.add(department);
            }
        }

        Log.i("Number of Departments: ", "" + departments.size());
        String[] allDepartments = new String[departments.size() + 1];
        allDepartments[0] = "[Select Department]";
        for (int i = 0; i < departments.size(); ++i)
            allDepartments[i + 1] = departments.get(i);

        return allDepartments;
    }

    public void reset(View v)
    {
        toggleShakeAnim(v);
        // Set spinner back to position 0
        instructorSpinner.setSelection(0);
        // Clear out the list adapter
        offeringListAdapter.clear();
        // Repopulate it from allOfferingsList
        offeringListAdapter.addAll(allOfferingsList);
    }

    public AdapterView.OnItemSelectedListener instructorSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> spinner, View view, int i, long l) {
            // Retrieve the instructor name
            String departmentName = String.valueOf(spinner.getItemAtPosition(i));
            // Clear the adapter
            offeringListAdapter.clear();
            if (departmentName.equals("[Select Department]"))
                offeringListAdapter.addAll(allOfferingsList);
            else
                for (Offering offering : allOfferingsList)
                    if (offering.getInstructor().getDepartment().equals(departmentName))
                        offeringListAdapter.add(offering);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    /**
     * Plays the animation from shake_anim.xml
     * Shakes the image horizontally
     * Used in reset function
     *
     * @param v
     */
    public void toggleShakeAnim(View v)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        offeringsListView.startAnimation(shakeAnim);
    }

    public void viewInstructorDetails(View v)
    {
        LinearLayout selectedLayout = (LinearLayout) v;
        Offering selectedOffering = (Offering) selectedLayout.getTag();
        Instructor selectedInstructor = (Instructor) selectedOffering.getInstructor();
        Intent detailsIntent = new Intent(this, InstructorDetailsActivity.class);
        detailsIntent.putExtra("Name", selectedInstructor.getFullName());
        detailsIntent.putExtra("Email", selectedInstructor.getEmail());
        detailsIntent.putExtra("Department", selectedInstructor.getDepartment());
        detailsIntent.putExtra("Building", selectedInstructor.getBuilding());
        detailsIntent.putExtra("Room", selectedInstructor.getRoom());
        detailsIntent.putExtra("Monday", selectedInstructor.getMonday());
        detailsIntent.putExtra("Tuesday", selectedInstructor.getTuesday());
        detailsIntent.putExtra("Wednesday", selectedInstructor.getWednesday());
        detailsIntent.putExtra("Thursday", selectedInstructor.getThursday());
        detailsIntent.putExtra("Friday", selectedInstructor.getFriday());
        startActivity(detailsIntent);
    }
}