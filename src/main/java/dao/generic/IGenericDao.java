package dao.generic;

import java.util.List;

public interface IGenericDao<T> {

    public T cadastrar(T entity);

    public void excluir(T entity);

    public List<T> buscarTodos();
}
