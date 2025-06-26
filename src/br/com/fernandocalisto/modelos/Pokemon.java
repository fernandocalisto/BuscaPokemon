package br.com.fernandocalisto.modelos;

import java.util.LinkedList;

public class Pokemon {
    private String name;
    private int id;
    private LinkedList<String> types;
    private LinkedList<String> abilities;
    private String sprite;

    public Pokemon(String name, int id, LinkedList<String> type, LinkedList<String> abilities, String sprite) {
        this.name = name;
        this.id = id;
        this.types = type;
        this.abilities = abilities;
        this.sprite = sprite;
    }

    public String toString (){

        String tipos = String.join(", ", types);
        String habilidades = String.join(", ", abilities);

        return """
                Nome: %s
                Id: %d
                Tipos: %s
                Habilidades: %s
                Sprite: %s
                """.formatted(name, id, tipos, habilidades, sprite);
    }

}
