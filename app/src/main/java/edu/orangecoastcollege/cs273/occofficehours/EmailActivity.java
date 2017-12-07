package edu.orangecoastcollege.cs273.occofficehours;

import android.app.LoaderManager;
import android.content.ActivityNotFoundException;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EmailActivity extends AppCompatActivity {

    private EditText recipientEditText;
    private EditText subjectEditText;
    private EditText contentsEditText;

    private String recipient;
    private String subject;
    private String bodyText;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        recipientEditText = (EditText) findViewById(R.id.emailRecipientEditText);
        subjectEditText = (EditText)findViewById(R.id.emailSubjectEditText);
        contentsEditText = (EditText) findViewById(R.id.emailMessageBodyEditText);

        Intent detailsIntent = getIntent();
        recipient = detailsIntent.getStringExtra("Recipient");

        monday = detailsIntent.getStringExtra("Monday");
        tuesday = detailsIntent.getStringExtra("Tuesday");
        wednesday = detailsIntent.getStringExtra("Wednesday");
        thursday = detailsIntent.getStringExtra("Thursday");
        friday = detailsIntent.getStringExtra("Friday");

        bodyText = getResources().getString(R.string.body_message);

        if ((monday != null) && !monday.equals("NA"))
            bodyText += " Monday at " + monday;
        if ((tuesday != null) && !tuesday.equals("NA"))
            bodyText += " Tuesday at " + tuesday;
        if ((wednesday != null) && !wednesday.equals("NA"))
            bodyText += " Wednesday at " + wednesday;
        if ((thursday != null) && !thursday.equals("NA"))
            bodyText += " Thurday at " +  thursday;
        if ((friday != null) && !friday.equals("NA"))
            bodyText += " Friday at " + friday;

        bodyText += ". \nThank you.";

        recipientEditText.setText(recipient);

        subject = getResources().getString(R.string.subject_content);
        subjectEditText.setText(subject);

        contentsEditText.setText(bodyText);

        Button startBtn = (Button) findViewById(R.id.emailSendButton);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    }


    protected void sendEmail() {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", recipient, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                bodyText);
        startActivity(Intent.createChooser(emailIntent, "Send email"));
    }
}



