package br.univali.petri;

import java.nio.file.Path;
import java.util.List;

public class PetriNetwork {
    private final Integer iterationLimit;
    private final List<Integer> mZero;
    private final Long rngSeed;
    private final List<Pre> preList;
    private final List<Pos> posList;
    private final List<Transition> transitionList;
    private final List<Place> places;

    public PetriNetwork(Integer iterationLimit, List<Integer> mZero, Long rngSeed, List<Pre> preList, List<Pos> posList, List<Transition> transitionList, List<Place> places) {
        this.iterationLimit = iterationLimit;
        this.mZero = mZero;
        this.rngSeed = rngSeed;
        this.preList = preList;
        this.posList = posList;
        this.transitionList = transitionList;
        this.places = places;
    }

    public static PetriNetwork fromModelFile(Path path) {
        // TODO: Implement
        return null;
    }
}
