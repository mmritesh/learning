package stanlay;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    enum Currencies {
        EUR, AUD, USD, DIN, INR
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] inputs = input.split(" ");
        int sourceAmount = Integer.parseInt(inputs[0]);
        String sourceCurrency = inputs[1];
        String destinationCurrency = inputs[3];
        double[][] conversionChart = getConversionMatrix();
        int result = (int)(sourceAmount * conversionChart[Currencies.valueOf(sourceCurrency).ordinal()][Currencies.valueOf(destinationCurrency).ordinal()]);

        System.out.println(result + " " + destinationCurrency);
    }

    private static double[][] getConversionMatrix() {
        double[][] matrix = {
                {1, 2, 4, 4/3, 70*4},
                {2/1.5, 1, 2, 2/3, 70*2},
                {1/1.5, 2/1.5, 1, 1/3, 70},
                {3/1.5, 6/1.5, 3, 1, 70*3},
                {1/(70*1.5), 2/(70*1.5), 1/70, 1/(70*3), 1}
        };
        return matrix;
    }
}

//    Map<String, Integer> conversionRates = new HashMap<>();
//        conversionRates.put("EUR", 0);
//                conversionRates.put("AUD", 1);
//                conversionRates.put("USD", 2);
//                conversionRates.put("DIN", 3);
//                conversionRates.put("INR", 4);