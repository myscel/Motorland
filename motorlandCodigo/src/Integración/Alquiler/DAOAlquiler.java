/**
 * 
 */
package Integración.Alquiler;

import java.util.ArrayList;
import java.util.Calendar;

import Negocio.Alquiler.TAlquiler;
import Negocio.Vehiculo.TVehiculo;


public interface DAOAlquiler {
	
	public int create(TAlquiler t) throws Exception;
	public int delete(int id);
	public int update(TAlquiler t);
	public TAlquiler read(int id) throws Exception;
	public ArrayList<TAlquiler> list();
	public int addVehiculo(TAlquiler t, TVehiculo v);
	public int deleteVehiculo(TAlquiler t, TVehiculo v);
	public ArrayList<TVehiculo> obtenVehiculosNoCoincidentes (Calendar fechaI, Calendar fechaF) throws Exception;
	public boolean alquilerSolapa(int idAlquiler, Calendar fechaI, Calendar fechaF);
	public ArrayList<TVehiculo> obtenVehiculosAlquilados(int id); 
	public ArrayList<TVehiculo> obtenVehiculosNoAlquiladosNoCoincidentes(int id, Calendar fechaI, Calendar fechaF);
}
