package lahass.stephany.miaujuda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import lahass.stephany.miaujuda.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Botão de Login
        Button btnLogar = findViewById(R.id.btnLogin);
        btnLogar.setOnClickListener(v -> {
            // Verificar se os campos de nome e senha estão preenchidos
            EditText etNomeUserLogin = findViewById(R.id.etNomeUserLogin);
            String nomeUserLogin = etNomeUserLogin.getText().toString();

            if (nomeUserLogin.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Campo de nome não preenchido", Toast.LENGTH_LONG).show();
                return;
            }

            EditText etSenhaLogin = findViewById(R.id.etSenhaLogin);
            String senhaLog = etSenhaLogin.getText().toString();

            if (senhaLog.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Campo de senha não preenchido", Toast.LENGTH_LONG).show();
                return;
            }

            // Simula login bem-sucedido
            Toast.makeText(LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

            // Redireciona para HomeActivity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        // Botão de Cadastro
        Button btnCadastrar = findViewById(R.id.btnCadastrarPetP);
        btnCadastrar.setOnClickListener(v -> {
            // Cria uma Intent para abrir a CadastroActivity
            Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }
}
