package lahass.stephany.miaujuda.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import lahass.stephany.miaujuda.R;

public class HomeActivityViewModel extends ViewModel {

    public List<Pet> getPets() {

        List<Pet> pets = new ArrayList<>();

        Pet p1 = new Pet();
        p1.nome = "Gatoso";
        p1.localizacao = "Serra";
        p1.foto = R.drawable.gato;
        pets.add(p1);

        Pet p2 = new Pet();
        p2.nome = "Fofinho";
        p2.localizacao = "Vitória";
        p2.foto = R.drawable.cachorro;
        pets.add(p2);

        Pet p3 = new Pet();
        p3.nome = "Bolota";
        p3.localizacao = "Vila Velha";
        p3.foto = R.drawable.gato_preto;
        pets.add(p3);

        Pet p4 = new Pet();
        p4.nome = "Pipoca";
        p4.localizacao = "Cariacica";
        p4.foto = R.drawable.cachorro_marrom;
        pets.add(p4);

        Pet p5 = new Pet();
        p5.nome = "Tigrinho";
        p5.localizacao = "Guarapari";
        p5.foto = R.drawable.gato_tigrado;
        pets.add(p5);

        Pet p6 = new Pet();
        p6.nome = "Rabito";
        p6.localizacao = "Linhares";
        p6.foto = R.drawable.cachorro_pequeno;
        pets.add(p6);

        Pet p7 = new Pet();
        p7.nome = "Mingau";
        p7.localizacao = "Colatina";
        p7.foto = R.drawable.gato_branco;
        pets.add(p7);

        Pet p8 = new Pet();
        p8.nome = "Bidu";
        p8.localizacao = "Aracruz";
        p8.foto = R.drawable.cachorro_grande;
        pets.add(p8);

        Pet p9 = new Pet();
        p9.nome = "Nina";
        p9.localizacao = "São Mateus";
        p9.foto = R.drawable.cachorro_fofo;
        pets.add(p9);

        Pet p10 = new Pet();
        p10.nome = "Balu";
        p10.localizacao = "Cachoeiro";
        p10.foto = R.drawable.cachorro_grande;
        pets.add(p10);

        return pets;

    }
}
