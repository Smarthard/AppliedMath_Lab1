import java.io.File;
import java.util.Map;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        for (String file : args) {
            TextReader tr = new TextReader(file);
            String text = tr.readFile();
            tr.closeStream();

            Map<String, Double> lProbs = ShannonEcoding.calcProbs(text, 1);

            double lEntropy = 0D;
            for (String lKey : lProbs.keySet()) {
                double val = lProbs.get(lKey);
                double cEntropy = -val * log(val) / log(2);

                lEntropy += cEntropy;
                System.out.printf("H(%s) = %.4f, P(%s) = %.4f\n", lKey, cEntropy, lKey, val);
            }

            Map<String, Double> wProbs = ShannonEcoding.calcProbs(text, 2);

            double wEntropy = 0D;
            for (String wKey : wProbs.keySet()) {
                wEntropy += wProbs.get(wKey) * lProbs.get("" + wKey.charAt(1)) * log(wProbs.get(wKey)) / log(2);
            }

            System.out.println();
            System.out.printf("%s: H(x) = %.4f, H*(x) = %.4f\n\n", file, lEntropy, wEntropy);
        }
    }
}
