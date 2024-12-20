package lahass.stephany.miaujuda.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import lahass.stephany.miaujuda.R;

public class HomeActivityViewModel extends ViewModel {

    public List<Pet> getPets() {

        List<Pet> pets = new ArrayList<>();

        Pet p2 = new Pet();
        p2.nome = "Fofinho";
        p2.localizacao = "Vitória";
        p2.foto = R.drawable.cachorro;
        p2.raca = "Poodle";
        p2.tamanho = "Pequeno";
        p2.peso = 5;
        p2.sexo = "Macho";
        p2.tipo = "Cão";  // Tipo adicionado
        pets.add(p2);

        Pet p3 = new Pet();
        p3.nome = "Bolota";
        p3.localizacao = "Vila Velha";
        p3.foto = R.drawable.gato_preto;
        p3.raca = "Siamês";
        p3.tamanho = "Médio";
        p3.peso = 4;
        p3.sexo = "Fêmea";
        p3.tipo = "Gato";  // Tipo adicionado
        pets.add(p3);

        Pet p4 = new Pet();
        p4.nome = "Pipoca";
        p4.localizacao = "Cariacica";
        p4.foto = R.drawable.cachorro_marrom;
        p4.raca = "Labrador";
        p4.tamanho = "Grande";
        p4.peso = 30;
        p4.sexo = "Macho";
        p4.tipo = "Cão";  // Tipo adicionado
        pets.add(p4);

        Pet p5 = new Pet();
        p5.nome = "Tigrinho";
        p5.localizacao = "Guarapari";
        p5.foto = R.drawable.gato_tigrado;
        p5.raca = "Bengal";
        p5.tamanho = "Médio";
        p5.peso = 5;
        p5.sexo = "Macho";
        p5.tipo = "Gato";  // Tipo adicionado
        pets.add(p5);

        Pet p6 = new Pet();
        p6.nome = "Rabito";
        p6.localizacao = "Linhares";
        p6.foto = R.drawable.cachorro_pequeno;
        p6.raca = "Chihuahua";
        p6.tamanho = "Pequeno";
        p6.peso = 2;
        p6.sexo = "Macho";
        p6.tipo = "Cão";  // Tipo adicionado
        pets.add(p6);

        Pet p7 = new Pet();
        p7.nome = "Mingau";
        p7.localizacao = "Colatina";
        p7.foto = R.drawable.gato_branco;
        p7.raca = "Persa";
        p7.tamanho = "Médio";
        p7.peso = 4;
        p7.sexo = "Fêmea";
        p7.tipo = "Gato";  // Tipo adicionado
        pets.add(p7);

        Pet p8 = new Pet();
        p8.nome = "Bidu";
        p8.localizacao = "Aracruz";
        p8.foto = R.drawable.cachorro_grande;
        p8.raca = "Rottweiler";
        p8.tamanho = "Grande";
        p8.peso = 35;
        p8.sexo = "Macho";
        p8.tipo = "Cão";  // Tipo adicionado
        pets.add(p8);

        Pet p9 = new Pet();
        p9.nome = "Nina";
        p9.localizacao = "São Mateus";
        p9.foto = R.drawable.cachorro_fofo;
        p9.raca = "Beagle";
        p9.tamanho = "Médio";
        p9.peso = 9;
        p9.sexo = "Fêmea";
        p9.tipo = "Cão";  // Tipo adicionado
        pets.add(p9);

        Pet p10 = new Pet();
        p10.nome = "Balu";
        p10.localizacao = "Cachoeiro";
        p10.foto = R.drawable.cachorro_grande;
        p10.raca = "Golden Retriever";
        p10.tamanho = "Grande";
        p10.peso = 32;
        p10.sexo = "Macho";
        p10.tipo = "Cão";  // Tipo adicionado
        pets.add(p10);

        return pets;
    }
}
