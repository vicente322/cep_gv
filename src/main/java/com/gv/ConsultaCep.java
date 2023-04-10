package com.gv;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.MINUTES;

public class ConsultaCep {
    public static final String urlBase = "https://viacep.com.br/ws";

    private HttpRequest httpRequest;
    private HttpResponse<String> httpResponse;

    public ConsultaCep () {
        httpRequest = null;
        httpResponse = null;
    }

    public HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public static String constroiConsulta(String urlAdicional) throws UnsupportedEncodingException{
        StringBuffer urlConsulta = new StringBuffer();
        urlConsulta.append(urlBase);
        urlConsulta.append(urlAdicional);
        urlConsulta.append("/json");

        return urlConsulta.toString();
    }

    public String mandaConsultaCEP(String urlCEP) throws UnsupportedEncodingException{
        String url = ConsultaCep.constroiConsulta(urlCEP);

        System.out.println("URL CEP: " + url);
        
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                                    .connectTimeout(Duration.of(1, MINUTES))
                                    .build();
            
            httpRequest = HttpRequest.newBuilder()
                          .GET()
                          .uri(URI.create(url))
                          .build();

            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            
            return httpResponse.body();
        }

        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
    }

    public String mandaConsultaLogradouro(String urlLog) throws UnsupportedEncodingException{
        String url = ConsultaCep.constroiConsulta(urlLog);

        System.out.println("URL Logradouro" + url);

        try {
            HttpClient httpClient = HttpClient.newBuilder()
                                    .connectTimeout(Duration.of(1, MINUTES))
                                    .build();

            httpRequest = HttpRequest.newBuilder()
                          .GET()
                          .uri(URI.create(url))
                          .build();

            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            
            return httpResponse.body();
        }

        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
    }
}
