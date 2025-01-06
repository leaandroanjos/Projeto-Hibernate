package dao;

import br.com.leandro.domain.Montadora;
import dao.generic.GenericDao;

public class MontadoraDao extends GenericDao<Montadora> implements IMontadoraDao{
    @Override
    protected Class<Montadora> buscarClasse() {
        return Montadora.class;
    }
}
