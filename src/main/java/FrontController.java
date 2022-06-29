

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Monster;
import entity.Yuusha;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//勇者とモンスターを作成、アプリケーションスコープに入れる
		Yuusha y = new Yuusha("けいしん",50);
		Monster m = new Monster("スライム",50);
		//アプリケーションスコープの作成

		ServletContext application = this.getServletContext();
		application.setAttribute("yuusha", y);
		application.setAttribute("monster", m);

		RequestDispatcher rd = request.getRequestDispatcher("battle.jsp");
		rd.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ServletContext apl = this.getServletContext();
		Yuusha y = (Yuusha)apl.getAttribute("yuusha");
		Monster m = (Monster)apl.getAttribute("monster");
		int yhp = y.getHp();
		int mhp = m.getHp();
		response.setContentType("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("attack")) {
			y.attack(m);
			m.attack(y);

			int ydmg = yhp - y.getHp();
			int mdmg = mhp - m.getHp();

			apl.setAttribute("ydmg",ydmg);
			apl.setAttribute("mdmg",mdmg);
			
			if(y.getHp()<=0) {
				RequestDispatcher rd = request.getRequestDispatcher("loser.jsp");
				rd.forward(request,response);
			}else if(m.getHp()<=0) {
				RequestDispatcher rd = request.getRequestDispatcher("winner.jsp");
				rd.forward(request,response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("battle.jsp");
				rd.forward(request,response);
			}
		}
		
		
		
		
	}

}


