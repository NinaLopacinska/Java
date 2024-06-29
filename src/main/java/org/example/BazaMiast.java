package org.example;

import java.util.ArrayList;
import java.util.List;

public class BazaMiast {
    private List<Miasto> miasta;

    public BazaMiast() {
        this.miasta = new ArrayList<>();
    }

    public List<Miasto> getMiasta() {
        return miasta;
    }
    public void setMiasta(List<Miasto> miasta) {
        this.miasta = miasta;
    }
}
