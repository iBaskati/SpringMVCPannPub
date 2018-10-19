package validationPack;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import formErrors.FormAddOfferErrors;
import models.Offer;

public class FileOperatAndValidat {

	private static boolean didTheUserEnterFile(HttpServletRequest request, String fileNameInForm, Offer offer) throws Exception {
		Part part;
		String fileName;
		InputStream fileContent;
		try {
			part = request.getPart(fileNameInForm);
			fileName = getFileName(part);
		} 
		catch ( IllegalStateException e ) {
			throw new Exception("Please choose a smaller file !");
		}
		catch (IOException | ServletException e) {
			throw new Exception("Error while trying to load the file, Try again !");
		}
		
		if(fileName == null) {
			throw new Exception("Error while trying to load the file !");
		}
		
		// is the file empty ?? 
		fileContent = part.getInputStream();
		if(theFileIsEmpty(fileContent)) {
			throw new Exception("Please choose a file !");
		}
		
		// so far offer.imageString is null, so ... 
		offer.setImageString(fileName);
		changeFileName(offer);
		
		return true;
	}
	
	
	
	private static boolean theFileIsEmpty(InputStream fileContent) {
		if(fileContent == null)		return true;
		return false;
	}



	private static void changeFileName(Offer offer) {
//		String[] partsOfName = offer.getImageString().split("\\."); // extract extension ! 
		String newName = "";
		newName += offer.getImageString().hashCode();
//		try{
//			newName += "."+partsOfName[1]; // add extension of the image !!
//		}
//		catch(Exception ignore) {} 
		offer.setImageString(newName);
	}
	
	
	
	private static String getFileName (Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				String fileName = contentDisposition.substring(contentDisposition.indexOf('=') + 1); // this may be the file name or whole path
				// extract file name
				fileName = fileName.substring(fileName.lastIndexOf( '/' ) + 1 ).substring( fileName.lastIndexOf( '\\' ) +1 );
				return fileName;
			}
		}
		return null;
	}



	public static boolean validateImage(HttpServletRequest request, String fileNameInForm , FormAddOfferErrors formAddOfferErrors, Offer offer) {
		try {
			return didTheUserEnterFile(request,fileNameInForm, offer);
		} catch (Exception e) { 
			formAddOfferErrors.setErrorImage(e.getMessage());
			return false;
		}
	}
}
