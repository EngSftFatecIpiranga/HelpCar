package br.com.helpcar.actions;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.VeiculoDao;
import br.com.helpcar.models.Veiculo;



import com.opensymphony.xwork2.ActionContext;


@ParentPackage("default")
public class EscolheVeiculoAction{
	private Veiculo veiculo;
	private String msg;
	private String tipo;
	private String idVeiculo;
	

	@Action(value="escolheVeiculo", results={
			@Result(name="ok", type= "redirectAction", params={"actionName","index", "msg", "${msg}","tipo","${tipo}"})},
			interceptorRefs={@InterceptorRef("seguranca")})
	public String execute() throws Exception{
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculo = veiculoDao.achaVeiculo(Integer.parseInt(idVeiculo.replaceAll( "\\D*", "" )));
			if(veiculo !=null ){
				ActionContext.getContext().getSession().put("veiculoLogado", veiculo);
				setMsg("Veiculo logado com sucesso");
				setTipo("success");
				return "ok";
			}else{
				setMsg("Veículo não selecionado!!");
				setTipo("notice");					
				return "ok";
			}
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	//******* Getter e Setters da Toast(envio de mensagens JSP)*********//
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

	public String getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	
	
	
}