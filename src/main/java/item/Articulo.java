package item;

public class Articulo extends Item{

	public Articulo(double unValor) {
		valor = unValor;
	}

	public boolean esArticulo() {
		return true;
	}
}
