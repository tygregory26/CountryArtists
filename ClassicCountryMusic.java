/**
 * 
 * @author tygregory
 *
 */
public class ClassicCountryMusic extends CountryMusic {
	private int yearReleased;
	private String artist;

	/**
	 * no arg constructor
	 */
	public ClassicCountryMusic() {

	}

	/**
	 * Creates a new ClassicCountryMusic object with the given name, popularity,
	 * year of release, and artist.
	 * 
	 * @param name         the name of the classic country music
	 * @param popularity   the popularity of the classic country music, as an
	 *                     integer
	 * @param yearReleased the year the classic country music was released, as an
	 *                     integer
	 * @param artist       the artist who performed the classic country music
	 */
	public ClassicCountryMusic(String name, int popularity, int yearReleased, String artist) {
		super();
		this.yearReleased = yearReleased;
		this.artist = artist;
	}

	/**
	 * Returns the year the classic country music was released.
	 * 
	 * @return the year the classic country music was released, as an integer
	 */
	public int getYearReleased() {
		return this.yearReleased;
	}

	/**
	 * Returns the artist who performed the classic country music.
	 * 
	 * @return the artist who performed the classic country music
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Plays the classic country music.
	 */
	public void playMusic() {
		System.out.println("Playing " + this.getName() + " by " + this.artist + "...");
	}

	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a string representation of the classic country music.
	 * 
	 * @return a string representation of the classic country music
	 */
	public String toString() {
		return super.toString() + " (released: " + this.yearReleased + ", artist: " + this.artist + ")";
	}
}
