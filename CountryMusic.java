import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * @author tygregory
 *
 */
public class CountryMusic {
	private String artist;
	private double popularity;
	private Picture photo;
	private Sound audio;

	/**
	 * no arg constructor
	 */
	public CountryMusic() {
	}

	/**
	 * 
	 * @param artist
	 * @param popularity
	 * @param photo
	 * @param audio
	 */
	public CountryMusic(String artist, int popularity, Picture photo, Sound audio) {
		this.setArtist(artist);
		this.setPopularity(popularity);
		this.setPhoto(photo);
		this.setAudio(audio);
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the popularity
	 */
	public Double getPopularity() {
		return popularity;
	}

	/**
	 * 
	 * @param popularity
	 */
	public void setPopularity(double popularity) {
		if (popularity > 10)
			popularity = 10;
		else if (popularity < 0)
			popularity = 0;
		else
			this.popularity = popularity;
	}

	/**
	 * @return the photo
	 */
	public Picture getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Picture photo) {
		this.photo = photo;
	}

	/**
	 * @return the audio
	 */
	public Sound getAudio() {
		return audio;
	}

	/**
	 * @param audio the audio to set
	 */
	public void setAudio(Sound audio) {
		this.audio = audio;
	}

	/**
	 * 
	 * @param c
	 * @param fontSize
	 * @return
	 */
	public Picture labelImage(Color c, int fontSize) {
		Picture temp = photo;
		Graphics g = temp.getGraphics();
		g.setColor(c);
		g.setFont(new Font("Arial", Font.BOLD, fontSize));

		g.drawString(artist, 25, 75);
		return temp;
	}

	@Override
	public String toString() {
		return "CountryMusic [artist=" + artist + ", popularity=" + popularity + ", photo=" + photo + ", audio=" + audio
				+ "]";
	}
}
