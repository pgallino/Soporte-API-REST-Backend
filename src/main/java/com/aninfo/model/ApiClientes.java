package com.aninfo.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;


public class ApiClientes {

    public ApiClientes(){}
    private static final String API_URL = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/clientes-psa/1.0.0/m/api/clientes";

    public Collection<Cliente> getClientes(){
        Cliente[] ClienteArray = getClientesArray();
        if (ClienteArray == null){
            return new ArrayList<>();
        }
        return  Arrays.asList(ClienteArray);
    }
    public Optional<Cliente> findById(long idBuscado) {
        Cliente[] clienteArray = getClientesArray();
        if (clienteArray == null){
            return Optional.empty();
        }
        for (Cliente cliente : clienteArray) {
            if (cliente.getId() == idBuscado) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }
    private Cliente[] getClientesArray(){
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/clientes-psa/1.0.0/m/api/clientes"))
                .setHeader("Accept", "application/json")
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, Cliente[].class);
        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
