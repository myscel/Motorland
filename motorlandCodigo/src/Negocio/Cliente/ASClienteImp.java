/**
 * 
 */
package Negocio.Cliente;

import java.util.ArrayList;
import java.util.List;

import Integración.Cliente.DAOCliente;
import Integración.DAOFactory.DaoFactory;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Integración.query.Query;
import Integración.query.VIPResultado;
import Integración.queryFactory.QueryFactory;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ASClienteImp implements ASCliente {

	@Override
	public int altaCliente(TCliente t) throws Exception {
        
        int id;
        Transaction tr = null; 
        DAOCliente dao = DaoFactory.getInstance().createDAOCliente(); 
        
        try {
	        TransactionManager.getInstance().newTransaction(); 
	        tr = TransactionManager.getInstance().getTransaction();
	        tr.start();
	        
	        TCliente tc = dao.readByDNI(t.getDni());
	
	        if (tc == null){
	        	//anadimos el cliente a la bd                       
	            id = dao.create(t);
	            
	            if (id == 0){ 
	                id = -1;// error al añadir cliente no dado de alta en la base de datos;
	                tr.rollback();
	            }        
	            else{ 
	                tr.commit();// confirmamos la transaccion
	            }
	        }            
	        else if (!tc.getActivo()) {
	            tc.setActivo(true);//lo ponemos a activo
	            //intentamos actualizar los valores dell cliente
	            id = dao.update(tc);            
	            if (id == 0){
	            	id = -2; //error al poner acrtivo un cliente dado de baja
	                tr.rollback(); // error                   
	            }
	            else {
	            	//confirmamos la trama de poner activo un cliente que estaba dado de baja
	                tr.commit();                
	            }            
	        }         
	            
	        else{
	                id = -3;//ya esta dado de alta
	        }

        }
        finally {
            TransactionManager.getInstance().deleteTransaction();        	
        }
        return id;            
	}

	@Override
	public int bajaCliente(int id) throws Exception {
		Transaction tr = null; 
		DAOCliente dao = DaoFactory.getInstance().createDAOCliente(); 
		
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			tr.start();
			
			TCliente tc = dao.read(id);
	
			if (tc != null){
				if (tc.getActivo()){
					tc.setActivo(false);
					id = dao.update(tc);
					if (id == 0){
						id = -1;
						tr.rollback(); // error al dar de baja a un cliente existente activo
					}
					else{
						tr.commit(); // damos de baja a un cliente de la bdd existente activo
					}
				} 
				else{
					id = -2; // ya esta dado de baja
				}
			} 
			else{
				id = -3; // error, no existe el cliente
			}
			
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return id;
	}

	@Override
	public int modificarCliente(TCliente t) throws Exception {
		int id = 0;
		Transaction tr = null; 
		DAOCliente dao = DaoFactory.getInstance().createDAOCliente(); 
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			tr.start();
			
			TCliente tExist = dao.read(t.getId());
	
			if (tExist != null){
				if (tExist.getActivo()){
					
					if(!t.getNombre().isEmpty())
						tExist.setNombre(t.getNombre());
					
					if(!t.getDomicilio().isEmpty())
						tExist.setDomicilio(t.getDomicilio());
					
					if(!Long.toString(t.getTarjeta()).isEmpty())
						tExist.setTarjeta(t.getTarjeta());	
					
					id = dao.update(tExist);
					if (id == 0){
						id = -1;//error al modificar un cliente existente					
						tr.rollback();//error
					}
					else
						tr.commit();// modificado corretamete
				} 
				else{
					id = -2; // error esta dado de baja
				}
			}
			else{
				id = -3; // no existe ese cliente
			}
		}
		finally{
			TransactionManager.getInstance().deleteTransaction();
		}
		
		return id;
	}

	@Override
	public TCliente detalleCliente(int id) throws Exception{
		
		Transaction tr = null; 
		TransactionManager.getInstance().newTransaction();
		tr = TransactionManager.getInstance().getTransaction();
		
		tr.start();
		
		TCliente t = DaoFactory.getInstance().createDAOCliente().read(id);
		
		tr.commit();
		
		TransactionManager.getInstance().deleteTransaction();
	
		return t;
	}

	@Override
	public ArrayList<TCliente> listaCliente() throws Exception {
		Transaction tr = null; 
		ArrayList<TCliente> lista = null; 
		try {
		TransactionManager.getInstance().newTransaction();
		tr = TransactionManager.getInstance().getTransaction();
		
		tr.start();
		
		lista = DaoFactory.getInstance().createDAOCliente().list();
		
		tr.commit();
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		
		
		return lista;
	}

	@Override
	public List<VIPResultado> clienteVip() throws Exception {
		Transaction tr;
		List<VIPResultado> vip = null;
		Query q = null; 
		try {
			TransactionManager.getInstance().newTransaction();
			
			tr = TransactionManager.getInstance().getTransaction();
			
			q = (Query) QueryFactory.getInstance().newQuery("ClienteAlquilerMasCostoso");
			
			if(q != null) {
				tr.start();
				
				vip = (ArrayList<VIPResultado>) q.execute(null);
				
				tr.commit();
			}
			else
				throw new Exception("Error al cargar la query"); 
		} 
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return vip;
	}

	@Override
	public int eliminaCliente(int id) {
		Transaction tr = null; 
		DAOCliente dao = DaoFactory.getInstance().createDAOCliente();
		int res = 0; 
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			if(dao.read(id) != null) {
				res = dao.delete(id);
				//Error al intentar eliminar el cliente. 
				if(res == 0) {
					res = -2;
					tr.rollback();
				}
				else
					tr.commit();
			}
			//El cliente no existe. 
			else {
				res = -1;
				tr.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return res;
	}

	
}