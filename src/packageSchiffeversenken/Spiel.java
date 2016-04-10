package packageSchiffeversenken;

import java.util.Scanner;

public class Spiel
{
	private int xKoordiante = 0;
	private int yKoordinate = 0;
	private Steuerung s;
	
	private boolean fertig= false;
	
	public Spiel()
	{
		
	}
	
	public Spiel(Steuerung spiel)
	{
		super();
		
		this.s= spiel;
									//Testzeugs:
		//spielAnfangen();			//spiel starten
		//schiessen(1);				//schuss setzen
		//s.setxyK(1, 1, 5, 1);		//koordinate setzen
		//gewinnAbfrage();			//gewonnen?
		//s.spielfeld();			//spielfeld anzeigen
	}
	
	public void spielAnfangen()
	{
		s.spielfeld();
		schiffeSetzen(1);
		schiffeSetzen(2);
		
		while(fertig== false)
		{
			schiessen(1);
			schiessen(2);
			
			gewinnAbfrage();
		}
	
		System.out.println("Spiel beendet!");
	}
	
	public void gewinnAbfrage()
	{
		if(gewinnAbfrage1()== true&& gewinnAbfrage2()==true)
		{
			System.out.println("Beide haben gleichzeitig gewonnen! Zufall? Ich glaube nicht :D");
			fertig= true;
		}
		else
		if(gewinnAbfrage1()== true)
		{
			System.out.println("Spieler2 gewinnt");
			fertig= true;
		}
		else
		if(gewinnAbfrage2()== true)
		{
			System.out.println("Spieler1 gewinnt");
			fertig= true;
		}
	}
	
	
	public void schiffeSetzen(int spielerNr)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Spieler"+spielerNr+" ist dran!");
		
		for (int eingabe = 1; eingabe <= s.getSchlachtschiff(); eingabe++)
		{

			System.out.println("Bitte das Schlachtschiff (xKoordinate) setzen: ");
			xKoordiante = input.nextInt();

			System.out.println("Bitte das Schlachtschiff (yKoordinate) setzen ");
			yKoordinate = input.nextInt();

			s.setxyK(xKoordiante, yKoordinate, 5, spielerNr);

			s.getSchlachtschiff();

		}

		for (int eingabe = 1; eingabe <= s.getKreuzer(); eingabe++) {

			System.out.println("Bitte den Kreuzer (xKoordinate) setzen: ");
			xKoordiante = input.nextInt();

			System.out.println("Bitte den Kreuzer (yKoordinate) setzen: ");
			yKoordinate = input.nextInt();

			s.setxyK(xKoordiante, yKoordinate,4, spielerNr);

			s.getKreuzer();

		}
		for (int eingabe = 1; eingabe <= s.getZerstörer1(); eingabe++) {

			System.out.println("Bitte den Zerstörer1 (xKoordinate) setzen: ");
			xKoordiante = input.nextInt();

			System.out.println("Bitte den Zerstörer1 (yKoordinate) setzen: ");
			yKoordinate = input.nextInt();
			
			s.setxyK(xKoordiante, yKoordinate,3,spielerNr);

			s.getZerstörer1();

		}

		for (int eingabe = 1; eingabe <= s.getZerstörer2(); eingabe++) {

			System.out.println("Bitte den Zerstörer2 (xKoordinate) setzen: ");
			xKoordiante = input.nextInt();

			System.out.println("Bitte den Zerstörer2 (yKoordinate) setzen: ");
			yKoordinate = input.nextInt();

			s.setxyK(xKoordiante, yKoordinate,3,spielerNr);

			s.getZerstörer2();
		}

		for (int eingabe = 1; eingabe <= s.getUboot(); eingabe++) {

			System.out.println("Bitte den U-Boot (xKoordinate) setzen: ");
			xKoordiante = input.nextInt();

			System.out.println("Bitte den U-Boot (yKoordinate) setzen: ");
			yKoordinate = input.nextInt();

			s.setxyK(xKoordiante, yKoordinate,2,spielerNr);

			s.getUboot();
		}
	}
	
	public void schiessen(int spielerNr)
	{
		System.out.println("Spieler"+spielerNr+" schiesst");
		s.spielfeld();
		
		Scanner input = new Scanner(System.in);
		System.out.println("X-Koordinate zum feuern eingeben!");
		int xSchiessen = input.nextInt()-1;

		System.out.println("Y-Koordinate zum feuern eingeben!");
		int ySchiessen = input.nextInt()-1;
		
		
		
	
		if(s.schiessen(xSchiessen, ySchiessen, spielerNr)== true)
		{
			System.out.println("getroffen");
		}
		else
			System.out.println("daneben");		
	}
	
	public boolean gewinnAbfrage1()
	{
		if(s.gewinnAbfrage1()== true)
			return true;
		else
		return false;
	}
	
	public boolean gewinnAbfrage2()
	{
		if(s.gewinnAbfrage2()== true)
			return true;
		else
		return false;
	}
}