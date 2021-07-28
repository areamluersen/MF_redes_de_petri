package br.univali.petri;

public class Pre {
    private final Integer id;
    private Integer tokenInput;
    private final Transition transition;
    private final Place place;

    public Pre(Integer id, Integer tokenInput, Transition transition, Place place) {
        this.id = id;
        this.tokenInput = tokenInput;
        this.transition = transition;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTokenInput() {
        return tokenInput;
    }

    public Transition getTransition() {
        return transition;
    }

    public Place getPlace() {
        return place;
    }
}
