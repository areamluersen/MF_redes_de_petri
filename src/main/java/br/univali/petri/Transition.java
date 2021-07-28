package br.univali.petri;

import java.util.List;

public class Transition {
    private final Integer id;
    private final List<Pre> preList;
    private final List<Pos> posList;

    public Transition(Integer id, List<Pre> preList, List<Pos> posList) {
        this.id = id;
        this.preList = preList;
        this.posList = posList;
    }

    public void fire() {
        // TODO: Implement
        return;
    }

    public boolean isEnabled() {
        // TODO: Implement
        return false;
    }
}
