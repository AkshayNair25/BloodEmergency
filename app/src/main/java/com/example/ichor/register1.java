package com.example.ichor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register1 extends AppCompatActivity {

    private Button Nex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        Nex=(Button)findViewById(R.id.next);
        Nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openregister2();
            }
        });
    }
    public void Openregister2(){
        Intent intent1=new Intent(this, register2.class);
        startActivity(intent1);
    }
}