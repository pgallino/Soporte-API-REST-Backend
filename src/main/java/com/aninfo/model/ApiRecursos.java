package com.aninfo.model;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.net.http.HttpResponse;
import com.google.gson.Gson;


public class ApiRecursos {

    public ApiRecursos(){}
    private static final String API_URL = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos";

    public Collection<Recurso> getRecursos(){
        Recurso[] recursosArray = getRecursosArray();
        if (recursosArray == null){
            return new ArrayList<>();
        }
        return  Arrays.asList(recursosArray);
    }
    public Optional<Recurso> findByLegajo(long legajoBuscado) {
        Recurso[] recursosArray = getRecursosArray();
        if (recursosArray == null){
            return Optional.empty();
        }
        for (Recurso persona : recursosArray) {
            if (persona.getLegajo() == legajoBuscado) {
                return Optional.of(persona);
            }
        }
        return Optional.empty();
    }
    private Recurso[] getRecursosArray(){
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos"))
                .setHeader("Accept", "application/json")
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();
            Gson gson = new Gson();
            Recurso[] recursosArray = gson.fromJson(responseBody, Recurso[].class);
            return recursosArray;
        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
