package br.univali.petri;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p = Path.of("models/pn-04.json");
        System.out.println(p.toString());
        var pn = PetriNetwork.fromModelFile(p);
        pn.run();
    }
}
