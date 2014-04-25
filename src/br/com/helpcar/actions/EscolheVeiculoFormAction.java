package br.com.helpcar.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.models.Veiculo;

@ParentPackage("default")
public class EscolheVeiculoFormAction {
	private String msg;
	private String tipo;
	private List<Veiculo> veiculos;
	@Action(value="escolheVeiculoForm", results={
			@Result(name="ok", location ="escolhe-veiculo.jsp")},
			interceptorRefs= { @InterceptorRef("seguranca") }) 
	public String execute() {
		return "ok";
	}
	public String getMsg() {
		return msg;
	}
	
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
