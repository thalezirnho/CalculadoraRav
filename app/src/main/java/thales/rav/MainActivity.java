package thales.rav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.*;
import android.app.*;

public class MainActivity extends AppCompatActivity {

    // Declaração das variáveis
    EditText mdr_avista, mdr2a6, mdr7a12, rav, parcelas, valor, mdr_final;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Importando os valores dos EditView do activity_main
        mdr_avista = (EditText) findViewById(R.id.mdr_vista);
        mdr2a6 = (EditText) findViewById(R.id.mdr_2a6);
        mdr7a12 = (EditText) findViewById(R.id.mdr_7a12);
        rav = (EditText) findViewById(R.id.rav_auto);
        parcelas = (EditText) findViewById(R.id.parcelas);
        valor = (EditText) findViewById(R.id.valor_venda);

        // Condicional do nº de parcelas para selecionar o MDR correto
        /*if (parcelas <= 1) {
            mdr_final = mdr_avista;
        } else if (parcelas > 1 && parcelas <= 6) {
            mdr_final = mdr2a6;
        } else {
            mdr_final = mdr7a12;
        }*/

        // Habilitando o botão
        Button btncalcular = (Button) findViewById(R.id.btncalcular);

        // Criando a ação do botão
        btncalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Convertendo os valores de Str para Double para realizar as operações matemáticas
                double n_parcelas = Double.parseDouble(parcelas.getText().toString());
                double valor_final = Double.parseDouble(valor.getText().toString());
                double resultado = valor_final/n_parcelas;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

                dialogo.setTitle("O valor de cada parcela é:");

                dialogo.setMessage("R$ " + resultado);

                dialogo.setNeutralButton("OK", null);

                dialogo.show();
            }
        });
    }
}

