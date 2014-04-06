package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@Action(value="olaMundoStruts", results={
			@Result(name="ok", location="formulario-login.jsp")
	})
	public String execute(){
		
		return "ok";
	}
}