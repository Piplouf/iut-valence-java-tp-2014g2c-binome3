/* TODO Javadoc ! */

public class JeuDeCarte {

	private Carte carte[];

	public JeuDeCarte(){
		int i = 0;
		for(Couleur coul : Couleur.values()){
			for(Numero num : Numero.values()){
				carte[i++] = new Carte(coul,num,true);
			}
		}
	}
}
