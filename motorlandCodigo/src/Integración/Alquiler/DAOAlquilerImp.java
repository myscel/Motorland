/**
 * 
 */
package Integraci�n.Alquiler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import Integraci�n.Transaction.Transaction;
import Integraci�n.Transaction.TransactionManager;
import Integraci�n.connectionPool.ConnectionPoolFactory;
import Negocio.Alquiler.TAlquiler;
import Negocio.Alquiler.TLineaAlquiler;
import Negocio.Alquiler.enumeradosAlq.Operacion;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.vistas.vistaCalendario.DateLabelFormatter;


public class DAOAlquilerImp implements DAOAlquiler {

	public int create(TAlquiler t) throws Exception {
		
		int res = 0; 
		ArrayList<TLineaAlquiler> lLineasAlquiler = null; 
		Connection cn = null; 
		Transaction tr = null; 
		PreparedStatement ps;
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
			
			ps = cn.prepareStatement("INSERT INTO alquiler (idCliente, fechaIni, fechaFin, costeTotal, pago, activo) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, t.getIdCliente());
			ps.setDate(2, (Date) DateLabelFormatter.toDate(t.getFechaIni()));
			ps.setDate(3, (Date) DateLabelFormatter.toDate(t.getFechaFin()));
			ps.setDouble(4, t.getCosteTotal());
			ps.setString(5, t.getPago());
			ps.setBoolean(6, t.getActivo());
			res = ps.executeUpdate();
			ps = cn.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) { 
				res = rs.getInt("LAST_INSERT_ID()");
				lLineasAlquiler = t.getListaLineasAlquiler();
				
				for (TLineaAlquiler linea : lLineasAlquiler) {
					ps = cn.prepareStatement("INSERT INTO lineaalquiler (idAlquiler, idVehiculo, coste) VALUES (?,?,?)");
					ps.setInt(1, res);
					ps.setInt(2, linea.getIdVehiculo());
					ps.setDouble(3, linea.getCoste());
					ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
		return res; 

	}

	/** 
	 * (sin Javadoc)
	 * @see DAOAlquiler#delete(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int delete(int id) {
		int res; 
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null; 
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
			ps = cn.prepareStatement("DELETE FROM alquiler WHERE idAlquiler = ?");
			ps.setInt(1, id);
			res = ps.executeUpdate(); 
			
			if(res == 0)
				tr.rollback();
			else
				tr.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}

	@Override
	public ArrayList<TAlquiler> list() {
		ArrayList<TAlquiler> l = new ArrayList<>();
		TAlquiler t = null; 
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		ResultSet rs_lineaA = null; 
		String forUpdate = ""; 
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if(tr == null)
				cn = creaConexion();
			else {
				forUpdate = " FOR UPDATE";
				cn = (Connection) tr.getResource();
			}
			ps = cn.prepareStatement("SELECT * FROM alquiler" + forUpdate);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				t = new TAlquiler(rs.getInt(1), rs.getInt(2), DateLabelFormatter.toCalendar(rs.getDate(3)), 
						DateLabelFormatter.toCalendar(rs.getDate(4)), 
						rs.getDouble(5), rs.getString(6), rs.getBoolean(7));
				
				ps = cn.prepareStatement("SELECT * FROM lineaalquiler WHERE idAlquiler = ?" + forUpdate);
				ps.setInt(1, t.getId());
				rs_lineaA = ps.executeQuery();
				while(rs_lineaA.next())
					t.addTolistaAlquilados(rs_lineaA.getInt(2), new TLineaAlquiler(rs_lineaA.getDouble(3)));
				
				l.add(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
				if (rs_lineaA != null)
					rs_lineaA.close();
			}
			catch (SQLException s) {
				s.printStackTrace();
			}
		}
		
		return l;
	}

	@SuppressWarnings("resource")
	@Override
	public TAlquiler read(int id) throws Exception {
		Transaction tr = null;
		Connection cn = null; 
		String forUpdate = ""; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TAlquiler t = null; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if (tr == null)
				cn = creaConexion(); 
			else {
				cn = (Connection) tr.getResource(); 
				forUpdate = " FOR UPDATE";
			}
			
			ps = cn.prepareStatement("SELECT * FROM alquiler WHERE idalquiler = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				t = new TAlquiler(id, rs.getInt(2), DateLabelFormatter.toCalendar(rs.getDate(3)), DateLabelFormatter.toCalendar(rs.getDate(4)),
						rs.getDouble(5), rs.getString(6), rs.getBoolean(7));
				ps = cn.prepareStatement("SELECT idVehiculo, coste FROM lineaalquiler WHERE idAlquiler = ?" + forUpdate);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				//A�adimos lista de vehiculos alquilados
				while (rs.next())
					t.addTolistaAlquilados(rs.getInt(1), new TLineaAlquiler(rs.getDouble(2)));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al consultar alquiler");
		}
		finally {
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}
		return t;
	}

	@Override
	public int update(TAlquiler t) {
		int res = -1; 
		Transaction tr = null;
		Connection cn = null; 
		PreparedStatement ps = null;
		ArrayList<TLineaAlquiler> lineas = new ArrayList<>();
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
			
			ps = cn.prepareStatement("UPDATE alquiler SET idCliente = ?, fechaIni = ?, fechaFin = ?, costeTotal = ?, pago = ?"
					+ " WHERE idAlquiler = ?");
			ps.setInt(1, t.getIdCliente());
			ps.setDate(2, (Date) DateLabelFormatter.toDate(t.getFechaIni()));
			ps.setDate(3, (Date) DateLabelFormatter.toDate(t.getFechaFin()));
			ps.setDouble(4, t.getCosteTotal());
			ps.setString(5, t.getPago());
			ps.setInt(6, t.getId());
			
			res = ps.executeUpdate();

			lineas = t.getListaLineasAlquiler();
			for (TLineaAlquiler l : lineas) {
				if (l.getOperacion() == Operacion.A�ADIR) {
					ps = cn.prepareStatement("INSERT INTO lineaalquiler VALUES (?,?,?)");
					ps.setInt(1, t.getId());
					ps.setInt(2, l.getIdVehiculo());
					ps.setDouble(3, l.getCoste());
					ps.executeUpdate();
				}
				else if (l.getOperacion() == Operacion.MODIFICAR) {
					ps = cn.prepareStatement("UPDATE lineaalquiler SET coste = ? WHERE idAlquiler = ? AND idVehiculo = ?");
					ps.setDouble(1, l.getCoste());
					ps.setInt(2, t.getId());
					ps.setInt(3, l.getIdVehiculo());
					ps.executeUpdate();
				}
				else if (l.getOperacion() == Operacion.ELIMINAR) {
					ps = cn.prepareStatement("DELETE FROM lineaalquiler WHERE idAlquiler = ? AND idVehiculo = ?");
					ps.setInt(1, t.getId());
					ps.setInt(2, l.getIdVehiculo());
					ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null)
					ps.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public int addVehiculo(TAlquiler t, TVehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteVehiculo(TAlquiler t, TVehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Devuelve todos aquellos vehiculos que no forman parte de ningun alquiler que coinciden en fecha inicial y final con 
	 * el alquiler actual. 
	 * @param fechaI
	 * @param fechaF
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<TVehiculo> obtenVehiculosNoCoincidentes (Calendar fechaI, Calendar fechaF) throws Exception{
		ArrayList<TVehiculo> l = new ArrayList<>(); 
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		String forUpdate = ""; 

		
		Date fI = (Date) DateLabelFormatter.toDate(fechaI);
		Date fF = (Date) DateLabelFormatter.toDate(fechaF);
		try {
		tr = TransactionManager.getInstance().getTransaction();
			if (tr == null)
				cn = creaConexion();
			else {
				forUpdate = " FOR UPDATE";
				cn = (Connection) tr.getResource();
			}
			/*Subconsulta  mas profunda devuelve todos aquellos alquileres que solopan con el actual 
			 * Le sigue una subconsulta que devuelve los IDs de todos aquellos vehiculos que se encuentran en un alquiler que solapa
			 * con el actual 
			 */
			ps = cn.prepareStatement("SELECT idvehiculo, modelo, color, numBaterias, coste "
					+ "FROM vehiculo v "
					+ "WHERE v.activo = 1 AND v.idvehiculo NOT IN "
					+ "(SELECT DISTINCT idVehiculo "
					+ "FROM lineaalquiler l WHERE l.idAlquiler IN (SELECT idAlquiler FROM alquiler WHERE (fechaIni >= ? AND fechaIni <= ?) OR ("
					+ "fechaFin >= ? AND fechaFin <= ?) OR (fechaIni <= ? AND fechaFin >= ?)))" + forUpdate);
			
			ps.setDate(1, fI);
			ps.setDate(2, fF);
			ps.setDate(3, fI);
			ps.setDate(4, fF);
			ps.setDate(5, fI);
			ps.setDate(6, fF);
			
			rs = ps.executeQuery(); 
			
			while(rs.next())
				l.add(new TVehiculo(rs.getInt(1), rs.getString(2), "", rs.getString(3), rs.getInt(4), rs.getDouble(5), true));
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			}
			catch(SQLException e) {
				throw new Exception(); 
			}
		}
		
		
		return l; 
	}

	public Connection creaConexion() throws Exception {
		Connection cn = null;
		
		try {
			cn = ConnectionPoolFactory.getInstance().getConnection();
			cn.setAutoCommit(false);
		}
		catch (SQLException e){
			throw new Exception("Error al conectarse a la base de datos.");
		}
		return cn; 
	}

	@Override
	public boolean alquilerSolapa(int idAlquiler, Calendar fechaI, Calendar fechaF) {
		boolean coincide = false;
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date fI;
		Date fF;
		String forUpdate = "";
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if(tr == null)
				cn = creaConexion();
			else {
				forUpdate = " FOR UPDATE";
				cn = (Connection) tr.getResource();
			}
			
			fI = (Date) DateLabelFormatter.toDate(fechaI);
			fF = (Date) DateLabelFormatter.toDate(fechaF);
			
			ps = cn.prepareStatement("SELECT idvehiculo "
					+ "FROM lineaalquiler v "
					+ "WHERE v.idAlquiler = ? AND v.idvehiculo IN "
					+ "(SELECT DISTINCT idVehiculo "
					+ "FROM lineaalquiler l WHERE l.idAlquiler IN (SELECT idAlquiler FROM alquiler WHERE (fechaIni >= ? AND fechaIni <= ?) OR ("
					+ "fechaFin >= ? AND fechaFin <= ?) OR (fechaIni <= ? AND fechaFin >= ?)))" + forUpdate);
			
			ps.setInt(1, idAlquiler);
			ps.setDate(2, fI);
			ps.setDate(3, fF);
			ps.setDate(4, fI);
			ps.setDate(5, fF);
			ps.setDate(6, fI);
			ps.setDate(7, fF);
			
			rs = ps.executeQuery(); 
			
			if(rs.next())
				coincide = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} 
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			
		}
		
		return coincide;
	}

	@Override
	public ArrayList<TVehiculo> obtenVehiculosAlquilados(int id) {
		Transaction tr = null;
		Connection cn = null; 
		ArrayList<TVehiculo> l = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs_vehiculo = null; 
		String forUpdate = "";
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if(tr == null)
				cn = creaConexion();
			else {
				forUpdate = " FOR UPDATE";
				cn = (Connection) tr.getResource();
			}
			
			ps = cn.prepareStatement("SELECT idVehiculo, coste FROM lineaalquiler WHERE idAlquiler = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			TVehiculo v; 
			while(rs.next()) {
				v = new TVehiculo();
				v.setId(rs.getInt(1));
				v.setCoste(rs.getDouble(2));
				ps = cn.prepareStatement("SELECT modelo, color, numBaterias FROM vehiculo WHERE idvehiculo = ?" + forUpdate); 
				ps.setInt(1, v.getId());
				rs_vehiculo = ps.executeQuery();
				if(rs_vehiculo.next()) {
					v.setModelo(rs_vehiculo.getString(1));
					v.setColor(rs_vehiculo.getString(2));
					v.setNumBaterias(rs_vehiculo.getInt(3));
					l.add(v);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			
		}
		return l;
	}

	@Override
	public ArrayList<TVehiculo> obtenVehiculosNoAlquiladosNoCoincidentes(int id, Calendar fechaI, Calendar fechaF) {
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String forUpdate = "";
		ArrayList<TVehiculo> l = new ArrayList<>();
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if(tr == null)
				cn = creaConexion();
			else {
				forUpdate = " FOR UPDATE";
				cn = (Connection) tr.getResource();
			}
			
			Date fI = (Date) DateLabelFormatter.toDate(fechaI);
			Date fF = (Date) DateLabelFormatter.toDate(fechaF);
			
			ps = cn.prepareStatement("SELECT idvehiculo, modelo, color, numBaterias, coste " + 
					"FROM vehiculo v " + 
					"WHERE v.activo = 1 AND v.idvehiculo NOT IN " + 
					"(SELECT idVehiculo FROM lineaalquiler WHERE idAlquiler = ?) AND v.idvehiculo NOT IN " + 
					"(SELECT DISTINCT idVehiculo " + 
					"FROM lineaalquiler l WHERE l.idAlquiler IN (SELECT idAlquiler FROM alquiler WHERE (fechaIni >= ? AND fechaIni <= ?) OR (" + 
					"fechaFin >= ? AND fechaFin <= ?) OR (fechaIni <= ? AND fechaFin >= ?)))" + forUpdate);
			ps.setInt(1, id);
			ps.setDate(2, fI);
			ps.setDate(3, fF);
			ps.setDate(4, fI);
			ps.setDate(5, fF);
			ps.setDate(6, fI);
			ps.setDate(7, fF);
			rs = ps.executeQuery();
			
			tr.commit();
			while(rs.next())
				l.add(new TVehiculo(rs.getInt(1), rs.getString(2), null, rs.getString(3), rs.getInt(4), rs.getDouble(5), true));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return l;
	}
	
}