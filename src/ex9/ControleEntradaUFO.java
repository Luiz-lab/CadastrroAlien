package ex9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleEntradaUFO {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean continuaPrograma = true;
        List<Especie> especieList = new ArrayList<>();
        Alien alienManager = new Alien();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (continuaPrograma){
            System.out.println("Bem vindo ao cadastro de Aliens da Terra \nQual opção deseja acessar?");
            System.out.println("1 - Cadastrar Especie \n2 - Cadastrar Alien \n3 - Relatorio de Entradas \n4 - Ranking de Periculosidade \n5 - Lista de Planetas \n6 - Lista de Especies \n7 - Lista de Aliens em Quarentena \n8 - Pesquisar Aliens por Especie \n9 - Listar Aliens chegados até 6 meses  \n10 - Sair do Programa");
            int opcao = keyboard.nextInt();
            keyboard.nextLine();

            switch (opcao){
                case 1:
                    try {
                        System.out.println("Digite o nome da Especie: ");
                        String nome = keyboard.nextLine();
                        System.out.println("Digite o planeta da Especie: ");
                        String especieAlien = keyboard.nextLine();
                        System.out.println("Digite o nivel de periculosidade: ");
                        int nivelPericulosidade  = keyboard.nextInt();
                        keyboard.nextLine();
                        Especie especie = new Especie(nome, especieAlien, nivelPericulosidade);
                        especieList.add(especie);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Entrada inválida. Tente novamente.");
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Digite o nome do Alien: ");
                        String nomeAlien = keyboard.nextLine();
                        System.out.println("Escolha a espécie do Alien pelo índice: ");
                        for (int i = 0; i < especieList.size(); i++) {
                            System.out.println(i + " - " + especieList.get(i).getEspecie());
                        }
                        int indiceEspecie = keyboard.nextInt();
                        keyboard.nextLine();
                        if (indiceEspecie < 0 || indiceEspecie >= especieList.size()) {
                            throw new IllegalArgumentException("Índice de espécie inválido.");
                        }
                        Especie especie = especieList.get(indiceEspecie);
                        System.out.println("Digite a data de chegada ao planeta (dd-MM-yyyy): ");
                        String dataInformada  = keyboard.nextLine();
                        LocalDate dataEntrada;
                        try {
                            dataEntrada = LocalDate.parse(dataInformada, dateTimeFormatter);
                        } catch (Exception e) {
                            System.out.println("Data inválida. Usando data atual.");
                            dataEntrada = LocalDate.now();
                        }
                        alienManager.RegistrarAlien(nomeAlien, especie, dataEntrada);

                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar alien. Tente novamente.");
                    }
                    break;

                case 3:
                    try {
                        if (!alienManager.getAlienList().isEmpty()) {
                            alienManager.RelatorioEntradaAlien();
                        } else {
                            System.out.println("Nenhum alien cadastrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao gerar relatório. Tente novamente.");
                    }
                    break;

                case 4:
                    alienManager.rankingPericulosidade();
                    break;

                case 5:
                    Especie.imprimirListaPlanetas();
                    break;

                case 6:
                    Especie.imprimirListaEspecies();
                    break;

                case 7:
                    alienManager.listaQuarentena();
                    break;

                case 8:
                    System.out.println("Digite o nome da espécie do Alien : ");
                    for (int i = 0; i < especieList.size(); i++) {
                        System.out.println(i + " - " + especieList.get(i).getEspecie());
                    }
                    String  nomeEspecie = keyboard.nextLine();
                    alienManager.pesquisarAliensPorEspecie(nomeEspecie);
                    break;

                case 9:
                    alienManager.listarUltimosSeisMeses();
                    break;

                case 10:
                    continuaPrograma = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        keyboard.close();
    }
}
