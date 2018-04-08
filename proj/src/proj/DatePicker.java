package proj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;

/**
 *
 * @author 1BestCsharp
 */
public class DatePicker extends javax.swing.JFrame {
	private int row;
	ReadAndStore kek = new ReadAndStore();
	GiftBean[] gift = kek.store();
	ReadFile rows = new ReadFile();
	private String date;
    /**
     * Creates new form Java_JTable_And_JDateChooser
     */
    public DatePicker(int selectedRow) {
    	setTitle("Date picker");
    	setType(Type.NORMAL);
    	setSize(100,50);
    	//setResizable(false);
        initComponents(selectedRow);
    }

   // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents(int selectedRow) {
    	setRow(selectedRow);
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_Add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE); 

        jButton_Add.setText("Select this date");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(199, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton_Add, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(199))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton_Add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(220, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

            pack();
        }// </editor-fold>                        

        private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {                                            
            try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String theDate = dateFormat.format(jDateChooser1.getDate());
            date = theDate;
            //System.out.println(getDate());

            gift[getRow()].setReserved(gift[getRow()].getReserved() + 1);
			gift[row].setRemaining(gift[row].getRemaining() - 1);
            EditGiftData edit = new EditGiftData();
			edit.writeFile(rows.getNumberOfRows(), gift);
			EditReservedData rowadd = new EditReservedData();
			rowadd.addRow(getRow(), gift, date);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "No Date Selected");
            }
            
        }                                           

        /**
         * @param args the command line arguments
         */
        public static void main(int selectedRow) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
        	//setRow(selectedRow);
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(DatePicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(DatePicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(DatePicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(DatePicker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DatePicker(selectedRow).setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton jButton_Add;
        private com.toedter.calendar.JDateChooser jDateChooser1;
        
        public String getDate() {
        	return date;
        }
        public void setRow(int row) {
        	this.row = row;
        }
        public int getRow() {
        	return row;
        }
    }