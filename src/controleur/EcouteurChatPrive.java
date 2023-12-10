package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic implements ActionListener {
    private String alias;
    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat) {
        super(clientChat, panneauChat);
        this.alias = alias;
        this.clientChat = clientChat;
        this.panneauChat = panneauChat;
    }

    //à compléter (redéfinir la méthode actionPerformed())
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton b = (JButton) e.getSource();
            String choice = b.getActionCommand();

            if ("ACCEPTER".equals(choice)) {
                clientChat.envoyer("CHESS " + alias);
            } else if ("REFUSER".equals(choice)) {
                clientChat.envoyer("DECLINE " + alias);
            }

        } else if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();
            String text = textField.getText();

            if (panneauChat.getChampDeSaisie().getText().equals("QUIT")){

                clientChat.envoyer("QUIT " + alias);

            }
            else  if (panneauChat.getChampDeSaisie().getText().equals("ABANDON")){

                clientChat.envoyer("ABANDON");

            }
            else  if (!text.equals("")) {
                clientChat.envoyer("PRV " + alias + " " + text);
                panneauChat.ajouter("MOI>>" + text);
                textField.setText("");
            }

        }
    }

}