package org.example;
import javax.management.ListenerNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static LinkedList<String> uzunlugaGoreEkleme(String input1) throws IOException {

        List<String> kelimeler = Files.readAllLines(
                Paths.get("words.txt"),
                StandardCharsets.UTF_8
        );


        LinkedList<String> liste = new LinkedList<>();


        for (String kelime : kelimeler) {
            String ortakKisim = "";

            for (int t = 0; t < Math.min(input1.length(), kelime.length()); t++) {
                if (input1.charAt(t) == kelime.charAt(t)) {
                    ortakKisim += input1.charAt(t);

                    if (kelime.length() == input1.length() + 1) {
                        liste.add(kelime);
                    }
                    if (kelime.length() == input1.length() + 2) {
                        liste.add(kelime);
                    }
                } else {
                    break;
                }
            }
        }

        return liste;
    }





    public static LinkedList<String> harfleriDegistirerekEkleme(String input1) throws IOException {

        List<String> kelimeler = Files.readAllLines(
                Paths.get("words.txt"),
                StandardCharsets.UTF_8
        );

        LinkedList<String> liste = new LinkedList<>();

        String alfabe = "abcçdefgğhıijklmnoöprsştuüvyz";
        char[] alfabeninHarfleri = alfabe.toCharArray();


        char[] harfler = input1.toCharArray();


        for (int i = 0; i < harfler.length; i++) {      // burası mesela krlime kelimesini bulmaya yarar
            char eskiHarf = harfler[i];

            for (int j = 0; j < alfabeninHarfleri.length; j++) {
                harfler[i] = alfabeninHarfleri[j];

                String yeniKelime = new String(harfler);
                if (kelimeler.contains(yeniKelime) && !liste.contains(yeniKelime)) {
                    liste.add(yeniKelime);
                }
            }

            harfler[i] = eskiHarf;
        }
        return liste;
    }




    public static void main(String[] args) throws IOException {

        String input = "kelim";

        System.out.println(uzunlugaGoreEkleme(input));
        System.out.println(harfleriDegistirerekEkleme(input));

    }
}
