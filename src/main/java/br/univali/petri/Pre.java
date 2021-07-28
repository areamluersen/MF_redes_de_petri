package br.univali.petri;

public class Pre {
    private final Integer id;
    private Integer tokenInput;
    private final Transition transition;

    public Pre(Integer id, Integer tokenInput, Transition transition) {
        this.id = id;
        this.tokenInput = tokenInput;
        this.transition = transition;
    }
}
