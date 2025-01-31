package lahass.stephany.miaujuda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lahass.stephany.miaujuda.R;

public class CadastrarPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_pet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontra o Spinner no layout
        Spinner spinner = findViewById(R.id.spinnerTipo2);

        // Cria um ArrayAdapter usando o array de strings e o layout padrão do Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tipo_animal,  // Array de opções definido no strings.xml
                android.R.layout.simple_spinner_item
        );

        // Define o layout usado para exibir os itens da lista suspensa
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplica o adapter ao Spinner
        spinner.setAdapter(adapter);

        // Captura o item selecionado
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Caso nenhum item seja selecionado
            }
        });

        // Quando o usuário clicar no bptão cadastrar
        Button btnCadPet =  findViewById(R.id.btn_cadAnAd);
        btnCadPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Primeiro verificamos se o usuário digitou corretamente os dados de cadastro.
                // No nosso caso, apenas verificamos se o campo não está vazio no momento em que o
                // usuário clicou no botão cadastrar. Se o campo está vazio, exibimos uma mensagem para o
                // usuário indicando que ele não preencheu o campo e retornamos da função sem fazer
                // mais nada.
                EditText etNome_cadAnAd =  findViewById(R.id.etNome_cadAnAd);
                final String NomeAnimal = etNome_cadAnAd.getText().toString();
                if(NomeAnimal.isEmpty()) {
                    Toast.makeText(CadastrarPetActivity.this, "Campo de nome do pet não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etP_cadAdAn =  findViewById(R.id.etP_cadAdAn);
                String PesoAnimal = etP_cadAdAn.getText().toString();
                if(PesoAnimal.isEmpty()) {
                    Toast.makeText(CadastrarPetActivity.this, "Campo de peso do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etTam_cadAnAd =  findViewById(R.id.etTam_cadAnAd);
                String TamanhoAnimal = etTam_cadAnAd.getText().toString();
                if(TamanhoAnimal.isEmpty()) {
                    Toast.makeText(CadastrarPetActivity.this, "Campo de tamanho do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etRaca_cadAnAd =  findViewById(R.id.etRaca_cadAnAd);
                String RacaAnimal = etRaca_cadAnAd.getText().toString();
                if(RacaAnimal.isEmpty()) {
                    Toast.makeText(CadastrarPetActivity.this, "Campo de raça do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etDesc_cadAnAd =  findViewById(R.id.etDesc_cadAnAd);
                String DescAnimal = etDesc_cadAnAd.getText().toString();
                if(DescAnimal.isEmpty()) {
                    Toast.makeText(CadastrarPetActivity.this, "Campo de descrição do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                finish();


            }
        });
    }
}