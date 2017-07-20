/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import static Manager.Initial_order.stripNonDigits;
import Waiter.new_order2;
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
import javax.swing.DefaultListModel;

/**
 *
 * @author Shakil
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form Sales
     */
     private Connection myConn;
     public DefaultListModel dm;
     public double  count1,count12;
     public String id;
     public String name,address1,address2,address3,phone,tableno,delivery ,card_cash;
     public String itemName,itemQuantity,itemPrice;
     
       public Sales() {
            Properties props = new Properties();
        try {
        props.load(new FileInputStream("demo.properties")); //loading demo properties file    
        } catch (IOException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
		String user = props.getProperty("user"); //from that taking the user 
         
		String password = props.getProperty("password"); // password 
  
                String dburl = props.getProperty("dburl"); //url of the database
               
		
        try {
        // connect to database
            myConn = DriverManager.getConnection(dburl, user, password);
            
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        dm=new DefaultListModel();
        retrive();
        jLabel1.setText(String.valueOf(count1));
        
        
    }
     public void retrive()
    {
                String order="Order : ";
                PreparedStatement myStmt= null;
		dm.removeAllElements();
              
                Object[] row = new Object[3];
		
		try {
			myStmt = myConn.prepareStatement("Select * from orderpanel where action=? ");
			myStmt.setString(1, "complited");
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
			while (rs.next()) {
                            
                          //  row[1]=rs.getString("orderlist");
                          //  row[2]=rs.getString("action");
                            
                            dm.addElement(order
                                   +""+rs.getString("orderNo")
                                   +"      "+rs.getString("total")+
                                    " $");
                            
                            count1=count1+Double.parseDouble(rs.getString("total"));
                         
			}
                        jList1.setModel(dm);
                            
				
		}
        catch (SQLException ex) {
           Logger.getLogger(Initial_order.class.getName()).log(Level.SEVERE, null, ex);

        }	
    
    }
     
      public void retrive1()
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
                            delivery=rs.getString("delivery");
	
			}
  		
		}
        catch (SQLException ex) {
           //Logger.getLogger(List_new.class.getName()).log(Level.SEVERE, null, ex);

        }	
    
    }
      
      
     
    public void retrive2()
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
                           count12=count12+Double.parseDouble(rs.getString("price"))*coun2;
                             
                      
                            
  
 
				
			}
                        jTextArea1.append("----------------------------------------------\n");
                        jTextArea1.append("Total Price :"+count12+" $\n\n");
                        jTextArea1.append("Payment by :"+card_cash+" \n");
                        //System.out.println(count1);
                    
				
		}
        catch (SQLException ex) {
           //Logger.getLogger(List_new.class.getName()).log(Level.SEVERE, null, ex);

        }	
    
    }
        public void retrive3()
    {
              
                PreparedStatement myStmt= null;
		try {
			myStmt = myConn.prepareStatement("Select * from card");
			//myStmt.setString(1, name);
                        
                        ResultSet rs = myStmt.executeQuery(); 
                        
			while (rs.next()) {
                            
                          card_cash=rs.getString("card_cash");
                            
        
			}
  	
		}
        catch (SQLException ex) {

        }	 
    }
    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */){
    final StringBuilder sb = new StringBuilder(
            input.length() /* also inspired by seh's comment */);
    
    int count=0;
    for(int i = 0; i < input.length() && count<5 ; i++){
        final char c = input.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
           
        }
        else if (c==' ') count++;
                
                
    }
    return sb.toString();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("                    Sales Summary");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder("Order List"));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("All Sells Total"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        
        count1=0;
        count12=0;
        id=stripNonDigits(jList1.getSelectedValue().toString());
        retrive1();
        
        jTextArea1.setText("  ");
        jTextArea1.append(
                 "\t Order no: "+id+"\n\n"
                +name+" "+"\n"
                +address1+" "+address2+""+address3+"\n"
                +"Mobile No: "+phone+"\n"
                +"Table No: "+tableno+"\n\n"
                +delivery+"\n"        
                +"===========================\n\n"
                );
         
        
      
        
        
        jTextArea1.setEditable(false);
        retrive3();
        retrive2();
        
        
        
    }//GEN-LAST:event_jList1MouseClicked

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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
