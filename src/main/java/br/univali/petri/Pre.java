package br.univali.petri;

import java.util.List;
import java.util.stream.Collectors;

public class Pre {
    public final Integer id;
    public Integer tokenInput;
    public final Integer transitionID;
    public final Integer placeID;

    public Pre(Integer id, Integer placeID, Integer transitionID, Integer tokenInput) {
        this.id = id;
        this.tokenInput = tokenInput;
        this.transitionID = transitionID;
        this.placeID = placeID;
    }

    public static List<Pre> findAllRelatedNodes(List<Pre> preList, Transition t) {
        return preList.stream().filter(p -> p.transitionID.equals(t.id)).collect(Collectors.toList());
    }
}
