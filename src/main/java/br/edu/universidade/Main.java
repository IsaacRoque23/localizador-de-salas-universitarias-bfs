package br.edu.universidade;

import br.edu.universidade.model.Grafo;
import br.edu.universidade.model.Local;
import br.edu.universidade.model.MapaUniversidade;
import br.edu.universidade.service.BuscaBFS;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Grafo universidade = MapaUniversidade.criarMapa();

        BuscaBFS busca = new BuscaBFS(universidade);

        int opcao;

        do {

            System.out.println("\n====================================");
            System.out.println("    SISTEMA DE ROTAS UNIVERSITARIAS");
            System.out.println("====================================");
            System.out.println("1 - Buscar caminho");
            System.out.println("2 - Listar locais");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- LOCAIS DISPONIVEIS ---");

                    Local[] locais = Local.values();

                    for (int i = 0; i < locais.length; i++) {
                        System.out.println(i + " - " + locais[i].getNome());
                    }

                    System.out.print("\nDigite o numero da origem: ");
                    int indiceOrigem = scanner.nextInt();

                    System.out.print("Digite o numero do destino: ");
                    int indiceDestino = scanner.nextInt();


                    if (indiceOrigem < 0 || indiceOrigem >= locais.length
                            || indiceDestino < 0 || indiceDestino >= locais.length) {

                        System.out.println("\nLocal invalido!");
                        break;
                    }

                    Local origem = locais[indiceOrigem];
                    Local destino = locais[indiceDestino];


                    Optional<List<Local>> resultado =
                            busca.buscarCaminho(origem, destino);

                    if (resultado.isPresent()) {

                        List<Local> caminho = resultado.get();

                        System.out.println("\n====================================");
                        System.out.println("         CAMINHO ENCONTRADO");
                        System.out.println("====================================");

                        System.out.println(caminho.stream()
                                .map(Local::getNome)
                                .collect(Collectors.joining(" -> ")));

                        System.out.println("\n- Origem: " + origem.getNome());
                        System.out.println("- Destino: " + destino.getNome());
                        System.out.println("- Total: " + (caminho.size() - 1)
                                + " conexoes.");

                    } else {

                        System.out.println("\nNenhum caminho encontrado entre "
                                + origem.getNome() + " e " + destino.getNome() + ".");
                    }

                    break;

                case 2:

                    System.out.println("\n--- LOCAIS DA UNIVERSIDADE ---");

                    for (Local local : Local.values()) {
                        System.out.println("- " + local.getNome());
                    }

                    break;

                case 0:

                    System.out.println("\nEncerrando sistema...");

                    break;

                default:

                    System.out.println("\nOpcao invalida!");

                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}