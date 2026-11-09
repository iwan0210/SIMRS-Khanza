/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fungsi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author iwan
 */
public class AturanPakaiParser {

    public static String[] parseAturanPakai(String aturan) {
        if (aturan == null) {
            return null;
        }
        aturan = aturan.trim().toLowerCase();

        // 1. Format perkalian (Contoh: 3x1, 3x500, 3x4mg, 3x0,5)
        Pattern patternX = Pattern.compile("^(\\d+(?:[.,]\\d+)?)\\s*x\\s*(\\d+(?:[.,]\\d+)?)\\s*(mg|g|mcg|ml|tab|kapsul)?");
        Matcher matcherX = patternX.matcher(aturan);
        if (matcherX.find()) {
            String freq = matcherX.group(1).replace(',', '.');
            String dosisValueStr = matcherX.group(2).replace(',', '.');
            String satuan = matcherX.group(3);

            double dosisVal = Double.parseDouble(dosisValueStr);

            // Jika ada satuan (mg, g, dll) ATAU angka dosis kedua bernilai > 3 (misal 4mg, 500),
            // maka asumsikan itu adalah kekuatan obat dalam mg, sehingga dosis per minum dijadikan "1"
            String finalDosis = (satuan != null || dosisVal > 3) ? "1" : formatOutputDosis(dosisValueStr);

            return new String[]{freq, finalDosis};
        }

        // 2. Format frekuensi harian (Contoh: 3dd1)
        Pattern patternDd = Pattern.compile("^(\\d+)\\s*dd\\s*(\\d+(?:/\\d+|[.,]\\d+)?)");
        Matcher matcherDd = patternDd.matcher(aturan);
        if (matcherDd.find()) {
            return new String[]{
                matcherDd.group(1),
                formatOutputDosis(matcherDd.group(2))
            };
        }

        // 3. Format waktu / interval (Contoh: 0-0-1, 1-1-0, 0.0.0,5, 0-0-0-0.5)
        Pattern patternTriple = Pattern.compile("^(\\d+(?:/\\d+|[.,]\\d+)?)\\s*[-.]\\s*(\\d+(?:/\\d+|[.,]\\d+)?)\\s*[-.]\\s*(\\d+(?:/\\d+|[.,]\\d+)?)(?:\\s*[-.]\\s*(\\d+(?:/\\d+|[.,]\\d+)?))?");
        Matcher matcherTriple = patternTriple.matcher(aturan);
        if (matcherTriple.find()) {
            double pagi = evalVal(matcherTriple.group(1));
            double siang = evalVal(matcherTriple.group(2));
            double malam = evalVal(matcherTriple.group(3));
            double kuartet = matcherTriple.group(4) != null ? evalVal(matcherTriple.group(4)) : 0;

            double totalDosis = pagi + siang + malam + kuartet;

            int freq = 0;
            if (pagi > 0) {
                freq++;
            }
            if (siang > 0) {
                freq++;
            }
            if (malam > 0) {
                freq++;
            }
            if (kuartet > 0) {
                freq++;
            }

            if (freq > 0) {
                double dosisPerMinum = (freq == 1) ? totalDosis : (totalDosis / freq);
                return new String[]{String.valueOf(freq), formatOutputDosis(String.valueOf(dosisPerMinum))};
            }
        }

        return null;
    }

    private static double evalVal(String str) {
        if (str == null) {
            return 0;
        }
        str = str.replace(',', '.');
        if (str.contains("/")) {
            String[] parts = str.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        }
        return Double.parseDouble(str);
    }

    private static String formatOutputDosis(String str) {
        if (str == null) {
            return "";
        }
        double val = evalVal(str);
        if (val == (int) val) {
            return String.valueOf((int) val);
        }
        return String.valueOf(val).replace('.', ',');
    }
}
