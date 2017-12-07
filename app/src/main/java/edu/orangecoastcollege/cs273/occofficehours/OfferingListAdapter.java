package edu.orangecoastcollege.cs273.occofficehours;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 12/1/2017.
 */
public class OfferingListAdapter extends ArrayAdapter<Offering> {

    private Context mContext;
    private List<Offering> mOfferingsList = new ArrayList<>();
    private int mResourceId;

    /**
     * Creates a new <code>OfferingListAdapter</code> given a mContext, resource id and list of offerings.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param offerings The list of offerings to display
     */
    public OfferingListAdapter(Context c, int rId, List<Offering> offerings) {
        super(c, rId, offerings);
        mContext = c;
        mResourceId = rId;
        mOfferingsList = offerings;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the Offering selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Offering selectedOffering = mOfferingsList.get(pos);
        final Course selectedCourse = selectedOffering.getCourse();
        final Instructor selectedInstructor = selectedOffering.getInstructor();

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout offeringListLinearLayout =
                (LinearLayout) view.findViewById(R.id.offeringListLinearLayout);

        TextView offeringListCourseTextView =
                (TextView) view.findViewById(R.id.offeringListCourseTextView);
        TextView offeringListInstructorTextView =
                (TextView) view.findViewById(R.id.offeringListInstructorTextView);

        offeringListLinearLayout.setTag(selectedOffering);

        offeringListCourseTextView.setText(selectedCourse.getFullName());
        offeringListInstructorTextView.setText(selectedInstructor.getFullName());

        return view;
    }
}
