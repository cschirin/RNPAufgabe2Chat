/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.gui;

import client.ChatClient;
import client.ClientSenderThread;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class ChatClientGUI extends javax.swing.JFrame {

    /**
     * Creates new form ChatClientGUI
     */
    public ChatClientGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendButton = new javax.swing.JButton();
        inputTextFieldScrollPane = new javax.swing.JScrollPane();
        inputTextField = new javax.swing.JTextPane();
        userListScrollPane = new javax.swing.JScrollPane();
        userList = new javax.swing.JList(ChatClient.users.toArray());
        chatProtocolScrollPane = new javax.swing.JScrollPane();
        chatProtocol = new javax.swing.JTextArea();
        labelForUserList = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UDP Chat Client");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        sendButton.setLabel("Abschicken");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        inputTextField.setToolTipText("");
        inputTextFieldScrollPane.setViewportView(inputTextField);

        userList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        userList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userListScrollPane.setViewportView(userList);

        chatProtocol.setEditable(false);
        chatProtocol.setColumns(20);
        chatProtocol.setLineWrap(true);
        chatProtocol.setRows(5);
        chatProtocol.setWrapStyleWord(true);
        chatProtocolScrollPane.setViewportView(chatProtocol);

        labelForUserList.setText("Aktuell Eingeloggt:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTextFieldScrollPane)
                    .addComponent(chatProtocolScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelForUserList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userListScrollPane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelForUserList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chatProtocolScrollPane)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendButton)
                    .addComponent(inputTextFieldScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String msgToSend = inputTextField.getText();
        try {
        ClientSenderThread c = ChatClient.createMessageSender(msgToSend);
        java.awt.EventQueue.invokeLater(c);
        } catch (SocketException e) {
            JOptionPane.showMessageDialog(rootPane, "Es konnte kein socket für das verschicken der nachricht erzeugt werden!", "ClientSenderThread fehler", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        logUserOut(); //ClientMessageCommunicator beenden und aufräumen
        stopListeningToMessages(); //ClientMessageReciever beenden und aufräumen
        
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea chatProtocol;
    private javax.swing.JScrollPane chatProtocolScrollPane;
    private javax.swing.JTextPane inputTextField;
    private javax.swing.JScrollPane inputTextFieldScrollPane;
    private javax.swing.JLabel labelForUserList;
    private javax.swing.JButton sendButton;
    public javax.swing.JList userList;
    private javax.swing.JScrollPane userListScrollPane;
    // End of variables declaration//GEN-END:variables

    public void logUserOut() {
        if(ChatClient.serverThread!=null && !ChatClient.serverThread.isInterrupted()){
        ChatClient.serverThread.interrupt();
            try {
                ChatClient.serverThread.join();
            } catch (InterruptedException ex) {
                System.err.println("GUI/Main Thread has been interrupted during logUserOut!"); 
                ex.printStackTrace();
            }
        }
    }

    private void stopListeningToMessages() {
        if(ChatClient.messageReciever != null && !ChatClient.messageReciever.isInterrupted()) {
            ChatClient.messageReciever.interrupt();
            try {
                ChatClient.messageReciever.join();
            } catch (InterruptedException ex) {
                System.err.println("GUI/Main Thread has been interrupted during stopListeningToMessages!");
                ex.printStackTrace();
            }
        }
    }
}
