package br.edu.ifba.eunapolis.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.eunapolis.data.CategoriaProdutoRepository;
import br.edu.ifba.eunapolis.data.ListaCompraRepository;
import br.edu.ifba.eunapolis.data.MarcaRepository;
import br.edu.ifba.eunapolis.data.PrecoProdutoRepository;
import br.edu.ifba.eunapolis.data.SimilarRepository;
import br.edu.ifba.eunapolis.data.UserRepository;
import br.edu.ifba.eunapolis.model.CategoriaProduto;
import br.edu.ifba.eunapolis.model.ListaCompra;
import br.edu.ifba.eunapolis.model.Marca;
import br.edu.ifba.eunapolis.model.Orcamento;
import br.edu.ifba.eunapolis.model.PontoVenda;
import br.edu.ifba.eunapolis.model.PrecoProduto;
import br.edu.ifba.eunapolis.model.Produto;
import br.edu.ifba.eunapolis.model.Rede;
import br.edu.ifba.eunapolis.model.Similar;
import br.edu.ifba.eunapolis.model.UnidadeMedida;
import br.edu.ifba.eunapolis.model.User;
import br.edu.ifba.eunapolis.service.CategoriaProdutoRegistration;
import br.edu.ifba.eunapolis.service.ListaCompraRegistration;
import br.edu.ifba.eunapolis.service.MarcaRegistration;
import br.edu.ifba.eunapolis.service.OrcamentoRegistration;
import br.edu.ifba.eunapolis.service.PontoVendaRegistration;
import br.edu.ifba.eunapolis.service.PrecoProdutoRegistration;
import br.edu.ifba.eunapolis.service.ProdutoRegistration;
import br.edu.ifba.eunapolis.service.RedeRegistration;
import br.edu.ifba.eunapolis.service.SimilarRegistration;
import br.edu.ifba.eunapolis.service.UnidadeMedidaRegistration;
import br.edu.ifba.eunapolis.service.UserRegistration;

@Model
public abstract class Controller {

	@Inject
	private FacesContext facesContext;
	@Inject
	private CategoriaProdutoRegistration categoriaProdutoRegistration;
	@Inject
	private CategoriaProdutoRepository categoriaProdutoRepository;
	@Inject
	private ListaCompraRegistration listaCompraRegistration;
	@Inject
	private ListaCompraRepository listaCompraRepository;
	@Inject
	private PontoVendaRegistration pontoVendaRegistration;
	@Inject
	private PrecoProdutoRegistration precoProdutoRegistration;
	@Inject
	private PrecoProdutoRepository precoProdutoRepository;
	@Inject
	private SimilarRegistration similarRegistration;
	@Inject
	private SimilarRepository similarRepository;
	@Inject
	private MarcaRegistration marcaRegistration;
	@Inject
	private MarcaRepository marcaRepository;
	@Inject
	private ProdutoRegistration ProdutoRegistration;
	@Inject
	private UserRegistration userRegistration;
	@Inject
	private UserRepository userRepository;
	@Inject
	private Authenticator authenticator;
	@Inject
	private RedeRegistration redeRegistration;
	@Inject
	private UnidadeMedidaRegistration UnidadeMedidaRegistration;
	@Inject
	private OrcamentoRegistration orcamentoRegistration;
	
	@Produces
	@Named
	private List<PrecoProduto> listaPrecoProduto;

	@Produces
	@Named
	private Orcamento newOrcamento;

	@Produces
	@Named
	private UnidadeMedida newUnidadeMedida;

	@Produces
	@Named
	private Rede newRede;

	@Produces
	@Named
	private PrecoProduto newPrecoProduto;

	@Produces
	@Named
	private Produto newProduto;


	@Produces
	@Named
	private PontoVenda newPontoVenda;

	@Produces
	@Named
	private Marca newMarca;

	@Produces
	@Named
	private CategoriaProduto newCategoriaProduto;

	@Produces
	@Named
	private Similar newSimilar;

	@Produces
	@Named
	private ListaCompra newListaCompra;

	@Produces
	@Named
	private User newUser;

	@PostConstruct
	public void initNewListaCompra() {
		this.setNewListaCompra(new ListaCompra());
	}

	public String getRootErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			// This shouldn't happen, but return the default messages
			return errorMessage;
		}

		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		return errorMessage;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public SimilarRegistration getSimilarRegistration() {
		return similarRegistration;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public User getUser() {
		return newUser;
	}

	public Similar getNewSimilar() {
		return newSimilar;
	}

	public void setNewSimilar(Similar newSimilar) {
		this.newSimilar = newSimilar;
	}

	public ListaCompraRegistration getListaCompraRegistration() {
		return listaCompraRegistration;
	}

	public ListaCompraRepository getListaCompraRepository() {
		return listaCompraRepository;
	}

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public void setListaCompraRegistration(ListaCompraRegistration listaCompraRegistration) {
		this.listaCompraRegistration = listaCompraRegistration;
	}

	public void setListaCompraRepository(ListaCompraRepository listaCompraRepository) {
		this.listaCompraRepository = listaCompraRepository;
	}

	public void setSimilarRegistration(SimilarRegistration similarRegistration) {
		this.similarRegistration = similarRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public void setUser(User user) {
		this.newUser = user;
	}

	public SimilarRepository getSimilarRepository() {
		return similarRepository;
	}

	public void setSimilarRepository(SimilarRepository similarRepository) {
		this.similarRepository = similarRepository;
	}

	public ListaCompra getNewListaCompra() {
		return newListaCompra;
	}

	public void setNewListaCompra(ListaCompra newListaCompra) {
		this.newListaCompra = newListaCompra;
	}

	public CategoriaProdutoRegistration getCategoriaProdutoRegistration() {
		return categoriaProdutoRegistration;
	}

	public CategoriaProdutoRepository getCategoriaProdutoRepository() {
		return categoriaProdutoRepository;
	}

	public CategoriaProduto getNewCategoriaProduto() {
		return newCategoriaProduto;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setCategoriaProdutoRegistration(CategoriaProdutoRegistration categoriaProdutoRegistration) {
		this.categoriaProdutoRegistration = categoriaProdutoRegistration;
	}

	public void setCategoriaProdutoRepository(CategoriaProdutoRepository categoriaProdutoRepository) {
		this.categoriaProdutoRepository = categoriaProdutoRepository;
	}

	public void setNewCategoriaProduto(CategoriaProduto newCategoriaProduto) {
		this.newCategoriaProduto = newCategoriaProduto;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public MarcaRegistration getMarcaRegistration() {
		return marcaRegistration;
	}

	public MarcaRepository getMarcaRepository() {
		return marcaRepository;
	}

	public Marca getNewMarca() {
		return newMarca;
	}

	public void setMarcaRegistration(MarcaRegistration marcaRegistration) {
		this.marcaRegistration = marcaRegistration;
	}

	public void setMarcaRepository(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}

	public void setNewMarca(Marca newMarca) {
		this.newMarca = newMarca;
	}

	public PontoVendaRegistration getPontoVendaRegistration() {
		return pontoVendaRegistration;
	}

	public PontoVenda getNewPontoVenda() {
		return newPontoVenda;
	}

	public void setPontoVendaRegistration(PontoVendaRegistration pontoVendaRegistration) {
		this.pontoVendaRegistration = pontoVendaRegistration;
	}

	public void setNewPontoVenda(PontoVenda newPontoVenda) {
		this.newPontoVenda = newPontoVenda;
	}

	public PrecoProdutoRegistration getPrecoProdutoRegistration() {
		return precoProdutoRegistration;
	}

	public PrecoProdutoRepository getPrecoProdutoRepository() {
		return precoProdutoRepository;
	}

	public void setPrecoProdutoRegistration(PrecoProdutoRegistration precoProdutoRegistration) {
		this.precoProdutoRegistration = precoProdutoRegistration;
	}

	public void setPrecoProdutoRepository(PrecoProdutoRepository precoProdutoRepository) {
		this.precoProdutoRepository = precoProdutoRepository;
	}

	public PrecoProduto getNewPrecoProduto() {
		return newPrecoProduto;
	}

	public void setNewPrecoProduto(PrecoProduto newPrecoProduto) {
		this.newPrecoProduto = newPrecoProduto;
	}

	public ProdutoRegistration getProdutoRegistration() {
		return ProdutoRegistration;
	}

	public Produto getNewProduto() {
		return newProduto;
	}

	public void setProdutoRegistration(ProdutoRegistration produtoRegistration) {
		ProdutoRegistration = produtoRegistration;
	}

	public void setNewProduto(Produto newProduto) {
		this.newProduto = newProduto;
	}

	public RedeRegistration getRedeRegistration() {
		return redeRegistration;
	}

	public Rede getNewRede() {
		return newRede;
	}

	public void setRedeRegistration(RedeRegistration redeRegistration) {
		this.redeRegistration = redeRegistration;
	}

	public void setNewRede(Rede newRede) {
		this.newRede = newRede;
	}

	public UnidadeMedidaRegistration getUnidadeMedidaRegistration() {
		return UnidadeMedidaRegistration;
	}

	public UnidadeMedida getNewUnidadeMedida() {
		return newUnidadeMedida;
	}

	public void setUnidadeMedidaRegistration(UnidadeMedidaRegistration unidadeMedidaRegistration) {
		UnidadeMedidaRegistration = unidadeMedidaRegistration;
	}

	public void setNewUnidadeMedida(UnidadeMedida newUnidadeMedida) {
		this.newUnidadeMedida = newUnidadeMedida;
	}

	public OrcamentoRegistration getOrcamentoRegistration() {
		return orcamentoRegistration;
	}

	public Orcamento getNewOrcamento() {
		return newOrcamento;
	}

	public void setOrcamentoRegistration(OrcamentoRegistration orcamentoRegistration) {
		this.orcamentoRegistration = orcamentoRegistration;
	}

	public void setNewOrcamento(Orcamento newOrcamento) {
		this.newOrcamento = newOrcamento;
	}

	public List<PrecoProduto> getListaPrecoProduto() {
		return listaPrecoProduto;
	}

	public void setListaPrecoProduto(List<PrecoProduto> listaPrecoProduto) {
		this.listaPrecoProduto = listaPrecoProduto;
	}
}
