package edu.rutgers.software;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignUp;
    FirebaseAuth mfirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText3);
        password = findViewById(R.id.editText4);
        btnSignUp = findViewById(R.id.button2);
        btnSignUp.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               String email = emailId.getText().toString();
               String pwd = password.getText().toString();

               if(email.isEmpty() && pwd.isEmpty()){
                   password.setError("Please enter your password");
                   emailId.setError("Please enter a valid email");
               } else if(email.isEmpty()){
                   emailId.setError("Please enter a valid email");
                   emailId.requestFocus();
               } else if(pwd.isEmpty()){
                   password.setError("Please enter your password");
                   password.requestFocus();
               }  else if(!(email.isEmpty() && pwd.isEmpty())){
                   mfirebaseAuth.createUserWithEmailAndPassword(email,pwd); //.addOnCompleteListener(MainActivity.this, new onCompleteListener);
                   //@Override
                   //public void onComplete(@NonNull  )
               }

           }
        });
    }
}
