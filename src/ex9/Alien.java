package ex9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alien implements AlienInterface {
    private int id;
    private String nome;
    private Especie especie;
    private String planeta;
    private LocalDate dataEntrada;
    private List<Alien> alienList = new ArrayList<>();
    private int nivelPericulosidade;
    private boolean emQuarentena;

    public Alien() {}

    public List<Alien> getAlienList() {
        return alienList;
    }

    public Alien(String nome, Especie especie, LocalDate dataEntrada) {
        this.id = (int) (Math.random() * 1000000);
        this.nome = nome;
        this.especie = especie;
        this.planeta = especie.getNomePlaneta();
        this.dataEntrada = dataEntrada;
        this.nivelPericulosidade = especie.getNivelPericulosidade();
        this.emQuarentena = especie.getNivelPericulosidade() > 40;
    }

    @Override
    public void RegistrarAlien(String nome, Especie especie, LocalDate dataEntrada) {
        Alien alien = new Alien(nome, especie, dataEntrada);
        alienList.add(alien);
    }

    public void EmQuarentena() {
        LocalDate dataAtual = LocalDate.now().minusDays(40);
        for (Alien alien : alienList) {
            if (!dataEntrada.isBefore(dataAtual)){
                alien.emQuarentena = alien.especie.getNivelPericulosidade() > 40;
            }
        }
    }

    public void listaQuarentena() {
        List<Alien> listaAlienQuarentena = new ArrayList<>();
        for (Alien alien : alienList) {
            if (alien.emQuarentena) {
                listaAlienQuarentena.add(alien);
            }
        }
        listaAliensVariadas(listaAlienQuarentena);
    }

    public void pesquisarAliensPorEspecie(String especie) {
        List<Alien> listaPorEspecies = new ArrayList<>();
        for (Alien alien : alienList) {
            if (alien.especie.getEspecie().equalsIgnoreCase(especie)) {
                listaPorEspecies.add(alien);
            }
        }
        listaAliensVariadas(listaPorEspecies);
    }

    public void pesquisarAliensPorData(LocalDate dataEntrada) {
        List<Alien> listaPorData = new ArrayList<>();
        for (Alien alien : alienList) {
            if (alien.dataEntrada.isEqual(dataEntrada)) {
                listaPorData.add(alien);
            }
        }
        listaAliensVariadas(listaPorData);
    }

    public void listarUltimosSeisMeses(){
        List<Alien> listaPorData = new ArrayList<>();
        LocalDate seisMesesAtras = LocalDate.now().minusMonths(6);
        for (Alien alien : alienList) {
            if (alien.dataEntrada.isAfter(seisMesesAtras) || alien.dataEntrada.isEqual(seisMesesAtras)) {
                listaPorData.add(alien);
            }
        }
        listaAliensVariadas(listaPorData);
    }

    public void rankingPericulosidade() {
        int n = alienList.size();
        List<Alien> listaPericulosidade = new ArrayList<>(alienList);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listaPericulosidade.get(j).nivelPericulosidade < listaPericulosidade.get(j + 1).nivelPericulosidade) {
                    Alien temp = listaPericulosidade.get(j);
                    listaPericulosidade.set(j, listaPericulosidade.get(j + 1));
                    listaPericulosidade.set(j + 1, temp);
                }
            }
        }
        listaAliensVariadas(listaPericulosidade);
    }

    @Override
    public void RelatorioEntradaAlien() {
        listaAliensVariadas(alienList);
    }

    @Override
    public void listaAliensVariadas(List<Alien> alienList) {
        for (Alien alien : alienList) {
            System.out.println("ID: " + alien.id);
            System.out.println("Nome: " + alien.nome);
            System.out.println("Espécie: " + alien.especie.getEspecie());
            System.out.println("Nome Planeta: " + alien.planeta);
            System.out.println("Nível Periculosidade: " + alien.nivelPericulosidade);
            System.out.println("Está em quarentena: " + alien.emQuarentena);
            System.out.println("Data de Entrada: " + alien.dataEntrada);
            System.out.println("------");
        }
    }
}
