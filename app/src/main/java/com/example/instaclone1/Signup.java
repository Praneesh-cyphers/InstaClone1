package com.example.instaclone1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Signup extends AppCompatActivity implements View.OnClickListener{

    private EditText    edtTxtName;
    private EditText    edtAge;
    private CheckBox    checkBoxMale;
    private CheckBox    checkBoxFeMale;
    private Button      btnClicktoSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTxtName=findViewById(R.id.editText);
        edtAge=findViewById(R.id.editText2);

        checkBoxMale=findViewById(R.id.checkBox);
        checkBoxFeMale=findViewById(R.id.checkBox2);

        btnClicktoSave=findViewById(R.id.button);
        btnClicktoSave.setOnClickListener(Signup.this);

        checkBoxMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxMale.isChecked()) {
                    checkBoxFeMale.setEnabled(false);
                }
                else {
                    checkBoxFeMale.setEnabled(true);
                }
            }
        });

        checkBoxFeMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxFeMale.isChecked()) {
                    checkBoxMale.setEnabled(false);
                } else
                {
                    checkBoxMale.setEnabled(true);
                }
            }
        });


    }


    @Override
    public void onClick(View view) {

        ParseObject Person = new ParseObject("Student");
        Person.put("Name",edtTxtName.getText().toString());
        Person.put("Age",edtAge.getText().toString());

        if(checkBoxMale.isChecked())
        {
            Person.put("Gender","Male");
        }
        else
        {
            Person.put("Gender","Female");
        }

        Person.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
//                    Toast.makeText(Signup.this,"Saved Successfully"
//                            ,Toast.LENGTH_LONG).show();

                    FancyToast.makeText(Signup.this,"Saved Successfully!"
                            ,FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }
                else{
//                    Toast.makeText(Signup.this,"Not saved Successfully"
//                        ,Toast.LENGTH_LONG).show();
                    FancyToast.makeText(Signup.this
                            ,"Failed to save"
                            ,FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }
            }
        });
    }
}
