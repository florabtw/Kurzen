package models;

import helpers.Base62Encoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class UrlMapping extends Model {

	public static Finder<String, UrlMapping> find = new Finder<String, UrlMapping>(
			String.class, UrlMapping.class);

	public static UrlMapping reverseLookup(String url) {
		return find.where().eq("url", url).findUnique();
	}

	public static UrlMapping lookup(String key) {
		return find.where().eq("key", key).findUnique();
	}

	@Id
	private int id;

	@Column(unique = true)
	private String key;

	@Column(unique = true)
	private String url;

	public UrlMapping() {
	}

	public UrlMapping(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		if (key == null && id != 0) {
			key = Base62Encoder.encode(id);
			update();
		}

		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}