/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Waiter;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Shakil
 */
public class new_order2 extends javax.swing.JFrame {

    /**
     * Creates new form new_order2
     */
    
    private Connection myConn;
    public DefaultTableModel model,model2;
    public String name ,need,deliver ;
    public int id;
    

    
    public new_order2() {
        
            Properties props = new Properties();
        try {
        props.load(new FileInputStream("demo.properties")); //loading demo properties file    
        } catch (IOException ex) {
            Logger.getLogger(new_order2.class.getName()).log(Level.SEVERE, null, ex);
        }
		String user = props.getProperty("user"); //from that taking the user 
         
		String password = props.getProperty("password"); // password 
  
                String dburl = props.getProperty("dburl"); //url of the database
               
		
        try {
        // connect to database
            myConn = DriverManager.getConnection(dburl, user, password);
            
        } catch (SQLException ex) {
            Logger.getLogger(new_order2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        initComponents();
        
         // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Item no","Item Name","Item Price"};
        model= new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        jTable1.setModel(model);
        
        //Table 2
        Object[] columns2 = {"Item Name","Item Quantity","Item Price"};
        model2= new DefaultTableModel();
        model2.setColumnIdentifiers(columns2);
        jTable2.setModel(model2);
        
        
        
    }
      public void order(String x)
    {
        deliver=x;
        retrive();
    }
    
     public void retrive()
    {
                System.out.println("retrive");
                PreparedStatement myStmt = null;
                model2.setRowCount(0);
                Object[] row = new Object[3];

		
		try {
			myStmt = myConn.prepareStatement("Select * from orderitem where Ordeer=?");
			myStmt.setString(1, deliver);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
			while (rs.next()) {
                            
                            System.out.println("x");
                            row[0]=rs.getString("name");
                            row[1]=rs.getString("quantity");
                            row[2]=rs.getString("price");
                            
                           
                            
                            model2.addRow(row);
  
				
			}
                        

				
		}
        catch (SQLException ex) {
           //Logger.getLogger(List_new.class.getName()).log(Level.SEVERE, null, ex);

        }	
    
    }
      public void count()
    {
                System.out.println("retrive");
                PreparedStatement myStmt = null;
                model2.setRowCount(0);
                Object[] row = new Object[3];
		double count=0;
                double coun2;
		try {
			myStmt = myConn.prepareStatement("Select * from orderitem where Ordeer=?");
			myStmt.setString(1, deliver);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
			while (rs.next()) {
                            
                            
                            row[0]=rs.getString("name");
                            row[1]=rs.getString("quantity");
                            row[2]=rs.getString("price");
                            
                            coun2=Double.parseDouble(rs.getString("quantity"));
                            count=count+Double.parseDouble(rs.getString("price"))*coun2;
                             
                             //System.out.println(count);
                             
                            TotalLabel.setText(String.valueOf(count));
                            
                            model2.addRow(row);
  
				
			}
                        

				
		}
        catch (SQLException ex) {
           //Logger.getLogger(List_new.class.getName()).log(Level.SEVERE, null, ex);

        }	
    
    }
      public void orderlist(String x, String y)
      {
                PreparedStatement myStmt = null;
        
       

		try {
			myStmt = myConn.prepareStatement("update orderpanel"
					+ " set total=?"
					+ " where orderNo=?");
			
                        
			// set params
			myStmt.setString(1, y);
			myStmt.setString(2, x);
		
			
			// execute SQL
			myStmt.executeUpdate();			
		}
        catch (SQLException ex) {
           
        }		finally {
                	
		}
        
          
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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ConfirmBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        itemlabel = new javax.swing.JLabel();
        pricelabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        TotalLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1175, 544));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("       New Order2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main", "Drinks", "Starter", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ConfirmBtn.setText("Confirm");
        ConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmBtn)
                    .addComponent(CancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemlabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Name"));

        pricelabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Price "));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantity "));
        jTextField1.setPreferredSize(new java.awt.Dimension(22, 23));

        jButton2.setText("ADD ITEM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        TotalLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Total"));

        jButton3.setText("Change");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete ITEMS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TotalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(itemlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(pricelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(pricelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                PreparedStatement myStmt= null;
		 model.setRowCount(0);
                Object[] row = new Object[3];
                String name=(String) jComboBox1.getSelectedItem();
		
		try {
			myStmt = myConn.prepareStatement("Select * from items where cat=?");
			myStmt.setString(1, name);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
			while (rs.next()) {
                            
                            row[0]=rs.getString("number");
                            row[1]=rs.getString("name");
                            row[2]=rs.getString("price");
                            
                            model.addRow(row);
  
				
			}
                        

				
		}
        catch (SQLException ex) {
           //Logger.getLogger(List_new.class.getName()).log(Level.SEVERE, null, ex);

        }	
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       // Get The Index Of The Slected Row 
        int i = jTable1.getSelectedRow();
        
        TableModel model = jTable1.getModel();
        
        // Display Slected Row In jalbel
        itemlabel.setText(model.getValueAt(i,1).toString());

        pricelabel.setText(model.getValueAt(i,2).toString());

       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
                PreparedStatement myStmt = null;
        
       

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into orderitem"
					+ " (name, quantity, price,Ordeer)"
					+ " values (?, ?, ?,?)");
			
			// set params
			myStmt.setString(1, itemlabel.getText());
			myStmt.setString(2, jTextField1.getText());
			myStmt.setString(3, pricelabel.getText());
                        myStmt.setString(4, deliver);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
        catch (SQLException ex) {
           
        }		finally {
                	
		}
        
        
        
        
                Object[] row = new Object[3];
        
                row[0] = itemlabel.getText();
                row[1] = jTextField1.getText();
                row[2] = pricelabel.getText();
           
                
                // add row to the model
                model2.addRow(row);
                
                itemlabel.setText("");
                jTextField1.setText("");
                pricelabel.setText("");
                count();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
               
               PreparedStatement myStmt = null;
            

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update orderitem"
					+ " set name=?, quantity=?, price=? "
					+ " where id=?");
			
                        
			// set params
			myStmt.setString(1, itemlabel.getText());
			myStmt.setString(2, jTextField1.getText());
			myStmt.setString(3, pricelabel.getText());
			myStmt.setInt(4, id);
			
			// execute SQL
			myStmt.executeUpdate();	
                        
                        
		}
        catch (SQLException ex) {
       
        }
                
                
                retrive();
       
                itemlabel.setText("");
                jTextField1.setText("");
                pricelabel.setText("");
                count();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
                
          int i = jTable2.getSelectedRow();
          System.out.println(i);
          TableModel model = jTable2.getModel();
        
        // Display Slected Row In jalbel
          need = model.getValueAt(i,0).toString();
        
        
                PreparedStatement myStmt= null;
		
             //data statement sql 
		
		try {
			myStmt = myConn.prepareStatement("Select * from orderitem where name=?");
			myStmt.setString(1, need);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                      //  System.out.println(need+"x");
                        //checking for that id all element 
                        
			while (rs.next()) {
                            
                            
                            id=rs.getInt("id");
                            String  y=rs.getString("name");
                            String  y1=rs.getString("quantity");
                            String  y2=rs.getString("price");
                            
                             itemlabel.setText(y);
                             jTextField1.setText(y1);
                             pricelabel.setText(y2);
                             
                             
                            
		
			}
                        

				
		}
        catch (SQLException ex) {
                System.out.println(ex);

        }
                
                
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                  PreparedStatement myStmt= null;
	
              
      

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("delete from orderitem where id=?");
			
			// set param
			myStmt.setInt(1, id);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
        catch (SQLException ex) {
            
        }		finally {
			
		}
                   
                  retrive();
                  itemlabel.setText("");
                  jTextField1.setText("");
                  pricelabel.setText("");
              
            count();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBtnActionPerformed
        // TODO add your handling code here:
        
        
        orderlist(deliver, TotalLabel.getText());
        this.setVisible(false);
        
        
        
    }//GEN-LAST:event_ConfirmBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
    }//GEN-LAST:event_CancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(new_order2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(new_order2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(new_order2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(new_order2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new new_order2().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel itemlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel pricelabel;
    // End of variables declaration//GEN-END:variables
}
