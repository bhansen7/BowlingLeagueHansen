package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;


/**
 * Servlet implementation class deletePlayerServlet
 */
@WebServlet("/deletePlayerServlet")
public class deletePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerHelper dao = new PlayerHelper();
		String act = request.getParameter("doThisToItem");

		System.out.println("Act" + act);
		
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPlayerServlet").forward(request, response);
		} else if (act.equals("Delete Selected Player")) {
			System.out.println("In Delete Step");
			Integer tempId = Integer.parseInt(request.getParameter("playerId"));
			System.out.println("id" + tempId);
			Player playerToDelete = dao.searchForPlayerById(tempId);
			dao.deletePlayer(playerToDelete);
			getServletContext().getRequestDispatcher("/viewAllPlayerServlet").forward(request, response);
		}
	}

}