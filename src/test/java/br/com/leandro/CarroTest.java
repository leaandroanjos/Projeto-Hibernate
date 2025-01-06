package br.com.leandro;

import br.com.leandro.domain.Acessorio;
import br.com.leandro.domain.Carro;
import br.com.leandro.domain.Montadora;
import dao.*;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

public class CarroTest {

    private IMontadoraDao montadoraDao;
    private ICarroDao carroDao;
    private IAcessorioDao acessorioDao;

    public CarroTest(){
        montadoraDao = new MontadoraDao();
        carroDao = new CarroDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar(){
        Montadora montadora = new Montadora();
        montadora.setName("Hyundai");
        montadora.setCodigo("456");
        montadoraDao.cadastrar(montadora);

        Carro carro = new Carro();
        carro.setNome("Hb20");
        carro.setCodigo("135");
        carro.setMontadora(montadora);
        carro.adicionarAcessorio(acessorioFactory("Apoio de braço", "A1"));
        carro.adicionarAcessorio(acessorioFactory("Pedaleiras", "B3"));
        carroDao.cadastrar(carro);

        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());
        System.out.println("ID: "+carro.getId());
    }

    public Acessorio acessorioFactory(String nome, String codigo){
        Acessorio acessorio = new Acessorio();
        acessorio.setNome(nome);
        acessorio.setCodigo(codigo);
        return acessorio;
    }

}
