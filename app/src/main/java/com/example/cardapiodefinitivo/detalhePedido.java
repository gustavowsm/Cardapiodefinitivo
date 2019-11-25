package com.example.cardapiodefinitivo;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class detalhePedido extends AppCompatActivity {

    TextView lista_ordenada, mostrar_preco_view, listaordenadaTexto;
    TextToSpeech t1;
    String preco;
    Button b1,b2,b3;
    String sms;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhepedido);

        b1 = findViewById(R.id.listen);
        b2 = findViewById(R.id.call);
        b3 = findViewById(R.id.sms);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Escolha_itens");
        preco = bundle.getString("preco_itens");

        sms = data;

        listaordenadaTexto = findViewById(R.id.orderlistTextview);
        lista_ordenada = findViewById(R.id.orderDetailstextView);

        mostrar_preco_view = findViewById(R.id.showprice);
        mostrar_preco_view.setText("Preço: "+preco+" Reais ");

        lista_ordenada.setText(data);



    }
}
