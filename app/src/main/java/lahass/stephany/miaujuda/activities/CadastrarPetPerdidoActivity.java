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

public class CadastrarPetPerdidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_pet_perdido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        // Encontra o Spinner no layout
        Spinner spinner = findViewById(R.id.spinnerTipo);

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
        Button btnCadastrarPetp =  findViewById(R.id.btnCadastrarPetP);
        btnCadastrarPetp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Primeiro verificamos se o usuário digitou corretamente os dados de cadastro.
                // No nosso caso, apenas verificamos se o campo não está vazio no momento em que o
                // usuário clicou no botão cadastrar. Se o campo está vazio, exibimos uma mensagem para o
                // usuário indicando que ele não preencheu o campo e retornamos da função sem fazer
                // mais nada.
                EditText etNomeAnimal =  findViewById(R.id.etNomeAnimal);
                final String NomeAnimalP = etNomeAnimal.getText().toString();
                if(NomeAnimalP.isEmpty()) {
                    Toast.makeText(CadastrarPetPerdidoActivity.this, "Campo de nome do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etDescAnimal =  findViewById(R.id.etDescAnimal);
                final String DescAnimal = etDescAnimal.getText().toString();
                if(DescAnimal.isEmpty()) {
                    Toast.makeText(CadastrarPetPerdidoActivity.this, "Campo de descrição do animal não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etUltimaLocalizacao =  findViewById(R.id.etUltimaLocalizacao);
                String UltimaLoc = etUltimaLocalizacao.getText().toString();
                if(UltimaLoc.isEmpty()) {
                    Toast.makeText(CadastrarPetPerdidoActivity.this, "Campo de última localização não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etFormaContato =  findViewById(R.id.etFormaContato);
                String FormaContato = etFormaContato.getText().toString();
                if(FormaContato.isEmpty()) {
                    Toast.makeText(CadastrarPetPerdidoActivity.this, "Campo de forma de contato não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                finish();


            }
        });
    }
}