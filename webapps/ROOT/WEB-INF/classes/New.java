import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class New
{
public static void main(String [] args, String mail, String text)

{
	
	String recipient = mail;

	
	String sender = "2018ece0802@svce.ac.in";

	
	String host = "smtp.gmail.com";

	
	Properties properties = System.getProperties();

	
	properties.setProperty("mail.smtp.host", host);
	properties.setProperty("mail.smtp.port", "587");
	properties.setProperty("mail.smtp.starttls.enable", "true");
	properties.setProperty("mail.smtp.auth", "true");
	
	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	  protected PasswordAuthentication getPasswordAuthentication() {

             return new PasswordAuthentication("2018ece0802@svce.ac.in", "student.svce");//from

         }

     });
		session.setDebug(true);
		

	 try {
         
         MimeMessage message = new MimeMessage(session);

         
         message.setFrom(new InternetAddress(sender));

         
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

         
         message.setSubject("Your Todo list!!");

         
         message.setContent(text, "text/html");


         System.out.println("sending...");
         
         Transport.send(message);
         System.out.println("Sent message successfully....");
     } catch (Exception e) {
         e.printStackTrace();
     }
}
}
