package br.com.cajuinaweb.androidappbanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cajuinaweb.androidappbanco.dbUtils.database;

public class SaqueActivity extends AppCompatActivity {

    //COMMON
    private TextView lbNumConta;
    private TextView lbSaldo;
    //Deposito Activity
    private EditText valorSaque;
    private Button btnSacar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);

        lbNumConta = (TextView) findViewById(R.id.lbnumConta);
        lbSaldo = (TextView) findViewById(R.id.lbSaldoValue);

        lbSaldo.setText("R$ " + database.saldoConta.toString());
        lbNumConta.setText("Número da Conta: " + database.numConta.toString());

        valorSaque = (EditText) findViewById(R.id.valorSaque);

        btnSacar = (Button) findViewById(R.id.efetuarSaque);

        btnSacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valorSaque.getText().toString().length() != 0){

                    Double vSaque = Double.parseDouble(valorSaque.getText().toString());
                    database.saldoConta = database.saldoConta - vSaque;

                    Intent i = new Intent(SaqueActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();


                    Toast t = Toast.makeText(SaqueActivity.this, "Quantia R$ " + vSaque +" Debitada da Conta!", Toast.LENGTH_LONG);
                    t.show();
                }else{
                    Toast t = Toast.makeText(SaqueActivity.this, "Valor Digitado Inválido!", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });


    }
}