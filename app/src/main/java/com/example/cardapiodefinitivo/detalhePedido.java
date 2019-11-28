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
import java.util.Locale;

import org.w3c.dom.Text;

public class detalhePedido extends AppCompatActivity {

    TextView ordered_list, mostrar_preco_view, orderlistText;
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
        String data = bundle.getString("Itens escolhidos");
        preco = bundle.getString("Preço do pedido");


        //dados irao virar sms
        sms = data;

        orderlistText = findViewById(R.id.orderlistTextview);
        ordered_list = findViewById(R.id.orderDetailstextView);

        mostrar_preco_view = findViewById(R.id.showprice);
        mostrar_preco_view.setText("Preço: "+preco+" Reais ");

        ordered_list.setText(data);

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto: "));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address", new String("61991966562"));
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
        String phone = "+556191966562";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);

    }
}