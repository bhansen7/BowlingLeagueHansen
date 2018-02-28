package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class deleteTeamServlet
 */
@WebServlet("/deleteTeamServlet")
public class deleteTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTeamServlet() {
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
		TeamHelper dao = new TeamHelper();
		String act = request.getParameter("doThisToItem");

		System.out.println("Act" + act);
		
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllTeamServlet").forward(request, response);
		} else if (act.equals("Delete Selected Team")) {
			System.out.println("In Delete Step");
			Integer tempId = Integer.parseInt(request.getParameter("teamId"));
			System.out.println("id" + tempId);
			Team teamToDelete = dao.searchForTeamById(tempId);
			dao.deleteTeam(teamToDelete);
			getServletContext().getRequestDispatcher("/viewAllTeamServlet").forward(request, response);
		}
	}

}
