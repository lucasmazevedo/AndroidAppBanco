package br.com.cajuinaweb.androidappbanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cajuinaweb.androidappbanco.dbUtils.database;

public class LoginActivity extends AppCompatActivity {

    private EditText nConta;
    private EditText passConta;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nConta = (EditText) findViewById(R.id.numConta);
        passConta = (EditText) findViewById(R.id.passwordConta);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( nConta.getText().length() != 0 && passConta.getText().length() != 0){
                    if(nConta.getText().toString().equals(database.numConta.toString())
                            &&
                            passConta.getText().toString().equals(database.passConta.toString())){
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast t = Toast.makeText(LoginActivity.this, "Credenciais Inválidas", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }else{
                    Toast t = Toast.makeText(LoginActivity.this, "Preencha todos os Campos!", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }
}
