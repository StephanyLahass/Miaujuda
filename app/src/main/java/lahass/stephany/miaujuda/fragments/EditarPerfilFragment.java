package lahass.stephany.miaujuda.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import lahass.stephany.miaujuda.R;

public class EditarPerfilFragment extends Fragment {

    // Declarando os parâmetros
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public EditarPerfilFragment() {
        // Required empty public constructor
    }

    // Método para criar uma nova instância do fragmento
    public static EditarPerfilFragment newInstance(String param1, String param2) {
        EditarPerfilFragment fragment = new EditarPerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar o layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_editar_perfil, container, false);

        // Encontrar o botão "SALVAR ALTERAÇÕES" e configurar o OnClickListener
        Button btnSave = view.findViewById(R.id.btnSave); // ID do botão "SALVAR ALTERAÇÕES"
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Substituir o fragmento atual por PerfilFragment
                PerfilFragment perfilFragment = new PerfilFragment();

                // Iniciar a transação para substituir o fragmento
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, perfilFragment); // 'R.id.fragment_container' é o contêiner onde o fragmento será exibido
                transaction.addToBackStack(null); // Opcional: Adicionar à pilha de navegação
                transaction.commit();
            }
        });

        return view;
    }
}
