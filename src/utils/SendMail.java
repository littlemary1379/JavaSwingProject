package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendMail {
	public void sendingMail(String type, String DBemail, String DBsend, String DBname) {
        String user = " "; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
        String password = " ";   // �н�����

        // SMTP ���� ������ �����Ѵ�.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", 465); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.ssl.enable", "true"); 
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            //�����ڸ����ּ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(DBemail)); 

            // Subject
            message.setSubject("No24 "+type+"�ȳ��Դϴ�."); //���� ������ �Է�

            // Text
            message.setText(DBname+"���� No24 "+type+"�� "+DBsend+"�Դϴ�. ���� �Ϸ� �ǽʽÿ� ^^");    //���� ������ �Է�

            // send the message
            Transport.send(message); ////����
            System.out.println("���ۿϷ�");
            JOptionPane.showMessageDialog(null, "���ϰ� �Է��Ͻ� ������ ������ �߼۵Ǿ����ϴ�.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
