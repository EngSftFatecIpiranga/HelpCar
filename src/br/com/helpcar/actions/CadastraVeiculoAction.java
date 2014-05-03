package br.com.helpcar.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.dao.VeiculoDao;
import br.com.helpcar.listener.HibernateListener;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Veiculo;

@ParentPackage("default")
public class CadastraVeiculoAction {
	
	private Veiculo veiculo;
	private List<Veiculo> veiculos ;
	private Condutor condutor;
	private CondutorDao condutorDao;
	private String msg;
	private String tipo;
	@Action(value="cadastraVeiculo", results={
			@Result(name="ok",type= "redirectAction", params={"actionName","cadastroEventoForm", "msg", "${msg}"}),
			@Result(name="erro",type= "redirectAction", params={"actionName","cadatroVeiculoForm", "msg", "${msg}"})},
			interceptorRefs= { @InterceptorRef("seguranca") })
	public String execute(){
		veiculos = new ArrayList<Veiculo>();
		condutorDao = new CondutorDao();
		condutor = new Condutor();
		condutor = (Condutor)ActionContext.getContext().getSession().get("usuarioLogado");
		try{
			veiculos = condutor.getVeiculo();
		}catch(Exception e){
			System.out.println(e);
		}
		veiculos.add(veiculo);
		condutor.setVeiculo(veiculos);
		if(condutorDao.atualizaCondutor(condutor)){
			ActionContext.getContext().getSession().remove("veiculoLogado");
			ActionContext.getContext().getSession().put("veiculoLogado", veiculo);
			setMsg("Veiculo cadastrado com sucesso");
			setTipo("success");
			return "ok";
		}
		
		return "erro";
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
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
