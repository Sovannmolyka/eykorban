package com.example.dell.contactus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.contactus.R;

import de.cketti.mailto.EmailIntentBuilder;


public class ActivityContactUs extends AppCompatActivity implements View.OnClickListener{


    private Toolbar  toolbar;
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtSubject;
    private EditText txtMessage;
    private Button   btnSubmit;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact_us);

        toolbar = findViewById(R.id.ContactUsToolbar);
        setSupportActionBar(toolbar);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtSubject = findViewById(R.id.txtSubject);
        txtMessage = findViewById(R.id.txtMessage);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

//        String name = txtName.getText().toString();
        String to=txtEmail.getText().toString();
        String subject=txtSubject.getText().toString();
        String message=txtMessage.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

//
        boolean success = EmailIntentBuilder.from(this)
                .to(to)
                .subject(subject)
                .body(message)
                .start();
    }


}
