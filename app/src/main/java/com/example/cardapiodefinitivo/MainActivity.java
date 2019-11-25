package com.example.cardapiodefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView btv, ftv, ctv, ltv, rtv, cetv;
    TextView bptv, fptv, cptv, lptv, rptv, ceptv;
    String escolhas = "";
    String precos;
    Button bife, frango, churras, lasanha, refri, cerveja;

    //botoes de remoçao
    Button rm_bife, rm_frango, rm_churras, rm_lasanha, rm_refri, rm_cerveja;

    int bp = 0, fp = 0, cp = 0, lp = 0, rp = 0, cep = 0;
    int tbp = 0, tfp = 0, tcp = 0, tlp = 0, trp = 0, tcep = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btv = findViewById(R.id.bife_textView);
        ftv = findViewById(R.id.frango_textView);
        ctv = findViewById(R.id.churras_textView);
        ltv = findViewById(R.id.lasanha_textView);
        rtv = findViewById(R.id.refri_textView);
        cetv = findViewById(R.id.cerveja_textView);

        //botoes de adicionar
        bife = (Button) findViewById(R.id.bife_button);
        frango = (Button) findViewById(R.id.frango_button);
        churras = (Button) findViewById(R.id.churras_button);
        lasanha = (Button) findViewById(R.id.lasanha_button);
        refri = (Button) findViewById(R.id.refri_button);
        cerveja = (Button) findViewById(R.id.cerveja_button);

        // botao de remover
        rm_bife = (Button) findViewById(R.id.bife_button_rm);
        rm_frango = (Button) findViewById(R.id.frango_button_rm);
        rm_churras = (Button) findViewById(R.id.churras_button_rm);
        rm_lasanha = (Button) findViewById(R.id.lasanha_button_rm);
        rm_refri = (Button) findViewById(R.id.refri_button_rm);
        rm_cerveja = (Button) findViewById(R.id.cerveja_button_rm);

        //botao pedido
        bptv = findViewById(R.id.bife_preco);
        fptv = findViewById(R.id.frango_preco);
        cptv = findViewById(R.id.churras_preco);
        lptv = findViewById(R.id.lasanha_preco);
        rptv = findViewById(R.id.refri_preco);
        ceptv = findViewById(R.id.cerveja_preco);

    }

    public void fazer_pedido(View view){

        valortotal();
        Intent i = new Intent( MainActivity.this, detalhePedido.class);
        Bundle bundle = new Bundle();
        bundle.putString("Itens escolhidos", escolhas);
        bundle.putString("Preço do pedido", precos);
        i.putExtras(bundle);
        startActivity(i);
        escolhas="";
    }

    // adiciona na lista
    public void add_lista(View view){
        if(view == findViewById(R.id.bife_button)){
            Toast.makeText(this, "Bife Adicionado", Toast.LENGTH_LONG).show();
            bp = bp+1;
            bife.setText(Integer.toString(bp));
        } else if (view == findViewById(R.id.frango_button)){
            Toast.makeText(this, "Frango Adicionado", Toast.LENGTH_SHORT).show();
            fp = fp+1;
            frango.setText(Integer.toString(fp));
        } else if (view == findViewById(R.id.churras_button)) {
            Toast.makeText(this, "Churrasco Adicionado", Toast.LENGTH_SHORT).show();
            cp = cp + 1;
            churras.setText(Integer.toString(cp));
        } else if (view == findViewById(R.id.lasanha_button)) {
            Toast.makeText(this, "Lasanha Adicionada", Toast.LENGTH_SHORT).show();
            lp = lp + 1;
            lasanha.setText(Integer.toString(lp));
        } else if (view == findViewById(R.id.refri_button)) {
            Toast.makeText(this, "Refrigerante Adicionado", Toast.LENGTH_SHORT).show();
            rp = rp + 1;
            refri.setText(Integer.toString(rp));
        } else if (view == findViewById(R.id.cerveja_button)) {
            Toast.makeText(this, "Cerveja Adicionada", Toast.LENGTH_SHORT).show();
            cep = cep + 1;
            cerveja.setText(Integer.toString(cep));
        }

    }

    // remove da lista

    public void remove_lista(View view) {
        if (view == findViewById(R.id.bife_button_rm)) {
            if (bp > 0) {
                bp = bp - 1;

                bife.setText(Integer.toString(bp));
                Toast.makeText(this, "Bife removido", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Adicione algo primeiro", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.frango_button_rm)) {
            if (fp > 0) {
                fp = fp - 1;

                frango.setText(Integer.toString(fp));
                Toast.makeText(this, "Frango removido", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Adicione algo primeiro", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.churras_button_rm)) {
            if (cp > 0) {
                cp = cp - 1;

                churras.setText(Integer.toString(cp));
                Toast.makeText(this, "Churrasco removido", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Adicione algo primeiro", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.lasanha_button_rm)) {
            if (lp > 0) {
                lp = lp - 1;

                lasanha.setText(Integer.toString(lp));
                Toast.makeText(this, "Lasanha removida", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Adicione algo primeiro", Toast.LENGTH_SHORT).show();


        } else if (view == findViewById(R.id.refri_button_rm)) {
            if (rp > 0) {
                rp = rp - 1;

                refri.setText(Integer.toString(rp));
                Toast.makeText(this, "Refrigerante removido", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Adicione algo primeiro", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.cerveja_button_rm)) {
            if (cep > 0) {
                cep = cep - 1;

                cerveja.setText(Integer.toString(cep));
                Toast.makeText(this, "Cerveja removida", Toast.LENGTH_SHORT).show();
            }

        }Toast.makeText(this, "Adicione algo primeiro", Toast.LENGTH_SHORT).show();


    }

    public void valortotal(){
        tbp = bp * 12;
        tfp = fp * 12;
        tcp = cp * 20;
        tlp = lp * 19;
        trp = rp * 7;
        tcep = cep * 7;
        total = tbp + tfp + tcp + tlp + trp + tcep;
        precos = Integer.toString(total);

        if(bp > 0){
            escolhas = escolhas + "Bife (" + bp + " x 12) = " + tbp;
        }

        if(fp > 0){
            escolhas = escolhas + "\n\nFrango(" + fp + " x 12) = " + tfp;
        }

        if(cp > 0){
            escolhas = escolhas + "\n\nChurrasco(" + cp + " x 20) = " + tcp;
        }

        if(lp > 0){
            escolhas = escolhas + "\n\nLasanha ("+ lp + " x 19) = " + tlp;
        }

        if(rp > 0){
            escolhas = escolhas + "\n\nRefrigerante(" + rp + " x 7) = " + rp;
        }

        if(cep > 0){
            escolhas = escolhas + "\n\nCerveja(" + cep + " x 7) = " + cep;
        }
    }

}