package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TextFileExporter implements Exporter {

    @Override
    public void export(List<Miasto> miasta, String nazwaPliku) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nazwaPliku))) {
            for (Miasto miasto : miasta) {
                writer.println("Nazwa miasta: " + miasto.getNazwaMiasta());
                writer.println("Nazwa kraju: " + miasto.getwJakimKraju());
                writer.println("Stolica: " + (miasto.isCzyStolica() ? "TAK" : "NIE"));
                writer.println("Odwiedzone: " + (miasto.isCzyOdwiedzoneMiasto() ? "TAK" : "NIE"));
                writer.println();
            }
        }
    }
}
