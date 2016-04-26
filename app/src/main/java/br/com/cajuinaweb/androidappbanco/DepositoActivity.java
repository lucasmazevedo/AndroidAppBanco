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

public class DepositoActivity extends AppCompatActivity {

    //COMMON
    private TextView lbNumConta;
    private TextView lbSaldo;
    //Deposito Activity
    private EditText valorDeposito;
    private Button btnDepositar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        lbNumConta = (TextView) findViewById(R.id.lbnumConta);
        lbSaldo = (TextView) findViewById(R.id.lbSaldoValue);

        lbSaldo.setText("R$ " + database.saldoConta.toString());
        lbNumConta.setText("Número da Conta: " + database.numConta.toString());

        valorDeposito = (EditText) findViewById(R.id.valorDeposito);

        btnDepositar = (Button) findViewById(R.id.efetuarDeposito);

        btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valorDeposito.getText().toString().length() != 0){

                    Double vDeposito = Double.parseDouble(valorDeposito.getText().toString());
                    database.saldoConta = database.saldoConta + vDeposito;

                    Intent i = new Intent(DepositoActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();


                    Toast t = Toast.makeText(DepositoActivity.this, "Quantia R$ " + vDeposito +" Creditada na Conta!", Toast.LENGTH_LONG);
                    t.show();
                }else{
                    Toast t = Toast.makeText(DepositoActivity.this, "Valor Digitado Inválido!", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });


    }
}
