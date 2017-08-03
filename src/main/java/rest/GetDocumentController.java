package rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mail.EmailServiceImpl;
import manager.UserManager;
import model.User;
import pdf.CreatePDF;

@RestController
public class GetDocumentController {

	private static final String template = "emil: %s , doc format: %s , filter:  %s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	protected UserManager userManager;

	@Autowired
	public SimpleMailMessage templatelEmail;

	@Autowired
	protected EmailServiceImpl emailServiceImpl;

	@RequestMapping("/get_document/") // http://localhost:8080/get_document/?email=ivan.gainutsa@right-road.com&doc_format=doc&filter=2017-01-01
	public GetDocument getdocument(@RequestParam(value = "email", required = false, defaultValue = "email") String email, @RequestParam(value = "doc_format", required = false, defaultValue = "doc_format") String doc_format,
			@RequestParam(value = "filter", required = false, defaultValue = "filter") String filter) {

		User user = userManager.getUser(2);
		String userInfo;

		userInfo = "user Id: " + user.getId() + "\n";
		userInfo += "user name: " + user.getUserName() + "\n";
		userInfo += "user group: " + user.getUserGroupId().getGroupName() + "\n";
		userInfo += "user location: " + user.getLocationId().getLocationName() + "\n";
		userInfo += "user country: " + user.getLocationId().getCountry().getCountryName() + "\n";
		userInfo += "email : " + email + "\n";
		userInfo += "doc_format : " + doc_format + "\n";
		userInfo += "filter : " + filter + "\n";

		CreatePDF createPDF = new CreatePDF();
		createPDF.createUserInfo(userInfo);
		// System.out.println(userInfo);

		String text = String.format(templatelEmail.getText(), email);
		emailServiceImpl.sendMessageWithAttachment(email, "You are greeted by the company google.com", text, createPDF.FILE_NAME);

		return new GetDocument(counter.incrementAndGet(), String.format(template, email, doc_format, filter));
	}

}
