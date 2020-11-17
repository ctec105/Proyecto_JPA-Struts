package proyecto.struts.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Intercepter;

public class AuthenticationInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		Action action = (Action) invocation.getAction();
		if (session.get("login") == null) {
			System.out.println("Error en el interceptor");

			return Action.ERROR;

		} else {

			System.out.println("Action = " + action.toString());
			return invocation.invoke();
		}
	}

}
