package br.univali.petri;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p = Path.of("models/pn-04.json");
        if (args.length != 1) {
            System.out.println("Model file not provided, using defaults");
        } else {
            p = Path.of(args[0]);
        }
        var pn = PetriNetwork.fromModelFile(p);
        pn.run();
    }
}
