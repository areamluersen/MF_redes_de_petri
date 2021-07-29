package br.univali.petri;

import java.nio.file.Path;
import java.util.List;
import java.util.Random;
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
        var rng = new Random(rngSeed);
        System.out.println("=== Starting PetriModel ===.");
        for (int i = 0; i < iterationLimit; i++) {
            System.out.printf("=== Running iteration %d ===\n", i);
            System.out.println("==> Before:");
            System.out.println(getCurrentState());
            var enabledTransitions = findAllEnabledTransitions();
            if (enabledTransitions.size() == 0) {
                System.out.println("=== Zero enabled transitions left, halting model simulation ===");
                break;
            }
            var rand = rng.nextInt() % enabledTransitions.size();
            var chosenTransition = enabledTransitions.get(rand);
            for (Pre pre: Pre.findAllRelatedNodes(preList, chosenTransition)) {
                places.stream()
                        .filter(p -> p.id.equals(pre.placeID))
                        .peek( p ->
                                System.out.printf("TransitionID %d has consumed %d tokens from PlaceID %d\n", chosenTransition.id, pre.tokenInput, p.id))
                        .findFirst().get()
                        .decrementTokenCount(pre.tokenInput);
            }
            for (Pos pos : Pos.findAllRelatedNodes(posList, chosenTransition)) {
                places.stream()
                        .filter(p -> p.id.equals(pos.placeID))
                        .peek(p -> System.out.printf("PosID %d triggered, adding %d tokens to PlaceID %d\n", pos.id, pos.tokenOutput, p.id))
                        .findFirst().get()
                        .incrementTokenCount(pos.tokenOutput);
            }
            System.out.println("==> After:");
            System.out.println(getCurrentState());
        }
    }

    private List<Transition> findAllEnabledTransitions() {
        List<Transition> enabledTransitions;
        enabledTransitions = transitionList.stream().filter(f -> {
            var preLinked = preList.stream()
                    .filter(pre -> pre.transitionID.equals(f.id))
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
        return enabledTransitions;
    }

    private String getCurrentState() {
        StringBuilder sb = new StringBuilder();
        for (Place p: places) {
            sb.append(String.format("PlaceID %d has %d tokens\n", p.id, p.getTokenCount()));
        }
        return sb.toString();
    }
}
