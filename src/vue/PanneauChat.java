package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel {
    protected JTextArea zoneChat ;
    protected JTextField champDeSaisie ;

    public PanneauChat() {
        zoneChat = new JTextArea();
        champDeSaisie = new JTextField();
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(zoneChat);
        add(scrollPane);
        add(champDeSaisie,BorderLayout.SOUTH);
        zoneChat.setEditable(false);
             //à compléter.
    }

    public void ajouter(String msg) {
        zoneChat.append("\n"+msg);
    }

    public JTextArea getZoneChat() {
        return zoneChat;
    }

    public void setZoneChat(JTextArea zoneChat) {
        this.zoneChat = zoneChat;
    }

    public JTextField getChampDeSaisie() {
        return champDeSaisie;
    }

    public void setChampDeSaisie(JTextField champDeSaisie) {
        this.champDeSaisie = champDeSaisie;
    }

    public void setEcouteur(ActionListener ecouteur) {
        this.champDeSaisie.addActionListener(ecouteur);
    }

    public void vider() {
        this.zoneChat.setText("");
    }
}