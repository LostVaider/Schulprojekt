package packageSchiffeversenken;

public class DatenklasseSV {
	private int schlachtschiff = 5;
	private int kreuzer = 4;
	private int zerstörer1 = 3;
	private int zerstörer2 = 3;
	private int uboot = 2;
	private int xK, yK;
	public int spielfeld1[][] = new int[10][10];
	public int spielfeld2[][] = new int[10][10];

	public DatenklasseSV() {

	}

	public DatenklasseSV(Steuerung steuerung) {
		super();

	}

	public boolean schiessen(int x, int y, int spielerNr) {
		if (spielerNr == 1) {
			if (spielfeld2[x][y] != 1) {
				if (spielfeld2[x][y] != 0) {
					spielfeld2[x][y] = 1;

					return true;
				}

			}
			spielfeld2[x][y] = 1;

		} else if (spielerNr == 2) {
			if (spielfeld1[x][y] != 1) {
				if (spielfeld1[x][y] != 0) {
					spielfeld1[x][y] = 1;

					return true;
				}
				spielfeld1[x][y] = 1;
			}
		}
		return false;
	}

	public int[][] getSpielfeld(int welches) {
		if (welches == 1)
			return this.spielfeld1;

		return this.spielfeld2;
	}

	public int getSpielfeldElement(int spielerNummer, int x, int y) {
		if (spielerNummer == 1)
			return this.spielfeld1[x][y];
				return this.spielfeld2[x][y];	}

	public boolean gewinnAbfrage2() {
		boolean leer = true;

		for (int x = 0; x < getSpielfeld(2).length; x++) {
			for (int y = 0; y < getSpielfeld(2).length; y++) {
				if (getSpielfeldElement(2, x, y) != 0 && getSpielfeldElement(2, x, y) != 1) {
					leer = false;
				}
			}
		}
		if (leer == true)
			return true;

		return false;
	}

	public boolean gewinnAbfrage1() {
		boolean leer = true;

		for (int x = 0; x < getSpielfeld(1).length; x++) {
			for (int y = 0; y < getSpielfeld(1).length; y++) {
				if (getSpielfeldElement(1, x, y) != 0 && getSpielfeldElement(1, x, y) != 1) {
					leer = false;
				}
			}
		}
		if (leer == true)
			return true;

		return false;
	}

	public void spielfeld() {

		// Speicherplatzt für Array reserviert
		for (int x = 0; x < spielfeld1.length; x++) {
			for (int y = 0; y < spielfeld1.length; y++) {
				System.out.print(spielfeld1[y][x]); // Ausgabe der Array
													// Elemente
			}
			System.out.println();
		}
		System.out.println();

		for (int x = 0; x < spielfeld2.length; x++) {
			for (int y = 0; y < spielfeld2.length; y++) {
				System.out.print(spielfeld2[y][x]); // Ausgabe der Array
													// Elemente
			}
			System.out.println();
		}
	}

	public int getSchlachtschiff() {
		return schlachtschiff;
	}

	public void setSchlachtschiff(int schlachtschiff) {
		this.schlachtschiff = schlachtschiff;
	}

	public int getKreuzer() {
		return kreuzer;
	}

	public void setKreuzer(int kreuzer) {
		this.kreuzer = kreuzer;

	}

	public int getZerstörer1() {
		return zerstörer1;
	}

	public void setZerstörer1(int zerstörer1) {
		this.zerstörer1 = zerstörer1;
	}

	public int getZerstörer2() {
		return zerstörer2;
	}

	public void setZerstörer2(int zerstörer2) {
		this.zerstörer2 = zerstörer2;
	}

	public int getUboot() {
		return uboot;
	}

	public int[][] getSpielfeld1() {
		return spielfeld1;
	}

	public int[][] getSpielfeld2() {
		return spielfeld2;
	}
	public void setUboot(int uboot) {
		this.uboot = uboot;
	}

	// get Set x

	public int getxyK() {
		return xK;
	}

	public void setxyK(int yko, int xKo, int schiffsTyp, int spielerNr) {
		xK = xKo - 1;
		yK = yko - 1;
		if (spielerNr == 1) {
			spielfeld1[yK][xK] = schiffsTyp;
			for (int x = 0; x < spielfeld1.length; x++) {
				for (int y = 0; y < spielfeld1.length; y++) {
					System.out.print(spielfeld1[y][x]); // Ausgabe der Array
														// Elemente
				}
				System.out.println();
			}
		} else if (spielerNr == 2) {
			spielfeld2[yK][xK] = schiffsTyp;
			for (int x = 0; x < spielfeld2.length; x++) {
				for (int y = 0; y < spielfeld2.length; y++) {
					System.out.print(spielfeld2[y][x]); // Ausgabe der Array
														// Elemente
				}
				System.out.println();
			}
		} else {
			System.err.println("keine Gültige Spielernummer!");
		}

	}

	
	

}
