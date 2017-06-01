package br.edu.ifba.eunapolis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.eunapolis.data.OrcamentoRepository;
import br.edu.ifba.eunapolis.model.ListaCompra;
import br.edu.ifba.eunapolis.model.Orcamento;
import br.edu.ifba.eunapolis.model.PrecoProduto;
import br.edu.ifba.eunapolis.model.Produto;
import br.edu.ifba.eunapolis.model.Similar;

@Model
public class ListaCompraController extends Controller {

	@Inject
	OrcamentoRepository orcamentoRepository;
	
	@Produces
	@Named
	private Orcamento newOrcamento2;
	
	@Produces
	@Named
	private Orcamento newOrcamento3;

	public String setSelected(Long id) {
		this.setNewListaCompra(this.findById(id));
		return "add_produtos.jsf";
	}

	public ListaCompra findById(Long id) {
		return this.getListaCompraRepository().findById(id);
	}
	public void buscaOrcamento (javax.faces.event.AjaxBehaviorEvent event) {
		
		//getNewListaCompra().setOrcamentos(orcamentoRepository.findAllOrcamentos(getNewListaCompra().getId()));
		//getNewOrcamento().setPrecoProduto(orcamentoRepository.findById(getNewListaCompra().getOrcamentos().get(0).getId()).getPrecoProduto());
		setNewOrcamento(getNewListaCompra().getOrcamentos().get(0));
		getNewOrcamento().setPrecoProduto(getNewListaCompra().getOrcamentos().get(0).getPrecoProduto());
		newOrcamento2=getNewListaCompra().getOrcamentos().get(1);
		newOrcamento3=getNewListaCompra().getOrcamentos().get(2);
		newOrcamento2.setPrecoProduto(getNewListaCompra().getOrcamentos().get(1).getPrecoProduto());
		newOrcamento3.setPrecoProduto(getNewListaCompra().getOrcamentos().get(2).getPrecoProduto());
		
		/*getNewListaCompra().setOrcamentos(orcamentoRepository.findAllOrcamentos(getNewListaCompra().getId()));
		setNewOrcamento(getNewListaCompra().getOrcamentos().get(0));
		getNewOrcamento().setPrecoProduto(getNewListaCompra().getOrcamentos().get(0).getPrecoProduto());
		newOrcamento2=getNewListaCompra().getOrcamentos().get(1);
		newOrcamento3=getNewListaCompra().getOrcamentos().get(2);
		newOrcamento2.setPrecoProduto(getNewListaCompra().getOrcamentos().get(1).getPrecoProduto());
		newOrcamento3.setPrecoProduto(getNewListaCompra().getOrcamentos().get(2).getPrecoProduto());*/
	}
	public void setMenorPreco() {

		setNewOrcamento(new Orcamento());
		//setNewListaCompra(getListaCompraRepository().findById(id));
		getNewOrcamento().setNome(getNewListaCompra().getNome());
		getNewOrcamento().setListaCompra(getNewListaCompra());
		getNewOrcamento().setPrecoProduto(new ArrayList<PrecoProduto>());
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBarato(listaProduto.getId()));
			if (getNewPrecoProduto() != null) {
				getNewOrcamento().getPrecoProduto().add(getNewPrecoProduto());
			}
		}
	}

	public void setMenorPrecoPorSimilar() {

		newOrcamento2 = new Orcamento();
		//setNewListaCompra(getListaCompraRepository().findById(id));
		newOrcamento2.setPrecoProduto(new ArrayList<PrecoProduto>());
		newOrcamento2.setNome(getNewListaCompra().getNome());
		newOrcamento2.setListaCompra(getNewListaCompra());

		
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			Similar s = getSimilarRepository().findByProdutoOrigem(listaProduto.getId());
			if (s != null) {
				List<Long> similarIds = new ArrayList<Long>();
				similarIds.add(s.getProdutoOrigem().getId());
				for (Produto ids : s.getProdutosSimilares()) {
					similarIds.add(ids.getId());
				}				
				setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBaratoPorSimilar(similarIds));
				if (getNewPrecoProduto() != null) {
					newOrcamento2.getPrecoProduto().add(getNewPrecoProduto());
				}	
			} else {
				setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBarato(listaProduto.getId()));
				if (getNewPrecoProduto() != null) {
					newOrcamento2.getPrecoProduto().add(getNewPrecoProduto());
				}
			}
		}
	}

	public void setMenorPrecoPorPontoVenda() {

		newOrcamento3 = new Orcamento();		
		List<Long> pvs = new ArrayList<Long>();
		pvs.add((long)0);
		pvs.add((long)2);
		//setNewListaCompra(getListaCompraRepository().findById(id));
		newOrcamento3.setNome(getNewListaCompra().getNome());
		newOrcamento3.setListaCompra(getNewListaCompra());
		newOrcamento3.setPrecoProduto(new ArrayList<PrecoProduto>());
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBaratoPorPontoVenda(listaProduto.getId(),pvs));
			if (getNewPrecoProduto() != null) {
				newOrcamento3.getPrecoProduto().add(getNewPrecoProduto());
			}
		}
	}

	public String menorPreco(Long id) {
		setNewListaCompra(getListaCompraRepository().findById(id));
		this.setMenorPreco();
		this.setMenorPrecoPorSimilar();
		this.setMenorPrecoPorPontoVenda();		
		return "melhor_lista.jsf";
	}
	public String menorPrecoPorSimilar(Long id) {
		this.setMenorPrecoPorSimilar();
		return "melhor_lista.jsf";
	}
	public String menorPrecoPorPontoVenda(Long id) {
		this.setMenorPrecoPorPontoVenda();
		return "melhor_lista.jsf";
	}
	public void registerOrcameto() throws Exception {
		try {			
			
			this.setMenorPreco();
			this.setMenorPrecoPorSimilar();
			this.setMenorPrecoPorPontoVenda();
			getOrcamentoRegistration().register(getNewOrcamento());
			getOrcamentoRegistration().register(newOrcamento2);
			getOrcamentoRegistration().register(newOrcamento3);
			getNewListaCompra().getOrcamentos().add(getNewOrcamento());
			getNewListaCompra().getOrcamentos().add(newOrcamento2);
			getNewListaCompra().getOrcamentos().add(newOrcamento3);
			getListaCompraRegistration().update(getNewListaCompra());
			
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
		
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

	public Orcamento getNewOrcamento2() {
		return newOrcamento2;
	}

	public void setNewOrcamento2(Orcamento newOrcamento2) {
		this.newOrcamento2 = newOrcamento2;
	}

	public Orcamento getNewOrcamento3() {
		return newOrcamento3;
	}

	public void setNewOrcamento3(Orcamento newOrcamento3) {
		this.newOrcamento3 = newOrcamento3;
	}

	public void register() throws Exception {
		try {
			setUser(getUserRepository().findByFbId(getAuthenticator().getProfile().getValidatedId()));
			getNewListaCompra().setUser(getUser());
			getListaCompraRegistration().register(getNewListaCompra());
			getUser().getListaCompras().add(getNewListaCompra());
			getUserRegistration().update(getUser());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewListaCompra();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

	public void addProdutos() throws Exception {
		try {
			ListaCompra oldListaCompra = getListaCompraRepository().findById(getNewListaCompra().getId());
			oldListaCompra.setProdutos(getNewListaCompra().getProdutos());
			getListaCompraRegistration().addProdutos(oldListaCompra);
			setNewListaCompra(oldListaCompra);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
