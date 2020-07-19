package combustivel.bugdroiddevs.com.combustivel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool, precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Localizar componentes na tela
        precoAlcool = findViewById(R.id.precoAlcoolId);
        precoGasolina = findViewById(R.id.precoGasolinaId);
        botaoVerificar = findViewById(R.id.botaoVerificar);
        textoResultado = findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recuperar valores digitados
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();


                //Converter valores strings para números
                Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                //Calculando preço do álcool divido pela gasolina
                double resultado = valorAlcool / valorGasolina;

                if (textoPrecoAlcool.isEmpty()){
                    textoResultado.setText("Digite um valor de Álcool");
                }else{
                    textoPrecoGasolina.isEmpty();
                    textoResultado.setText("Digite um valor de Gasolina");
                }
                if (resultado >= 0.7){
                    //Gasolina
                    textoResultado.setText("GASOLINA");
                }else{
                    //Álcool
                    textoResultado.setBackgroundResource(R.drawable.icon);
                }
            }
        });
    }
}
