package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.main;

public class Kurzen extends Controller {

	public static Result index() {
		return ok(main.render(null));
	}

	public static Result create() {
		DynamicForm requestData = Form.form().bindFromRequest();
		String url = requestData.get("url");
		return ok(url);
	}

}
