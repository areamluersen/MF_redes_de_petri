package br.univali.petri;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        List<Integer> mZero = Arrays.asList(1, 1, 1);
        var p0 = new Place(0, 3);
        // t0 needs preList, but preList needs t0!!!
        var pre0 = new Pre(0,1, t0, p0);
        List<Place> places = Arrays.asList(p0);
        List<Pre> preList = Arrays.asList(
                pre0
        );
        List<Pos> posList = Arrays.asList(
        );
        var t0 = new Transition(0, preList, posList);

        List<Transition> transitionList = Arrays.asList(
                t0
        );

        var pn = new PetriNetwork(100, mZero, 42, preList, posList, transitionList, places);
        pn.run();
    }
}
