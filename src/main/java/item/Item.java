package item;

public abstract class Item {
	
	protected double valor;
	
	public double valor() {
		return valor;
	}
	
	public abstract boolean esArticulo();
	
	public void cambiarValor(double unValor) {
		valor = unValor;
	}
	
}
