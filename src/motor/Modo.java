package motor;

import jm.music.data.Note;

public abstract class Modo {
	public String modoVar="Libre";
	
	public String getModoVar() {
		return modoVar;
	}

	public void setModoVar(String modoVar) {
		this.modoVar = modoVar;
	}

	public abstract boolean evaluar(String tocada, String[] sugerida);
	public abstract Note[] getNoteArray();
	

}
