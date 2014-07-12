package br.com.helpcar.utils;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public final class EditaTexto{
	
	public static String retirarAcentos(String texto) {

		if (texto != null) {
			texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
			texto = texto.replaceAll("[^\\p{ASCII}]", "");
		}

		return texto;
	}
	public static String deleta(String texto, int num, int num2){
		StringBuilder substring = new StringBuilder(texto);
		substring= substring.delete(num,num2);
		String textoR=substring.toString();
		return textoR;
	}
	
	public static String insert(String sb, int num, char c){  
		return sb.substring(0,num)+c+sb.substring(num,sb.length());  
	}
	

}