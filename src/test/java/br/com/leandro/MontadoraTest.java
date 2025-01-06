package br.com.leandro;

import br.com.leandro.domain.Montadora;
import dao.IMontadoraDao;
import dao.MontadoraDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MontadoraTest {

    private IMontadoraDao montadoraDao;

    public MontadoraTest(){
        montadoraDao = new MontadoraDao();
    }

    @After
    public void end(){
        List<Montadora> lista = montadoraDao.buscarTodos();
        lista.forEach(montadora -> montadoraDao.excluir(montadora));
    }

    @Test
    public void cadastrar(){
        Montadora montadora = new Montadora();
        montadora.setName("Hyundai");
        montadora.setCodigo("A1");

        montadoraDao.cadastrar(montadora);

        Assert.assertNotNull(montadora);
        Assert.assertNotNull(montadora.getId());
    }

}
