package UserGestion;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {

    public void sendPassword(String mail,String password)
    {
        // Sender's email ID needs to be mentioned
        String from = "hellocine.noreply@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("hellocine.noreply@gmail.com", "ProjetJava2022");
            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

            // Set Subject: header field
            message.setSubject("Your password");

            // Now set the actual message
            message.setText("Hello,\nThis is your password : \""+password+"\".\nKind regards, \nThe HelloCine team.");

            //System.out.println("sending...");
            // Send message
            Transport.send(message);
            //System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public void sendReceipt(String mail,User u,int nbticekt,int price,String moviename,String sceance,String hour) {
        String html="<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"nl-container\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\\\" width=\\\"100%\\\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\\\"center\\\" border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"row row-1\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\\\"center\\\" border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"row-content stack\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\\\" width=\\\"500\\\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\\\"column column-1\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; background-color: #fbf6ec; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\\\" width=\\\"100%\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"image_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td style=\\\"width:100%;padding-right:0px;padding-left:0px;\\\">\n" +
                "<div align=\\\"center\\\" style=\\\"line-height:10px\\\"><img src=\\\"images/logocine2.PNG\\\" style=\\\"display: block; height: auto; border: 0; width: 444px; max-width: 100%;\\\" width=\\\"444\\\"/></div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"divider_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div align=\\\"center\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td class=\\\"divider_inner\\\" style=\\\"font-size: 1px; line-height: 1px; border-top: 11px solid #000000;\\\"><span> </span></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"paragraph_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\\\"color:#000000;font-size:14px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-weight:400;line-height:120%;text-align:left;direction:ltr;letter-spacing:0px;\\\">\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>Dear "+u.getName() +" "+ u.getFirstname() +",</strong></p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">Thank you for placing your order with HelloCine.</p>\n" +
                "<p style=\\\"margin: 0;\\\">We wish you a good viewing!</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"divider_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div align=\\\"center\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td class=\\\"divider_inner\\\" style=\\\"font-size: 1px; line-height: 1px; border-top: 11px solid #1A1818;\\\"><span> </span></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"paragraph_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\\\"color:#000000;font-size:14px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-weight:400;line-height:120%;text-align:left;direction:ltr;letter-spacing:0px;\\\">\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">Here is the information corresponding to your order:</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>Order Number:</strong> “6783”</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>Tickets Number:</strong> “"+nbticekt+"”</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>For Movie:</strong> “"+moviename+"”</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>At :</strong> “"+sceance+"”</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>by :</strong> “"+hour+"”</p>\n" +
                "<p style=\\\"margin: 0;\\\"><strong>Total Price:</strong> £ "+price+"</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"divider_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div align=\\\"center\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td class=\\\"divider_inner\\\" style=\\\"font-size: 1px; line-height: 1px; border-top: 11px solid #1A1818;\\\"><span> </span></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"paragraph_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\\\"color:#000000;font-size:14px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-weight:400;line-height:120%;text-align:left;direction:ltr;letter-spacing:0px;\\\">\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>Customer data : </strong></p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">"+u.getName()+" "+u.getFirstname()+"</p>\n" +
                "<p style=\\\"margin: 0;\\\">"+u.getMail()+"</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"divider_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div align=\\\"center\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td class=\\\"divider_inner\\\" style=\\\"font-size: 1px; line-height: 1px; border-top: 11px solid #1A1818;\\\"><span> </span></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"paragraph_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\\\"color:#000000;font-size:14px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-weight:400;line-height:120%;text-align:left;direction:ltr;letter-spacing:0px;\\\">\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\"><strong>Payment details :</strong></p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">We have charged your credit card for the following amount: <strong>£ \\"+price+"\\\"</strong>.</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">If you have any further questions about refunds or any other problems, please contact our customer service team who will be happy to help.</p>\n" +
                "<p style=\\\"margin: 0;\\\">You can contact them via the following email address: <strong>hellocine.noreply@gmail.com</strong> Monday to Friday between 9am and 8pm and at weekends between 10am and 6pm.</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"divider_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div align=\\\"center\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td class=\\\"divider_inner\\\" style=\\\"font-size: 1px; line-height: 1px; border-top: 11px solid #1A1818;\\\"><span> </span></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"10\\\" cellspacing=\\\"0\\\" class=\\\"paragraph_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\\\"color:#000000;font-size:14px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-weight:400;line-height:120%;text-align:left;direction:ltr;letter-spacing:0px;\\\">\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">Thank you for your confidence.</p>\n" +
                "<p style=\\\"margin: 0; margin-bottom: 16px;\\\">See you soon.</p>\n" +
                "<p style=\\\"margin: 0;\\\"><strong><em>The HelloCine team.</em></strong></p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\\\"center\\\" border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"row row-2\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\\\"center\\\" border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"row-content stack\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\\\" width=\\\"500\\\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\\\"column column-1\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\\\" width=\\\"100%\\\">\n" +
                "<table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"icons_block\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td style=\\\"vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\\\">\n" +
                "<table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\\\" width=\\\"100%\\\">\n" +
                "<tr>\n" +
                "<td style=\\\"vertical-align: middle; text-align: center;\\\">\n" +
                "<!--[if vml]><table align=\\\"left\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" role=\\\"presentation\\\" style=\\\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\\\"><![endif]-->\n" +
                "<!--[if !vml]><!-->\n" +
                "<table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" class=\\\"icons-inner\\\" role=\\\"presentation\\\" style=\\\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\\\">\n" +
                "<!--<![endif]-->\n" +
                "<tr>\n" +
                "<td style=\\\"vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;\\\"><a href=\\\"https://www.designedwithbee.com/\\\" style=\\\"text-decoration: none;\\\" target=\\\"_blank\\\"><img align=\\\"center\\\" alt=\\\"Designed with BEE\\\" class=\\\"icon\\\" height=\\\"32\\\" src=\\\"images/bee.png\\\" style=\\\"display: block; height: auto; margin: 0 auto; border: 0;\\\" width=\\\"34\\\"/></a></td>\n" +
                "<td style=\\\"font-family: Arial, Helvetica Neue, Helvetica, sans-serif; font-size: 15px; color: #9d9d9d; vertical-align: middle; letter-spacing: undefined; text-align: center;\\\"><a href=\\\"https://www.designedwithbee.com/\\\" style=\\\"color: #9d9d9d; text-decoration: none;\\\" target=\\\"_blank\\\">Designed with BEE</a></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>";
        String from = "hellocine.noreply@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("hellocine.noreply@gmail.com", "ProjetJava2022");
            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

            // Set Subject: header field
            message.setSubject("Your reicipte");

            // Now set the actual message
            message.setText(html,"text/html");
            message.setContent(
                    html,
                    "text/html");

            //System.out.println("sending...");
            // Send message
            Transport.send(message);
            //System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
