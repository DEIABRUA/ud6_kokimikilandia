package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.json.JSONObject;

import modelo.bean.Comic;
import modelo.dao.ModeloComic;

public class ApiComic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApiComic() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ModeloComic modeloComic = new ModeloComic();
		Comic comic = modeloComic.select(id);

		JSONObject jsonObject = new JSONObject(comic);
		String jsonString = jsonObject.toString();

		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		out.print(jsonString);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
