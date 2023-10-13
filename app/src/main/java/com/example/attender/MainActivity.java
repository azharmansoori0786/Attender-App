package com.example.attender;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.attender.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    public Button loginbtn;
    public EditText emailsign;
    public EditText passwordsign;
    TextView a1;
    ActivityMainBinding binding;
    FirebaseAuth firebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        emailsign= findViewById(R.id.emailsign);
        passwordsign = findViewById(R.id.passwordsign);
        loginbtn = findViewById(R.id.loginbtn);
        firebaseauth = FirebaseAuth.getInstance();

        a1=findViewById(R.id.textreg);
        a1.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,Add_fac.class);
            startActivity(intent);
        });
        binding.loginbtn.setOnClickListener(v -> {
            String email = binding.emailsign.getText().toString();
            String password = binding.passwordsign.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                firebaseauth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                // Login successful
                                firebaseauth.getCurrentUser();
                                Intent intent = new Intent(MainActivity.this, Add_student.class);
                                startActivity(intent);
                            } else {
                                // Login failed
                                Toast.makeText(MainActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }
}