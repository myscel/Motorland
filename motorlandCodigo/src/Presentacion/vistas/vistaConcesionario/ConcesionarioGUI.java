package Presentacion.vistas.vistaConcesionario;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Negocio.concesionario.Concesionario;
import Negocio.concesionario.ConcesionarioDepartamento;
import Negocio.concesionario.ConcesionarioDepartamentoID;
import Negocio.departamento.Departamento;
import Presentacion.comandos.listadecomandos.ListaComandosJPA;
import Presentacion.controlador.Controller;

public class ConcesionarioGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String SEPARATOR = "\n -------------------------------------------------------------- \n";
	
	/**
     * Creates new form ConcesionarioGUI
     */
    public ConcesionarioGUI() {
    	this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/MotorLand.png")).getImage());
        initComponents();
    }

    public void muestra(String texto) {
    	concesionarioTA.append(texto);
    	concesionarioTA.append(SEPARATOR);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        concesionarioTA = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        direccionTF = new javax.swing.JTextField();
        departamentoTF = new javax.swing.JTextField();
        presupuestoTF = new javax.swing.JTextField();
        limpiarB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idDepartamentoTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        altaB = new javax.swing.JButton();
        bajaB = new javax.swing.JButton();
        ModificaB = new javax.swing.JButton();
        consultaB = new javax.swing.JButton();
        listaB = new javax.swing.JButton();
        a�adeB = new javax.swing.JButton();
        eliminaB = new javax.swing.JButton();
        volverB = new javax.swing.JButton();
        calculaPresupuestoB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concesionario");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        concesionarioTA.setEditable(false);
        concesionarioTA.setColumns(20);
        concesionarioTA.setRows(5);
        jScrollPane1.setViewportView(concesionarioTA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Direccion:");

        jLabel3.setText("Departamento:");

        jLabel4.setText("Presupuesto:");

        limpiarB.setText("Limpiar");
        limpiarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBActionPerformed(evt);
            }
        });

        jLabel5.setText("ID:");

        jLabel6.setText("ID departamento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limpiarB))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(direccionTF, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                        .addComponent(nombreTF))
                                    .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(departamentoTF)
                                    .addComponent(presupuestoTF, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idDepartamentoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(direccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idDepartamentoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(departamentoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(presupuestoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(limpiarB)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        altaB.setText("Alta concesionario");
        altaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaBActionPerformed(evt);
            }
        });

        bajaB.setText("Baja concesionario");
        bajaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaBActionPerformed(evt);
            }
        });

        ModificaB.setText("Modifica concesionario");
        ModificaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaBActionPerformed(evt);
            }
        });

        consultaB.setText("Consulta concesionario");
        consultaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaBActionPerformed(evt);
            }
        });

        listaB.setText("Lista concesionarios");
        listaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaBActionPerformed(evt);
            }
        });

        a�adeB.setText("A�ade departamento");
        a�adeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a�adeBActionPerformed(evt);
            }
        });

        eliminaB.setText("Elimina departamento");
        eliminaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaBActionPerformed(evt);
            }
        });

        volverB.setText("Volver");
        volverB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBActionPerformed(evt);
            }
        });

        calculaPresupuestoB.setText("Calcula presupuesto total");
        calculaPresupuestoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculaPresupuestoBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(altaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bajaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModificaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consultaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a�adeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminaB, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverB))
                    .addComponent(calculaPresupuestoB, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaB)
                    .addComponent(calculaPresupuestoB))
                .addGap(18, 18, 18)
                .addComponent(bajaB)
                .addGap(18, 18, 18)
                .addComponent(ModificaB)
                .addGap(18, 18, 18)
                .addComponent(consultaB)
                .addGap(18, 18, 18)
                .addComponent(listaB)
                .addGap(18, 18, 18)
                .addComponent(a�adeB)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminaB)
                    .addComponent(volverB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void altaBActionPerformed(java.awt.event.ActionEvent evt) {
    	String nombre = nombreTF.getText();
    	String direccion = direccionTF.getText();
       if(!nombre.isEmpty() && !direccion.isEmpty())
    	   Controller.getInstance().run(ListaComandosJPA.NEGOCIO_ALTA_CONCESIONARIO,
    			   new Concesionario(nombre, direccion));
       else
    	   JOptionPane.showMessageDialog(this, "Rellene el campo nombre y direcci�n.", "Alta concesionario", 
    			   JOptionPane.ERROR_MESSAGE);
    }                                        

    private void bajaBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        int id;
        try {
        	if(!idTF.getText().isEmpty()) {
        		id = Integer.parseInt(idTF.getText());
        		Controller.getInstance().run(ListaComandosJPA.NEGOCIO_BAJA_CONCESIONARIO, id);
        	}
        	else
        		JOptionPane.showMessageDialog(this, "Introduzca un ID de concesionario.", "Baja concesionario", 
         			   JOptionPane.INFORMATION_MESSAGE);
        }
        catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, "Formato del campo ID incorrecto.", "Baja concesionario", 
     			   JOptionPane.ERROR_MESSAGE);
        }
    }                                     

    private void ModificaBActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int id;
        String nombre = nombreTF.getText();
        String direccion = direccionTF.getText();
        try {
        	if(!idTF.getText().isEmpty() && (!nombre.isEmpty() || !direccion.isEmpty())) {
        		id = Integer.parseInt(idTF.getText());
        		Concesionario c = new Concesionario(id, nombre, direccion);
        		
        		Controller.getInstance().run(ListaComandosJPA.NEGOCIO_MODIFICA_CONCESIONARIO, c);
        	}
        	else
        		JOptionPane.showMessageDialog(this, "Rellene el campo ID y alguno de los campos de concesionario (nombre o direccion).", "Modifica concesionario", 
         			   JOptionPane.INFORMATION_MESSAGE);
        }
        catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, "Formato del campo ID incorrecto.", "Modifica concesionario", 
      			   JOptionPane.ERROR_MESSAGE);
        }
    }                                         

    private void consultaBActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int id;
        try {
        	if(!idTF.getText().isEmpty()) {
        		id = Integer.parseInt(idTF.getText());
        		Controller.getInstance().run(ListaComandosJPA.NEGOCIO_CONSULTA_CONCESIONARIO, id);
        	}
        	else
        		JOptionPane.showMessageDialog(this, "Rellene el campo ID .", "Consulta concesionario", 
          			   JOptionPane.INFORMATION_MESSAGE);
        }
        catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, "Formato del campo ID incorrecto.", "Consulta concesionario", 
       			   JOptionPane.ERROR_MESSAGE);
        }
    }                                         

    private void listaBActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Controller.getInstance().run(ListaComandosJPA.NEGOCIO_LISTA_CONCESIONARIOS, null);
    }                                      

    private void a�adeBActionPerformed(java.awt.event.ActionEvent evt) {
    	int idConcesionario, idDepartamento;
    	double presupuesto;
    	if(!idTF.getText().isEmpty() && !idDepartamentoTF.getText().isEmpty()
    			&& !presupuestoTF.getText().isEmpty()) {
    		try {
    		idConcesionario = Integer.parseInt(idTF.getText());
    		idDepartamento = Integer.parseInt(idDepartamentoTF.getText());
    		presupuesto = Double.parseDouble(presupuestoTF.getText());
    		
    		Controller.getInstance().run(ListaComandosJPA.NEGOCIO_AGREGA_CONCESIONARIODEPARTAMENTO_CONCONCESIONARIO,
    				new ConcesionarioDepartamento(new Concesionario(idConcesionario, "", ""), 
    						new Departamento(idDepartamento, ""), presupuesto));
    		}
    		catch(NumberFormatException e) {
    			JOptionPane.showMessageDialog(this, "Formato de los campos incorrecto.", "Agregar departamento", 
    	       			   JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	else {
    		JOptionPane.showMessageDialog(this, "Introduzca un presupuesto y el ID de un departamento"
    				+ " y concesionario.", "Agregar departamento", JOptionPane.INFORMATION_MESSAGE);
    	}
    }                                      

    private void eliminaBActionPerformed(java.awt.event.ActionEvent evt) {     
    	int idConcesionario, idDepartamento;
    	if(!idTF.getText().isEmpty() && !idDepartamentoTF.getText().isEmpty()) {
    		try {
    		idConcesionario = Integer.parseInt(idTF.getText());
    		idDepartamento = Integer.parseInt(idDepartamentoTF.getText());
    		
    		Controller.getInstance().run(ListaComandosJPA.NEGOCIO_ELIMINA_CONCESIONARIODEPARTAMENTO_CONCESIONARIO,
    				new ConcesionarioDepartamentoID(idConcesionario, idDepartamento));
    		}
    		catch(NumberFormatException e) {
    			JOptionPane.showMessageDialog(this, "Formato de los campos incorrecto.", "Eliminar departamento", 
    	       			   JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	else {
    		JOptionPane.showMessageDialog(this, "Introduzca el ID de un departamento"
    				+ " y concesionario.", "Eliminar departamento", JOptionPane.INFORMATION_MESSAGE);
    	}
    }                                        

    private void calculaPresupuestoBActionPerformed(java.awt.event.ActionEvent evt) {     
    	int id;
    	
    	try {
    		if(!idTF.getText().isEmpty()) {
    			id = Integer.parseInt(idTF.getText());
    			Controller.getInstance().run(ListaComandosJPA.NEGOCIO_CALCULA_PRESUPUESTO_CONCESIONARIO, id);
    		}
    		else
    			JOptionPane.showMessageDialog(this, "Rellene el campo ID de concesionario.", "Calcula presupuesto concesionario", 
           			   JOptionPane.INFORMATION_MESSAGE);
    	}
    	catch (NumberFormatException e) {
    		JOptionPane.showMessageDialog(this, "Formato de los campos incorrecto.", "Eliminar departamento", 
	       			   JOptionPane.ERROR_MESSAGE);
    	}
    }                                                   

    private void volverBActionPerformed(java.awt.event.ActionEvent evt) {    
    	Controller.getInstance().run(ListaComandosJPA.CERRAR_VISTA_CONCESIONARIO, null);
    }                                       

    private void limpiarBActionPerformed(java.awt.event.ActionEvent evt) {  
    	nombreTF.setText("");
    	direccionTF.setText("");
    	departamentoTF.setText("");
    	presupuestoTF.setText("");
    	concesionarioTA.setText("");
    	idDepartamentoTF.setText("");
    	idTF.setText("");
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton ModificaB;
    private javax.swing.JButton a�adeB;
    private javax.swing.JButton bajaB;
    private javax.swing.JButton calculaPresupuestoB;
    private javax.swing.JTextArea concesionarioTA;
    private javax.swing.JButton consultaB;
    private javax.swing.JTextField departamentoTF;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JButton eliminaB;
    private javax.swing.JButton altaB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarB;
    private javax.swing.JButton listaB;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTextField presupuestoTF;
    private javax.swing.JButton volverB;
    private javax.swing.JTextField idTF;
    private javax.swing.JTextField idDepartamentoTF;
    // End of variables declaration  
}
