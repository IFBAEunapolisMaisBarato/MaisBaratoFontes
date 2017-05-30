package br.edu.ifba.eunapolis.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;

import br.edu.ifba.eunapolis.data.UserRepository;
import br.edu.ifba.eunapolis.model.User;
import br.edu.ifba.eunapolis.service.UserRegistration;

@Named
@SessionScoped
public class Authenticator implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UserRepository uR;
	
	@Inject
    private UserRegistration userRegistration;

	User user;
	
	private SocialAuthManager socialManager;
	private Profile profile;
	private boolean loggedIn;
	
	
	//private final String mainURL = "http://10.9.64.94:8080/MaisBarato/index.xhtml";
	//private final String redirectURL = "http://10.9.64.94:8080/MaisBarato/redirectHome.xhtml";
	private final String mainURL = "http://localhost:8080/MaisBarato/secured/listaCompra/cad_lista_compra.xhtml";
	private final String redirectURL = "http://localhost:8080/MaisBarato/redirectHome.xhtml";
	//private final String redirectURL = "http://www.codewebpro.com/blog";
	private final String provider = "facebook";
	 
	public void logout() {
		setLoggedIn(false);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/MaisBarato/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void conectar() {
		Properties prop = System.getProperties();
		prop.put("graph.facebook.com.consumer_key", "2081901585370202");
		prop.put("graph.facebook.com.consumer_secret", "98ccc9b5035c8afa28d78b6c0b25a18a");
		prop.put("graph.facebook.com.custom_permissions", "public_profile,email");

		SocialAuthConfig socialConfig = SocialAuthConfig.getDefault();
		try {
			socialConfig.load(prop);
			socialManager = new SocialAuthManager();
			socialManager.setSocialAuthConfig(socialConfig);
			String URLRetorno = socialManager.getAuthenticationUrl(provider, redirectURL);
			FacesContext.getCurrentInstance().getExternalContext().redirect(URLRetorno);
			setLoggedIn(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPerfilUsuario() throws Exception {
		ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ex.getRequest();

		Map<String, String> parametros = SocialAuthUtil.getRequestParametersMap(request);

		if (socialManager != null) {
			AuthProvider provider = socialManager.connect(parametros);
			this.setProfile(provider.getUserProfile());

		}
		
		if (uR.findByEmail(getProfile().getEmail()) == null) {
			
			user = new User();
			user.setNome(profile.getFullName());
			user.setEmail(getProfile().getEmail());
			user.setFbID(profile.getValidatedId());
			userRegistration.register(user);
			user = uR.findByEmail(getProfile().getEmail());
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect(mainURL);
	}
	public String getCad(){
		return "cad_user.xhtml";
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
