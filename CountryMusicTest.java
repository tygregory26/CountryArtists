import java.awt.Color;
import java.util.Scanner;

/**
 * @author tygregory
 *
 */
public class CountryMusicTest {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CountryMusic[] playlist = new CountryMusic[6];
		buildInventory(playlist);
		showMenu(playlist);
	}

	/**
	 * 
	 * @param playlist
	 */
	public static void buildInventory(CountryMusic[] playlist) {
		Scanner scnr = new Scanner(System.in);
		playlist[0] = new CountryMusic("Luke Bryan", 7, new Picture("LukeBryan.png"), new Sound("DrumRoll.wav"));
		playlist[1] = new CountryMusic("Carrie Underwood", 9, new Picture("CarrieUnderwood.png"),
				new Sound("Piano.wav"));
		playlist[2] = new ModernCountryMusic("Luke Bryan", 7, new Picture("LukeBryan.png"), new Sound("DrumRoll.wav"),
				true, 9);
		playlist[3] = new ModernCountryMusic("Carrie Underwood", 9, new Picture("CarrieUnderwood.png"),
				new Sound("Piano.wav"), false, 12);
		playlist[4] = new CountryMusic();
		ModernCountryMusic m1 = new ModernCountryMusic();
		System.out.println(
				"What is a Country artist, that is modern in our current generation that you would like to use?");
		String temp = scnr.nextLine();
		m1.setArtist(temp);
		System.out.println("What is the popularity on a scale of 1-10 of the modern country artist?");
		int temp2 = scnr.nextInt();
		m1.setPopularity(temp2);
		m1.setPhoto(new Picture("ThomasRhett.png"));
		m1.setAudio(new Sound("Banjo.wav"));
		m1.setAutoTune(true);
		m1.setNumFeaturedArtists(7);
		playlist[5] = m1;
		System.out.println("What is a country music arist you would like to use?");
		scnr.nextLine();
		String temp1 = scnr.nextLine();
		playlist[4].setArtist(temp1);

		System.out.println("What is the popularity on a scale from 1-10 of the country artist?");
		int temp3 = scnr.nextInt();
		playlist[4].setPopularity(temp3);
		playlist[4].setPhoto(new Picture("JohnnyCash.png"));
		playlist[4].setAudio(new Sound("Guitar.wav"));
	}

	/**
	 * 
	 * @param playlist
	 */
	public static void showMenu(CountryMusic[] playlist) {
		Scanner scnr = new Scanner(System.in);
		int menuOptions;
		menuOptions = 0;
		while (menuOptions != 7) {
			System.out.println("Select an option:");
			System.out.println("1.) Search for an artist");
			System.out.println("2.) Display artists");
			System.out.println("3.) Listen to what the artists play");
			System.out.println("4.) Display the most popular artist");
			System.out.println("5.) Display images of the artists");
			System.out.println("6.) 3 additonal options");
			System.out.println("7.) Exit");
			menuOptions = scnr.nextInt();
			switch (menuOptions) {
			case (1):
				System.out.println("You selection option 1.): Search for an artist");
				System.out.println("Search the artist you are looking for:");
				scnr.nextLine();
				String target = scnr.nextLine();
				int index = linearFind(target, playlist);
				if (index != 99) {
					System.out.println("Artist found!");
					while (menuOptions != 4) {
						System.out.println("Select an option:");
						System.out.println("1.) View an image of the artist");
						System.out.println("2.) Listen to what instrument the artist plays");
						System.out.println("3.) View the artist's popularity");
						System.out.println("4.) Exit");
						menuOptions = scnr.nextInt();
						switch (menuOptions) {
						case (1):
							System.out.println("You selected option 1:) View an image of the artist");
							playlist[index].getPhoto().show();
							break;
						case (2):
							System.out.println("You selected option 2:) Listen to what instrument the artist plays");
							playlist[index].getAudio().play();
							break;
						case (3):
							System.out.println("You selected options 3:) View the artist's popularity");
							System.out.println(playlist[index].getPopularity());
							break;
						case (4):
							System.out.println("You selected option 4:) Exit");
							System.out.println("Now returning to the main menu");
							break;
						default:
							System.out.println("Please rechoose from the following options with a valid entry.");
							break;
						}

					}
				} else
					System.out.println("Artist not found");
				break;
			case (2):
				System.out.println("You selected option 2:) Display artists");

				for (CountryMusic playlists : playlist) {
					System.out.println(playlists.toString());
				}
				break;
			case (3):
				System.out.println("You selected option 3: Listen to what the artists play");
				int i = 0;
				while (i < playlist.length) {
					Sound sound = playlist[i].getAudio();
					sound.blockingPlay();
					i++;
				}
				break;
			case 4:
				System.out.println("You selected option 4: Display the most popular artist");
				CountryMusic mostPopular = playlist[0];
				for (int j = 1; j < playlist.length; j++) {
					if (playlist[j].getPopularity() > mostPopular.getPopularity()) {
						mostPopular = playlist[j];

					}
				}
				System.out.printf("The most popular artist is %s with a popularity of %.2f\n", mostPopular.getArtist(),
						mostPopular.getPopularity());
				break;
			case (5):
				System.out.println("You selected option 5: Display images of the artists");
				Picture labeled1 = playlist[0].labelImage(Color.RED, 20);
				Picture labeled2 = playlist[1].labelImage(Color.RED, 20);
				Picture labeled3 = playlist[2].labelImage(Color.GREEN, 25);
				Picture labeled4 = playlist[3].labelImage(Color.GREEN, 25);
				Picture labeled5 = playlist[4].labelImage(Color.YELLOW, 30);
				Picture labeled6 = playlist[5].labelImage(Color.YELLOW, 30);
				labeled1.show();
				labeled2.show();
				labeled3.show();
				labeled4.show();
				labeled5.show();
				labeled6.show();
				break;
			case (6):
				dataValidationTest();
				testGetterSetter(playlist);
				testInheritanceRules(playlist);
				break;
			case (7):
				System.out.println("You selected option 7: Exit, I hope you enjoyed the program!");
				break;
			default:
				System.out.println("Please rechoose from the following options with a valid entry.");
				break;

			}
		}
		scnr.close();
	}

	/**
	 * 
	 * @param target
	 * @param list
	 * @return
	 */
	public static int linearFind(String target, CountryMusic[] list) {
		for (int index = 0; index < list.length; index++) {
			if (target.compareTo(list[index].getArtist()) == 0) {
				return (index);
			}
		}
		return (99);
	}

	/**
	 * 
	 */
	public static void dataValidationTest() {
		CountryMusic lukeBryan = new CountryMusic("Luke Bryan", 7, new Picture("LukeBryan.png"),
				new Sound("DrumRoll.wav"));
		System.out.println("The current popularity of Luke Bryan is: " + lukeBryan.getPopularity());
		Scanner scanner = new Scanner(System.in);
		System.out.println("How popular do you think Luke Bryan is on a scale of 0-10?");
		int newPopularity = scanner.nextInt();
		if (newPopularity < 0) {
			newPopularity = 0;
		} else if (newPopularity > 10) {
			newPopularity = 10;
		}
		lukeBryan.setPopularity(newPopularity);

		System.out.println("Your opinion on the populaity of Luke Bryan is: " + lukeBryan.getPopularity());
	}

	/**
	 * 
	 * @param playlist
	 */
	public static void testGetterSetter(CountryMusic[] playlist) {
		System.out.println("Name of first artist: " + playlist[0].getArtist());
		String newName = playlist[0].getArtist().toUpperCase();
		playlist[0].setArtist(newName);
		System.out.println("Name of first artist in  all uppercase: " + playlist[0].getArtist());
	}

	/**
	 * 
	 * @param playlist
	 */
	public static void testInheritanceRules(CountryMusic[] playlist) {

		ModernCountryMusic storedModernCountryMusic = (ModernCountryMusic) playlist[5];
		System.out.println("Does Thomas Rhett use autotune?: " + storedModernCountryMusic.isAutoTune());
		System.out.println(
				"Num. of featured artists sung with Thomas Rhett: " + storedModernCountryMusic.getNumFeaturedArtists());
	}

}
