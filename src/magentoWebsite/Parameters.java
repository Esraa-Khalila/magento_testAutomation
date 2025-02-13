package magentoWebsite;

import java.util.Random;

public class Parameters {
	Random Rand = new Random();
	int randomIndex = Rand.nextInt(10);
	int randEmailID =Rand.nextInt(999);
	String[] firstNames = { "Amir", "Layla", "Tariq", "Hana", "Zayd", "Nour", "Samir", "Yasmin", "Omar", "Rania" };
	String[] lastNames = { "Al-Farsi", "Ibrahim", "Hassan", "Sami", "Al-Mansoor", "Abdullah", "Jamal", "Qadir", "Shah",
			"Khalil" };
	String emailID = firstNames[randomIndex]+lastNames[randomIndex]+"@"+"gmail.com";
	String CommonPassword = "ABC123@@";
	
	
	

}
