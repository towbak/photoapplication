import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayPhotoServlet
 */
@WebServlet("/DisplayPhotoServlet")
public class DisplayPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			                 throws ServletException, IOException {
		String indexString = request.getParameter("photo");
		int index = (new Integer(indexString.trim())).intValue();
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		try {
			HttpSession session = 
					request.getSession();
			PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(session);
			byte[] bytes = pa.getPhotoData(index);
			for (int i = 0; i < bytes.length; i++) {
				out.write(bytes[i]);
			}
		} finally {
			out.close();
		}
	}

}
