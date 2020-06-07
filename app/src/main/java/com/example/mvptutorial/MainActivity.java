package com.example.mvptutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    MainActivityContract.Presenter presenter;


    EditText editTextEmail, editTextPassword;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        //click login

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate inputs
                String email1 = editTextEmail.getText().toString();
                String password1 = editTextPassword.getText().toString();

                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)) {
                    onError("Campos obrigatórios");
                }else {
                    presenter.doLogin(email1,password1);
                }

            }
        });


    }

    @Override
    public void onSucess(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}