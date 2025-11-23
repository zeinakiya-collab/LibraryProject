package com.example.libraryproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button B1;
    EditText email;
    EditText password;

    TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            B1 = findViewById(R.id.B1);
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);

            B1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String T1 = email.getText().toString().trim();
                    String T2 = password.getText().toString().trim();

                    if (T1.isEmpty() && T2.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Invalid Email/Passoword", Toast.LENGTH_SHORT).show();
                    } else if (T1.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    } else if (T2.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, RoomReserve.class);
                        startActivity(intent);
                    }
                }
            });
            return insets;
        });
    }
}