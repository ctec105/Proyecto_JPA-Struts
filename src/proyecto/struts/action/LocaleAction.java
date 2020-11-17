package proyecto.struts.action;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LocaleAction extends ActionSupport {

	Map<String, String[]> parameters;
	private String url;

	// business logic
	public String execute() {

		url = ServletActionContext.getRequest().getHeader("Referer");
		System.out.println("REFERER: " + url);
		return "success";

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}