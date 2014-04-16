package br.com.helpcar.actions;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.models.Condutor;
import br.com.helpcar.models.Veiculo;
import br.com.helpcar.utils.EncriptadorSenha;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Hello
	private Condutor condutor;
	private CondutorDao condutorDao;
	private List<Veiculo> veiculos;
	private Veiculo veiculo;
	private String msg;
	
	@Action(value="login", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="cadastreVeiculo", type= "redirectAction", params={"actionName","cadastraVeiculoForm", "msg", "${msg}"}),
			@Result(name="escolha", location="escolhaVeiculo.jsp"),
			@Result(name="invalido", location="formulario-login.jsp")
	})
	public String login() throws Exception{
		
		condutorDao = new CondutorDao();
		condutor.setLogin(condutor.getLogin());
		condutor.setSenha(EncriptadorSenha.encripta(condutor.getSenha()));
		if(condutorDao.existeCondutor(condutor)){
			condutor = condutorDao.achaCondutor(condutor);
			ActionContext.getContext().getSession().put("usuarioLogado", condutor);
			veiculos = condutor.getVeiculo();
		
			if(veiculos.size()==1){
				ActionContext.getContext().getSession().put("veiculoLogado", veiculos.get(0));
				return "ok";
			}else{
				if(veiculos.size()>1){
					ActionContext.getContext().getSession().put("listaVeiculos", veiculos);
					return "escolha";
				}else{
					return "cadastreVeiculo";
				}
			}
		}else{
			
			return "invalido";
		}
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
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

	
	
}