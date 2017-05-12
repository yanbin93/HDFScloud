package com.hdfscloud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdfscloud.util.HDFSDownload;

/**
 * Servlet implementation class DownloadFile
 */
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		String s_pageNow=request.getParameter("pageNow");
		String dirname=request.getParameter("dirname");
		String s_dirname=request.getParameter("filename");
		String isDir = request.getParameter("isDir").toString();
		String SrcPath = null;
		if(s_dirname!=null){
			//接收到了pageNow
			SrcPath=s_dirname;
			}
		String dstPath="/home/yanbin/桌面";
		HDFSDownload downfile=new HDFSDownload();
		if (isDir.equals("File")){
			dstPath=dstPath+SrcPath.split("/")[SrcPath.split("/").length-1];
		}
		boolean flag = downfile.downloadAll(SrcPath, dstPath);
		request.setAttribute("dirname", dirname);
		if (flag){request.setAttribute("message", "下载成功，文件存放在"+dstPath);}
		else{
			request.setAttribute("message", "下载失败");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
