package com.example.trabalhoa2_cmd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etGasolina, etEtanol;
    private TextView tvValorfinal;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEtanol = findViewById(R.id.etEtanol);
        etGasolina = findViewById(R.id.etGasolina);
        tvValorfinal = findViewById(R.id.tvValorfinal);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etanol = etEtanol.getText().toString();
                String gasolina = etGasolina.getText().toString();
                tvValorfinal.setText("");

                if(etanol.equals("") || gasolina.equals("")){
                    Toast.makeText(MainActivity.this, "Favor informar os valores", Toast.LENGTH_LONG).show();
                }else{
                        Double precoEtanol = Double.parseDouble(etanol);
                        Double precoGasolina = Double.parseDouble(gasolina);
                        Double resultado = precoEtanol / precoGasolina;

                        if(resultado < 0.7){
                            tvValorfinal.setText("O melhor para abastecer no momento é com etanol.");
                        }else{
                            tvValorfinal.setText("O melhor para abastecer no momento é com gasolina.");
                        }
                }
            }
        });
    }
}





