package com.kannon.aaron.magiastrpg.controller.JSONReader;

import com.kannon.aaron.magiastrpg.controller.MagiaController;
import com.kannon.aaron.magiastrpg.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formatter {

    public List<Magia> JSONFormatter() throws FileNotFoundException {

        JsonFileReader jr = new JsonFileReader();

        Scanner sc = jr.fileToScanner();

        List<Magia> allMagias = new ArrayList<>();

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

        while (sc.hasNextLine()) {

            temp = sc.nextLine();
            teste = temp.split("\"");

            // Check Nome
            if (temp.contains("Nome")) {
                nome = teste[3];
                //System.out.println(nome);
            }

            // Check Nivel
            if (temp.contains("\"Nível\": ")) {
                nivel = teste[3];

                // Check Escola
                int inicioEscola = nivel.indexOf("(")+1;
                int finalEscola = nivel.indexOf(")");
                escola = nivel.substring(inicioEscola,finalEscola);

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
                }else{
                    String[] partes = tipoMagia[0].split(" ");
                    //System.out.println(partes[0]);
                    if (partes[0].equals("arcana")){
                        arcano = true;
                        nivelArcano = Integer.parseInt(partes[1]);
                    } else {
                        divino = true;
                        nivelDivino = Integer.parseInt(partes[1]);
                    }
                }
            }

            // Check Execucao
            if (temp.contains("\"Tempo de Execução\": ")) {
                execucao = teste[3];
            }

            // Check Alcance
            if (temp.contains("\"Alcance\": ")) {
                alcance = teste[3];
            }

            // Check AlvoAreaEfeito
            if (temp.contains("\"Alvo\": ") || temp.contains("\"Efeito\": ") || temp.contains("\"Área\": ")
                    || (temp.contains("\"Alvos\": ")) || (temp.contains("\"Alvo ou Área\": ")) || (temp.contains("\"Alvo ou Área ou Efeito\": "))
                    || (temp.contains("\"Alvo ou Efeito\": ")) || (temp.contains("\"Alvo ou Alvos\": "))) {
                tipoAlvoAreaEfeito = teste[1];
                alvoAreaEfeito = teste[3];
            }

            // Check Duracao
            if (temp.contains("\"Duração\": ")) {
                duracao = teste[3];
            }

            // Check Resistencia
            if (temp.contains("\"Teste de Resistência\": ")) {
                resistencia = teste[3];
            }

            // Check Fonte
            if (temp.contains("\"Fonte\": ")) {
                fonte = teste[3];
            }

            // Check Descricao
            if (temp.contains("\"Descrição\": ")) {
                descricao = teste[3];
            }

            if (temp.contains("}")) {
                Magia send = new Magia();
                send.setNome(nome);

                if (!(nivel == null)){
                    Escola sendEscola = new Escola();
                    sendEscola.setTipoEscola(escola);

                    Nivel sendNivel = new Nivel();
                    sendNivel.setArcano(arcano);
                    sendNivel.setDivino(divino);
                    sendNivel.setEscola(sendEscola);
                    sendNivel.setNivelArcano(nivelArcano);
                    sendNivel.setNivelDivino(nivelDivino);
                    send.setNivel(sendNivel);
                }
                if (!(execucao == null)){
                    Execucao sendExecucao = new Execucao();
                    sendExecucao.setTipoExecucao(execucao);
                    send.setExecucao(sendExecucao);
                }
                if (!(alcance == null)){
                    Alcance sendAlcance = new Alcance();
                    sendAlcance.setTipoAlcance(alcance);
                    send.setAlcance(sendAlcance);
                }
                if (!(tipoAlvoAreaEfeito == null)){
                    AlvoAreaEfeito sendAlvoAreaEfeito = new AlvoAreaEfeito();
                    sendAlvoAreaEfeito.setTipoAlvoAreaEfeito(tipoAlvoAreaEfeito);
                    sendAlvoAreaEfeito.setDescricao(alvoAreaEfeito);
                    send.setAlvoAreaEfeito(sendAlvoAreaEfeito);
                }
                if (!(duracao == null)) {
                    Duracao sendDuracao = new Duracao();
                    sendDuracao.setTipoDuracao(duracao);
                    send.setDuracao(sendDuracao);
                }
                if (!(resistencia == null)){
                    Resistencia sendResistencia = new Resistencia();
                    sendResistencia.setTipoResistencia(resistencia);
                    send.setResistencia(sendResistencia);
                }
                if (!(fonte == null)){
                    send.setFonte(fonte);
                }
                if (!(fonte == null)){
                    send.setDescricao(descricao);
                }

                //System.out.println(send.toString());
                allMagias.add(send);

                //System.out.println(allMagias.toString());

                nome = null;
                nivel = null;
                escola = null;
                arcano = false;
                divino = false;
                nivelArcano = -1;
                nivelDivino = -1;
                execucao = null;
                alcance = null;
                tipoAlvoAreaEfeito = null;
                alvoAreaEfeito = null;
                duracao = null;
                resistencia = null;
                fonte = null;
                descricao = null;
            }

            /*if (temp.contains("{")) {
                send.setNome(null);
                send.setNivel(null);
                send.setExecucao(null);
                send.setAlcance(null);
                send.setAlvoAreaEfeito(null);
                send.setDuracao(null);
                send.setResistencia(null);
                send.setFonte(null);
                send.setDescricao(null);
            }*/
        }
        sc.close();
        allMagias.remove(allMagias.size()-1);
        //System.out.println(allMagias.toString());
        return allMagias;
    }
}
