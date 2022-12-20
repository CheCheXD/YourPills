package com.example.yourpills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText conta, password;
    private Button singin, singup, voltar;
    private DB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conta = (EditText) findViewById(R.id.conta);
        password = (EditText) findViewById(R.id.password);
        singin = (Button) findViewById(R.id.btnlogin);
        singup = (Button) findViewById(R.id.btnsingup);
        voltar = (Button) findViewById(R.id.voltar4);
        DB = new DB(this);



        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = conta.getText()  .toString();
                String pass = password.getText() .toString();

                if(email.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Por favor preencha os campos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(email, pass);
                    if (checkuserpass==true) {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Credenciais Erradas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });



    }
}