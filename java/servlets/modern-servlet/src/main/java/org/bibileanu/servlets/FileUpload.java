package org.bibileanu.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

class FileOnDisk {
	String fileName;
	File fHandle;
	String path;
	long size;
	String sha1;
	long dateModified;
	
	public FileOnDisk(File f) {
		this.fHandle = f;
		this.fileName = f.getName();
		size = f.length();
		dateModified = f.lastModified();
	}
}

@MultipartConfig
public class FileUpload extends HttpServlet {
	public static final String FILE_INPUT_FIELD_NAME = "filetoupload";
	public static final String FILE_ID_PARAM_NAME = "id";
	
	public void printFormAndResult(PrintWriter out, HttpServletRequest req, ArrayList<FileOnDisk> files) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>" + "\n");
		sb.append("<html>" + "\n");
		sb.append("    <head>" + "\n");
		sb.append("        <title>\n");
		sb.append("        File upload\n");
		sb.append("		   </title>\n");
		sb.append("    </head>" + "\n");
		sb.append("    <body>" + "\n");
		sb.append("        <form action=\"/fileupload\" method=\"POST\" enctype=\"multipart/form-data\">" + "\n");
		sb.append("            <input type=\"file\" name=\"" + FILE_INPUT_FIELD_NAME + "\" />" + "\n");
		sb.append("            <input type=\"submit\" value=\"Upload file\" name=\"mySubmit\" />" + "\n");
		sb.append("        </form>\n");
		sb.append("        <table border=\"1\">\n");
		sb.append("            <tr>\n");
		sb.append("                <th>\n");
		sb.append("                    File Name\n");
		sb.append("                </th>\n");
		sb.append("                <th>\n");
		sb.append("                    Size\n");
		sb.append("                </th>\n");
		sb.append("                <th>\n");
		sb.append("                    Date Modified\n");
		sb.append("                </th>\n");
		sb.append("            </tr>\n");

		int id = 0;
		for (FileOnDisk f : files) {
			sb.append("            <tr>\n");
			sb.append("                <td>\n");
			sb.append("                    <a href=\"/fileupload?id=" + id + "\" target=\"_blank\">" + f.fileName + "</a>");
			sb.append("\n                </td>\n");

			sb.append("                <td>\n");
			sb.append("                    " + f.size);
			sb.append("\n                </td>\n");

			sb.append("                <td>\n");
			sb.append("                    " + f.dateModified);
			sb.append("\n                </td>\n");
			sb.append("            </tr>\n");

			/*
			sb.append("                <td>");
			sb.append("                    " + f.sha1);
			sb.append("                </td>");
			*/
			id++;
		}

		sb.append("        </table>\n");
		sb.append("");
		sb.append("");
		sb.append("    </body>\n");
		sb.append("</html>\n");
		out.print(sb.toString());
	}
	
	public ArrayList<FileOnDisk> listDir(String path) {
		ArrayList<FileOnDisk> res = new ArrayList<FileOnDisk>();
		File dir = new File(path);
		if (dir.isDirectory())  {
			File[] files = dir.listFiles();
			for (File f : files) {
				res.add(new FileOnDisk(f));
			}
		}
		return res;
	}
	
	public void receiveUploadedFile(HttpServletRequest req) throws ServletException, IOException {
		Part filePart = req.getPart(FILE_INPUT_FIELD_NAME);
		String fileName = filePart.getSubmittedFileName();
		filePart.write(fileName);
	}
	
	public void printNoFileFound(int id, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.printf("No file with id (%d) found!", id);
	}
	
	public void downloadFile(int fileId, HttpServletResponse resp, ArrayList<FileOnDisk> files) throws IOException {
		FileOnDisk fileToDownload = null;
		try {
			fileToDownload = files.get(fileId);
		} catch (Exception e) {
			printNoFileFound(fileId, resp);
			return;
		}

		OutputStream out = resp.getOutputStream();
		FileInputStream fin = new FileInputStream(fileToDownload.fHandle.getAbsolutePath());
		
		byte[] buffer = new byte[4096];
		int length;
		while ((length = fin.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		fin.close();
		out.flush();
	}
	
	public int getFileId(HttpServletRequest req) {
		String strFileId = req.getParameter(FILE_ID_PARAM_NAME);
		int fileId = -1;
		if (strFileId != null) {
			try {
				fileId = Integer.parseInt(strFileId, 10);
			} catch (Exception e) {
				// do nothing
			}
		}
		return fileId;
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<FileOnDisk> files = listDir(getFilePath());

		int fileId = getFileId(req);
		if (fileId != -1) {
			downloadFile(fileId, resp, files);
			return;
		}

		PrintWriter out = resp.getWriter();
		printFormAndResult(out, req, files);
	}
	
	public String getFilePath() {
		File tmpDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
		return tmpDir.getAbsolutePath();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		receiveUploadedFile(req);
		PrintWriter out = resp.getWriter();
		ArrayList<FileOnDisk> files = listDir(getFilePath());
		printFormAndResult(out, req, files);
	}
}
