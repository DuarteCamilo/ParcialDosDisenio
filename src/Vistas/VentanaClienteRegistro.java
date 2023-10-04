/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;
import ConexioDB.ConexionDB;
import Controladores.ControladorVentanaClienteRegistro;
import Modelos.Cliente;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cduar
 */
public class VentanaClienteRegistro extends javax.swing.JFrame {
    private ControladorVentanaClienteRegistro controlador;

    /**
     * Creates new form VentanaClienteRegistro
     */
    public VentanaClienteRegistro() {
        initComponents();
        this.controlador = new  ControladorVentanaClienteRegistro();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btRegistar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gestion Cliente"));

        btRegistar.setText("Registrar");
        btRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistarActionPerformed(evt);
            }
        });

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Email:");

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btBuscar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btRegistar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRegistar)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if ( txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Escriba un número de ID o el nombre de una categoría para buscar en la base de datos");
            return;
        }
        String cliente_id = txtId.getText();
        boolean encontrado = false; 
        try {
            int filas = tablaClientes.getRowCount();
            int segundaColumna = 0;
            for (int i = 0; i < filas; i++) {
                Object valor = tablaClientes.getValueAt(i, segundaColumna);
                if (cliente_id.equals(valor.toString())) {
                    String nombre = tablaClientes.getValueAt(i, 1).toString();
                    String email = tablaClientes.getValueAt(i, 2).toString();
                    txtNombre.setText(nombre);
                    txtEmail.setText(email);
                    txtId.setEditable(false);
                    encontrado = true; 
                    //limpiarCampos();
                    break; 
                }
            }
        } catch (Exception e) {
        }
    
    
        if (!encontrado) {
            LimpiarCampos();
            JOptionPane.showMessageDialog(rootPane, "No se encontró ninguna coincidencia");
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
         if(txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty()   ){
            JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos de texto para editar al cliente en la base de datos");
            return;
        }
       
        try {
           int cliente_id = Integer.parseInt(txtId.getText()) ;
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            Cliente cliente = new Cliente(cliente_id, nombre, email);
         
            boolean respuesta  = controlador.editarCliente(cliente);
            if(respuesta){
                LimpiarCampos();
                actualizarTabla();
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistarActionPerformed
        if(txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty()   ){
            JOptionPane.showMessageDialog(rootPane, "Ingrese todos los campos de texto para agregar al cliente en la base de datos");
            return;
        }
        
        try {
            int cliente_id = Integer.parseInt(txtId.getText()) ;
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            Cliente cliente = new Cliente(cliente_id, nombre, email);
         
            boolean respuesta  = controlador.aniadirCliente(cliente);
            if(respuesta){
                LimpiarCampos();
                actualizarTabla();
            }else{
                txtId.setText("");
            }
            

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btRegistarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        if(txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingrese un numero de id en el campo de texto para eliminar al cliente");
        }else{
            try {
                int cliente_id = Integer.parseInt(txtId.getText());
                controlador.eliminarCliente(cliente_id);
                LimpiarCampos();
                actualizarTabla();
            } catch (Exception ex) {
            } 
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Inicio i = new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
       char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE )) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros"); 
        }else if (txtId.getText().length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 10 caracteres permitidos");
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != KeyEvent.VK_BACK_SPACE) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo letras "); 
        } else if (txtNombre.getText().length() >= 250) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 250 caracteres permitidos");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        char c = evt.getKeyChar();
        if ( c == ' ') {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, " sin espacios"); 
        } else if (txtEmail.getText().length() >= 300) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 300 caracteres permitidos");
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int row = tablaClientes.getSelectedRow();
        txtId.setText(tablaClientes.getValueAt(row,0).toString());
        txtId.setEditable(false);
        txtNombre.setText(tablaClientes.getValueAt(row,1).toString());
        txtEmail.setText(tablaClientes.getValueAt(row,2).toString());

    }//GEN-LAST:event_tablaClientesMouseClicked

    
    public void LimpiarCampos(){
        String t = "";
        txtId.setText(t);
        txtId.setEditable(true);
        txtEmail.setText(t);
        txtNombre.setText(t);
    }
    public void actualizarTabla(){
        DefaultTableModel modelo = new  DefaultTableModel();
        tablaClientes.setModel(modelo);  

        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }
            }
        }catch(NullPointerException e){
        }
        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            java.sql.Connection conn = ConexionDB.getINSTANCE().getConnection();
 
            String sql = "SELECT cliente_id,nombre,email FROM clientes ";                    
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Email");
           

            int anchos[] = {70, 150 , 150 };
            for (int i = 0; i < tablaClientes.getColumnCount(); i++) {
                tablaClientes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);                
            }
            
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaClienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaClienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaClienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaClienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaClienteRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btRegistar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
