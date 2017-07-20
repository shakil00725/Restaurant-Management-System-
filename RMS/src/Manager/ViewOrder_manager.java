/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Waiter.*;
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
import javax.swing.JTextField;

/**
 *
 * @author Shakil
 */
public class ViewOrder_manager extends javax.swing.JFrame {

    /**
     * Creates new form ViewOrder
     */
    //public  JTextField id;
    public String id;
    public double count1;
    public String name,address1,address2,address3,phone,tableno;
    public String itemName,itemQuantity,itemPrice;
    

    
    private Connection myConn;
    
    public ViewOrder_manager(String x) {
        
        this.setVisible(true);
        id=x;
        
        DataConnection();
        retrive();
        
        
        
        initComponents();
        jTextArea1.append("\t\t\t RPOSS \n\n"
                +"\t\t\t Order no: "+x+"\n\n"
                +name+" "+"\n"
                +address1+" "+address2+""+address3+"\n"
                +"Mobile No: "+phone+"\n"
                +"Table No: "+tableno+"\n\n"
                +"\t===============================================================\n\n"
                );
                retrive1();
        
      
        
        
        jTextArea1.setEditable(false);
    }
    

    public void DataConnection()
    {
                  Properties props = new Properties();
                  
        try {
        props.load(new FileInputStream("demo.properties")); //loading demo properties file    
        } catch (IOException ex) {
            Logger.getLogger(ViewOrder_manager.class.getName()).log(Level.SEVERE, null, ex);
        }
		String user = props.getProperty("user"); //from that taking the user 
         
		String password = props.getProperty("password"); // password 
  
                String dburl = props.getProperty("dburl"); //url of the database
               
		
        try {
        // connect to database
            myConn = DriverManager.getConnection(dburl, user, password);
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewOrder_manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         public void retrive1()
    {
            
                PreparedStatement myStmt = null;

              
		
		try {
			myStmt = myConn.prepareStatement("Select * from orderitem where Ordeer=?");
			myStmt.setString(1, id);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
                        //jTextArea1.append("Item Name"+"        "+"Item Quantity"+"       "+"Item Price"+"  \n");
			while (rs.next()) {
                            
                         
                            itemName=rs.getString("name");
                            itemQuantity=rs.getString("quantity");
                            itemPrice=rs.getString("price");
                            
                                    
                            
                            jTextArea1.append(itemName+"   "+itemQuantity+"   "+itemPrice+" $\n");
                            
                            
                           double  coun2=Double.parseDouble(rs.getString("quantity"));
                           count1=count1+Double.parseDouble(rs.getString("price"))*coun2;
                             
                      
                            
  
 
				
			}
                        jTextArea1.append("----------------------------------------------\n");
                        jTextArea1.append("Total Price :"+count1+" $\n");
                        
                        //System.out.println(count1);
                    
				
		}
        catch (SQLException ex) {
           //Logger.getLogger(List_new.class.getName()).log(Level.SEVERE, null, ex);

        }	
    
    }
     public void retrive()
    {
            
                PreparedStatement myStmt = null;

              
		
		try {
			myStmt = myConn.prepareStatement("Select * from customer where Order1=?");
			myStmt.setString(1, id);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
			while (rs.next()) {
                            
                         
                            name=rs.getString("name");
                            address1=rs.getString("address1");
                            address2=rs.getString("address2");
                            address3=rs.getString("address3");
                            phone=rs.getString("mobile");
                            tableno=rs.getString("number");
 
				
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
			// prepare statement
			myStmt = myConn.prepareStatement("insert into card"
					+ " (orderlist, card_cash)"
					+ " values (?, ?)");
			
			// set params
			myStmt.setString(1, x);
			myStmt.setString(2, y);
	
			
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("           View Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("Paid by Cash ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Paid by Card");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       Initial_order in = new Initial_order();
       orderlist(id, "Cash");
       in.action("Completed",id);
       in.setVisible(true);
       this.setVisible(false);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       Initial_order in = new Initial_order();
       orderlist(id, "Card");
       in.action("Completed",id);
  
       in.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Initial_order in=new Initial_order();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewOrder_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrder_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrder_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrder_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new ViewOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
