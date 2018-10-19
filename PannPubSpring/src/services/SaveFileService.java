package services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import formErrors.FormAddOfferErrors;
import models.Offer;

public class SaveFileService {
	
	private static final Integer MAX_SIZE = 10240;
	private static final String PATH = "E:\\ug\\Documents\\Images\\";

	private SaveFileService() {

	}
	
	
	public static void saveFile(String fileNameInForm, Offer offer, HttpServletRequest request, FormAddOfferErrors formAddOfferErrors) throws IOException, ServletException {
		Part part = request.getPart(fileNameInForm);
		writeFile(part,offer.getImageString(), PATH);
	}

	

	private static void writeFile(Part part, String fileName, String path) throws IOException {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(part.getInputStream(), MAX_SIZE);
			System.out.println("done 1");
			out = new BufferedOutputStream(new FileOutputStream(new File(path + fileName)), MAX_SIZE);
			System.out.println("done 2");
			byte[] buffer = new byte[MAX_SIZE];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			System.out.println("ALL DONE .... end of loading the file :) ");
		} 
		catch(Exception e ){
			e.printStackTrace();
		}
		finally {
			try {
				out.close();
			} 
			catch (IOException ignore) { }
			try {
				in.close();
			} catch (IOException ignore) {}
		}
	}
	
	
	
	
	
	
	

}
