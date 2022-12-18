package com.example.yourpills;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, conta1, idade, password, repassword;
    private Button btnsign, voltar;
    private DB DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username1);
        conta1 = (EditText) findViewById(R.id.conta1);
        idade = (EditText) findViewById(R.id.idade) ;
        password = (EditText) findViewById(R.id.password1);
        repassword= (EditText) findViewById(R.id.repassword1);
        btnsign = (Button) findViewById(R.id.btnsingup1);
        voltar = (Button) findViewById(R.id.voltar);
        DB = new DB(this);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText()  .toString();
                String email = conta1.getText() .toString();
                String age = idade.getText() .toString();
                String pass = password.getText() .toString();
                String repass = repassword.getText() .toString();

                if(user.equals("")||email.equals("")||age.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(RegisterActivity.this, "Por favor preencha todos os requisitos por favor", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            boolean insert = DB.insertDATA(user, email, age, pass);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this, "Registrado com sucesso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Resgistração falhou", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Utilizador já existe", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Palavras passes não coincidem", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}