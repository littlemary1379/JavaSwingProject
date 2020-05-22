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
        String user = " "; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
        String password = " ";   // 패스워드

        // SMTP 서버 정보를 설정한다.
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

            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(DBemail)); 

            // Subject
            message.setSubject("No24 "+type+"안내입니다."); //메일 제목을 입력

            // Text
            message.setText(DBname+"님의 No24 "+type+"는 "+DBsend+"입니다. 좋은 하루 되십시오 ^^");    //메일 내용을 입력

            // send the message
            Transport.send(message); ////전송
            System.out.println("전송완료");
            JOptionPane.showMessageDialog(null, "귀하가 입력하신 곳으로 메일이 발송되었습니다.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
