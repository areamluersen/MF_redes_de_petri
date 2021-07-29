package br.univali.petri;

public class Pre {
    public final Integer id;
    public Integer tokenInput;
    public final Integer transitionID;
    public final Integer placeID;

    public Pre(Integer id, Integer tokenInput, Integer transitionID, Integer placeID) {
        this.id = id;
        this.tokenInput = tokenInput;
        this.transitionID = transitionID;
        this.placeID = placeID;
    }
}
