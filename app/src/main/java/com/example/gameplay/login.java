package com.example.gameplay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private EditText email, pass;
    private Button login_btn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

        findViews();
        setupOnClick();
    }

    private void findViews() {
        login_btn = findViewById(R.id.userLoginBtn);
        email = findViewById(R.id.userEmail);
        pass = findViewById(R.id.userPass);
    }

    private void setupOnClick() {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if (emailAddress.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                    Toast.makeText(login.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(emailAddress, password);
                }
            }
        });
    }

    private void loginUser(String emailAddress, String password) {
        mAuth.signInWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null && user.isEmailVerified()) {
                            Toast.makeText(login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, gameOption.class));
                            finish();
                        } else if (user != null && !user.isEmailVerified()) {
                            Toast.makeText(login.this, "Please verify your email before logging in.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        String errorMessage = task.getException() != null ? task.getException().getMessage() : "Login failed.";
                        Toast.makeText(login.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
