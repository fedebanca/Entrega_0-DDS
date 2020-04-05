package item;

public class Servicio extends Item {

	public Servicio(double unValor) {
		valor = unValor;
	}
	
	public boolean esArticulo() {
		return false;
	}

}
