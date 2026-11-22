package br.edu.universidade.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private final Map<Local, List<Local>> adjacencias = new EnumMap<>(Local.class);

    public Grafo() {
        for (Local local : Local.values()) {
            adjacencias.put(local, new ArrayList<>());
        }
    }

    /** Cria uma conexão nos dois sentidos entre dois locais. */
    public void adicionarConexao(Local a, Local b) {
        if (!adjacencias.get(a).contains(b)) {
            adjacencias.get(a).add(b);
            adjacencias.get(b).add(a);
        }
    }

    public List<Local> getVizinhos(Local local) {
        return Collections.unmodifiableList(adjacencias.get(local));
    }
}