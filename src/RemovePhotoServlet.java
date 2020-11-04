

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemovePhotoServlet
 */
@WebServlet("/RemovePhotoServlet")
public class RemovePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexString = request.getParameter("photo");
		int index = (new Integer(indexString.trim())).intValue();
		PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(request.getSession());
		pa.removePhoto(index);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAlbumServlet");
		rd.forward(request, response);
	}


}
