package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseServices fbs;
    private Utilities utls;
    private EditText etusername,etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etusername=findViewById(R.id.etUsernameSignup);
        etpassword=findViewById(R.id.etPasswordSignup);
        utls= Utilities.getInstance();
        fbs=FirebaseServices.getInstance();
    }



    public void Signup(View view) {
        String username=etusername.getText().toString();
        String password=etpassword.getText().toString();
        //validation if empty
        if(username.trim().isEmpty()||password.trim().isEmpty())
        {
            Toast.makeText(this, "Username or Password is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(utls.validatePassword(this,password)|| utls.validateEmail(this,username)))
            return;

        fbs.getAuth().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {

                                    // Intent i=new Intent(this.MainPage.class)//the page isn't available right now
                                    //  startActivity(i);
                                }
                                else
                                {

                                    Toast.makeText(SignUpActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        }
                );
    }

}
