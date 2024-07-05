package ex9;

import java.time.LocalDate;
import java.util.List;

public interface AlienInterface {
    public void RegistrarAlien(String nome, Especie especie, LocalDate dataEntrada);
    public void RelatorioEntradaAlien();
    public  void listaAliensVariadas(List<Alien> alienList);
}
