package br.com.helpcar.actions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.helpcar.dao.CondutorDao;
import br.com.helpcar.dao.VeiculoDao;
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
	private Condutor condutor;
	private CondutorDao condutorDao;
	private List<Veiculo> veiculos;
	private Veiculo veiculo;
	private String msg;
	private String tipo;
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Action(value="login", results={
			@Result(name="ok", location ="menu.jsp"),
			@Result(name="cadastreVeiculo", type= "redirectAction", params={"actionName","cadastroVeiculoForm", "msg", "${msg}","tipo","${tipo}"}),
			@Result(name="escolha",  type= "redirectAction", params={"actionName","escolheVeiculoForm", "msg", "${msg}","tipo","${tipo}" }),
			@Result(name="invalido", type= "redirectAction", params={"actionName","loginForm", "msg", "${msg}","tipo","${tipo}"})
	})
	public String execute() throws Exception{

		condutorDao = new CondutorDao();
		condutor.setLogin(condutor.getLogin());
		condutor.setSenha(EncriptadorSenha.encripta(condutor.getSenha()));
		if(condutorDao.existeLoginCondutor(condutor)){
			condutor = condutorDao.achaCondutor(condutor);
			ActionContext.getContext().getSession().put("usuarioLogado", condutor);
			veiculos = condutor.getVeiculo();
			
			veiculos = new ArrayList(new HashSet(veiculos)); 
			
			
			if(veiculos.size()==1){
				ActionContext.getContext().getSession().put("veiculoLogado", veiculos.get(0));
				return "ok";
			}else{
				if(veiculos.size()>1){
					ActionContext.getContext().getSession().put("listaVeiculos", veiculos);
					setMsg("Usuario logado com sucesso, escolha o veiculo!");
					setTipo("notice");					
					return "escolha";
				}else{
					setMsg("Usuario logado com sucesso, cadastre seu veiculo!");
					setTipo("notice");
					return "cadastreVeiculo";
				}
			}
		}else{
			setMsg("Usuario nao cadastrado. Tente novamente");
			setTipo("error");
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

	
	
}