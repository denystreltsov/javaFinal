package cwk4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 *
 * @author A.A.Marczyk
 * @version 20/10/23
 */
public class GameGUI
{
    private WIN gp = new SpaceWars("Olenka");
    private JFrame myFrame = new JFrame("Game GUI");
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight");
    private JButton state = new JButton("View State");

    private JButton clear = new JButton("Clear");
    private JPanel eastPanel = new JPanel();


    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }

    /**
     * Create the main frame's menu bar.
     */


    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the Forces menu
        JMenu forcesMenu = new JMenu("Forces");
        menubar.add(forcesMenu);

        JMenuItem listForcesItem = new JMenuItem("List All Forces ");
        listForcesItem.addActionListener(new ListForcesHandler());
        forcesMenu.add(listForcesItem);

        JMenuItem activateForce = new JMenuItem(("Activate "));
        activateForce.addActionListener(new ActivateHandler());
        forcesMenu.add(activateForce);

        JMenuItem recallForce = new JMenuItem(("Recall "));
        recallForce.addActionListener(new RecallHandler());
        forcesMenu.add(recallForce);

        JMenu battlesMenu = new JMenu("Battles");
        menubar.add(battlesMenu);

        JMenuItem listBattlesItem = new JMenuItem("List All Battles ");
        listBattlesItem.addActionListener(new ListBattlesHandler());
        battlesMenu.add(listBattlesItem);

    }
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(5,1));
        eastPanel.add(fightBtn);
        fightBtn.addActionListener(new FightBtnHandler());
        fightBtn.setVisible(true);

        myFrame.add(eastPanel,BorderLayout.EAST);
        eastPanel.setLayout(new GridLayout(5,1));
        eastPanel.add(state);
        state.addActionListener(new StateHandler());
        state.setVisible(true);

        myFrame.add(eastPanel,BorderLayout.EAST);
        eastPanel.setLayout(new GridLayout(5,1));
        eastPanel.add(clear);
        clear.addActionListener(new ClearHandler());
        clear.setVisible(true);

        // building is done - arrange the components and show
        myFrame.pack();
        myFrame.setVisible(true);
    }


    private String fighting(int code)
    {
        switch (code)
        {
            case 0:return "Fight won";
            case 1:return "Fight lost as no suitable force available";
            case 2:return "Fight lost on battle strength, force destroyed";
            case 3:return "fight is lost and admiral completely defeated ";
        }
        return " no such fight ";
    }

    private String activating(int code)
    {
        switch (code)
        {
            case 0:return "Force is activated";
            case 1:return "Force is not in the UFF dock or is destroyed";
            case 2:return "Not enough money";
            case -1:return "No such force";
        }
        return " No such force ";
    }

    private class ListForcesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getAllForces();
            listing.setText(xx);

        }
    }

    private class ListBattlesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getAllBattles();
            listing.setText(xx);

        }
    }

    private class ActivateHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputValue = JOptionPane.showInputDialog("Force reference ?: ");
            int result = gp.activateForce(inputValue);
            JOptionPane.showMessageDialog(myFrame, activating(result));
        }
    }

    private class RecallHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputValue = JOptionPane.showInputDialog("Force reference ?: ");
            if (gp.isInASFleet(inputValue)){
                gp.recallForce(inputValue);
                JOptionPane.showMessageDialog(myFrame,"Force is recalled ");
            }
            JOptionPane.showMessageDialog(myFrame,"Cannot recall Force ");
        }
    }

    private class FightBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Fight number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.doBattle(num);
            JOptionPane.showMessageDialog(myFrame,fighting(result));
        }
    }

    private class StateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.toString();
            listing.setText(xx);
        }
    }

    private class ClearHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(false);
        }
    }




    public static void main(String[] args)
    {
        new GameGUI();
    }
}