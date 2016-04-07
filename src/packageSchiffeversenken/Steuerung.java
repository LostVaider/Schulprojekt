package packageSchiffeversenken;


public class Steuerung
{
	private DatenklasseSV dk;
	private SV_Gui gui;
	
	public Steuerung()
	{

		dk = new DatenklasseSV(this);
		gui = new SV_Gui(this);
	}
	
	public void spielfeld()
	{
		dk.spielfeld();
	}
	public int [][]getSpielfeld1()
	{
		return dk.getSpielfeld1();
	}
	
	public int [][]getSpielfeld2()
	{
		return dk.getSpielfeld2();
	}
	
	public int getSchlachtschiff()
	{
		return dk.getSchlachtschiff();
	}
	
	public void setxyK(int xKoordiante, int yKoordinate, int schiffsNummer, int spielerNr)
	{
		dk.setxyK(xKoordiante, yKoordinate, schiffsNummer, spielerNr);
	}
	
	public int getKreuzer()
	{
		return dk.getKreuzer();
	}
	
	public int getZerstörer1()
	{
		return dk.getZerstörer1();
	}
	
	public int getZerstörer2()
	{
		return dk.getZerstörer2();
	}
	
	public int getUboot()
	{
		return dk.getUboot();
	}
	
	public boolean schiessen(int x, int y, int spielerNr)
	{
		return dk.schiessen(x, y, spielerNr);
	}
	
	public boolean gewinnAbfrage1()
	{
		return dk.gewinnAbfrage1();
	}
	
	public boolean gewinnAbfrage2()
	{
		return dk.gewinnAbfrage2();
	}
	
	public void GuiElemente(){
		
		//gui.ZeichenflächeMachen();
		
	
		
	}
	
	public int getSpielfeldElement(int spielerNummer, int x, int y)
	{
		return dk.getSpielfeldElement(spielerNummer, x, y);
		
	}
	
	
}

