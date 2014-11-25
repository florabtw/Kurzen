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

	@Id
	private int id;

	@Column(unique = true)
	private String original;

	@Column(unique = true)
	private String shortened;

	public UrlMapping() {
	}

	public UrlMapping(String original, String shortened) {
		this.original = original;
		this.shortened = shortened;
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