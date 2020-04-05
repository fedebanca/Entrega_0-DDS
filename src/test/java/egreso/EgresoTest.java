package egreso;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import egreso.exceptions.EgresoNoCerradoException;
import egreso.exceptions.EgresoNoTieneSoloArticulosException;
import egreso.exceptions.EgresoYaCerradoException;
import item.Articulo;
import item.Servicio;

public class EgresoTest {
	private final double valorArticulo1 = 100.32;
	private final double valorArticulo2 = 20.15;
	private final double valorServicio = 35.0;
	private final String documentoFinalAsociado = "Remito";
	private Egreso egreso;
	private Articulo articulo1;
	private Articulo articulo2;
	private Articulo articulo3;
	private Servicio servicio;
	
	@Before
	public void init() throws EgresoYaCerradoException {
		articulo1 = new Articulo(valorArticulo1);
		articulo2 = new Articulo(valorArticulo2);
		
		egreso = new Egreso( documentoFinalAsociado);
		
		egreso.agregarItem(articulo1);
		egreso.agregarItem(articulo2);
	}
	@Test
	public void testCalcularValorOK() throws EgresoYaCerradoException, EgresoNoCerradoException{
		//Precondiciones
		//Operaciones
		egreso.calcularValor();
		//Postcondiciones
		String message = "La operacion deberia estar cerrada";
		Assert.assertTrue(message, egreso.estaCerrada());
		Assert.assertEquals(valorArticulo1 + valorArticulo2, egreso.precio(), 0.11);
	}
	
	@Test(expected=EgresoYaCerradoException.class)
	public void testCalcularValorCerrado() throws EgresoYaCerradoException, EgresoNoCerradoException{
		//Precondiciones
		egreso.calcularValor();
		//Operaciones
		egreso.calcularValor();
		//Postcondiciones
	}
	
	@Test(expected=EgresoYaCerradoException.class)
	public void testNoPuedoCambiarElValorUnaVezCerrada() throws EgresoYaCerradoException, EgresoNoCerradoException{
		//Precondiciones
		articulo3 = new Articulo(10.14);
		egreso.calcularValor();
		//Operaciones
		egreso.calcularValor();
		
		egreso.agregarItem(articulo3);
		//Postcondiciones
	}
	
	@Test
	public void testCambioValorDeItemDespuesDeCerrar() throws EgresoYaCerradoException, EgresoNoCerradoException{
		//Precondiciones
		egreso.calcularValor();
		//Operaciones
		articulo1.cambiarValor(15.2);
		//Postcondiciones
		Assert.assertNotEquals( 15.2 + valorArticulo2, egreso.precio(), 0.1);
	}
	
	@Test
	public void testGenerarDocumentoOK() throws EgresoYaCerradoException, EgresoNoCerradoException, EgresoNoTieneSoloArticulosException{
		//Precondiciones
		//Operaciones
		egreso.generarDocumento();
		String message = "El documento asociado es remito";
		Assert.assertTrue(message, egreso.generarDocumento().equals(documentoFinalAsociado));
		//Postcondiciones
	}
	
	@Test(expected=EgresoNoTieneSoloArticulosException.class)
	public void testGenerarDocumentoConServicio() throws EgresoNoTieneSoloArticulosException, EgresoYaCerradoException{
		//Precondiciones
		servicio = new Servicio(valorServicio);
		egreso.agregarItem(servicio);
		//Operaciones
		egreso.generarDocumento();
		//Postcondiciones
	}


}
