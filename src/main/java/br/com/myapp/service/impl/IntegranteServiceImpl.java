package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.IntegranteDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Integrante;
import br.com.myapp.service.IntegranteService;

@Stateless
public class IntegranteServiceImpl implements IntegranteService {

	@EJB
	private IntegranteDAO dao;

	@Override
	public void criar(final Integrante integrante) throws BusinessException {

		try {

			this.dao.criar(integrante);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Integrante> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Integrante integrante) throws BusinessException {

		try {

			this.dao.atualizar(integrante);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Integrante integrante) throws BusinessException {

		try {

			this.dao.deletar(integrante);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

}
