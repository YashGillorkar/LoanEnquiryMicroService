package com.cjc.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cjc.exception.IDNotPresentException;
import com.cjc.exception.InvaildAgeException;
import com.cjc.exception.InvalidAlternateMobileNumberException;
import com.cjc.exception.InvalidEmailIdException;
import com.cjc.exception.InvalidFristNameException;
import com.cjc.exception.InvalidIdException;
import com.cjc.exception.InvalidLastNameException;
import com.cjc.exception.InvalidMiddleNameException;
import com.cjc.exception.InvalidMobileNumberException;
import com.cjc.exception.InvalidPANnumberException;
import com.cjc.model.CibilDetails;
import com.cjc.model.EnquiryDetails;
import com.cjc.repository.EnquiryDetailsRepository;
import com.cjc.serviceI.EnquiryDetailServiceI;

@Service
public class EnquiryDetailsImpl implements EnquiryDetailServiceI {

	@Autowired
	EnquiryDetailsRepository enquiryDetailsRepository;
	
	@Autowired RestTemplate rt;

	@Autowired 
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private static String from_email;

	private static final String PAN_PATTERN = "^[A-Z]{5}[0-9]{4}[A-Z]$";
	private static final String MOBILE_PATTERN = "[7-9][0-9]{9}";

	Random ramdom = new Random();
	String customId = "ENQ";


	@Override
	public void saveEnquiry(EnquiryDetails enquiry) {
		
		String url= "http://localhost:2222/sendCibilDetails";
		CibilDetails cd =  rt.getForObject(url, CibilDetails.class);
		
		int nextInt = ramdom.nextInt(100, 999);
		String newId = customId + nextInt;
		enquiry.setEnquiry_Id(newId);

		if (!enquiry.getFirst_Name().matches("[a-zA-Z]+")) {
			throw new InvalidFristNameException("Frist Name should not contain number or special symol or space");
		}
		if (!enquiry.getMiddle_Name().matches("[a-zA-Z]+")) {
			throw new InvalidMiddleNameException("Middle Name should not contain number or special symol or space");
		}
		if (!enquiry.getLast_Name().matches("[a-zA-Z]+")) {
			throw new InvalidLastNameException("Last Name should not contain number or special symol or space");
		}

		if (!(enquiry.getApplicant_EmailId().endsWith("@gmail.com"))) {
			throw new InvalidEmailIdException("Email id should not contain space and should ends with @gmail.com");
		}else {
			sendCibilReport(enquiry , cd);

		}

		int age = enquiry.getAge();
		if (!(age >= 21 && age <= 75)) {
			throw new InvaildAgeException("Age should be between 21 and 75");
		}

		if (!(Pattern.matches(PAN_PATTERN, enquiry.getPanCardNumber()))) {
			throw new InvalidPANnumberException("Please Enter a valid PAN number");
		}

		String mobileNumberStr = Long.toString(enquiry.getContact_Number());
		if (!Pattern.matches(MOBILE_PATTERN, mobileNumberStr)) {
			throw new InvalidMobileNumberException("Please Enter a valid mobile number");
		}

		String AlternatemobileNumberStr = Long.toString(enquiry.getContact_Number());
		if (!Pattern.matches(MOBILE_PATTERN, AlternatemobileNumberStr)) {
			throw new InvalidAlternateMobileNumberException("Please Enter a valid mobile number");
		}

		enquiry.setCibilDetails(cd);

		enquiryDetailsRepository.save(enquiry);
	}

	

	public List<EnquiryDetails> getAllEnquiries() {
		return enquiryDetailsRepository.findAll();

	}

	@Override
	public void deleteEnquiryData() {

		enquiryDetailsRepository.deleteAll();

	}

	@Override
	public void deleteOne(String id) {
		enquiryDetailsRepository.deleteById(id);
	}

	@Override

	public EnquiryDetails getSingleData(String enquiry_Id) {
		Optional<EnquiryDetails> list = enquiryDetailsRepository.findById(enquiry_Id);
		if (list.isPresent()) {
			EnquiryDetails s = list.get();
			return s;

		} else {
			throw new InvalidIdException("Id Not Present");
		}
	}

	public void updateById(String enquiryId, EnquiryDetails ed) {
		Optional<EnquiryDetails> optionalEnquiryDetails = enquiryDetailsRepository.findById(enquiryId);

		if (optionalEnquiryDetails.isPresent()) {
			EnquiryDetails existingEnquiryDetails = optionalEnquiryDetails.get();

			existingEnquiryDetails.setFirst_Name(ed.getFirst_Name());
			existingEnquiryDetails.setMiddle_Name(ed.getMiddle_Name());
			existingEnquiryDetails.setLast_Name(ed.getLast_Name());
			existingEnquiryDetails.setApplicant_EmailId(ed.getApplicant_EmailId());
			existingEnquiryDetails.setContact_Number(ed.getContact_Number());
			existingEnquiryDetails.setAlternateContactNumber(ed.getAlternateContactNumber());
			existingEnquiryDetails.setAge(ed.getAge());

			enquiryDetailsRepository.save(existingEnquiryDetails);
		} else {
			throw new IDNotPresentException("The given ID is not present");
		}
	}

	public void updateByid(String enquiry_Id, EnquiryDetails ed) {
		Optional<EnquiryDetails> checkIdPresent = enquiryDetailsRepository.findById(enquiry_Id);

		if (checkIdPresent.isPresent()) {
			enquiryDetailsRepository.save(ed);
		} else {
			throw new IDNotPresentException("The Given ID is not present");
		}

	}

	

	public void sendCibilReport(EnquiryDetails enquiry,CibilDetails cd) {
		
		SimpleMailMessage simpleMail=new SimpleMailMessage();
		simpleMail.setTo(enquiry.getApplicant_EmailId());
		simpleMail.setFrom(from_email);
		simpleMail.setSubject("Regarding your CIBIL Application");
		simpleMail.setText("\r\n"
				+ "We are delighted to inform you that your car loan enquiry has been successfully processed, and you are eligible for the loan!\r\n"
				+ "\r\n"
				+ "Enquiry ID: "+enquiry.getEnquiry_Id()+"\r\n"
				+ "Cibil Score: "+cd.getCibil_score()+"\r\n"
				+ "\r\n"
				+ "After a thorough review of your application, we are pleased to inform you that your credit profile meets our eligibility criteria, and you have been approved for the car loan. Congratulations on this significant milestone!\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Please feel free to reach out to us if you have any questions or need further clarification regarding the loan terms and conditions. We are here to ensure a smooth and seamless experience for you.\r\n"
				+ "\r\n"
				+ "Once again, congratulations on your loan approval! We look forward to assisting you in driving home your dream car.\r\n"
				+ "Best Regards.");
		sender.send(simpleMail);
	}

}
