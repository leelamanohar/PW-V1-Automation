package com.rp.automation.framework;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.File;
import java.util.*;

 public class SendMail

{
    
      public  static boolean sendMail(String userName,
                String passWord,
                String host,
                String port,
                String starttls,
                String auth,
                boolean debug,
                String socketFactoryClass,
                String fallback,
                String[] to,
                String[] cc,
                String[] bcc,
                String subject,
                String text,
                String attachmentPath,
                String attachmentName){

        //Object Instantiation of a properties file.
        Properties props = new Properties();

        props.put("mail.smtp.user", userName);

        props.put("mail.smtp.host", host);

        if(!"".equals(port)){
        props.put("mail.smtp.port", port);
        }

        if(!"".equals(starttls)){
            props.put("mail.smtp.starttls.enable",starttls);
            props.put("mail.smtp.auth", auth);
        }

        if(debug){

        props.put("mail.smtp.debug", "true");

        }else{

        props.put("mail.smtp.debug", "false");

        }

        if(!"".equals(port)){
            props.put("mail.smtp.socketFactory.port", port);
        }
        if(!"".equals(socketFactoryClass)){
            props.put("mail.smtp.socketFactory.class",socketFactoryClass);
        }
        if(!"".equals(fallback)){
            props.put("mail.smtp.socketFactory.fallback", fallback);
        }

        try{

            Session session = Session.getDefaultInstance(props, null);

            session.setDebug(debug);

            MimeMessage msg = new MimeMessage(session);

            //msg.setText(text);

            msg.setSubject(subject);

            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            File att = new File(new File(attachmentPath), attachmentName);
            //System.out.println("path is "+ att.getPath());
            DataSource source = new FileDataSource(att.getPath());
            messageBodyPart.setDataHandler(new DataHandler(source));
           // System.out.println("file name "+att.getName() );
            messageBodyPart.setFileName(att.getName());
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);
            msg.setFrom(new InternetAddress(userName));
            
            for(int i=0;i<to.length;i++){
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
            }

            for(int i=0;i<cc.length;i++){
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
            }

            for(int i=0;i<bcc.length;i++){
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
            }
           
            //msg.setText(text);
            
            //
            MimeBodyPart messageBodyPart1 = new MimeBodyPart(); 

            messageBodyPart1.setText(text);

            multipart.addBodyPart(messageBodyPart1, 0);
            //
            msg.saveChanges();

            Transport transport = session.getTransport("smtp");

            transport.connect(host, userName, passWord);

            transport.sendMessage(msg, msg.getAllRecipients());

            transport.close();

            return true;

        } catch (Exception mex){
            mex.printStackTrace();
            return false;
        }
    }
}