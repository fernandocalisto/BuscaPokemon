package br.com.fernandocalisto.principal;

import br.com.fernandocalisto.modelos.Pokemon;
import br.com.fernandocalisto.modelos.PokemonDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try (Scanner leitura = new Scanner(System.in)) {
            System.out.print("Insira o nome do Pokémon ou seu ID: ");
            String busca = leitura.nextLine().trim().toLowerCase();
            String path = URLEncoder.encode(busca, java.nio.charset.StandardCharsets.UTF_8);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1).connectTimeout(Duration.ofSeconds(10)).build();

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + path))
                    .timeout(Duration.ofSeconds(30))
                    .GET()
                    .build();

            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());

            if (resp.statusCode() == 200) {
                String json = resp.body();
                Gson gson = new GsonBuilder().registerTypeAdapter(Pokemon.class , new PokemonDeserializer()).create();
                Pokemon buscaPokemon = gson.fromJson(json, Pokemon.class);
                System.out.println(buscaPokemon);
            } else if (resp.statusCode() == 404) {
                System.out.println("Pokémon não encontrado.");
            } else {
                System.out.printf("Erro HTTP %d%n", resp.statusCode());
            }
        } catch (java.net.ConnectException ce) {
            System.out.println("Não foi possível conectar à PokéAPI. Verifique sua internet ou tente novamente.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}