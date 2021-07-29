package br.univali.petri;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        List<Integer> mZero = Arrays.asList(1, 1, 1);
        List<Place> places = Arrays.asList(
                new Place(0, 3),
                new Place(1 , 2),
                new Place(2,  0)
        );
        List<Pre> preList = Arrays.asList(
                new Pre(0,1, 0, 0),
                new Pre(1,1, 0, 1)
        );
        List<Pos> posList = Arrays.asList(
                new Pos(0, 1, 2)
        );
        List<Transition> transitionList = Arrays.asList(
                new Transition(0)
        );

        var pn = new PetriNetwork(100, mZero, 42L, preList, posList, transitionList, places);
        pn.run();
    }
}
