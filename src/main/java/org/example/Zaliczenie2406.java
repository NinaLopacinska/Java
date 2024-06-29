package org.example;
import java.io.IOException;
import java.util.Scanner;


public class Zaliczenie2406 {

    public static void main(String[] args) {

        BazaKrajow bazaKrajow = new BazaKrajow();
        BazaMiast bazaMiast = new BazaMiast();

        System.out.println("Witaj w biurze podrozy!");
        Scanner scanner = new Scanner(System.in);
        boolean wantExit = false;
        Exporter exporter = new TextFileExporter();
        while (!wantExit) {
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Dodaj nowy kraj");
            System.out.println("2. Dodaj nowe miasto");
            System.out.println("3. Wyświetl odwiedzone miejsca");
            System.out.println("4. Generuj raport");
            System.out.println("5. Zapisz do pliku");
            System.out.println("6. Opuść biuro podróży");

            if (scanner.hasNextInt()) {
                int optionNumber = scanner.nextInt();
                scanner.nextLine();
                switch (optionNumber) {
                    case 1:
                        System.out.println("Podaj nazwę kraju: ");
                        String kraj = scanner.nextLine();
                        System.out.println("Czy ten kraj jest w UE? Odpowiedz TAK lub NIE: ");
                        String czyWUEODP = scanner.nextLine();
                        boolean czyWUE = czyWUEODP.equalsIgnoreCase("TAK");
                        System.out.println("Podaj walute obowiązująca w tym kraju (max 3 znaki): ");
                        String waluta = scanner.nextLine();
                        System.out.println("Czy ten kraj jest odwiedzony? Odpowiedz TAK lub NIE: ");
                        String czyOdwiedzoneODP = scanner.nextLine();
                        boolean czyOdwiedzone = czyOdwiedzoneODP.equalsIgnoreCase("TAK");

                        Kraj newKraj = new Kraj();
                        newKraj.setNazwaKraju(kraj);
                        newKraj.setCzyWUE(czyWUE);
                        newKraj.setWaluta(waluta);
                        newKraj.setCzyOdwiedzone(czyOdwiedzone);
                        bazaKrajow.getKraje().add(newKraj);
                        break;
                    case 2:
                        System.out.println("Podaj nazwę miasta: ");
                        String miasto = scanner.nextLine();
                        System.out.println("Podaj nazwę kraju, w którym jest to miasto (max 120 znaków): ");
                        String wJakimKraju = scanner.nextLine();
                        System.out.println("Czy to miasto jest stolica? Odpowiedz TAK lub NIE: ");
                        String czyStolicaODP = scanner.nextLine();
                        boolean czyStolica = czyStolicaODP.equalsIgnoreCase("TAK");
                        System.out.println("Czy to miasto jest odwiedzone? Odpowiedz TAK lub NIE: ");
                        String czyOdwiedzoneMiastoODP = scanner.nextLine();
                        boolean czyOdwiedzoneMiasto = czyOdwiedzoneMiastoODP.equalsIgnoreCase("TAK");

                        Miasto newMiasto = new Miasto();
                        newMiasto.setNazwaMiasta(miasto);
                        newMiasto.setwJakimKraju(wJakimKraju);
                        newMiasto.setCzyStolica(czyStolica);
                        newMiasto.setCzyOdwiedzoneMiasto(czyOdwiedzoneMiasto);
                        bazaMiast.getMiasta().add(newMiasto);
                        break;
                    case 3:
                        System.out.println("Odwiedzone kraje:");
                        for (Kraj x : bazaKrajow.getKraje()) {
                            if (x.isCzyOdwiedzone()) {
                                System.out.println(x.getNazwaKraju());
                            }
                        }
                        System.out.println("Odwiedzone miasta:");
                        for (Miasto y : bazaMiast.getMiasta()) {
                            if (y.isCzyOdwiedzoneMiasto()) {
                                System.out.println(y.getNazwaMiasta());
                            }
                        }
                        break;
                    case 4:
                        long liczbaOdwiedzonychKrajow = bazaKrajow.getKraje().stream()
                                .filter(Kraj::isCzyOdwiedzone)
                                .count();
                        long liczbaPlanowanychKrajow = bazaKrajow.getKraje().stream()
                                .filter(Kraj::isCzyOdwiedzone)
                                .count();

                        long liczbaOdwiedzonychMiast = bazaMiast.getMiasta().stream()
                                .filter(Miasto::isCzyOdwiedzoneMiasto)
                                .count();

                        long liczbaPlanowanychMiast = bazaMiast.getMiasta().stream()
                                .filter(Miasto::isCzyOdwiedzoneMiasto)
                                .count();

                        long liczbaOdwiedzonychStolic = bazaMiast.getMiasta().stream()
                                .filter(Miasto::isCzyStolica)
                                .filter(Miasto::isCzyOdwiedzoneMiasto)
                                .count();

                        long liczbaPlanowanychStolic = bazaMiast.getMiasta().stream()
                                .filter(Miasto::isCzyStolica)
                                .filter(Miasto -> !Miasto.isCzyOdwiedzoneMiasto())
                                .count();

                        System.out.println("Raport:");
                        System.out.println("Liczba odwiedzonych krajow: " + liczbaOdwiedzonychKrajow);
                        System.out.println("Liczba krajów planowanych do odwiedzenia: " + liczbaPlanowanychKrajow);
                        System.out.println("Liczba odwiedzonych miast: " + liczbaOdwiedzonychMiast);
                        System.out.println("Liczba miast planowanych do odwiedzenia: " + liczbaPlanowanychMiast);
                        System.out.println("Liczba odwiedzonych stolic: " + liczbaOdwiedzonychStolic);
                        System.out.println("Liczba stolic planowanych do odwiedzenia: " + liczbaPlanowanychStolic);
                        break;
                    case 5:
                        System.out.println("Podaj nazwę pliku do zapisu (np. lista_miast.txt): ");
                        String nazwaPliku = scanner.nextLine();
                        try {
                            exporter.export(bazaMiast.getMiasta(), nazwaPliku);
                            System.out.println("Lista miejsc została zapisana do pliku: " + nazwaPliku);
                        } catch (IOException e) {
                            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Do zobaczenia!");
                        wantExit = true;
                        break;
                    default:
                        System.out.println("Błędna wartość!");
                }
            } else {
                System.out.println("Błędna wartość!");
                scanner.next();
            }
        }
        scanner.close();
    }
}
