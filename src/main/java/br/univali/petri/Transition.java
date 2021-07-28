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
        if (!this.isEnabled()) {
            System.out.printf("Attempted to fire disabled transition %d, ignoring...\n", this.id);
            return;
        }
        preList.forEach(pre -> pre.getPlace()
                        .decrementTokenCount(pre.getTokenInput()));
        posList.forEach(pos -> pos.getPlace()
                .incrementTokenCount(pos.getTokenOutput()));
        System.out.printf("Transition id %d fired successfully\n", this.id);
    }

    public boolean isEnabled() {
        // TODO: Implement
        for (Pre pre : preList) {
            if (pre.getPlace().getTokenCount() < pre.getTokenInput()) {
                System.out.printf("Pre-condition %d not satisfied, transition %d disabled\n", pre.getId(), this.id);
                return false;
            }
        }
        System.out.printf("All pre-conditions for transition id %d satisfied, transition enabled\n", this.id);
        return true;
    }
}
