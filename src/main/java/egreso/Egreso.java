package egreso;
import java.util.ArrayList;
import java.util.List;

import egreso.exceptions.EgresoNoCerradoException;
import egreso.exceptions.EgresoNoTieneSoloArticulosException;
import egreso.exceptions.EgresoYaCerradoException;
import item.Item;

public final class Egreso {
	private List<Item> listaDeItems = new ArrayList<>();
	private String documentoComercialAsociado;
	private double precio = 0; // una vez que el precio es instanciado no cambia, a pesar de que puedan cambiar los precios de los items con los
	//que se calculo, ya que no depende directamente de ellos, sino que es un valor independiente a partir del momento en que se calculo el.
	private boolean cerrada; // Por defecto, los boolean siempre se inicializan en false
	
	public Egreso( String documento) {
		//listaDeItems = lista;
		documentoComercialAsociado = documento;
	}
	
	public List<Item> getListaDeItems() {
		return listaDeItems;
	}
	
	public boolean estaCerrada() {
		return cerrada;
	}
	
	public void agregarItem(Item unItem) throws EgresoYaCerradoException{
		if(cerrada) {
			//error, se ha cerrado la operacion, no se puede cambiar el precio
			throw new EgresoYaCerradoException();
		}
		listaDeItems.add(unItem);
	}

	public void calcularValor() throws EgresoYaCerradoException{
		if(cerrada) {
			//error, se ha cerrado la operacion, no se puede cambiar el precio
			throw new EgresoYaCerradoException();
		}
		// calcular sumatoria de valores de los items y asignarselo a precio
		listaDeItems.forEach((Item item) -> precio += item.valor());
		
		cerrada = true;
		
	}
	
	public String generarDocumento() throws EgresoNoTieneSoloArticulosException{
		if(!this.soloArticulos()) {
			// error, no puede generarse el documento porque hay items que son servicios
			throw new EgresoNoTieneSoloArticulosException();
		}
		// se genera el documento comercial
		//System.out.println("El documento generado es: " + documentoComercialAsociado);
		return documentoComercialAsociado;
	}
	
	public boolean soloArticulos() {
		return listaDeItems.stream().allMatch((Item item) -> item.esArticulo());
	}
	
	public double precio() throws EgresoNoCerradoException {
		if(!cerrada) {
			// error, no se ha cerrado la operacion
			throw new EgresoNoCerradoException();
		}
		return precio;
	}
}