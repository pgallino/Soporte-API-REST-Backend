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

public class ApiTasks {
    public ApiTasks(){}
    private static final String API_URL = "https://my-json-server.typicode.com/gcaldev/psa-mock/tareas/";

    public Collection<Task> getMyTasks(){
        Task[] tasks = getTasksArray();
        if (tasks == null){
            return new ArrayList<>();
        }

        return  Arrays.asList(tasks);
    }
        private Task[] getTasksArray(){
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://my-json-server.typicode.com/gcaldev/psa-mock/tareas/"))
                .setHeader("Accept", "application/json")
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();
            Gson gson = new Gson();
            Task[] taskArray = gson.fromJson(responseBody, Task[].class);
            return taskArray;
        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
