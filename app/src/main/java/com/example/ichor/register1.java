package com.example.ichor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ichor.R.string.PASSWORDNOT;

public class register1 extends AppCompatActivity {

    private Button Nex;
    private EditText email, pass, conpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        setupuiviews();
        Nex=(Button)findViewById(R.id.next);
        Nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    if(equalto()){
                        Openregister2();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password are not same", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void Openregister2(){
        Intent intent1=new Intent(this, register2.class);
        startActivity(intent1);
    }
    public void setupuiviews(){
        email=(EditText)findViewById(R.id.emailadd);
        pass=(EditText)findViewById(R.id.conpass1);
        conpass=(EditText)findViewById(R.id.conpass2);
    }
    public Boolean validate(){
        Boolean result = false;

        String Email = email.getText().toString();
        String Pass = pass.getText().toString();
        String conPass = conpass.getText().toString();

        if(Email.isEmpty() && Pass.isEmpty() && conPass.isEmpty()){
            Toast.makeText(this, "Please enter the email & password",Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }
    public Boolean equalto(){
        Boolean result1 = false;

        String Pass = pass.getText().toString();
        String conPass = conpass.getText().toString();

        if(Pass.equals(conPass)) {
            result1 = true;
        }else{
            result1 = false;
        }
        return result1;
    }
}