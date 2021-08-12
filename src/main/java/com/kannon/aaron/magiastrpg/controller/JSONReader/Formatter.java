package com.kannon.aaron.magiastrpg.controller.JSONReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formatter {

    public void JSONFormatter() throws FileNotFoundException {

        //List<String> JSONList = new ArrayList<>();

        JsonFileReader jr = new JsonFileReader();

        Scanner sc = jr.fileToScanner();

        String temp;
        String[] teste;
        String nome = null;
        String nivel = null;
        String escola = null;
        boolean arcano = false;
        boolean divino = false;
        int nivelArcano = -1;
        int nivelDivino = -1;
        String execucao = null;
        String alcance = null;
        String tipoAlvoAreaEfeito = null;
        String alvoAreaEfeito = null;
        String duracao = null;
        String resistencia = null;
        String fonte = null;
        String descricao = null;
        int countPrint = 0;
        while (sc.hasNextLine()) {

            temp = sc.nextLine();
            teste = temp.split("\"");
            // Check Nome
            if (temp.contains("Nome")) {
                nome = teste[3];
                //System.out.println("Nome: " + nome);
                countPrint++;
            }

            // Check Nivel
            if (temp.contains("\"Nível\": ")) {
                nivel = teste[3];

                //Check Arcano Divino e Valores
                String[] tipoMagia = nivel.split(" \\(");
                if (tipoMagia[0].contains(", ")) {
                    String[] tipoSeparado = tipoMagia[0].split(", ");

                    String[] arcanoPartes = tipoSeparado[0].split(" ");
                    String[] divinoPartes = tipoSeparado[1].split(" ");

                    arcano = true;
                    divino = true;

                    nivelArcano = Integer.parseInt(arcanoPartes[1]);
                    nivelDivino = Integer.parseInt(divinoPartes[1]);

                    //System.out.println("Arcano: "+ arcano +" "+ nivelArcano);
                    //System.out.println("Divino: "+ divino +" "+ nivelDivino);
                }else{
                    String[] partes = tipoMagia[0].split(" ");
                    if (partes[0].equals("arcano")){
                        arcano = true;
                        nivelArcano = Integer.parseInt(partes[1]);
                        //System.out.println("Arcano: "+ arcano +" "+ nivelArcano);
                    } else {
                        divino = true;
                        nivelDivino = Integer.parseInt(partes[1]);
                        //System.out.println("Divino: "+ divino +" "+ nivelDivino);
                    }
                    //System.out.println(tipoMagia[0]);
                }

                // Check Escola
                int inicioEscola = nivel.indexOf("(")+1;
                int finalEscola = nivel.indexOf(")");
                escola = nivel.substring(inicioEscola,finalEscola);

                countPrint++;

                //System.out.println("Nivel: " + nivel);
                //System.out.println("Escola: " + escola);
            }

            // Check Execucao
            if (temp.contains("\"Tempo de Execução\": ")) {
                execucao = teste[3];
                countPrint++;
                //System.out.println("Execucao: "+ execucao);
            }

            // Check Alcance
            if (temp.contains("\"Alcance\": ")) {
                alcance = teste[3];
                countPrint++;
                //System.out.println("Alcance: "+ alcance);
            }

            // Check AlvoAreaEfeito
            if (temp.contains("\"Alvo\": ") || temp.contains("\"Efeito\": ") || temp.contains("\"Área\": ")
                    || (temp.contains("\"Alvos\": ")) || (temp.contains("\"Alvo ou Área\": ")) || (temp.contains("\"Alvo ou Área ou Efeito\": "))
                    || (temp.contains("\"Alvo ou Efeito\": ")) || (temp.contains("\"Alvo ou Alvos\": "))) {
                tipoAlvoAreaEfeito = teste[1];
                alvoAreaEfeito = teste[3];

                countPrint++;
                //System.out.println("TipoAlvoAreaEfeito: "+ tipoAlvoAreaEfeito);
                //System.out.println("AlvoAreaEfeito: "+ alvoAreaEfeito);
            }

            // Check Duracao
            if (temp.contains("\"Duração\": ")) {
                duracao = teste[3];
                countPrint++;
                //System.out.println("Duracao: "+ duracao);
            }

            // Check Resistencia
            if (temp.contains("\"Teste de Resistência\": ")) {
                resistencia = teste[3];
                countPrint++;
                //System.out.println("Resistencia: "+ resistencia);
            }

            // Check Fonte
            if (temp.contains("\"Fonte\": ")) {
                fonte = teste[3];
                countPrint++;
                //System.out.println("Fonte: "+ fonte);
            }

            // Check Descricao
            if (temp.contains("\"Descrição\": ")) {
                descricao = teste[3];
                countPrint++;
                //System.out.println("Descricao: "+ descricao);
                //System.out.println("--------");
            }

            //System.out.println(countPrint);

            if (countPrint==9){
                String json = "{ \"nome\": \""+nome+"\", \"nivel\": { \"arcano\": "+arcano+", \"divino\": "+divino+", \"escola\": { \"tipoEscola\": \""+escola+"\" }, \"nivelArcano\": "+nivelArcano+", \"nivelDivino\": "+nivelDivino+", }, \"execucao\": { \"tipoExecucao\": \""+execucao+"\" }, \"alcance\": { \"tipoAlcance\": \""+alcance+"\" }, \"alvoAreaEfeito\": { \"tipoAlvoAreaEfeito\": \""+tipoAlvoAreaEfeito+"\", \"descricao\": \""+alvoAreaEfeito+"\" }, \"duracao\": { \"tipoDuracao\": \""+duracao+"\" }, \"resistencia\": { \"tipoResistencia\": \""+resistencia+"\" }, \"fonte\": \""+fonte+"\", \"descricao\": \""+descricao+"\" }";
                System.out.println(json);
                System.out.println("---------");
                //JSONList.add(json);
                countPrint = 0;
            }
            //System.out.println(temp);      //returns the line that was skipped
            //System.out.println("--------");

        //System.out.println(JSONList.toString());

        }
    }
}
