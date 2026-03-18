package com.senai.pabline.f1.persistencia;

import com.senai.pabline.f1.entity.Piloto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Persistencia {
    private String nomeArquivo;

    public Persistencia(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public <Piloto> listagemDePilotosHashSet() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            HashSet<Piloto> conjuntoDePilotos = new HashSet<>();
            String linhaDoArquivo;
            while ((linhaDoArquivo = bufferedReader.readLine()) != null) {
                Piloto piloto = new Piloto(linhaDoArquivo);
                conjuntoDePilotos.add(piloto);
            }
            
            return conjuntoDePilotos.iterator();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterator<Piloto> listagemDePilotosTreeSet() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            TreeSet<Piloto> conjuntoDePilotos = new TreeSet<>();
            String linhaDoArquivo;
            while ((linhaDoArquivo = bufferedReader.readLine()) != null) {
                Piloto piloto = new Piloto(linhaDoArquivo);
                conjuntoDePilotos.add(piloto);
            }
            
            return conjuntoDePilotos.iterator();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterator<Piloto> listagemDePilotosArrayDeque() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            ArrayDeque<Piloto> conjuntoDePilotos = new ArrayDeque<>();
            String linhaDoArquivo;
            while ((linhaDoArquivo = bufferedReader.readLine()) != null) {
                Piloto piloto = new Piloto(linhaDoArquivo);
                conjuntoDePilotos.add(piloto);
            }
            
            return conjuntoDePilotos.iterator();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterator<Piloto> listagemDePilotosHashMap() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            HashMap<Integer, Piloto> conjuntoDePilotos = new HashMap<>();

            String linhaDoArquivo;
            int i =1;
            while ((linhaDoArquivo = bufferedReader.readLine()) != null) {
                Piloto piloto = new Piloto(linhaDoArquivo);

               conjuntoDePilotos.put(i,piloto);
               ++i;
            }
            
            return conjuntoDePilotos.values().iterator();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Iterator<Piloto> listagemDePilotosStack() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            Stack<Piloto> conjuntoDePilotos = new Stack<>();
            String linhaDoArquivo;
            while ((linhaDoArquivo = bufferedReader.readLine()) != null) {
                Piloto piloto = new Piloto(linhaDoArquivo);
                conjuntoDePilotos.push(piloto);
            }
            
            return conjuntoDePilotos.iterator();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
