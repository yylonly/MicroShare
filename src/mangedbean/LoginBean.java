package mangedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import model.User;
import result.ListResult;
import sessionbean.CheckLogin;
import sessionbean.ListQuerys;

@ManagedBean
@SessionScoped
public class LoginBean 
{
	
	private  User user;
	private List<ListResult> rsquerylist;
	private String domain;
	@EJB 
	CheckLogin check;
	@EJB
	ListQuerys  listquerys;
	
	
	
	@PostConstruct
    public void init() {
		user = new User();
		rsquerylist = new ArrayList<ListResult>();
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		domain = origRequest.getRequestURL().toString();
    }
		        
/*	public String login()
	{
		boolean result = check.Check(user.getUsername(), user.getPassword());
		String version = FacesContext.class.getPackage().getImplementationVersion();
		System.out.println("version:" + version); 
		return String.valueOf(result);
	}*/

	public void login()
	{
		boolean result = check.Check(user.getUsername(), user.getPassword());
		RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false; 
        
        if(result == true) {  
            loggedIn = true;   
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getUsername());  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
	}	
	

	
	/*public String runSql(String url)
	{
		   FacesContext context = FacesContext.getCurrentInstance();
		   ExternalContext ext = context.getExternalContext();
		   HttpServletResponse response = (HttpServletResponse) ext.getResponse();
		    try 
		    {
		    	response.sendRedirect(url);
		    } catch (IOException ex) 
		    {
		      
		    }
		    context.responseComplete();
		    return "";
	}*/
	public List<ListResult> getRsquerylist() {
		return listquerys.listAll(user);
	}


	public void setRsquerylist(List<ListResult> rsquerylist) {
		this.rsquerylist = rsquerylist;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}


	
	
}
