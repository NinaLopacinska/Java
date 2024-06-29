package org.example;

public class Miasto {
    private String nazwaMiasta;
    private String wJakimKraju;
    private boolean czyStolica;
    private boolean czyOdwiedzoneMiasto;
    private int numerMiasta;
    private static int idCounterM = 0;

    public Miasto() {
        this.numerMiasta = generateIdM();
    }

    private static synchronized int generateIdM() {
        return ++idCounterM;
    }

    public void setNumerMiasta(int numerMiasta) {
        this.numerMiasta = numerMiasta;
    }

    public int getNumerMiasta() {
        return numerMiasta;
    }

    public String getNazwaMiasta() {
        return nazwaMiasta;
    }

    public String getwJakimKraju() {
        return wJakimKraju;
    }

    public boolean isCzyStolica() {
        return czyStolica;
    }

    public boolean isCzyOdwiedzoneMiasto() {
        return czyOdwiedzoneMiasto;
    }

    public void setNazwaMiasta(String nazwaMiasta) {
        this.nazwaMiasta = nazwaMiasta;
    }

    public void setwJakimKraju(String wJakimKraju) {
        this.wJakimKraju = wJakimKraju;
    }

    public void setCzyStolica(boolean czyStolica) {
        this.czyStolica = czyStolica;
    }

    public void setCzyOdwiedzoneMiasto(boolean czyOdwiedzoneMiasto) {
        this.czyOdwiedzoneMiasto = czyOdwiedzoneMiasto;
    }
}
