/* TODO Javadoc ! */

public class JeuDeCarte {

	private Carte carte[] = new Carte[52];
	
	private int nombreCartesRestantes;
	

	public JeuDeCarte(){
		int i = 0;
		for(Couleur coul : Couleur.values()){
			for(Numero num : Numero.values()){
				carte[i++] = new Carte(coul,num,false);
			}
		}
		this.nombreCartesRestantes = i++;
	}
	
	
	
	public Carte[] distribuerCartePile(int nombreCartesPile) {
		/* Pré-condition sur la taille de la demande */
		
		Carte[] carteARetourner = new Carte[nombreCartesPile];
		
		if(nombreCartesPile < 0 || nombreCartesPile <= this.nombreCartesRestantes){}
		else
		{
		
		
		for(int i=0;i<nombreCartesPile;i++)
		{
			int rand = 0 + (int)(Math.random() * ((51) + 1));
			carteARetourner[i] = this.carte[rand];
			for(i = rand;i<nombreCartesRestantes;i++)
			{
				this.carte[rand] = this.carte[rand + 1];
			}
			this.nombreCartesRestantes--;
		}

		}
		return carteARetourner;
	}
}
