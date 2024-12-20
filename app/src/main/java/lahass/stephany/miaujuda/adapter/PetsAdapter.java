package lahass.stephany.miaujuda.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lahass.stephany.miaujuda.R;
import lahass.stephany.miaujuda.activities.HomeActivity;
import lahass.stephany.miaujuda.activities.InfoPetActivity;
import lahass.stephany.miaujuda.fragments.HomeFragment;
import lahass.stephany.miaujuda.model.Pet;


public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.MyViewHolder> {
    // Referência à atividade homeActivity e à lista de itens
    HomeActivity homeActivity;
    List<Pet> pets;

    private Context context;


    public PetsAdapter(HomeActivity mainActivity, List<Pet> itens) {
        this.homeActivity = mainActivity;
        this.pets = itens;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item da lista
        LayoutInflater inflater = LayoutInflater.from(homeActivity);
        View v = inflater.inflate(R.layout.pet_item, parent, false);
        // Retorna um novo objeto ViewHolder
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Obtém o item na posição especificada
        Pet pet = pets.get(position);
        // Obtém a visualização associada ao ViewHolder
        View v = holder.itemView;
        // Atualiza as visualizações com os dados do item

        ImageView imvfoto = v.findViewById(R.id.imvFoto);
        imvfoto.setImageResource(pet.foto);

        TextView tvTitle = v.findViewById(R.id.tvNomeAnimal);
        tvTitle.setText(pet.nome);

        TextView tvdesc = v.findViewById(R.id.tvLocAnimal);
        tvdesc.setText(pet.localizacao);

        v.setOnClickListener(view -> {
            Context context = view.getContext();

            Intent intent = new Intent(context, InfoPetActivity.class);
            context.startActivity(intent);
        });

        v.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent = new Intent(context, InfoPetActivity.class);

            // Adicione os dados do pet selecionado ao Intent
            intent.putExtra("nome", pet.nome);
            intent.putExtra("localizacao", pet.localizacao);
            intent.putExtra("foto", pet.foto);
            intent.putExtra("tipo", pet.tipo);
            intent.putExtra("raca", pet.raca);
            intent.putExtra("tamanho", pet.tamanho);
            intent.putExtra("peso", pet.peso);
            intent.putExtra("sexo", pet.sexo);


            context.startActivity(intent);
        });

    }

    // Método para obter o número total de itens na lista
    @Override
    public int getItemCount() {
        return pets.size();
    }

    // Classe interna para representar os itens de lista
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Construtor
        public MyViewHolder(final View itemView) {
            super(itemView);
        }

    }


}