package com.example.gameplay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    private EditText userName, userEmail, userPass, userPassConf;
    private CheckBox userInfoCheck;
    private Button userSignupBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        mAuth = FirebaseAuth.getInstance();
        findViews();
        setupOnClick();
    }

    private void findViews() {
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userPass = findViewById(R.id.userPass);
        userPassConf = findViewById(R.id.userPassConf);
        userInfoCheck = findViewById(R.id.userInfoCheck);
        userSignupBtn = findViewById(R.id.userSignupBtn);
    }

    private void setupOnClick() {
        userSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = userName.getText().toString().trim();
                String user_email = userEmail.getText().toString().trim();
                String user_pass = userPass.getText().toString().trim();
                String user_pass_conf = userPassConf.getText().toString().trim();

                if (user_name.isEmpty() || user_email.isEmpty() || user_pass.isEmpty() || user_pass_conf.isEmpty()) {
                    Toast.makeText(signup.this, "Please Fill-up all the Fields", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(user_email).matches()) {
                    Toast.makeText(signup.this, "Email is not Correct", Toast.LENGTH_SHORT).show();
                } else if (!user_pass.equals(user_pass_conf)) {
                    Toast.makeText(signup.this, "Password Didn't Match. Please Re-Check", Toast.LENGTH_SHORT).show();
                } else if (!userInfoCheck.isChecked()) {
                    Toast.makeText(signup.this, "Please Check if all the info are correct and tick the box.", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(user_email, user_pass);
                }
            }
        });
    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            user.sendEmailVerification()
                                    .addOnCompleteListener(emailTask -> {
                                        if (emailTask.isSuccessful()) {
                                            Toast.makeText(signup.this, "Verification email sent! Please verify and log in.", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(signup.this, login.class));
                                            finish();
                                        } else {
                                            Toast.makeText(signup.this, "Failed to send verification email.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    } else {

                        String errorMessage = task.getException() != null ? task.getException().getMessage() : "Registration failed.";
                        Toast.makeText(signup.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
