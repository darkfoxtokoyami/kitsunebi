package com.kitsunebi.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class GalleryPost
 */
@WebServlet("/gallery/post")
@MultipartConfig
public class GalleryPost extends HttpServlet {
	private static final String FORM_FIELD_NAME = "image";
	private static final String REDIRECT_SUCCESS = "../gallery";
	private static final String REDIRECT_FAIL = "../";
	private static final String OUTPUT_DIR = "/img/";
	private static final String DIRECTORY_DELIMITER = "\\"; //
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart(FORM_FIELD_NAME);
		String fileName = getFileName(filePart);
		
		if (writeFile(fileName,request.getServletContext().getRealPath(OUTPUT_DIR),  filePart))
		{
			response.sendRedirect(REDIRECT_SUCCESS);
		}
		else
		{
			response.sendRedirect(REDIRECT_FAIL);
		}
	}
	
	protected static Boolean writeFile(String fileName, String filePath, Part filePart) throws ServletException, IOException {
		InputStream fileContent = null;
		OutputStream fileOut = new FileOutputStream(new File(filePath + DIRECTORY_DELIMITER + fileName));
		int fileReadLength;
		byte[] fileData = new byte[1024];
		Boolean returnValue = false;
		
		try
		{
			fileContent = filePart.getInputStream();
			while ((fileReadLength=fileContent.read(fileData)) != -1)
			{
				fileOut.write(fileData, 0, fileReadLength);
			}
			
			System.out.println("Wrote file: " + filePath + DIRECTORY_DELIMITER + fileName);
			returnValue = true;
		}
		catch (IOException ioe) 
		{
			//Failure goes here
		}
		finally
		{
			fileContent.close();
			fileOut.close();
		}
		
		return returnValue; //Successfully wrote file
	}
	
	//Parses out the image name from the Part.getHeader("content-disposition") header. 
	protected static String getFileName(Part part) {
		//System.out.println(part.getHeader("content-disposition"));	//form-data; name="image"; filename="IMG.ext"
		
		//Parses out IMG.ext from content-disposition header.
		String fileName = "";
		for(String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				fileName = contentDisposition.substring(contentDisposition.indexOf("=") + 1).trim().replace("\"", "");
				return fileName;
			}
		}
		return "";
	}

}
