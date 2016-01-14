package cn.cqut.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cqut.edu.ArrayToHtml;
import cn.cqut.edu.Chessboard;

public class ChessBoardServlet extends HttpServlet {


	public ChessBoardServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try{
			int k = Integer.parseInt(request.getParameter("k"));
			int row = Integer.parseInt(request.getParameter("row"));
			int col = Integer.parseInt(request.getParameter("col"));
			Chessboard cb = new Chessboard(k, row, col);
			int[][] arr = cb.getBoard();
			ArrayToHtml ath = new ArrayToHtml();
			String result = ath.parse(arr);
			out.print(result);
		}catch (Exception e) {
			out.println("the parms you enter have some wrong please change it");
			out.print("Error : "+e.getMessage());
		}
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		//สนำร out.printf

		
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
