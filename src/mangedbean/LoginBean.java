package mangedbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;

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

	@EJB 
	CheckLogin check;
	@EJB
	ListQuerys listquerys;
	
	
	
	@PostConstruct
    public void init() {
		user = new User();
		rsquerylist = new ArrayList<ListResult>();

    }
	
	  public void viewCars() {  
		  System.out.println("run-----");
	        RequestContext.getCurrentInstance().openDialog("viewCars.xhtml");  
	    }  
	      
	    public void viewCarsCustomized() {  
	        Map<String,Object> options = new HashMap<String, Object>();  
	        options.put("modal", true);  
	        options.put("draggable", false);  
	        options.put("resizable", false);  
	        options.put("contentHeight", 320);  
	        //hint: available options are modal, draggable, resizable, width, height, contentWidth and contentHeight  
	          
	        RequestContext.getCurrentInstance().openDialog("viewCars", options, null);  
	    }  
	    
	public String login()
	{
		boolean result = check.Check(user.getUsername(), user.getPassword());
		String version = FacesContext.class.getPackage().getImplementationVersion();
		System.out.println("version:" + version); 
		return String.valueOf(result);
	}

	public String runSql(String url)
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
	}
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


	
	
}
