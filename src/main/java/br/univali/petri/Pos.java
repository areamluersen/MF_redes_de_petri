package br.univali.petri;

public class Pos {
    public final Integer id;
    public final Integer tokenOutput;
    public final Integer placeID;
    public final Integer transitionID;

    public Pos(Integer id, Integer tokenOutput, Integer placeID, Integer transitionID) {
        this.id = id;
        this.tokenOutput = tokenOutput;
        this.placeID = placeID;
        this.transitionID = transitionID;
    }
}
