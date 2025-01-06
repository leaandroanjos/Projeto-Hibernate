package dao;

import br.com.leandro.domain.Acessorio;
import dao.generic.GenericDao;

public class AcessorioDao extends GenericDao<Acessorio> implements IAcessorioDao {
    @Override
    protected Class<Acessorio> buscarClasse() {
        return Acessorio.class;
    }
}
