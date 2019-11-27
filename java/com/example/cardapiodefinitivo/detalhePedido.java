package com.example.cardapiodefinitivo;

//import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class detalhePedido extends AppCompatActivity {

    TextView lista_ordenada, mostrar_preco_view, lista_pedido;
//    TextToSpeech t1;
    String preco;
    Button b1,b2,b3;
    String sms;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhepedido);

//        b1 = findViewById(R.id.listen);
        b2 = findViewById(R.id.call);
        b3 = findViewById(R.id.sms);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Itens_escolhidos");
        preco = bundle.getString("preco_itens");
        //dados irao virar sms
        sms = data;

        lista_pedido = findViewById(R.id.listapedidoTextView);
        lista_ordenada = findViewById(R.id.pedidodetalhesTextView);

        mostrar_preco_view = findViewById(R.id.showprice);
        mostrar_preco_view.setText("Preço: "+preco+" Reais ");

        lista_ordenada.setText(data);

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto: "));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("endereco", new String("061986656026"));
                    i.putExtra("sms_body",sms);
                    startActivity(Intent.createChooser(i, "Send sms via:"));

                }
                catch(Exception e){
                    Toast.makeText(detalhePedido.this, "Envio do SMS falhou, tente novamente.", Toast.LENGTH_LONG).show();

                }

            }
        });



    }

    public void call(View view){
        String phone = "+5561986656026";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);

    }
}
