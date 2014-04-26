package br.com.helpcar.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ParentPackage;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.dao.VeiculoDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Veiculo;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("default")
public class AtualizaVeiculoAction {

	private Veiculo veiculo;
	private VeiculoDao veiculoDao;
	private String msg; 
	private String tipo; 

	@Action(value="atualizaVeiculo", results={
			@Result(name="ok", type = "redirectAction", params={"actionName", "index", "msg", "${msg}", "tipo", "${tipo}"})},
			interceptorRefs= { @InterceptorRef("seguranca") })
	public String execute(){
		
		veiculoDao = new VeiculoDao();
		try{
			veiculoDao.atualizaVeiculo(veiculo);
			ActionContext.getContext().getSession().remove("veiculoLogado");
			ActionContext.getContext().getSession().put("veiculoLogado",veiculo);
			setMsg("Veiculo alterado com sucesso!");
			setTipo("success");
			
			return "ok";
		}catch (Exception e){
			System.out.println(e);
			setMsg("Erro ao atualizado o veiculo!");
			setTipo("error");
			return "ok";
		}
		
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public String getMsg() {
		return msg;
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
