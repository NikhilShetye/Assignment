package com.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
	        try {
	        List<FileItem> fileItems=sf.parseRequest(request);

	        for(FileItem item:fileItems){
	        	File f = new File(item.getName());
	        	System.out.println(f.getName());
	        item.write(new File("F:\\nikhil\\projects\\Assignment\\fileupload\\"+f.getName()));
	        }
	        
			
	        
	        System.out.println("File Uploaded");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
