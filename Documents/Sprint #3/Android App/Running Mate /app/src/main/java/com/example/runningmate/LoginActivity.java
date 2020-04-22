package com.example.runningmate;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView tv_signup;
    ImageView iv_login;
    EditText editTextEmail, editTextPassword;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_signup = findViewById(R.id.tv_sign_up);
        iv_login = findViewById(R.id.iv_login);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Get the FirebaseAuth instance
        fAuth = FirebaseAuth.getInstance();

        // The user wants to login
        iv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    editTextEmail.setError("Email Required");
                    return;
                }

                if(TextUtils.isEmpty(password))  {
                    editTextPassword.setError("Password Required");
                    return;
                }

                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    editTextEmail.setError("Email Required");
                    editTextPassword.setError("Password Required");
                    return;
                }

                // User has entered both email and password, so authenticate them
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()) {
                                    // User has logged in successfully
                                    Toast.makeText(getApplicationContext(), "Logged in Successfully",
                                            Toast.LENGTH_LONG).show();
                                }

                                else {
                                    // User login failed. Show appropriate error
                                    Toast.makeText(getApplicationContext(), "Error - " +
                                            task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }


                            }
                        }
                );

            }
        });


    }

    public void onSignUpClick(View v) {

        startActivity(new Intent(this, RegisterActivity.class));
    }

    // Sends a link to the email that the user uses to register to reset the password. The dialog
    // box is used to handle the email password reset
    public void onForgotPassword(View v) {

        final EditText resetMail = new EditText(v.getContext());
        final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
        passwordResetDialog.setTitle("Reset Password ?");
        passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
        passwordResetDialog.setView(resetMail);

        passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // extract the email and send reset link
                String mail = resetMail.getText().toString();
                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // close the dialog
            }
        });

        passwordResetDialog.create().show();
    }
}
