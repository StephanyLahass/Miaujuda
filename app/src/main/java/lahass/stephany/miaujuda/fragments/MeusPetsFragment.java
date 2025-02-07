package lahass.stephany.miaujuda.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import lahass.stephany.miaujuda.R;
import lahass.stephany.miaujuda.activities.CadastrarPetActivity;
import lahass.stephany.miaujuda.activities.CadastrarPetPerdidoActivity;
import lahass.stephany.miaujuda.activities.HomeActivity;
import lahass.stephany.miaujuda.adapter.PetsAdapter;
import lahass.stephany.miaujuda.model.HomeActivityViewModel;
import lahass.stephany.miaujuda.model.Pet;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeusPetsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeusPetsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MeusPetsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeusPetsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeusPetsFragment newInstance(String param1, String param2) {
        MeusPetsFragment fragment = new MeusPetsFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meus_pets, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HomeActivityViewModel homeActivityViewModel = new ViewModelProvider(getActivity()).get(HomeActivityViewModel.class);

        List<Pet> pets = homeActivityViewModel.getPets();

        RecyclerView rvHome = view.findViewById(R.id.rvMeusPets);
        rvHome.setAdapter(new PetsAdapter((HomeActivity) getActivity(), pets));
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));

        FloatingActionButton fab = view.findViewById(R.id.fabCadPet);
        fab.setOnClickListener(new View.OnClickListener() {

            // partezinha que puxa o metodo para aparecer o dialog depois de clicar no botao
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    // metodo pro dialog
    private void showDialog() {
        if (getContext() == null) return;

        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.cadastro_pet_dlg);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        }

        // pegando os botoes do dialog
        Button cadPetAdocao = dialog.findViewById(R.id.btnCadPetAd);
        Button cadPetPerdido = dialog.findViewById(R.id.btnCadPetP);

        // configuracao das acoes executadas com o click nos botoes do dialog
        cadPetAdocao.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), CadastrarPetActivity.class);
            startActivity(intent);
            dialog.dismiss();
        });

        cadPetPerdido.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), CadastrarPetPerdidoActivity.class);
            startActivity(intent);
            dialog.dismiss();
        });

        // exibicao do dialog
        dialog.show();
    }

}