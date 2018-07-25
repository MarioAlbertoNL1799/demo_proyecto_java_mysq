/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionsql;

import java.sql.DriverManager; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conectar extends javax.swing.JFrame {

    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    
    public void Conectar(){
         String marca = null;
         marca = (String) this.jcb_marca.getSelectedItem();
         try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/demo_proyecto","root","1234");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from productos");             

            rs.next(); 
            this.jtf_id_producto.setText(rs.getString("id_producto"));                         
            this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
            this.jcb_marca.setSelectedItem(rs.getObject("marca"));
            this.jtf_existencias.setText(rs.getString("existencias")); 

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    } 
    private void Primer_registro(){
        try{             
             rs.first();
                 this.jtf_id_producto.setText(rs.getString("id_producto"));                         
                 this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
                 this.jcb_marca.setSelectedItem(rs.getObject("marca"));
                 this.jtf_existencias.setText(rs.getString("existencias")); 
         }
         catch(Exception err) {
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    }
    
    private void Anterior_registro(){
        try{             
             if(rs.isFirst()==false) {
                 rs.previous();
                 this.jtf_id_producto.setText(rs.getString("id_producto"));                         
                 this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
                 this.jcb_marca.setSelectedItem(rs.getObject("marca"));
                 this.jtf_existencias.setText(rs.getString("existencias")); 
              }         
         }
         catch(Exception err) {
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    }
    
    private void Siguiente_registro(){
        try{             
             if(rs.isLast()==false) {
                 rs.next();
                 this.jtf_id_producto.setText(rs.getString("id_producto"));                         
                 this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
                 this.jcb_marca.setSelectedItem(rs.getObject("marca"));
                 this.jtf_existencias.setText(rs.getString("existencias")); 
              }         
         }
         catch(Exception err) {
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    }
    
    private void Ultimo_Registro(){
        try{             
             rs.last();
                 this.jtf_id_producto.setText(rs.getString("id_producto"));                         
                 this.jtf_nombre_producto.setText(rs.getString("nombre_producto"));             
                 this.jcb_marca.setSelectedItem(rs.getObject("marca"));
                 this.jtf_existencias.setText(rs.getString("existencias")); 
         }
         catch(Exception err) {
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    }
    private void guardarRegistro(){
        try{
            int id_producto =Integer.parseInt(this.jtf_id_producto.getText());
            String name = this.jtf_nombre_producto.getText();
            Object valor = this.jcb_marca.getSelectedItem();
            String marca = String.valueOf(valor);
            int existencias = Integer.parseInt(this.jtf_existencias.getText());
            if (id_producto == 0){
        //toma de valores
                st.executeUpdate("Insert into productos (nombre_producto,marca,existencias)"+"values ('"+ name +"','"+ marca+"','"+existencias+"');");
            }
            else if (id_producto > 0){
                st.executeUpdate("Update productos set nombre_producto = '"+ name +"', marca = '"+ marca+"', existencias ='"+existencias+"' where id_producto = '"+id_producto+"';");
            }   
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
    private void borrarRegistro(){
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eiminar el registro?");
        if (JOptionPane.OK_OPTION== confirmar){
        try {
            int id_producto = Integer.parseInt(this.jtf_id_producto.getText());
            st.executeUpdate(" Delete from productos where id_producto = "+ id_producto);
            JOptionPane.showMessageDialog(null, "Articulo Borrado");
            st.executeQuery("select * from productos");
            this.Primer_registro();
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
        }
    }
    public Conectar() {
        initComponents();
        this.Conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_datos = new javax.swing.JPanel();
        jl_id_producto = new javax.swing.JLabel();
        jtf_id_producto = new javax.swing.JTextField();
        jl_nombre_producto = new javax.swing.JLabel();
        jtf_nombre_producto = new javax.swing.JTextField();
        jl_marca = new javax.swing.JLabel();
        jcb_marca = new javax.swing.JComboBox<>();
        jl_existtencias = new javax.swing.JLabel();
        jtf_existencias = new javax.swing.JTextField();
        jp_controles_movimiento = new javax.swing.JPanel();
        jb_primero = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_ultima = new javax.swing.JButton();
        jp_controles = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_id_producto.setText("Id Producto:");

        jtf_id_producto.setText(" ");
        jtf_id_producto.setEnabled(false);

        jl_nombre_producto.setText("Nombre del producto:");

        jtf_nombre_producto.setText(" ");
        jtf_nombre_producto.setEnabled(false);

        jl_marca.setText("Marca:");

        jcb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quacker", "Cemex", "Duracell", "Otro" }));
        jcb_marca.setEnabled(false);

        jl_existtencias.setText("Existencias:");

        jtf_existencias.setText(" ");
        jtf_existencias.setEnabled(false);

        javax.swing.GroupLayout jp_datosLayout = new javax.swing.GroupLayout(jp_datos);
        jp_datos.setLayout(jp_datosLayout);
        jp_datosLayout.setHorizontalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_nombre_producto)
                    .addComponent(jl_marca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_existtencias, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_id_producto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jp_datosLayout.setVerticalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_id_producto)
                    .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_nombre_producto)
                    .addComponent(jtf_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_marca)
                    .addComponent(jcb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_existtencias)
                    .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jb_primero.setText("|<");
        jb_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_primeroMouseClicked(evt);
            }
        });

        jb_anterior.setText("<");
        jb_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_anteriorMouseClicked(evt);
            }
        });

        jb_siguiente.setText(">");
        jb_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_siguienteMouseClicked(evt);
            }
        });

        jb_ultima.setText(">|");
        jb_ultima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_ultimaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_controles_movimientoLayout = new javax.swing.GroupLayout(jp_controles_movimiento);
        jp_controles_movimiento.setLayout(jp_controles_movimientoLayout);
        jp_controles_movimientoLayout.setHorizontalGroup(
            jp_controles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controles_movimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_ultima, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_controles_movimientoLayout.setVerticalGroup(
            jp_controles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_controles_movimientoLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jp_controles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_ultima, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_nuevoMouseClicked(evt);
            }
        });

        jb_cancelar.setText("Cancelar");
        jb_cancelar.setEnabled(false);
        jb_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelarMouseClicked(evt);
            }
        });

        jb_modificar.setText("Modificar");
        jb_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_modificarMouseClicked(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.setEnabled(false);
        jb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardarMouseClicked(evt);
            }
        });

        jb_borrar.setText("Borrar");
        jb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_borrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_controlesLayout = new javax.swing.GroupLayout(jp_controles);
        jp_controles.setLayout(jp_controlesLayout);
        jp_controlesLayout.setHorizontalGroup(
            jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controlesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jb_cancelar)
                .addGap(28, 28, 28)
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jp_controlesLayout.setVerticalGroup(
            jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_controlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_modificar)
                    .addComponent(jb_cancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_guardar)
                    .addComponent(jb_borrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jp_controles_movimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_controles_movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp_controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_siguienteMouseClicked
        this.Siguiente_registro();
    }//GEN-LAST:event_jb_siguienteMouseClicked

    private void jb_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_anteriorMouseClicked
        this.Anterior_registro();
    }//GEN-LAST:event_jb_anteriorMouseClicked

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked
        this.Primer_registro();
    }//GEN-LAST:event_jb_primeroMouseClicked

    private void jb_ultimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_ultimaMouseClicked
        this.Ultimo_Registro();
    }//GEN-LAST:event_jb_ultimaMouseClicked

    private void jb_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_nuevoMouseClicked
        this.jb_anterior.setEnabled(false);
        this.jb_siguiente.setEnabled(false);
        this.jb_primero.setEnabled(false);
        this.jb_ultima.setEnabled(false);
        this.jb_nuevo.setEnabled(false);
        this.jb_borrar.setEnabled(false);
        this.jb_modificar.setEnabled(false);
        this.jtf_id_producto.setText("0");
        this.jtf_id_producto.setEnabled(false);
        this.jtf_nombre_producto.setEnabled(true);
        this.jtf_existencias.setEnabled(true);
        this.jcb_marca.setEnabled(true);
        this.jtf_existencias.setText("0");
        this.jtf_nombre_producto.setText("");
        this.jb_cancelar.setEnabled(true);
        this.jb_guardar.setEnabled(true);
    }//GEN-LAST:event_jb_nuevoMouseClicked

    private void jb_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardarMouseClicked
        this.guardarRegistro();
        this.Primer_registro();
    }//GEN-LAST:event_jb_guardarMouseClicked

    private void jb_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_modificarMouseClicked
        this.jcb_marca.setEnabled(true);
        this.jtf_nombre_producto.setEnabled(true);
        this.jtf_existencias.setEnabled(true);
        this.jb_modificar.setEnabled(false);
        this.jb_guardar.setEnabled(true);
        this.jb_borrar.setEnabled(false);
        this.jb_cancelar.setEnabled(true);
        this.jb_nuevo.setEnabled(false);
        this.jb_anterior.setEnabled(false);
        this.jb_siguiente.setEnabled(false);
        this.jb_ultima.setEnabled(false);
        this.jb_primero.setEnabled(false);
    }//GEN-LAST:event_jb_modificarMouseClicked

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        this.jtf_existencias.setEnabled(false);
        this.jtf_nombre_producto.setEnabled(false);
        this.jcb_marca.setEnabled(false);
        this.jb_anterior.setEnabled(true);
        this.jb_siguiente.setEnabled(true);
        this.jb_ultima.setEnabled(true);
        this.jb_primero.setEnabled(true);
        this.jb_cancelar.setEnabled(false);
        this.jb_nuevo.setEnabled(true);
        this.jb_modificar.setEnabled(true);
        this.jb_borrar.setEnabled(true);
        this.jb_guardar.setEnabled(false);
        this.Primer_registro();
    }//GEN-LAST:event_jb_cancelarMouseClicked

    private void jb_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_borrarMouseClicked
        this.borrarRegistro();
    }//GEN-LAST:event_jb_borrarMouseClicked

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
            java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conectar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conectar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultima;
    private javax.swing.JComboBox<String> jcb_marca;
    private javax.swing.JLabel jl_existtencias;
    private javax.swing.JLabel jl_id_producto;
    private javax.swing.JLabel jl_marca;
    private javax.swing.JLabel jl_nombre_producto;
    private javax.swing.JPanel jp_controles;
    private javax.swing.JPanel jp_controles_movimiento;
    private javax.swing.JPanel jp_datos;
    private javax.swing.JTextField jtf_existencias;
    private javax.swing.JTextField jtf_id_producto;
    private javax.swing.JTextField jtf_nombre_producto;
    // End of variables declaration//GEN-END:variables
}
