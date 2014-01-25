package com.kitsunebi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletContext;


/**
 * Servlet implementation class Gallery
 */

@WebServlet("/gallery")
public class Gallery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Integer imgCount = 0;
	private static ArrayList<String> imgs = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gallery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //out.println("Hello World");
        //out.println(new File("/").list()[1]);
        if (imgs.isEmpty())
        	addImgs(request);
        
        try
        {
        	imgCount = Integer.parseInt(request.getParameter("i"));
        }
        catch (Exception e)
        {
        	imgCount = 0;
        }
        
        if (imgCount < 0)
        	imgCount = 0;
        else if (imgCount >= imgs.size())
        	imgCount = imgs.size() -1;
        
        //out.println( new Integer(imgs.size()).toString());
        //out.println("<br>" + imgs.isEmpty());
        //out.println(new Integer(imgCount).toString());
        
        if (!imgs.isEmpty())
        {
        	//out.println("<br>" + imgs.get(imgCount));
        	request.setAttribute("imgCount", imgCount);
        	request.setAttribute("img", imgs.get(imgCount));
        	if (request.getAttribute("imgDir") == "Right")
        	{
        		imgCount++;
        	}
        	else if (request.getAttribute("imgDir") == "Left")
        	{
        		imgCount--;
        	}
        	
        }
	}

	private void addImgs (HttpServletRequest request) throws ServletException, IOException {
		ServletContext servletContext = request.getServletContext();
        String files[] = new File(servletContext.getRealPath("/img/")).list();
        
        for (String file : files)
        {
        	if(file.endsWith(".jpg") || file.endsWith(".JPG") || file.endsWith(".jpeg") || file.endsWith(".JPEG") || file.endsWith(".gif") || file.endsWith(".GIF")
        			 || file.endsWith(".png") || file.endsWith(".PNG") || file.endsWith(".bmp") || file.endsWith(".BMP"))
        		imgs.add(file);
        }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
