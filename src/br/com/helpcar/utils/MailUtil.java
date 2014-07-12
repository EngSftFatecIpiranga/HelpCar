package br.com.helpcar.utils;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil{

	public static boolean sendMail(String email, StringBuilder msg){
		final String username = "helpcarfatec@gmail.com";
		final String password = "Helpcar@fatec";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("helpcarfatec@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("acszan@gmail.com, rafael_legionario@hotmail.com, diegomelin@ig.com.br, valdirtime@yahoo.com.br, katsumatamarcio@yahoo.com.br"));
			
			message.setSubject("Testando HelpCar");
			message.setText(msg.toString());

			Transport.send(message);

			return true;

		} catch (MessagingException e) {
			System.out.println(e);
			return false;
		
	}
	}
}
