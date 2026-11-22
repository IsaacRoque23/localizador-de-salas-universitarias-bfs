package br.edu.universidade;

import br.edu.universidade.model.Grafo;
import br.edu.universidade.model.Local;
import br.edu.universidade.service.BuscaBFS;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Grafo universidade = new Grafo();
        universidade.adicionarConexao(Local.BIBLIOTECA, Local.SECRETARIA);
        universidade.adicionarConexao(Local.BIBLIOTECA, Local.LABORATORIO);
        universidade.adicionarConexao(Local.SECRETARIA, Local.CANTINA);
        universidade.adicionarConexao(Local.LABORATORIO, Local.SALA_DE_AULA);
        universidade.adicionarConexao(Local.CANTINA, Local.AUDITORIO);
        universidade.adicionarConexao(Local.SALA_DE_AULA, Local.AUDITORIO);

        BuscaBFS busca = new BuscaBFS(universidade);

        Local origem = Local.BIBLIOTECA;
        Local destino = Local.AUDITORIO;

        Optional<List<Local>> resultado = busca.buscarCaminho(origem, destino);

        if (resultado.isPresent()) {
            List<Local> caminho = resultado.get();

            System.out.println("Caminho encontrado");
            System.out.println(caminho.stream()
                    .map(Local::getNome)
                    .collect(Collectors.joining(" → ")));
            System.out.println();
            System.out.println("- Origem: " + origem + ".");
            System.out.println("- Destino: " + destino + ".");
            System.out.println("- Total: " + (caminho.size() - 1) + " conexões.");
        } else {
            System.out.println("Nenhum caminho encontrado entre " + origem + " e " + destino + ".");
        }
    }
}