package com.example.attender;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.attender.databinding.ActivityAddFacBinding;
import com.example.attender.info.User_info;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Add_fac extends AppCompatActivity {

    private FirebaseAuth auth;
    FirebaseDatabase database;
    ActivityAddFacBinding binding;
    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAddFacBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        progressdialog=new ProgressDialog(Add_fac.this);
        progressdialog.setTitle("Creating account");
        progressdialog.setMessage("We are creating your account");

        binding.Signupbtn.setOnClickListener(v -> {
            String number= Objects.requireNonNull(binding.etmobile.getText()).toString();
            String name= Objects.requireNonNull(binding.etname.getText()).toString();
            String email = Objects.requireNonNull(binding.etemail.getText()).toString();
            String password = Objects.requireNonNull(binding.etpassword.getText()).toString();
            String confirmPassword = Objects.requireNonNull(binding.password1.getText()).toString();



                if(email.isEmpty()||password.isEmpty()||name.isEmpty()||number.isEmpty()){
                    Toast.makeText(Add_fac.this, "Field is empty", Toast.LENGTH_SHORT).show();
                }
            else if (password.equals(confirmPassword)) {
                // Passwords match
                progressdialog.show(); // Show the progress dialog

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            progressdialog.dismiss(); // Dismiss the progress dialog
                            if (task.isSuccessful()) {
                                User_info user = new User_info(
                                        binding.etname.getText().toString(),
                                        email,
                                        password
                                );
                                String id = Objects.requireNonNull(task.getResult().getUser()).getUid();
                                database.getReference().child("Users").child(id).setValue(user);
                                Toast.makeText(Add_fac.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Add_fac.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                // Passwords do not match
                Toast.makeText(Add_fac.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}