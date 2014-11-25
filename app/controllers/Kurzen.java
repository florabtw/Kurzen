package controllers;

import models.UrlMapping;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.main;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Kurzen extends Controller {

	public static Result index() {
		return ok(main.render());
	}

	public static Result create() {
		DynamicForm requestData = Form.form().bindFromRequest();
		String url = requestData.get("url");

		UrlMapping mapping = UrlMapping.getByOriginalUrl(url);

		if (mapping == null) {
			mapping = new UrlMapping(url);
			mapping.save();
		}

		String shortenedUrl = request().host() + "/" + mapping.getShortened();

		ObjectNode result = Json.newObject();
		result.put("url", shortenedUrl);

		return ok(result);
	}

	public static Result redirectWith(String key) {
		UrlMapping mapping = UrlMapping.getByShortenedUrl(key);

		if (mapping == null) {
			return redirect(routes.Kurzen.index());
		} else {
			return redirect(mapping.getOriginal());
		}
	}
}
