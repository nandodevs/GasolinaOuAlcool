package combustivel.bugdroiddevs.com.combustivel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool, precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    private PublisherAdView mPublisherAdView;

    private static final String TAG = "MainActivity";

    private AdView mAdView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-7436173854092434~6905008560");

        mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7436173854092434~6905008560");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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
                    textoResultado.setText("É melhor utilizar Gasolina!");

                }else{
                    //Álcool
                    textoResultado.setText("É melhor utilizar Álcool!");
                }
            }
        });
    }
}
