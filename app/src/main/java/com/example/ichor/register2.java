package com.example.ichor;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;
import java.util.HashMap;


public class register2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText PersonName, Loaclity, AgeNumber, Mnumber;
    private Button Registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        SetViews();
        spinner_op();

        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_Pname = PersonName.getText().toString().trim();
                String txt_Age = AgeNumber.getText().toString().trim();
                String txt_Locality = Loaclity.getText().toString().trim();
                String txt_MobNum = Mnumber.getText().toString().trim();
                if(txt_Pname.isEmpty() || txt_Age.isEmpty() || txt_Locality.isEmpty() || txt_MobNum.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter the details in Field",Toast.LENGTH_SHORT).show();
                }else{

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("Name", txt_Pname);
                    map.put("Age", txt_Age);
                    map.put("Locality", txt_Locality);
                    map.put("Mobile Number", txt_MobNum);

                    FirebaseDatabase.getInstance().getReference().child("UserData").push().updateChildren(map);

                    Toast.makeText(getApplicationContext(),"REGISTRATION SUCCESSFUL! ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void spinner_op(){
        Spinner spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.Bgrp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void SetViews(){
        PersonName=(EditText)findViewById(R.id.PersonName);
        AgeNumber=(EditText)findViewById(R.id.AgeN);
        Loaclity=(EditText)findViewById(R.id.Locality);
        Mnumber = (EditText)findViewById(R.id.MNumber);
        Registerbtn = (Button)findViewById(R.id.registerB);
    }
}