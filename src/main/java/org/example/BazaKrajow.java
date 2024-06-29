package org.example;

import java.util.ArrayList;
import java.util.List;

public class BazaKrajow {
    private List<Kraj> kraje;

    public BazaKrajow() {
        this.kraje = new ArrayList<>();
    }

    public List<Kraj> getKraje() {
        return kraje;
    }
     public void setKraje(List<Kraj> kraje) {
        this.kraje = kraje;
    }
}
