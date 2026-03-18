package com.senai.pabline.f1.service;

import com.senai.pabline.f1.entity.Piloto;
import com.senai.pabline.f1.persistencia.Persistencia;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PilotoService {

    public Set<Piloto> listarPilotos(String tipoDeEstrutura) throws Exception {
       Persistencia pilotoPersistencia = new Persistencia("src/main/resources/dados/DadosDosPilotosF1.csv");

        Iterator<Piloto> iteratorDePilotos;

        switch (tipoDeEstrutura.toLowerCase()) {
            case "hashset":
                iteratorDePilotos = pilotoPersistencia.listagemDePilotosHashSet();
                break;
            case "treeset":
                iteratorDePilotos = pilotoPersistencia.listagemDePilotosTreeSet();
                break;
            case "arraydeque":
                iteratorDePilotos = pilotoPersistencia.listagemDePilotosArrayDeque();
                break;
            case "hashmap":
                iteratorDePilotos = pilotoPersistencia.listagemDePilotosHashMap();
                break;
            case "stack":
                iteratorDePilotos = pilotoPersistencia.listagemDePilotosStack();
                break;
            default:
                iteratorDePilotos = pilotoPersistencia.listagemDePilotosHashSet();
                break;
        }

        Set<Piloto> pilotosParaExibicao = new LinkedHashSet<>();

        while (iteratorDePilotos.hasNext()) {
            Piloto pilotoAtual = iteratorDePilotos.next();
            pilotosParaExibicao.add(pilotoAtual);
        }

        return pilotosParaExibicao;
    }
}