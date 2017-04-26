package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.IntegranteDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Integrante;

@Stateless
public class IntegranteDAOImpl implements IntegranteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Integrante integrante) throws DAOException {

		try {
			this.em.persist(integrante);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Integrante> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from Integrante i";
			final Query query = this.em.createQuery(jpql, Integrante.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Integrante integrante) throws DAOException {

		try {
			this.em.merge(integrante);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Integrante integrante) throws DAOException {

		try {
			this.em.remove(integrante);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	public EntityManager getEm() {

		return this.em;
	}

	public void setEm(final EntityManager em) {

		this.em = em;
	}

}
