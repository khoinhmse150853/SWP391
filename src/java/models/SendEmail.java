/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SE150853 Nguyen Huynh Minh Khoi
 */
public class SendEmail {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean sendEmail(User user, String code) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "namphse150924@fpt.edu.vn";
        String password = "13073105";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.starttls.required", "true");
            pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            //set email subject
            mess.setSubject("Confirm Register");

            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n "
                    + "\n"
                    + "<head>\n "
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Xin ch??o " + user.getFullName() + " !</h3>\n"
                    + "    <div>M?? x??c minh t??i kho???n c???a b???n l?? : " + code + "</div>\n"
                    + "    <div>Th?? n??y ???????c t???o ra t??? ?????ng.</div>\n"
                    + "    <div>N???u b???n c???n tr??? gi??p ho???c c?? c??u h???i, h??y g???i email ?????n minhkhoi11.04nhmk@gmail.com b???t c??? l??c n??o.</div>\n"
                    + "    <h3 style=\"color: blue;\">Tr??n tr???ng!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";

            mess.setContent(message, "text/html; charset=UTF-8");

            //set message text
//            mess.setText(message);
//            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    public boolean sendEmailDelete(User user, String time, String childrenPitchName, String pitchName, String date, String reason) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "namphse150924@fpt.edu.vn";
        String password = "13073105";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.starttls.required", "true");
            pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            //set email subject
            mess.setSubject("Delete Booking");

            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n "
                    + "\n"
                    + "<head>\n "
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Xin ch??o " + user.getFullName() + " !</h3>\n"
                    + "    <div>Ch??? s??n ???? x??a l???ch ?????t s??n c???a b???n v??o l??c : " + time + " , ng??y " + date +"</div>\n"
                    + "    <div>T???i s??n : " + pitchName + "</div>\n"
                    + "    <div>C?? s??n con : " + childrenPitchName + "</div>\n"
                    + "    <div>L?? do : " + reason + "</div>\n"
                    + "    <div>Th?? n??y ???????c t???o ra t??? ?????ng.</div>\n"
                    + "    <div>N???u b???n c???n tr??? gi??p ho???c c?? c??u h???i, h??y g???i email ?????n minhkhoi11.04nhmk@gmail.com b???t c??? l??c n??o.</div>\n"
                    + "    <h3 style=\"color: blue;\">Tr??n tr???ng!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";

            mess.setContent(message, "text/html; charset=UTF-8");

            //set message text
//            mess.setText(message);
//            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
    
    public boolean sendEmailConfirmOwner(User user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "namphse150924@fpt.edu.vn";
        String password = "13073105";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.starttls.required", "true");
            pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            //set email subject
            mess.setSubject("Delete Booking");

            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n "
                    + "\n"
                    + "<head>\n "
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Xin ch??o " + user.getFullName() + " !</h3>\n"
                    + "    <div>Admin ???? x??c nh???n cho b???n tr??? th??nh ch??? s??n</div>\n"
                    + "    <div>B??y gi??? b???n c?? th??? ????ng nh???p v???i t?? c??ch l?? ch??? s??n v???i t??i kho???n ???? ????ng k??</div>\n"
                    + "    <div>Th?? n??y ???????c t???o ra t??? ?????ng.</div>\n"
                    + "    <div>N???u b???n c???n tr??? gi??p ho???c c?? c??u h???i, h??y g???i email ?????n minhkhoi11.04nhmk@gmail.com b???t c??? l??c n??o.</div>\n"
                    + "    <h3 style=\"color: blue;\">Tr??n tr???ng!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";

            mess.setContent(message, "text/html; charset=UTF-8");

            //set message text
//            mess.setText(message);
//            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
    
    public boolean sendEmailDenyOwner(User user, String reason) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "namphse150924@fpt.edu.vn";
        String password = "13073105";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.starttls.required", "true");
            pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            //set email subject
            mess.setSubject("Delete Booking");

            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n "
                    + "\n"
                    + "<head>\n "
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Xin ch??o " + user.getFullName() + " !</h3>\n"
                    + "    <div>Admin ???? t??? ch???i cho b???n tr??? th??nh ch??? s??n</div>\n"
                    + "    <div>L?? do: " + reason +"</div>\n"
                    + "    <div>Th?? n??y ???????c t???o ra t??? ?????ng.</div>\n"
                    + "    <div>N???u b???n c???n tr??? gi??p ho???c c?? c??u h???i, h??y g???i email ?????n minhkhoi11.04nhmk@gmail.com b???t c??? l??c n??o.</div>\n"
                    + "    <h3 style=\"color: blue;\">Tr??n tr???ng!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";

            mess.setContent(message, "text/html; charset=UTF-8");

            //set message text
//            mess.setText(message);
//            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
    
    public boolean sendEmailDeleteUser(User user, String reason) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "namphse150924@fpt.edu.vn";
        String password = "13073105";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.starttls.required", "true");
            pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            //set email subject
            mess.setSubject("Delete User");

            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n "
                    + "\n"
                    + "<head>\n "
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Xin ch??o " + user.getFullName() + " !</h3>\n"
                    + "    <div>Admin ???? x??a t??i kho???n s??? d???ng c???a b???n</div>\n"
                    + "    <div>L?? do: " + reason +"</div>\n"
                    + "    <div>Th?? n??y ???????c t???o ra t??? ?????ng.</div>\n"
                    + "    <div>N???u b???n c???n tr??? gi??p ho???c c?? c??u h???i, h??y g???i email ?????n minhkhoi11.04nhmk@gmail.com b???t c??? l??c n??o.</div>\n"
                    + "    <h3 style=\"color: blue;\">Tr??n tr???ng!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";

            mess.setContent(message, "text/html; charset=UTF-8");

            //set message text
//            mess.setText(message);
//            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}
