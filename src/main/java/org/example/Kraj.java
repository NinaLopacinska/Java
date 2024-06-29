package org.example;

public class Kraj {
    private String nazwaKraju;
    private boolean czyWUE;
    private String waluta;
    private boolean czyOdwiedzone;
    private int numerKraju;
    private static int idCounter = 0;

    public Kraj() {
        this.numerKraju = generateId();
    }

    private static synchronized int generateId() {
        return ++idCounter;
    }

    public void setNumerKraju(int numerKraju) {
        this.numerKraju = numerKraju;
    }

    public int getNumerKraju() {
        return numerKraju;
    }

    public String getNazwaKraju() {
        return nazwaKraju;
    }

    public boolean isCzyWUE() {
        return czyWUE;
    }

    public String getWaluta() {
        return waluta;
    }

    public boolean isCzyOdwiedzone() {
        return czyOdwiedzone;
    }

    public void setNazwaKraju(String nazwaKraju) {
        this.nazwaKraju = nazwaKraju;
    }

    public void setCzyWUE(boolean czyWUE) {
        this.czyWUE = czyWUE;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public void setCzyOdwiedzone(boolean czyOdwiedzone) {
        this.czyOdwiedzone = czyOdwiedzone;
    }
}
