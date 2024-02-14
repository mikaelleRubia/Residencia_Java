package com.mikaelle.soft.pratica12.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

@RestController
public class Pratica12Controller {

	@RequestMapping("/todos")
	public String lerArquivoCSV() throws IOException {
	    StringBuilder csvContent = new StringBuilder();
	    String line = "";
	    String csvDelimiter = ",";

	    try (BufferedReader br = new BufferedReader(new FileReader("/home/mikaelle/eclipse-workspace/pratica12/vencedores.csv"))) {
	        while ((line = br.readLine()) != null) {
	            String[] fields = line.split(csvDelimiter);
	            for (String field : fields) {
	                csvContent.append(field).append(", ");
	            }
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return csvContent.toString();
	}

	@RequestMapping("/brasileiros")
	public ArrayList <String> lerVencedoresBrasileiros() throws IOException {
	    StringBuilder csvContent = new StringBuilder();
	    ArrayList <String> lista= new ArrayList<>();
	    String line = "";
	    String csvDelimiter = ",";

	    try (BufferedReader br = new BufferedReader(new FileReader("/home/mikaelle/eclipse-workspace/pratica12/vencedores.csv"))) {
	        while ((line = br.readLine()) != null) {
	            String[] fields = line.split(csvDelimiter);

	            if ("Brasil".equals(fields[2])) { 
	                for (String field : fields) {
	                    csvContent.append(field).append(", ");
	                }
	                lista.add(csvContent.toString());
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return lista;
	}
	
	@RequestMapping("/top5")
	public ArrayList<String> lerVencedoresTop5() throws IOException {
	    ArrayList <String> lista= new ArrayList<>();
	    ArrayList<String> listaTop5 = new ArrayList<>();
	    int cont = 0;
	    try (BufferedReader br = new BufferedReader(new FileReader("/home/mikaelle/eclipse-workspace/pratica12/vencedores.csv"))) {
	        String line = br.readLine(); 
	        while ((line = br.readLine()) != null) {
	            String[] fields = line.split(","); 
	            StringBuilder csvContent = new StringBuilder();
	            for (String field : fields) {
	                csvContent.append(field).append(", ");
	            }
	            lista.add(csvContent.toString());   
	            }
	            for(String vencedor: lista) {
	            	if(cont < 5) {
	            		listaTop5.add(vencedor);
	            		cont ++;	
	            	}
	            }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return listaTop5;
	}
	
	@RequestMapping("/top10")
	public ArrayList<String> lerVencedoresTop10() throws IOException {
	    ArrayList <String> lista= new ArrayList<>();
	    ArrayList<String> listaTop5 = new ArrayList<>();
	    int cont = 0;
	    try (BufferedReader br = new BufferedReader(new FileReader("/home/mikaelle/eclipse-workspace/pratica12/vencedores.csv"))) {
	        String line = br.readLine(); 
	        while ((line = br.readLine()) != null) {
	            String[] fields = line.split(","); 
	            StringBuilder csvContent = new StringBuilder();
	            for (String field : fields) {
	                csvContent.append(field).append(", ");
	            }
	            lista.add(csvContent.toString());   
	            }	            
	            for(String vencedor: lista) {
	            	if(cont < 10) {
	            		listaTop5.add(vencedor);
	            		cont ++;	
	            	}
	            }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return listaTop5;
	}

	@RequestMapping("/porpais")
    public Map<String, Integer> vitoriasPorPais() throws IOException {
        Map<String, Integer> vitoriasPorPais = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/mikaelle/eclipse-workspace/pratica12/vencedores.csv"))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(","); 
                if (fields.length >= 3) {
                    String pais = fields[2].trim();
                    if (!fields[1].trim().isEmpty()) {
                        int vitorias = Integer.parseInt(fields[1].trim());
                        vitoriasPorPais.put(pais, vitoriasPorPais.getOrDefault(pais, 0) + vitorias);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(vitoriasPorPais.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        Map<String, Integer> resultadoOrdenado = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            resultadoOrdenado.put(entry.getKey(), entry.getValue());
        }

        return resultadoOrdenado;
    }

    @RequestMapping("/mediaporpais")
    public Map<String, Double> mediaPorPais() throws IOException {
        Map<String, Integer> totalVitoriasPorPais = new HashMap<>();
        Map<String, Integer> totalVencedoresPorPais = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/mikaelle/eclipse-workspace/pratica12/vencedores.csv"))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(","); 
                if (fields.length >= 3) {
                    String pais = fields[2].trim();
                    if (!fields[1].trim().isEmpty()) {
                        int vitorias = Integer.parseInt(fields[1].trim());
                        totalVitoriasPorPais.put(pais, totalVitoriasPorPais.getOrDefault(pais, 0) + vitorias);
                    }
                    totalVencedoresPorPais.put(pais, totalVencedoresPorPais.getOrDefault(pais, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Double> mediaPorPais = new HashMap<>();
        for (String pais : totalVitoriasPorPais.keySet()) {
            int totalVitorias = totalVitoriasPorPais.get(pais);
            int totalVencedores = totalVencedoresPorPais.getOrDefault(pais, 0);
            double media = totalVencedores > 0 ? (double) totalVitorias / totalVencedores : 0.0;
            mediaPorPais.put(pais, media);
        }
        List<Map.Entry<String, Double>> sortedList = mediaPorPais.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());

        Map<String, Double> resultadoOrdenado = new HashMap<>();
        for (Map.Entry<String, Double> entry : sortedList) {
            resultadoOrdenado.put(entry.getKey(), entry.getValue());
        }

        return resultadoOrdenado;
    }


}
