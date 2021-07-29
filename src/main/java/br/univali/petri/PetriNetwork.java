package br.univali.petri;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

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

    public void run() {
        System.out.println("Starting PetriModel...");
        boolean hasSomethingChangedSinceLastIter = true;
        for (int i = 0; i < iterationLimit; i++) {
            System.out.printf("Running iteration %d\n", i);
            findAllEnabledTransitions();
        }
    }

    private List<Transition> findAllEnabledTransitions() {
        List<Transition> enabledTransitions;
        enabledTransitions = transitionList.stream().filter(f -> {
            var preLinked = preList.stream()
                    .filter(pre -> pre.id.equals(f.id))
                    .collect(Collectors.toList());
            AtomicBoolean hasEnoughTokens = new AtomicBoolean(true);
            preLinked.forEach(preElement -> {
                var place = places.stream()
                        .filter(placeElement -> placeElement.id.equals(preElement.placeID))
                        .findFirst().get();
                if (place.getTokenCount() < preElement.tokenInput) {
                    System.out.printf("PlaceID %d doesn't have enough tokens, want=%d have=%d\n", place.id, preElement.tokenInput, place.getTokenCount());
                    System.out.printf("PreID %d not satisfied, not enabling TransitionID %d\n", preElement.id, f.id);
                    hasEnoughTokens.set(false);
                }
            });
            return hasEnoughTokens.get();
        }).collect(Collectors.toList());
        System.out.println(enabledTransitions.size());
        for (Transition t : enabledTransitions) {
            System.out.printf("TransitionID %d is enabled\n", t.id);
        }
        return enabledTransitions;
    }
}
