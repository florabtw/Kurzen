package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class UrlMapping extends Model {

	public static Finder<String, UrlMapping> find = new Finder<String, UrlMapping>(
			String.class, UrlMapping.class);

	public static UrlMapping getByOriginalUrl(String url) {
		// TODO implement
		return null;
	}

	@Id
	private int id;

	@Column(unique = true)
	private String original;

	@Column(unique = true)
	private String shortened;

	public UrlMapping() {
	}

	public UrlMapping(String original) {
		this.original = original;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getShortened() {
		return shortened;
	}

	public void setShortened(String shortened) {
		this.shortened = shortened;
	}
}