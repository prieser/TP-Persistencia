package modelo.aerolinea;

import java.util.Collection;

import modelo.usuario.Usuario;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Empresa {

    private Collection<Aerolinea> aerolineas;
    
    
    
    public void reservarAsiento(Tramo tramo , Asiento asiento , Usuario usuario ) {
   
/*    	recorrer la lista de asientos sacadas desde el tramo
 * preguntar si el asiento esta ocupado si no esta ocupado reservarlo enviadonle el metodo al asiento
 */
         for (Asiento butaca : tramo.getAsientos()) {
    		if (asiento.getNumero() == butaca.getNumero())
    		{
    			asiento.reservarAsiento(usuario);
    			}
    		}
    		
        }
    	
    }
    
