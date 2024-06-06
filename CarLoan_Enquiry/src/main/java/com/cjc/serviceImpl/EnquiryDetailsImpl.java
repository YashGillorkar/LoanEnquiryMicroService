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

<<<<<<< HEAD
	 public void updateById(String enquiryId, EnquiryDetails ed) {
	        Optional<EnquiryDetails> optionalEnquiryDetails = enquiryDetailsRepository.findById(enquiryId);
=======
	public void updateById(String enquiryId, EnquiryDetails ed) {

		Optional<EnquiryDetails> optionalEnquiryDetails = enquiryDetailsRepository.findById(enquiryId);
>>>>>>> branch 'main' of https://github.com/YashGillorkar/LoanEnquiryMicroService.git

<<<<<<< HEAD
	        if (optionalEnquiryDetails.isPresent()) {
	            EnquiryDetails existingEnquiryDetails = optionalEnquiryDetails.get();
=======
		if (optionalEnquiryDetails.isPresent()) {
>>>>>>> branch 'main' of https://github.com/YashGillorkar/LoanEnquiryMicroService.git

<<<<<<< HEAD
	            if (ed.getFirst_Name() != null) {
	                existingEnquiryDetails.setFirst_Name(ed.getFirst_Name());
	            }
	            if (ed.getMiddle_Name() != null) {
	                existingEnquiryDetails.setMiddle_Name(ed.getMiddle_Name());
	            }
	            if (ed.getLast_Name() != null) {
	                existingEnquiryDetails.setLast_Name(ed.getLast_Name());
	            }
	            if (ed.getApplicant_EmailId() != null) {
	                existingEnquiryDetails.setApplicant_EmailId(ed.getApplicant_EmailId());
	            }
	            if (ed.getContact_Number() != 0) {  // Assuming 0 is not a valid contact number
	                existingEnquiryDetails.setContact_Number(ed.getContact_Number());
	            }
	            if (ed.getAlternateContactNumber() != 0) {  // Assuming 0 is not a valid contact number
	                existingEnquiryDetails.setAlternateContactNumber(ed.getAlternateContactNumber());
	            }
	            if (ed.getAge() != 0) {  // Assuming 0 is not a valid age
	                existingEnquiryDetails.setAge(ed.getAge());
	            }
	            if (ed.getPanCardNumber() != null) {
	                existingEnquiryDetails.setPanCardNumber(ed.getPanCardNumber());
	            }
=======
			EnquiryDetails enquiryDetails = optionalEnquiryDetails.get();
>>>>>>> branch 'main' of https://github.com/YashGillorkar/LoanEnquiryMicroService.git

<<<<<<< HEAD
	            enquiryDetailsRepository.save(existingEnquiryDetails);
	        } else {
	            throw new IDNotPresentException("The given ID is not present");
	        }
	    }
=======
			// update field are Not null & Not Empty

			if (ed.getFirst_Name() != null && !ed.getFirst_Name().isEmpty()) {
				enquiryDetails.setFirst_Name(ed.getFirst_Name());
			}

			if (ed.getMiddle_Name() != null && !ed.getMiddle_Name().isEmpty()) {
				enquiryDetails.setMiddle_Name(ed.getMiddle_Name());
			}

			if (ed.getLast_Name() != null && !ed.getLast_Name().isEmpty()) {
				enquiryDetails.setLast_Name(ed.getLast_Name());
			}

			if (ed.getApplicant_EmailId() != null && !ed.getApplicant_EmailId().isEmpty()) {
				enquiryDetails.setApplicant_EmailId(ed.getApplicant_EmailId());
			}

			/*
			 * if (ed.getContact_Number() != null && !ed.getContact_Number().isEmpty()) {
			 * existingEnquiryDetails.setContact_Number(ed.getContact_Number()); }
			 * 
			 * if (ed.getAlternateContactNumber() != null &&
			 * !ed.getAlternateContactNumber().isEmpty()) {
			 * existingEnquiryDetails.setAlternateContactNumber(ed.getAlternateContactNumber
			 * ()); }
			 * 
			 * // Assuming age is an Integer and null is an acceptable "empty" state if
			 * (ed.getAge() != null) { existingEnquiryDetails.setAge(ed.getAge()); }
			 * 
			 */
			enquiryDetailsRepository.save(enquiryDetails);

		} else {
			throw new IDNotPresentException("The given ID is not present");
		}
	}

	/*
	 * public void updateById(String enquiryId, EnquiryDetails ed) {
	 * Optional<EnquiryDetails> optionalEnquiryDetails =
	 * enquiryDetailsRepository.findById(enquiryId);
	 * 
	 * if (optionalEnquiryDetails.isPresent()) { EnquiryDetails
	 * existingEnquiryDetails = optionalEnquiryDetails.get();
	 * 
	 * existingEnquiryDetails.setFirst_Name(ed.getFirst_Name());
	 * existingEnquiryDetails.setMiddle_Name(ed.getMiddle_Name());
	 * existingEnquiryDetails.setLast_Name(ed.getLast_Name());
	 * existingEnquiryDetails.setApplicant_EmailId(ed.getApplicant_EmailId());
	 * existingEnquiryDetails.setContact_Number(ed.getContact_Number());
	 * existingEnquiryDetails.setAlternateContactNumber(ed.getAlternateContactNumber
	 * ()); existingEnquiryDetails.setAge(ed.getAge());
	 * 
	 * enquiryDetailsRepository.save(existingEnquiryDetails); } else { throw new
	 * IDNotPresentException("The given ID is not present"); } }
	 * 
	 * public void updateByid(String enquiry_Id, EnquiryDetails ed) {
	 * Optional<EnquiryDetails> checkIdPresent =
	 * enquiryDetailsRepository.findById(enquiry_Id);
	 * 
	 * if (checkIdPresent.isPresent()) { enquiryDetailsRepository.save(ed); } else {
	 * throw new IDNotPresentException("The Given ID is not present"); }
	 * 
	 * }
	 */

	
>>>>>>> branch 'main' of https://github.com/YashGillorkar/LoanEnquiryMicroService.git

	public void sendCibilReport(EnquiryDetails enquiry,CibilDetails cd) {
		
		SimpleMailMessage simpleMail=new SimpleMailMessage();
		simpleMail.setTo(enquiry.getApplicant_EmailId());
		simpleMail.setFrom(from_email);
		simpleMail.setSubject("Regarding your CIBIL Application");
		if(cd.getCibil_score()>= 550) {
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
		}else {
			simpleMail.setText("\r\n"
					+ "We are delighted to inform you that your car loan enquiry has been successfully processed, and you are eligible for the loan!\r\n"
					+ "\r\n"
					+ "Enquiry ID: "+enquiry.getEnquiry_Id()+"\r\n"
					+ "Cibil Score: "+cd.getCibil_score()+"\r\n"
					+ "\r\n"
					+ "We regret to inform you that, based on your current Cibil score, you are not eligible for a car loan at this time..\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "Please feel free to reach out to us if you have any questions or need further clarification regarding the loan terms and conditions. We are here to ensure a smooth and seamless experience for you.\r\n"
					+ "\r\n"
					+ "Thank you for considering our services. We hope to have the opportunity to assist you in the future.\r\n"
					+ "Best Regards.");
		}
		sender.send(simpleMail);
	}

}
