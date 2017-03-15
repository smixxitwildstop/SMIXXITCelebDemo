package com.wildstop.smixxitceleb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "" ;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button signinButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    Intent intent= new Intent(SignIn.this,Profile.class);
                    startActivity(intent);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");

                }
                // ...
            }
        };
        final EditText editextSmixxitID=(EditText)findViewById(R.id.editext_username_sign_in);
        final EditText editextSmixxitPassword=(EditText)findViewById(R.id.editext_password_sign_in);

        Button signinButton=(Button)findViewById(R.id.button_sign_in);

        signinButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String smixxitid=editextSmixxitID.getText().toString().toLowerCase().trim();
                String smixxitpassword=editextSmixxitPassword.getText().toString().trim();
               if (smixxitid.length()==0||smixxitpassword.length()==0){
                   Toast.makeText(SignIn.this, "Please Enter Alll Fields", Toast.LENGTH_SHORT).show();

               }

                else if (smixxitid.length()>0&&smixxitpassword.length()>0){
                   /*mAuth.signInWithEmailAndPassword(smixxitid+"@smixxit.com", smixxitpassword)
                           .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                   // If sign in fails, display a message to the user. If sign in succeeds
                                   // the auth state listener will be notified and logic to handle the
                                   // signed in user can be handled in the listener.
                                   if (!task.isSuccessful()) {
                                       Log.w(TAG, "signInWithEmail", task.getException());
                                       Toast.makeText(SignIn.this, "Wrong Credentials",
                                               Toast.LENGTH_SHORT).show();
                                   }
                                   else if (task.isSuccessful()){
                                       Toast.makeText(SignIn.this, "Welcome", Toast.LENGTH_SHORT).show();
                                       Intent intent= new Intent(SignIn.this,Profile.class);
                                       startActivity(intent);

                                   }

                                   // ...
                               }
                           });
                           */
                   Intent intent= new Intent(SignIn.this,Profile.class);
                   startActivity(intent);
               }
                //Authenticate The User

            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
