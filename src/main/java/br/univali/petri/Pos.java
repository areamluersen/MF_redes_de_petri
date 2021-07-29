package br.univali.petri;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Pos> findAllRelatedNodes(List<Pos> posList, Transition t) {
        return posList.stream().filter(p -> p.transitionID.equals(t.id)).collect(Collectors.toList());
    }
}
