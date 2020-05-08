package api;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.JSONStringer;

import modelo.bean.Comic;
import modelo.dao.ModeloComic;

public class ApiComics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApiComics() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModeloComic modeloComic = new ModeloComic();
		ArrayList<Comic> comics = modeloComic.selectAll();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");

		String jsonString = JSONStringer.valueToString(comics);

		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}