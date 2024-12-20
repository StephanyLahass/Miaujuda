package lahass.stephany.miaujuda.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import lahass.stephany.miaujuda.R;

public class InfoPetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pet);

        // Recupera os dados do Intent
        String nome = getIntent().getStringExtra("nome");
        String localizacao = getIntent().getStringExtra("localizacao");
        int foto = getIntent().getIntExtra("foto", 0);
        String tamanho = getIntent().getStringExtra("tamanho");
        double peso = getIntent().getDoubleExtra("peso", 0.0);
        String sexo = getIntent().getStringExtra("sexo");
        String tipo = getIntent().getStringExtra("tipo");
        String raca = getIntent().getStringExtra("raca");

        // Atualiza as visualizações com os dados
        TextView tvNome = findViewById(R.id.tvNomePet);
        TextView tvLocalizacao = findViewById(R.id.tvLocalizacaoPet);
        ImageView imvFoto = findViewById(R.id.imvFotoPet);
        TextView tvTamanhos = findViewById(R.id.tvTamanho);
        TextView tvPesar = findViewById(R.id.tvPeso);
        TextView tvSexos = findViewById(R.id.tvSexo);
        TextView tvTipos = findViewById(R.id.tvTipo);
        TextView tvRacas = findViewById(R.id.tvRaca);

        tvNome.setText(nome);
        tvLocalizacao.setText(localizacao);
        imvFoto.setImageResource(foto);
        tvTamanhos.setText(tamanho);
        tvPesar.setText(String.format("%.2f kg", peso)); // Formata o peso com 2 casas decimais e adiciona "kg"
        tvSexos.setText(sexo);
        tvTipos.setText(tipo);
        tvRacas.setText(raca);
    }
}
