package jwd.prodavnica.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utility {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	static Scanner sc = new Scanner(System.in);
	
	public static String getRelativePath(String fileName){
		
		String sp = System.getProperty("file.separator");
		String path = "."+sp+"data"+sp+fileName;
		return path;
	}
	
	// citanje promenljive String
		public static String ocitajTekst() {
			String tekst = "";
			while (tekst == null || tekst.equals(""))
				tekst = sc.nextLine();

			return tekst;
		}

		// citanje promenljive integer
		public static int ocitajCeoBroj() {
			int ceoBroj = 0;
			boolean notRead = true;
			do {
				if (sc.hasNextInt()) {
					ceoBroj = sc.nextInt();
					notRead = false;
				} else {
					System.out
							.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
				}
				sc.nextLine(); // cisti sve sa ulaza sto nije broj ili ostatak teste
								// posla broja
			} while (notRead);
			return ceoBroj;
		}

		// citanje promenljive double
		public static double ocitajRealanBroj() {
			double realanBroj = 0;
			boolean notRead = true;
			do {
				if (sc.hasNextDouble()) {
					realanBroj = sc.nextDouble();
					notRead = false;
				} else {
					System.out
							.println("GRESKA - Pogresno unsesena vrednost za realan broj, pokusajte ponovo: ");
				}
				sc.nextLine(); // cisti sve sa ulaza sto nije broj ili ostatak testa
								// posle broja
			} while (notRead);
			return realanBroj;
		}

		// citanje promenljive char
		public static char ocitajKarakter() {
			char karakter = ' ';
			boolean notRead = true;
			do {
				String text = sc.next();
				if (text.length() == 1) {
					karakter = text.charAt(0);
					notRead = false;
				} else {
					System.out
							.println("GRESKA - Pogresno unsesena vrednost za karakter, pokusajte ponovo: ");
				}
				sc.nextLine();// cisti sve sa ulaza sto nije broj ili ostatak testa
								// posle karaktera
			} while (notRead);
			return karakter;
		}

		// citanje promenljive char
		public static char ocitajOdlukuOPotvrdi(String tekst) {
			System.out.println("Da li zelite " + tekst + " [Y/N]:");
			char odluka = ' ';
			while (!(odluka == 'Y' || odluka == 'N')) {
				odluka = ocitajKarakter();
				if (!(odluka == 'Y' || odluka == 'N')) {
					System.out.println("Opcije su Y ili N");
				}
			}
			return odluka;
		}

		public static boolean isInteger(String s) {
			try {
				Integer.parseInt(s);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		public static boolean isDouble(String s) {
			try {
				Double.parseDouble(s);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		public static boolean isBoolean(String s) {
			try {
				Boolean.parseBoolean(s);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		
		
		public static String konvertujDatumUString(Date datum){
			
			return sdf1.format(datum);
		}
		
		public static Date ocitajDatum(String datumString){
			Date date=null;
			try {
				date = sdf1.parse(datumString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return date;
		}
		

}
