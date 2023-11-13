package com.mundoti.atividadeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextName = findViewById(R.id.editTextName);
        Button buttonEnter = findViewById(R.id.buttonEnter);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("NAME", name);
                startActivity(intent);
            }
        });
    }
}
