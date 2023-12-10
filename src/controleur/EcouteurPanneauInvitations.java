package controleur;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurPanneauInvitations implements ActionListener {

  private ClientChat clientChat;

  private PanneauInvitations panneauInvitations;

  public EcouteurPanneauInvitations(ClientChat chat, PanneauInvitations invit){
      this.clientChat = chat;
      this.panneauInvitations= invit;
  }
    @Override
    public void actionPerformed(ActionEvent e) {

panneauInvitations.getElementsSelectionnes();
        JButton b = (JButton)e.getSource();
String choice = b.getActionCommand();

        if ("ACCEPTER".equals(choice)) {
            for(int i=0;i<panneauInvitations.getElementsSelectionnes().size();i++){
                clientChat.envoyer("JOIN " + panneauInvitations.getElementsSelectionnes().get(i));
            }
            panneauInvitations.vider();
        }
        if("REFUSER".equals(choice)){
            for(int i=0;i<panneauInvitations.getElementsSelectionnes().size();i++){
                clientChat.envoyer("DECLINE " + panneauInvitations.getElementsSelectionnes().get(i));
            }
            panneauInvitations.vider();

        }
    }
}
