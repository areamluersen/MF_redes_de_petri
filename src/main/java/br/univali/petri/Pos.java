package br.univali.petri;

public class Pos {
    private final Integer id;
    private final Integer tokenOutput;
    private final Place place;

    public Pos(Integer id, Integer tokenOutput, Place place) {
        this.id = id;
        this.tokenOutput = tokenOutput;
        this.place = place;
    }


}