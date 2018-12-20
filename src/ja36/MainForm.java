/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja36;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author aware
 */
public class MainForm extends javax.swing.JFrame {

	private final int MAX_THREADS = 3;
	private MyThread[] threads;
	private Printer printer;
	
	/**
	 * Creates new form NewJFrame
	 */
	public MainForm() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		initComponents();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension formSize = getSize();
		
		int newWidth = (screenSize.width - formSize.width) / 2;
		int newHeight = (screenSize.height - formSize.height) / 2;
		
		setLocation(newWidth, newHeight);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnCreate = new javax.swing.JButton();
        jbtnStart = new javax.swing.JButton();
        jbtnCreateSyncThreads = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnCreate.setText("Create threads");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });

        jbtnStart.setText("Start threads");
        jbtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStartActionPerformed(evt);
            }
        });

        jbtnCreateSyncThreads.setText("Create sync threads");
        jbtnCreateSyncThreads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateSyncThreadsActionPerformed(evt);
            }
        });

        jButton1.setText("Start queue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCreateSyncThreads))
                    .addComponent(jButton1))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCreate)
                    .addComponent(jbtnCreateSyncThreads))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnStart)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed
		//createThreads(false);
		JOptionPane.showMessageDialog(this, "nope...");
    }//GEN-LAST:event_jbtnCreateActionPerformed

    private void jbtnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStartActionPerformed
        if (threads == null)
			return;
		
		for(MyThread thread: threads) 
			thread.start();
    }//GEN-LAST:event_jbtnStartActionPerformed

    private void jbtnCreateSyncThreadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateSyncThreadsActionPerformed
        //createThreads(true);
		JOptionPane.showMessageDialog(this, "nope...");		
    }//GEN-LAST:event_jbtnCreateSyncThreadsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Queue queue = new Queue();
		Printer printer = new Printer(queue);
		
		MyThread[] threads = new MyThread[MAX_THREADS];
		for (int i = 0; i < MAX_THREADS; i++) {
			threads[i] = new MyThread(String.format("thread%d", i), printer, queue);
			threads[i].start();
		}
    }//GEN-LAST:event_jButton1ActionPerformed

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
			java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnCreateSyncThreads;
    private javax.swing.JButton jbtnStart;
    // End of variables declaration//GEN-END:variables
}

class Queue {
    private String text;
    private boolean isLocked = false;
    
    public void put(String text) {		
        this.text = text;
    }
    
    public String get() {
        return text;
    }
}

class Printer implements Runnable {
        
        private Queue queue;
        private Thread t;
        
        public Printer(Queue q) {
            this.queue = q;
            this.t = new Thread(this, "Printer");
            t.start();
        }
        
        @Override
        public void run() {
            String text = queue.get();
            System.out.println(text);
        }
        
}

class MyThread extends Thread {
			
	private Printer p;
	private Queue queue;
	private String threadName;
	
	public MyThread(String name, Printer p, Queue q) {
		super();
		this.setName(name);
		this.threadName = name;
		this.p = p;
		this.queue = q;
		System.out.println("Created " + name);
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			StringBuilder sb = new StringBuilder();
			
			sb.append(String.format("%s: ", this.threadName));
			for (int j = 1; j < 10; j++) 
				sb.append(String.format("%d ", i * 10 + j));
			
			queue.put(sb.toString());
		}
	}

}

