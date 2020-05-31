package com.app.staysafefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    private EditText inputEmail,reInputEmail,inputPassword,reInputPassword;
    private Button savebt;
    private TextView cancelbt;
    private FirebaseAuth auth ;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        inputEmail = findViewById(R.id.emailetCA);
        reInputEmail = findViewById(R.id.reemailetCA);
        inputPassword = findViewById(R.id.passwordCA);
        reInputPassword = findViewById(R.id.repasswordCA);
        savebt = findViewById(R.id.savebt);
        cancelbt = findViewById(R.id.canceltv);
        progressBar = findViewById(R.id.progressBarv);

        auth = FirebaseAuth.getInstance();
        progressBar.setVisibility(View.GONE);



        cancelbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        savebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String reEmail = reInputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String rePassword = reInputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "ادخل البريد الخاص بك ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TextUtils.equals(email,reEmail)||TextUtils.isEmpty(reEmail)){
                    Toast.makeText(getApplicationContext(), "البريد الخاص بك غير متطابق", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "ادخل كلمه المرور الخاص بك ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TextUtils.equals(password,rePassword)||TextUtils.isEmpty(rePassword)){
                    Toast.makeText(getApplicationContext(), "كلمه المرور الخاصه بك غير متطابقه", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), getString(R.string.minimum_password), Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(CreateAccount.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(CreateAccount.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(CreateAccount.this, ProfilePage.class));
                                    finish();
                                }
                            }
                        });

            }


        });





    }
}
