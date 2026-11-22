package br.edu.universidade.service;

import br.edu.universidade.model.Grafo;
import br.edu.universidade.model.Local;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BuscaBFS {

    private final Grafo grafo;

    public BuscaBFS(Grafo grafo) {
        this.grafo = grafo;
    }

    public Optional<List<Local>> buscarCaminho(Local origem, Local destino) {
        Queue<Local> fila = new ArrayDeque<>();
        Set<Local> visitados = new HashSet<>();
        Map<Local, Local> anterior = new HashMap<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            Local atual = fila.poll();

            if (atual == destino) {
                return Optional.of(reconstruir(anterior, origem, destino));
            }

            for (Local vizinho : grafo.getVizinhos(atual)) {
                if (visitados.add(vizinho)) {
                    anterior.put(vizinho, atual);
                    fila.add(vizinho);
                }
            }
        }
        return Optional.empty();
    }

    private List<Local> reconstruir(Map<Local, Local> anterior, Local origem, Local destino) {
        LinkedList<Local> caminho = new LinkedList<>();
        for (Local l = destino; l != null; l = anterior.get(l)) {
            caminho.addFirst(l);
            if (l == origem) break;
        }
        return caminho;
    }
}