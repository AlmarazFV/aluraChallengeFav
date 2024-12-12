package com.fav.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ClienteHttp {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/8606a3125ebe69df3cfdfc37/latest/USD";
    private final HttpClient client;

    public ClienteHttp() {
        this.client = HttpClient.newHttpClient();
    }

    public JsonObject obtenerDatosProcesados() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return JsonParser.parseString(response.body()).getAsJsonObject();
        } else {
            throw new Exception("Error al obtener los datos: Código de respuesta " + response.statusCode());
        }
    }

    public Map<String, Double> filtrarMonedas() throws Exception {
        // Lista de monedas en orden alfabético
        String[] monedasDeseadas = {"ARS", "BOB", "BRL", "CLP", "COP", "JPY", "KRW", "MXN", "USD", "EUR"};

        JsonObject datosJson = obtenerDatosProcesados();
        JsonObject conversionRates = datosJson.getAsJsonObject("conversion_rates");

        Map<String, Double> tasasFiltradas = new HashMap<>();
        for (String moneda : monedasDeseadas) {
            if (conversionRates.has(moneda)) {
                tasasFiltradas.put(moneda, conversionRates.get(moneda).getAsDouble());
            }
        }
        return tasasFiltradas;
    }
}
