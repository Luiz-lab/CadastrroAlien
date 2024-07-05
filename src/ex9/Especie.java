package ex9;

import java.util.ArrayList;
import java.util.List;

public class Especie {
    private String nomePlaneta;
    private String especie;
    private int nivelPericulosidade = 0;
    private static List<Especie> especiesList = new ArrayList<>();

    public Especie(String especie, String nomePlaneta, int nivelPericulosidade) {
        this.nomePlaneta = nomePlaneta;
        this.especie = especie;
        this.nivelPericulosidade = nivelPericulosidade;
        especiesList.add(this);
    }

    public Especie() {
    }

    public String getNomePlaneta() {
        return nomePlaneta;
    }

    public void setNomePlaneta(String nomePlaneta) {
        this.nomePlaneta = nomePlaneta;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getNivelPericulosidade() {
        return nivelPericulosidade;
    }

    public void setNivelPericulosidade(int nivelPericulosidade) {
        this.nivelPericulosidade = nivelPericulosidade;
    }

    public static void imprimirListaEspecieAll() {
        for (Especie especie : especiesList) {
            System.out.println("Espécie: " + especie.getEspecie());
            System.out.println("Planeta de Origem: " + especie.getNomePlaneta());
            System.out.println("Nível de Periculosidade: " + especie.getNivelPericulosidade());
            System.out.println("------");
        }
    }
    public static void imprimirListaPlanetas(){
        for (Especie especies: especiesList){
            System.out.println("Planeta: " + especies.getNomePlaneta());
            System.out.println("------");
        }
    }
    public static void imprimirListaEspecies(){
        for (Especie especies: especiesList){
            System.out.println("Especies: " + especies.getEspecie());
            System.out.println("------");
        }
    }

    @Override
    public String toString() {
        return "Especie{" +
                "nomePlaneta='" + nomePlaneta + '\'' +
                ", especie='" + especie + '\'' +
                ", nivelPericulosidade=" + nivelPericulosidade +
                '}';
    }
}
