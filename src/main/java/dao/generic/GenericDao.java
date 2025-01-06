package dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class GenericDao<T> implements IGenericDao<T> {

    protected abstract Class<T> buscarClasse();

    @Override
    public T cadastrar(T entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        emf.close();
        em.close();
        return entity;
    }

    @Override
    public void excluir(T entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        entity = em.merge(entity);
        em.remove(entity);
        em.getTransaction().commit();

        emf.close();
        em.close();
    }

    @Override
    public List<T> buscarTodos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        Class<T> clazz = buscarClasse();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT x FROM "+clazz.getName()+" x ");

        TypedQuery<T> query = em.createQuery(sb.toString(), clazz);
        List<T> list = query.getResultList();

        emf.close();
        em.close();
        return list;
    }
}
