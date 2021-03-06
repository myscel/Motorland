package Presentacion.vistas.vistaAlquiler.vistaAlquilerEmergente;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Negocio.Alquiler.TAlquiler;
import Negocio.Alquiler.TLineaAlquiler;
import Negocio.Alquiler.enumeradosAlq.Accion;
import Negocio.Alquiler.enumeradosAlq.Operacion;
import Negocio.Alquiler.miscelanea.CalculadorPrecios;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class AlquilerEmergenteGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TAlquiler tAlquiler; 
	private Accion tipoAccion; 
	//Para la operacion de modificacion. 
	private HashSet<TVehiculo> vehiculosAA�adir; 
	private HashSet<TVehiculo> vehiculosAEliminar;
	//Contiene todos los vehiculos que se pueden a�adir al alquiler. 
	private HashSet<Integer> vIDDisponiblesIniciales; 
	//Contiene todos los vehiculos originales del alquiler que se quiere modificar
	private HashSet<Integer> vIDVehiculosAlquiladosIniciales;
    /**
     * Creates new form AltaAlquilerEmergente
     */
    public AlquilerEmergenteGUI(TAlquiler tAlquiler) {
    	this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/MotorLand.png")).getImage());
        this.tAlquiler = tAlquiler; 
        CalculadorPrecios.calculaTarifa(tAlquiler.getFechaIni(), tAlquiler.getFechaFin());
    	initComponents();
    }

    public  AlquilerEmergenteGUI() {
    	this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/MotorLand.png")).getImage());
    	tAlquiler = null; 
    	
    	initComponents();
	}
    
    public void setTAlquiler(TAlquiler t) {
    	tAlquiler = t;
    }
    
    public TAlquiler getTAlquiler() {
    	return tAlquiler;
    }
    
    public void configuraFechas() {
    	CalculadorPrecios.calculaTarifa(tAlquiler.getFechaIni(), tAlquiler.getFechaFin());
        fechaITF.setText(tAlquiler.getFechaIniLegible());
     	fechaFTF.setText(tAlquiler.getFechaFinLegible());
    }
    
    public void muestraVehiculosDisponibles(ArrayList<TVehiculo> lista) {
    	double precioBase; 
    	for(TVehiculo v : lista) {
    		precioBase = v.getCoste();
    		v.setCoste(CalculadorPrecios.calculaPrecioAgregado(precioBase));
    		vDisponiblesModel.addElement(v);
    		
    		if(tipoAccion == Accion.MODIFICACION)
    			vIDDisponiblesIniciales.add(v.getId());
    	}
    	
    	
    }
    public void muestraVehiculosAlquilados(ArrayList<TVehiculo> lista) {
    	for (TVehiculo v : lista) {
			vAgregadosModel.addElement(v);
			vIDVehiculosAlquiladosIniciales.add(v.getId());
		}
    	importeTF.setText("" + tAlquiler.getCosteTotal());
    }
    
    public void limpiaCampos() {
    	fechaITF.setText("");
    	fechaFTF.setText("");
    	importeTF.setText("");
    	vDisponiblesModel.removeAllElements();
    	vAgregadosModel.removeAllElements();
    }
    public Accion getTipo() {
    	return tipoAccion;
    }
    
    public void setTipo(Accion tipo) {
    	tipoAccion = tipo;
    }
    
    public void preparaTipo() {
    	if(tipoAccion == Accion.MODIFICACION) {
    		vehiculosAA�adir = new HashSet<>();
        	vehiculosAEliminar = new HashSet<>();
        	vIDDisponiblesIniciales = new HashSet<>(); 
        	vIDVehiculosAlquiladosIniciales = new HashSet<>();
    	}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vehiculosDisponiblesL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vDisponiblesList = new javax.swing.JList<>();
        agrVehiculoB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        vehiculosAgreL = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        vAgregadosList = new javax.swing.JList<>();
        importeL = new javax.swing.JLabel();
        importeTF = new javax.swing.JTextField();
        eliVehiculoB = new javax.swing.JButton();
        confAlquilerB = new javax.swing.JButton();
        DesAlquilerB = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaITF = new javax.swing.JTextField();
        fechaFTF = new javax.swing.JTextField();
        
        vAgregadosModel = new DefaultListModel<>();
        vDisponiblesModel = new DefaultListModel<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configura Alquiler");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        vehiculosDisponiblesL.setForeground(new java.awt.Color(0, 0, 102));
        vehiculosDisponiblesL.setText("VEH�CULOS DISPONIBLES");

        vDisponiblesList.setModel(vDisponiblesModel);
        
        
        jScrollPane1.setViewportView(vDisponiblesList);

        agrVehiculoB.setText("Agregar");
        agrVehiculoB.setToolTipText("Agrega un veh�culo de la lista de veh�culos disponibles.");
        agrVehiculoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agrVehiculoBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehiculosDisponiblesL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agrVehiculoB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vehiculosDisponiblesL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agrVehiculoB)
                .addGap(7, 7, 7))
        );

        vehiculosAgreL.setForeground(new java.awt.Color(51, 153, 0));
        vehiculosAgreL.setText("VEH�CULOS AGREGADOS");

        vAgregadosList.setModel(vAgregadosModel);
        
        jScrollPane3.setViewportView(vAgregadosList);

        importeL.setText("Importe:");

        importeTF.setEditable(false);
        
     /*   if(tipoAccion == Accion.MODIFICACION)
        	importeTF.setText("" + tAlquiler.getCosteTotal());*/
        
        importeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importeTFActionPerformed(evt);
            }
        });

        eliVehiculoB.setText("Eliminar");
        eliVehiculoB.setToolTipText("Elimina un veh�culo de la lista de veh�culos que quieres alquilar.");
        eliVehiculoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliVehiculoBActionPerformed(evt);
            }
        });

        confAlquilerB.setBackground(new java.awt.Color(153, 153, 255));
        confAlquilerB.setText("Confirmar Alquiler");
        confAlquilerB.setToolTipText("Guarda el alquiler realizado.");
        confAlquilerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					confAlquilerBActionPerformed(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        DesAlquilerB.setBackground(new java.awt.Color(255, 153, 153));
        DesAlquilerB.setText("Deshacer Alquiler");
        DesAlquilerB.setToolTipText("Deshace los cambios y vuelve a la ventana anterior.");
        DesAlquilerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesAlquilerBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vehiculosAgreL)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(importeL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(importeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(eliVehiculoB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DesAlquilerB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confAlquilerB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vehiculosAgreL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliVehiculoB)
                    .addComponent(confAlquilerB, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(importeL)
                            .addComponent(importeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DesAlquilerB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel3.setText("Fecha Inicial: ");

        jLabel4.setText("Fecha Final:");

        fechaITF.setEditable(false);

        fechaFTF.setEditable(false);
     

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaITF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(fechaFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(fechaITF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void importeTFActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void eliVehiculoBActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	int indiceSel = vAgregadosList.getSelectedIndex();
    	TVehiculo tSel = null;
    	double importeAct = 0; 
    	/*No podemos operar directamente dentro del setText. 
    	 * Realizamos y guardamos la operacion primero.
    	 * 
    	 */
 
    	double resta = 0; 
    	if (vAgregadosModel.isEmpty())
    		JOptionPane.showMessageDialog(this, "No hay veh�culos para eliminar.",
    				"Error al eliminar", JOptionPane.ERROR_MESSAGE);
    	else if(tipoAccion == Accion.MODIFICACION && vAgregadosModel.size() == 1) {
    		JOptionPane.showMessageDialog(this, "El alquiler debe tener al menos un vehiculo",
    				"Error al eliminar", JOptionPane.ERROR_MESSAGE);
    	}
    	else if (indiceSel > - 1) {
    		tSel = vAgregadosList.getSelectedValue();
    		vDisponiblesModel.addElement(tSel);
	    	vAgregadosModel.removeElementAt(indiceSel);
	    	
	    	if (!importeTF.getText().isEmpty())
	    		importeAct = CalculadorPrecios.redondeaPrecio(Double.parseDouble(importeTF.getText()));
	    	
	    	if(tipoAccion == Accion.MODIFICACION) {
	    		if(!vIDDisponiblesIniciales.contains(tSel.getId()))
	    			vehiculosAEliminar.add(tSel);
	    		else {
	    			if(vehiculosAA�adir.contains(tSel))
	    				vehiculosAA�adir.remove(tSel);
	    		}
	    		
	    	}
	    		
	    	resta = CalculadorPrecios.redondeaPrecio((importeAct - tSel.getCoste()));
	    	
	    	
	    	importeTF.setText("" + resta);
    	}
    	else
    		JOptionPane.showMessageDialog(this,
    			    "No ha seleccionado ning�n veh�culo.",
    			    "Error al eliminar",
    			    JOptionPane.ERROR_MESSAGE);
    }                                            

    private void confAlquilerBActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {                                              
        // TODO add your handling code here:
    	TVehiculo v; 
    	double precio;
    	double precioTotal = 0; 
    	TLineaAlquiler tL;
    	
    	tAlquiler.setCosteTotal(Double.parseDouble(importeTF.getText()));
    	
    	if(tipoAccion == Accion.ALTA) {
    		for(int i = 0; i < vAgregadosModel.size(); i++) {
        		v = vAgregadosModel.get(i);
        		
        		precio = v.getCoste();
        		
        		tL = new TLineaAlquiler(precio);
        		
    			tAlquiler.addTolistaAlquilados(v.getId(), tL);
    			
    			precioTotal += precio;
        	}
    		
    		Controller.getInstance().run(ListaComandos.NEGOCIOALTAALQUILER, tAlquiler);
    	}
    	else if(tipoAccion == Accion.MODIFICACION) {
    		precioTotal = tAlquiler.getCosteTotal();
    		for (TVehiculo vA�adir : vehiculosAA�adir) {
				tL = new TLineaAlquiler(vA�adir.getCoste());
				tL.setOperacion(Operacion.A�ADIR);
				
				tAlquiler.addTolistaAlquilados(vA�adir.getId(), tL);
				
				precioTotal += vA�adir.getCoste();
			}
    		for (TVehiculo vEliminar : vehiculosAEliminar) {
				tL = new TLineaAlquiler(vEliminar.getCoste());
				tL.setOperacion(Operacion.ELIMINAR);
				
				tAlquiler.addTolistaAlquilados(vEliminar.getId(), tL);
				
				precioTotal -= vEliminar.getCoste();
			}
    		
    		Controller.getInstance().run(ListaComandos.NEGOCIOMODIFICARALQUILER, tAlquiler);
    	}    	
    	
    		
    }                                             

    private void agrVehiculoBActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	int indiceSel = vDisponiblesList.getSelectedIndex(); 
    	TVehiculo tSel = null; 
    	double importeAct = 0; 
    	/*No podemos operar directamente dentro del setText. 
    	 * Realizamos y guardamos la operacion primero
    	 */
    	double suma = 0; 
    	if (vDisponiblesModel.isEmpty())
    		JOptionPane.showMessageDialog(this,
    			    "No hay veh�culos disponibles.",
    			    "Error al agregar",
    			    JOptionPane.ERROR_MESSAGE);
    	else if (indiceSel > -1) {
    		tSel = vDisponiblesList.getSelectedValue();
	    	vAgregadosModel.addElement(tSel);
	    	vDisponiblesModel.removeElementAt(indiceSel);
	    	
	    	//Nuevos vehiculos que se quieren a�adir. 
	    	if(tipoAccion == Accion.MODIFICACION) {
	    		if(!vIDVehiculosAlquiladosIniciales.contains(tSel.getId())) {
	    			vehiculosAA�adir.add(tSel);
	    		}
	    		else {
	    			//Si volvemos a agregar un vehiculo que ya existia en el alquiler. No lo eliminamos
	    			if (vehiculosAEliminar.contains(tSel))
	    				vehiculosAEliminar.remove(tSel);
	    		}
	    	}
	    		
	    	
	    	if(!importeTF.getText().isEmpty())
	    		importeAct = CalculadorPrecios.redondeaPrecio((Double.parseDouble(importeTF.getText())));

	    	suma = CalculadorPrecios.redondeaPrecio(importeAct + tSel.getCoste());
	    	importeTF.setText("" + suma);
    	}
    	else
    		JOptionPane.showMessageDialog(this,
    			    "No ha seleccionado ning�n veh�culo.",
    			    "Error al agregar",
    			    JOptionPane.ERROR_MESSAGE);
    }                                            

    private void DesAlquilerBActionPerformed(java.awt.event.ActionEvent evt) {                                             
       Controller.getInstance().run(ListaComandos.CERRAR_VISTA_ALQUILER_EMERGENTE, null);
    }                                                                                

    // Variables declaration - do not modify                     
    private javax.swing.JButton DesAlquilerB;
    private javax.swing.JButton agrVehiculoB;
    private javax.swing.JButton confAlquilerB;
    private javax.swing.JButton eliVehiculoB;
    private javax.swing.JTextField fechaFTF;
    private javax.swing.JTextField fechaITF;
    private javax.swing.JLabel importeL;
    private javax.swing.JTextField importeTF;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<TVehiculo> vAgregadosList;
    private javax.swing.DefaultListModel<TVehiculo> vAgregadosModel;
    private javax.swing.JList<TVehiculo> vDisponiblesList;
    private javax.swing.DefaultListModel<TVehiculo> vDisponiblesModel;
    private javax.swing.JLabel vehiculosAgreL;
    private javax.swing.JLabel vehiculosDisponiblesL;
    // End of variables declaration                   
	
}
