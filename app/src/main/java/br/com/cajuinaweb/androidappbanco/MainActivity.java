package br.com.cajuinaweb.androidappbanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.cajuinaweb.androidappbanco.dbUtils.database;

public class MainActivity extends AppCompatActivity {

    private TextView lbNumConta;
    private TextView lbSaldo;
    private Button btnSaque;
    private Button btnDeposito;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbNumConta = (TextView) findViewById(R.id.lbnumConta);
        lbSaldo = (TextView) findViewById(R.id.lbSaldoValue);

        lbSaldo.setText("R$ " + database.saldoConta.toString());
        lbNumConta.setText("Número da Conta: " + database.numConta.toString());

        btnSaque = (Button) findViewById(R.id.btnSaque);
        btnDeposito = (Button) findViewById(R.id.btnDeposito);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnSaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SaqueActivity.class);
                startActivity(i);
               // finish();
            }
        });


        btnDeposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DepositoActivity.class);
                startActivity(i);
                // finish();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });



    }
}
