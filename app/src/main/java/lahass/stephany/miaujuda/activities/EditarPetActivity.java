package lahass.stephany.miaujuda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lahass.stephany.miaujuda.R;

public class EditarPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_pet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Quando o usuário clicar no botão cadastrar
        Button btnCadPetad =  findViewById(R.id.btn_cadPetAd);
        btnCadPetad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Primeiro verificamos se o usuário digitou corretamente os dados de cadastro.
                // No nosso caso, apenas verificamos se o campo não está vazio no momento em que o
                // usuário clicou no botão cadastrar. Se o campo está vazio, exibimos uma mensagem para o
                // usuário indicando que ele não preencheu o campo e retornamos da função sem fazer
                // mais nada.
                EditText etNome_anAdoc =  findViewById(R.id.etNome_anAdoc);
                final String NomeAnimalAD = etNome_anAdoc.getText().toString();
                if(NomeAnimalAD.isEmpty()) {
                    Toast.makeText(EditarPetActivity.this, "Campo de nome do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etPeso_anAdoc =  findViewById(R.id.etPeso_anAdoc);
                final String Peso = etPeso_anAdoc.getText().toString();
                if(Peso.isEmpty()) {
                    Toast.makeText(EditarPetActivity.this, "Campo de peso do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etTam_anAdoc =  findViewById(R.id.etTam_anAdoc);
                final String TamanhoAniAd = etTam_anAdoc.getText().toString();
                if(TamanhoAniAd.isEmpty()) {
                    Toast.makeText(EditarPetActivity.this, "Campo de tamanho do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etRaca_anAdoc =  findViewById(R.id.etRaca_anAdoc);
                String RacaAd = etRaca_anAdoc.getText().toString();
                if(RacaAd.isEmpty()) {
                    Toast.makeText(EditarPetActivity.this, "Campo de raça do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etDesc_anAdoc =  findViewById(R.id.etDesc_anAdoc);
                String DescAd = etDesc_anAdoc.getText().toString();
                if(DescAd.isEmpty()) {
                    Toast.makeText(EditarPetActivity.this, "Campo de adoção de animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                finish();


            }
        });
    }
}