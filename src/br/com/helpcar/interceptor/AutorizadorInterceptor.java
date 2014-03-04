package br.com.helpcar.interceptor;

import br.com.helpcar.models.Usuario;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AutorizadorInterceptor implements Interceptor {

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
		Usuario usuarioLogado = (Usuario)invocation.getInvocationContext().
				getSession().get("usuarioLogado");
		if(usuarioLogado==null){
			return "naoLogado";
		}
		
		return invocation.invoke();
	}
	
}
