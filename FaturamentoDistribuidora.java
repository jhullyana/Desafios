import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        try {
            // Lendo o arquivo JSON de faturamento
            FileReader reader = new FileReader("faturamento.json");
            JSONArray jsonArray = new JSONArray(new JSONTokener(reader));

            double totalFaturamento = 0.0;
            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            int diasComFaturamentoSuperiorAMedia = 0;
            int diasComFaturamento = 0;


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                double faturamento = obj.getDouble("faturamento");

                if (faturamento > 0) {
                    totalFaturamento += faturamento;
                    diasComFaturamento++;

                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }

                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }
                }

            double mediaFaturamento = totalFaturamento / diasComFaturamento;


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                double faturamento = obj.getDouble("faturamento");

                if (faturamento > mediaFaturamento) {
                    diasComFaturamentoSuperiorAMedia++;
                }
            }

            // Exibir resultados
            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento superior à média: " + diasComFaturamentoSuperiorAMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
