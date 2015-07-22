package com.cloud.tags.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;

import com.cloud.tags.common.util.Constants;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.microtripit.mandrillapp.lutung.MandrillApi;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage.Recipient;
import com.microtripit.mandrillapp.lutung.view.MandrillMessageStatus;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import com.sendgrid.smtpapi.SMTPAPI;

public class MailUtil {
	private final static Logger _log = Logger.getLogger(MailUtil.class
			.getName());

	public static String getContent(String articleName,
			ThemeDisplay themeDisplay) {
		String emailTemplate = StringPool.BLANK;

		JournalArticle journal = null;

		try {
			journal = JournalArticleLocalServiceUtil.getArticleByUrlTitle(
					themeDisplay.getScopeGroupId(), articleName);

		} catch (Exception e) {
			_log.warn(e.getMessage());

		}

		if (Validator.isNotNull(journal))
			emailTemplate = journal.getContent();
		emailTemplate = emailTemplate.replace("<![CDATA[", "");
		emailTemplate = emailTemplate.replace("]]>", "");

		return emailTemplate;

	}

	/*public static void sendEmail(String emailAddress, String emailTemplate, String storeId) {
		try {


			String subject = "Your Collection from Made.com";

			InternetAddress fromAddress = new InternetAddress(
					"no-reply@made.com", "Made.com");
			InternetAddress to = new InternetAddress(emailAddress,
					"");
			_log.info("fromAddress>>>>"+fromAddress);
			_log.info("toAddress>>>>"+to);
			MailMessage message = new MailMessage(fromAddress, to, subject,
					emailTemplate, true);


			//MailServiceUtil.sendEmail(message);
			//SendGrid Java API for sending mails - starts

			SendGrid sendgrid = new SendGrid(PortletProps.get("sendgrid.user.name"), PortletProps.get("sendgrid.user.password"));


			SendGrid.Email email = new SendGrid.Email();
			email.addCategory(PortletProps.get("sendgrid.email.category"));
			email.addCategory(storeId);
			// email.addCategory("STORE1");
			//email.addCategory("MADE.COM");
			email.addTo(emailAddress);
			email.setFrom(PortletProps.get("sendgrid.from.email"));
			email.setFromName(PortletProps.get("sendgrid.from.name"));
			email.setSubject(subject);
			email.setHtml(emailTemplate);

			try {
				SendGrid.Response response = sendgrid.send(email);
				System.out.println(response.getMessage());
			}
			catch (SendGridException e) {
				System.err.println(e);
			}


			//Ends

		} catch (Exception e) {
			_log.warn(e.getMessage());

		}
	}*/

	/*public static void sendEmail(String emailAddress, String emailTemplate) {
		try {


			String subject = "Your Collection from Made.com";

			InternetAddress fromAddress = new InternetAddress(
					"no-reply@made.com", "Made.com");
			InternetAddress to = new InternetAddress(emailAddress,
					"");
			_log.info("fromAddress>>>>"+fromAddress);
			_log.info("toAddress>>>>"+to);
			MailMessage message = new MailMessage(fromAddress, to, subject,
					emailTemplate, true);


			//MailServiceUtil.sendEmail(message);
			//SendGrid Java API for sending mails - starts

			SendGrid sendgrid = new SendGrid(PortletProps.get("sendgrid.user.name"), PortletProps.get("sendgrid.user.password"));


			SendGrid.Email email = new SendGrid.Email();
			email.addCategory(PortletProps.get("sendgrid.email.category"));
			email.addCategory("STORE1");
			//email.addCategory("MADE.COM");
			email.addTo(emailAddress);
			email.setFrom(PortletProps.get("sendgrid.from.email"));
			email.setFromName(PortletProps.get("sendgrid.from.name"));
			email.setSubject(subject);
			email.setHtml(emailTemplate);

			try {
				SendGrid.Response response = sendgrid.send(email);
				System.out.println(response.getMessage());
			}
			catch (SendGridException e) {
				System.err.println(e);
			}


			//Ends

		} catch (Exception e) {
			_log.warn(e.getMessage());

		}
	}*/

	public static void sendEmail(String emailAddress, String emailTemplate,
			String sendMailDate, String storeId, Map<String, String> salesAssociateTags) {

		try {


			System.out.println("<><>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sendMailDate);


			//SimpleDateFormat dateFormatter = new SimpleDateFormat(" MMMM d, yyyy hh:mm a");
			//String subject = "Your In-Store Collection from Made "+dateFormatter.format(sendMailDate);

			String subject = "Your In-Store Collection from Made "+sendMailDate;

			InternetAddress fromAddress = new InternetAddress(
					"no-reply@made.com", "Made.com");
			InternetAddress to = new InternetAddress(emailAddress,
					"");
			_log.info("fromAddress>>>>"+fromAddress);
			_log.info("toAddress>>>>"+to);
			MailMessage message = new MailMessage(fromAddress, to, subject,
					emailTemplate, true);

			storeId = storeId.replaceAll(" ", "_");
			//MailServiceUtil.sendEmail(message);
			//SendGrid Java API for sending mails - starts

			SendGrid sendgrid = new SendGrid(PortletProps.get("sendgrid.user.name"), PortletProps.get("sendgrid.user.password"));


			SendGrid.Email email = new SendGrid.Email();
			email.addCategory(PortletProps.get("sendgrid.email.category"));
			email.addCategory(storeId);


			// email.addCategory("STORE1");
			//email.addCategory("MADE.COM");
			email.addTo(emailAddress);
			email.setFrom(PortletProps.get("sendgrid.from.email"));
			email.setFromName(PortletProps.get("sendgrid.from.name"));
			email.setSubject(subject);
			email.setHtml(emailTemplate);

			//Mandrill -start

			MandrillApi mandrillApi = new MandrillApi(PortletProps.get("mandrill.access.key"));
			// create your message
			MandrillMessage mandrillMessage = new MandrillMessage();
			mandrillMessage.setSubject(subject);
			mandrillMessage.setHtml(emailTemplate);
			mandrillMessage.setAutoText(true);
			mandrillMessage.setFromEmail(PortletProps.get("sendgrid.from.email"));
			mandrillMessage.setFromName(PortletProps.get("sendgrid.from.name"));
			// add recipients
			ArrayList<Recipient> recipients = new ArrayList<Recipient>();

			Recipient recipient = new Recipient();
			recipient.setEmail(emailAddress);
			recipients.add(recipient);

			/*
			recipient = new Recipient();
			recipient.setEmail("zahee.786@gmail.com");
			recipient.setType(Recipient.Type.CC);		
			recipients.add(recipient);

			recipient = new Recipient();
			recipient.setEmail("piyush@cloudtags.com");
			recipient.setType(Recipient.Type.BCC);		
			recipients.add(recipient);
			 */

			mandrillMessage.setTo(recipients);
			mandrillMessage.setPreserveRecipients(true);
			ArrayList<String> tags = new ArrayList<String>();
			tags.add(PortletProps.get("sendgrid.email.category"));
			tags.add(storeId);

			//commenting adding sales associate tags
			/*//add sales associate tags 
			if(salesAssociateTags != null){
				for(String salesAssociateTag : salesAssociateTags.keySet()){
					tags.add(salesAssociateTag);
					if(!salesAssociateTag.equals(salesAssociateTags.get(salesAssociateTag)))
						tags.add(salesAssociateTags.get(salesAssociateTag));
					_log.info(salesAssociateTag + " "+salesAssociateTags.get(salesAssociateTag));
				}
				//tags.addAll(salesAssociateTags.keySet());
				//tags.addAll(salesAssociateTags.values());
			}*/

			mandrillMessage.setTags(tags);
			// ... add more message details if you want to!
			// then ... send


			//Mandrill - end
			MandrillMessageStatus[] messageStatusReports;
			try {
				if(PortletProps.get("made.mailing.service").contains("sendgrid")){

					//add sales associate tags 
					/*if(salesAssociateTags != null){
						for(String salesAssociateTag : salesAssociateTags.keySet()){
							email.addCategory(salesAssociateTag);
							if(!salesAssociateTag.equals(salesAssociateTags.get(salesAssociateTag)))
								email.addCategory(salesAssociateTags.get(salesAssociateTag));
							_log.info(salesAssociateTag + " "+salesAssociateTags.get(salesAssociateTag));
						}
						//tags.addAll(salesAssociateTags.keySet());
						//tags.addAll(salesAssociateTags.values());
					}*/

					SendGrid.Response response = sendgrid.send(email);
					System.out.println(response.getMessage());
				}else if(PortletProps.get("made.mailing.service").contains("mandrill")){
					try{
						messageStatusReports = mandrillApi
								.messages().send(mandrillMessage, false);
						System.out.println("Mandrill mail send successfully.");
					}catch(Exception e){
						_log.error(e.getMessage());
						/*messageStatusReports = mandrillApi
								.messages().send(mandrillMessage, false);
						System.out.println("Mandrill mail send successfully.");*/
					}
				}

			}
			catch (SendGridException e) {
				System.err.println(e);
			}


			//Ends

		} catch (Exception e) {
			_log.warn(e.getMessage());

		}
	}

	public static void sendEmail(String emailAddress, String emailTemplate,
			String sendMailDate, String storeId, long cartId, long userId,
			String staffList) {

		try {


			System.out.println("<><>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sendMailDate);


			//SimpleDateFormat dateFormatter = new SimpleDateFormat(" MMMM d, yyyy hh:mm a");
			//String subject = "Your In-Store Collection from Made "+dateFormatter.format(sendMailDate);

			String subject = "Your In-Store Collection from Made "+sendMailDate;

			InternetAddress fromAddress = new InternetAddress(
					"no-reply@made.com", "Made.com");
			InternetAddress to = new InternetAddress(emailAddress,
					"");
			_log.info("fromAddress>>>>"+fromAddress);
			_log.info("toAddress>>>>"+to);
			MailMessage message = new MailMessage(fromAddress, to, subject,
					emailTemplate, true);

			storeId = storeId.replaceAll(" ", "_");
			//MailServiceUtil.sendEmail(message);
			//SendGrid Java API for sending mails - starts

			SendGrid sendgrid = new SendGrid(PortletProps.get("sendgrid.user.name"), PortletProps.get("sendgrid.user.password"));


			SendGrid.Email email = new SendGrid.Email();
			email.addCategory(PortletProps.get("sendgrid.email.category"));
			email.addCategory(storeId);


			// email.addCategory("STORE1");
			//email.addCategory("MADE.COM");
			email.addTo(emailAddress);
			email.setFrom(PortletProps.get("sendgrid.from.email"));
			email.setFromName(PortletProps.get("sendgrid.from.name"));
			email.setSubject(subject);
			email.setHtml(emailTemplate);

			//Mandrill -start

			MandrillApi mandrillApi = new MandrillApi(PortletProps.get("mandrill.access.key"));
			// create your message
			MandrillMessage mandrillMessage = new MandrillMessage();
			mandrillMessage.setSubject(subject);
			mandrillMessage.setHtml(emailTemplate);
			mandrillMessage.setAutoText(true);
			mandrillMessage.setFromEmail(PortletProps.get("sendgrid.from.email"));
			mandrillMessage.setFromName(PortletProps.get("sendgrid.from.name"));
			// add recipients
			ArrayList<Recipient> recipients = new ArrayList<Recipient>();

			Recipient recipient = new Recipient();
			recipient.setEmail(emailAddress);
			recipients.add(recipient);

			/*
			recipient = new Recipient();
			recipient.setEmail("zahee.786@gmail.com");
			recipient.setType(Recipient.Type.CC);		
			recipients.add(recipient);

			recipient = new Recipient();
			recipient.setEmail("piyush@cloudtags.com");
			recipient.setType(Recipient.Type.BCC);		
			recipients.add(recipient);
			 */

			mandrillMessage.setTo(recipients);
			mandrillMessage.setPreserveRecipients(true);

			String client = PortletProps.get("sendgrid.email.category");

			ArrayList<String> tags = new ArrayList<String>();
			tags.add(client);
			tags.add(storeId);

			Map<String, String> metadata=new HashMap<String,String>();
			metadata.put("client", client);
			metadata.put("store", storeId);
			if(staffList != null && !staffList.isEmpty()){
				if(staffList.length() > Constants.MANDRILL_SALES_ASS_LEN){
					_log.info("Mandrill Sales Assciates Tag : "
							+staffList.substring(0, Constants.MANDRILL_SALES_ASS_LEN));
					metadata.put("staff", staffList.substring(0, Constants.MANDRILL_SALES_ASS_LEN));
				}
				else{
					metadata.put("staff", staffList);
				}
			}
			metadata.put("cartId", String.valueOf(cartId));
			metadata.put("userId", String.valueOf(userId));

			mandrillMessage.setMetadata(metadata);

			//commenting adding sales associate tags
			/*//add sales associate tags 
			if(salesAssociateTags != null){
				for(String salesAssociateTag : salesAssociateTags.keySet()){
					tags.add(salesAssociateTag);
					if(!salesAssociateTag.equals(salesAssociateTags.get(salesAssociateTag)))
						tags.add(salesAssociateTags.get(salesAssociateTag));
					_log.info(salesAssociateTag + " "+salesAssociateTags.get(salesAssociateTag));
				}
				//tags.addAll(salesAssociateTags.keySet());
				//tags.addAll(salesAssociateTags.values());
			}*/

			//mandrillMessage.setTags(tags);
			// ... add more message details if you want to!
			// then ... send


			//Mandrill - end
			MandrillMessageStatus[] messageStatusReports;
			try {
				if(PortletProps.get("made.mailing.service").contains("sendgrid")){

					//add sales associate tags 
					/*if(salesAssociateTags != null){
						for(String salesAssociateTag : salesAssociateTags.keySet()){
							email.addCategory(salesAssociateTag);
							if(!salesAssociateTag.equals(salesAssociateTags.get(salesAssociateTag)))
								email.addCategory(salesAssociateTags.get(salesAssociateTag));
							_log.info(salesAssociateTag + " "+salesAssociateTags.get(salesAssociateTag));
						}
						//tags.addAll(salesAssociateTags.keySet());
						//tags.addAll(salesAssociateTags.values());
					}*/

					SendGrid.Response response = sendgrid.send(email);
					System.out.println(response.getMessage());
				}else if(PortletProps.get("made.mailing.service").contains("mandrill")){
					try{
						messageStatusReports = mandrillApi
								.messages().send(mandrillMessage, false);
						System.out.println("Mandrill mail send successfully.");
					}catch(Exception e){
						_log.error(e.getMessage());
						/*messageStatusReports = mandrillApi
								.messages().send(mandrillMessage, false);
						System.out.println("Mandrill mail send successfully.");*/
					}
				}

			}
			catch (SendGridException e) {
				System.err.println(e);
			}


			//Ends

		} catch (Exception e) {
			_log.warn(e.getMessage());

		}
	}
}