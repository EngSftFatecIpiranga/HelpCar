import javax.swing.JOptionPane;

public class TesteMoreira {

	public static void main(String[] args) {
		
	
int resposta;
	
	resposta = JOptionPane.showConfirmDialog(null,"Recebeu a atualiza��o(sim/n�o)");
	
	if(resposta == JOptionPane.YES_OPTION){
		System.out.println("Legal, aparentemente est� tudo certo");
	} else{
		System.out.println("Existem problemas.. :D");
	}
	
	
	
	
	
	}
}
