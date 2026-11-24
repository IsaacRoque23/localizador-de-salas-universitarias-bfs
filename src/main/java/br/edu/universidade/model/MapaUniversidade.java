package br.edu.universidade.model;

public class MapaUniversidade {

    public static Grafo criarMapa() {

        Grafo universidade = new Grafo();

        universidade.adicionarConexao(Local.BIBLIOTECA, Local.SECRETARIA);
        universidade.adicionarConexao(Local.BIBLIOTECA, Local.LABORATORIO);
        universidade.adicionarConexao(Local.BIBLIOTECA, Local.CANTINA);


        universidade.adicionarConexao(Local.SECRETARIA, Local.CANTINA);
        universidade.adicionarConexao(Local.SECRETARIA, Local.SALA_DE_AULA);


        universidade.adicionarConexao(Local.LABORATORIO, Local.LAB_QUIMICA);
        universidade.adicionarConexao(Local.LABORATORIO, Local.LAB_INFORMATICA);
        universidade.adicionarConexao(Local.LABORATORIO, Local.SALA_DE_AULA);


        universidade.adicionarConexao(Local.LAB_QUIMICA, Local.BANHEIRO);
        universidade.adicionarConexao(Local.LAB_QUIMICA, Local.AUDITORIO);


        universidade.adicionarConexao(Local.LAB_INFORMATICA, Local.SALA_DE_AULA);
        universidade.adicionarConexao(Local.LAB_INFORMATICA, Local.AUDITORIO);


        universidade.adicionarConexao(Local.CANTINA, Local.AUDITORIO);
        universidade.adicionarConexao(Local.CANTINA, Local.BANHEIRO);
        universidade.adicionarConexao(Local.CANTINA, Local.SALA_DE_AULA);


        universidade.adicionarConexao(Local.AUDITORIO, Local.SALA_DE_AULA);
        universidade.adicionarConexao(Local.AUDITORIO, Local.BANHEIRO);


        universidade.adicionarConexao(Local.SALA_DE_AULA, Local.BANHEIRO);

        return universidade;
    }
}