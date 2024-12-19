package lahass.stephany.miaujuda.activities;

import android.content.Intent;
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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import lahass.stephany.miaujuda.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Quando o usuário clicar no bptão cadastrar
        Button btnRegister =  findViewById(R.id.btnRegistro);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Primeiro verificamos se o usuário digitou corretamente os dados de cadastro.
                // No nosso caso, apenas verificamos se o campo não está vazio no momento em que o
                // usuário clicou no botão cadastrar. Se o campo está vazio, exibimos uma mensagem para o
                // usuário indicando que ele não preencheu o campo e retornamos da função sem fazer
                // mais nada.
                EditText etNomeUsuario =  findViewById(R.id.etNomeUsuario);
                final String NomeUserLogin = etNomeUsuario.getText().toString();
                if(NomeUserLogin.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de nome não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etEmail =  findViewById(R.id.etEmail);
                final String Email = etEmail.getText().toString();
                if(Email.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de email não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etSenha =  findViewById(R.id.etSenha);
                final String Senha = etSenha.getText().toString();
                if(Senha.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etConfirmarSenha =  findViewById(R.id.etConfirmarSenha);
                String SenhaCheck = etConfirmarSenha.getText().toString();
                if(SenhaCheck.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de checagem de senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!Senha.equals(SenhaCheck)) {
                    Toast.makeText(CadastroActivity.this, "Senha não confere", Toast.LENGTH_LONG).show();
                    return;
                }

                // Botão de Cadastro
                Button btnRegister = findViewById(R.id.btnRegistro);
                btnRegister.setOnClickListener(e -> {


                    // Simula login bem-sucedido
                    Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                    // Cria uma Intent para abrir a CadastroActivity
                    Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
                    startActivity(intent);

                });

            }
        });
    }
}