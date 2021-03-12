package com.example.scopone30.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scopone30.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_firebase_ui_login);
    }

    private void signIn(){
        mAuth = FirebaseAuth.getInstance();
        EditText mail = findViewById(R.id.login_email);
        String mailStr = mail.getText().toString();
        EditText password = findViewById(R.id.login_password);
        String passwordStr = password.getText().toString();
        //System.out.println("logging: " + mailStr + ", " +  passwordStr);
        login(mailStr, passwordStr);
    }

    private void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        startActivity(new Intent(LoginActivity.this, GameSetupActivity.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        //updateUI(null);
                    }

                    // ...
                });

    }

    @Override
    public void onClick(View v) {
        signIn();
    }
}
