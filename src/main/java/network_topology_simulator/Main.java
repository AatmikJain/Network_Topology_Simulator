package network_topology_simulator;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AATMIK JAIN
 */
class Node
{
    int x, y;
    ArrayList<Node> connections;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        connections = new ArrayList<>();
    }
    
}
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private boolean addingNode = true;
    private Point p = new Point(-1, -1);
    ArrayList<Node> nodeArl = new ArrayList<>();
    String instruction = "To add a Node:\n"
            + "1. Click the monitor icon on the right side.\n"
            + "2. Click on the drawing area where you want to add the node.\n\n"
            + "To connect two Nodes:\n"
            + "1. Click on the \"Add Connection\" button on the right side.\n"
            + "2. Click the nodes which you want to connect.\n\n"
            + "After you are done with drawing the topology, click \"Evaluate\" button to check which topology your diagram represents.\n\n"
            + "Click \"Reset\" button to clear the drawing area.";
    
    public Main() {
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

        jPanel1 = new javax.swing.JPanel();
        NodeBtn = new javax.swing.JButton();
        EvaluateBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        ConnectionBtn = new javax.swing.JButton();
        InstructionsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Network Topology Simulator");
        setName("Network Topology Simulator"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        NodeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/node_icon.png"))); // NOI18N
        NodeBtn.setToolTipText("Add Node");
        NodeBtn.setBorder(null);
        NodeBtn.setBorderPainted(false);
        NodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NodeBtnActionPerformed(evt);
            }
        });

        EvaluateBtn.setText("Evaluate");
        EvaluateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvaluateBtnActionPerformed(evt);
            }
        });

        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        ConnectionBtn.setText("Add Connection");
        ConnectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectionBtnActionPerformed(evt);
            }
        });

        InstructionsBtn.setText("Instructions");
        InstructionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(InstructionsBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NodeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EvaluateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResetBtn))
                            .addComponent(ConnectionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(NodeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ConnectionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EvaluateBtn)
                            .addComponent(ResetBtn))
                        .addGap(148, 148, 148)
                        .addComponent(InstructionsBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NodeBtnActionPerformed
        // TODO add your handling code here:
        addingNode = true;        
    }//GEN-LAST:event_NodeBtnActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:

        if(addingNode)
        {
            // TODO validate right corner addition
            Graphics g = this.jPanel1.getGraphics();
            p.x = Math.max(0, evt.getX()-50);
            p.y = Math.max(0, evt.getY()-50);
            try 
            {
                if(isPointOnANode(p))
                    JOptionPane.showMessageDialog(this, "Overlapping other node");
                else
                {
                    BufferedImage img = ImageIO.read(getClass().getResource("/images/node_icon.png"));
                    
                    g.drawImage(img, p.x, p.y, 100, 100, rootPane);
                    nodeArl.add(new Node(p.x, p.y));
                    System.out.println("node added");
                    p.x = -1;
                    p.y = -1;
                }
            }
            catch (IOException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                p.x = -1;
                p.y = -1;
            }
            p.x = -1;
            p.y = -1;
        }

        else //adding Connection
        {
            //TODO remove multiple connections
            if (p.x == -1 && p.y == -1)
            {
                p.x = evt.getX();
                p.y = evt.getY();
            }
            else
            {
                Graphics g = this.jPanel1.getGraphics();
                Point p2 = new Point(evt.getX(), evt.getY());
                System.out.println(p.x+" "+p.y+" "+p2.x+" "+p2.y);
                
                Node src=null, dest=null;
                //locate src
                if(isPointOnANode(p))
                {
                    //TODO separate or optimize search for src and dest
                    for(int i=0; i<nodeArl.size(); i++)
                    {
                        if(p.x - nodeArl.get(i).x <= 100 && p.x - nodeArl.get(i).x >= 0 && p.y - nodeArl.get(i).y <= 100&& p.y - nodeArl.get(i).y >= 0)
                        {
                            src = nodeArl.get(i);
                            break;
                        }
                    }
                    
                    //locate dest
                    if(isPointOnANode(p2))
                    {
                        for(int i=0; i<nodeArl.size(); i++)
                        {
                            if(nodeArl.get(i)!=src && p2.x - nodeArl.get(i).x <= 100 && p2.x - nodeArl.get(i).x >= 0 && p2.y - nodeArl.get(i).y <= 100 && p2.y - nodeArl.get(i).y >= 0)
                            {
                                dest = nodeArl.get(i);
                                break;
                            }                            
                        }
                    }
                }
                if(dest != null)
                {
                    System.out.println(src.x+ " " +src.y);
                    System.out.println(dest.x+ " " +dest.y);
                    src.connections.add(dest);
                    dest.connections.add(src);
                    g.drawLine(p.x, p.y, p2.x, p2.y);
                }
                
                // reset the start point
                p.x = -1;
                p.y = -1;
            }
        }    
    }//GEN-LAST:event_jPanel1MouseClicked

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
        revalidate();
        repaint();
        nodeArl.clear();
        p.x = -1;
        p.y = -1;
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void ConnectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectionBtnActionPerformed
        // TODO add your handling code here:
        addingNode = false;
    }//GEN-LAST:event_ConnectionBtnActionPerformed

    private void EvaluateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvaluateBtnActionPerformed
        // TODO add your handling code here:
        for(int i=0; i<nodeArl.size(); i++)
            System.out.println(i+": "+nodeArl.get(i).x+" "+nodeArl.get(i).y);
        printConnections();
        if(isRingTopology())
            System.out.println("Ring");
        else
            System.out.println("Not in Ring");
        if(isMeshTopology())
            System.out.println("Mesh");
        else
            System.out.println("Not in Mesh");
        if(isStarTopology())
            System.out.println("Star");
        else
            System.out.println("Not in Star");
    }//GEN-LAST:event_EvaluateBtnActionPerformed

    private void InstructionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionsBtnActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, instruction, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_InstructionsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }
    private boolean isPointOnANode(Point p)
    {
        //TODO sort arraylist and binary search point
        for(int i=0; i<nodeArl.size(); i++)
        {
            if(Math.abs(nodeArl.get(i).x - p.x) <= 95 && Math.abs(nodeArl.get(i).y - p.y) <= 95)
                return true;
        }
        System.out.println(p.x+" "+ p.y+" "+"not on a node");
        return false;
    }
    
    private boolean isRingTopology()
    {
        int totalNodes = nodeArl.size();
        if(totalNodes<2)
        {
            JOptionPane.showMessageDialog(rootPane, "Add more nodes");
            return false;
        }
        else if(totalNodes==2)
        {
            if(nodeArl.get(0).connections.size()==1)
                return true;
            else
                return false;
        }
        else
        {
            boolean[] visited = new boolean[totalNodes];
            Node src = nodeArl.get(0);
            visited[0] = true;
            boolean hasUnvisited = true;
            while(hasUnvisited)
            {
                if(src.connections.size()!=2)
                    return false;
                for(int i=0; i<src.connections.size(); i++)
                {
                    if(src.connections.size()!=2)
                        return false;
                    Node cur = src.connections.get(i);
                    int flag=0;
                    for(int j=0; j<totalNodes; j++)
                    {
                        if(cur==nodeArl.get(j) && !visited[j])
                        {
                            src = cur;
                            visited[j] = true;
                            hasUnvisited = true;
                            i--;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0)
                        hasUnvisited = false;
                }
            }
            for(int i=0; i<totalNodes; i++)
            {
                if(!visited[i])
                    return false;
            }
            return true;
        }        
    }

    private boolean isMeshTopology()
    {
        int totalNodes = nodeArl.size();
        if(totalNodes<2)
        {
            JOptionPane.showMessageDialog(rootPane, "Add more nodes");
            return false;
        }
        for(int i=0; i<totalNodes; i++)
            if(nodeArl.get(i).connections.size()!=totalNodes-1)
                return false;
        return true;
    }
    
    private boolean isStarTopology()
    {
        int totalNodes = nodeArl.size();
        int serverNodes=0;
        if(totalNodes==2)
        {
            for(int i=0; i<2; i++)
            {
                if(nodeArl.get(i).connections.size()!=1)
                    return false;
            }
            return true;
        }
        for(int i=0; i<totalNodes; i++)
        {
            if(nodeArl.get(i).connections.size()==totalNodes-1)
            {
                serverNodes++;
                if(serverNodes>1)
                    return false;
            }
            else if(nodeArl.get(i).connections.size()!=1)
                return false;
        }
        return true;
    }
    void printConnections()
    {
        int totalNodes = nodeArl.size();
        for(int i=0; i<totalNodes; i++)
        {
            System.out.println("Node :" + nodeArl.get(i).x+" "+ nodeArl.get(i).y);
            System.out.println(nodeArl.get(i).connections.size());
            for(int j=0; j<nodeArl.get(i).connections.size(); j++)
                System.out.println(nodeArl.get(i).connections.get(j).x +" "+nodeArl.get(i).connections.get(j).y);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConnectionBtn;
    private javax.swing.JButton EvaluateBtn;
    private javax.swing.JButton InstructionsBtn;
    private javax.swing.JButton NodeBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}