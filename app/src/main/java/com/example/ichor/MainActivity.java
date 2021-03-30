package com.example.ichor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button register, login;
    private EditText email, pass;
    private FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupuiviews(); //call the function for variable declaration

        //register button
        register = findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        //login button
        login = findViewById(R.id.log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String Email = email.getText().toString().trim();
                    String Pass = pass.getText().toString().trim();
                    loginUser(Email, Pass);

                }
            }
        });
    }

    //vraible dec function
    public void setupuiviews(){
        email= findViewById(R.id.email);
        pass= findViewById(R.id.pass);
        auth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    //validates whether the edittext is empty or not and returns the value
    public Boolean validate(){
        Boolean result = false;

        String Email = email.getText().toString();
        String Pass = pass.getText().toString();

        if(Email.isEmpty() && Pass.isEmpty()){
            Toast.makeText(this, "Please enter the email & password",Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }

    //navigate to the next activity which is register A
    public void openActivity2(){
        Intent intent=new Intent(this, register1.class);
        startActivity(intent);
    }


    public void loginUser(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getApplicationContext(), "Login Successful!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Mainpage.class));
                finish();
            }
        });
    }
}