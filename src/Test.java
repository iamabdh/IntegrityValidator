 import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("Select an action: ");
		System.out.println("---------------------");
		System.out.println("1) Generate Hash");
		System.out.println("2) Compare Hash");
		System.out.println("3) Re-compute");
		
		Scanner scan = new Scanner(System.in);  
		int option = scan.nextInt();
		if (option == 1) {
			System.out.println("Generate Hash\n");
			String userInputString = scan.next();
			System.out.print("string:  ");
			System.out.println(getHash(userInputString));
		} else if (option == 2) {
			System.out.println("Compare Hash");
		} else if (option == 3) {
			System.out.println("Re-compute");
		} else {
			System.out.println("Wrong Option");
		}

	}
	/**
	 * method for hashing 
	 * @param input string to be hashed 
	 * @return hashed string 
	 */
	public static String getHash(String input) {
		MessageDigest mDigest =  null;
		try {
			mDigest = MessageDigest.getInstance("SHA-256");	
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    BigInteger number = new BigInteger(1,  mDigest.digest(input.getBytes(StandardCharsets.UTF_8)));
	    
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
        
        return hexString.toString();
	}
	
}
