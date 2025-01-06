package dao;

import br.com.leandro.domain.Carro;
import dao.generic.GenericDao;

public class CarroDao extends GenericDao<Carro> implements ICarroDao {
    @Override
    protected Class<Carro> buscarClasse() {
        return Carro.class;
    }
}
