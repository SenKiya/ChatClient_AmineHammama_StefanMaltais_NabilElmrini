package com.chat.echecs;

import observer.Observable;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-10-01
 */
public class EtatPartieEchecs extends Observable {
    private char[][] etatEchiquier = new char[8][8];
    public EtatPartieEchecs() {
        //Les pions :
        for (int j=0;j<8;j++) {
            etatEchiquier[1][j] = 'p';
            etatEchiquier[6][j] = 'P';
        }
        //Cases vide :
        for (int j=0;j<8;j++)
          for (int i=2;i<6;i++) {
            etatEchiquier[i][j] = ' ';
        }

        //Tours :
        etatEchiquier[0][0] = 't';
        etatEchiquier[0][7] = 't';
        etatEchiquier[7][0] = 'T';
        etatEchiquier[7][7] = 'T';

        //Cavaliers :
        etatEchiquier[0][1] = 'c';
        etatEchiquier[0][6] = 'c';
        etatEchiquier[7][1] = 'C';
        etatEchiquier[7][6] = 'C';

        //Fous :
        etatEchiquier[0][2] = 'f';
        etatEchiquier[0][5] = 'f';
        etatEchiquier[7][2] = 'F';
        etatEchiquier[7][5] = 'F';

        //Dames :
        etatEchiquier[0][3] = 'd';
        etatEchiquier[7][3] = 'D';

        //Rois :
        etatEchiquier[0][4] = 'r';
        etatEchiquier[7][4] = 'R';
    }
    public boolean move(String deplacement) {
        boolean res = false;
        //à compléter
        int posI1 = 0, posF1 = 0;
        int posI2 = 0, posF2 = 0;

        boolean possible;
        if(deplacement.length()<5){
            posI1 = deplacement.charAt(0) - 'a';
            posI2 = (Character.getNumericValue(deplacement.charAt(1)));
            posF1 = deplacement.charAt(2) - 'a';
            posF2 = (Character.getNumericValue(deplacement.charAt(3)));

            etatEchiquier[posI2][posF2]=etatEchiquier[posI1][posF1];
            etatEchiquier[posI1][posF1]=' ';

            notifierObservateurs();
            res = true;

        } else if(deplacement.length()<6 && (deplacement.substring(2,3).equals("-") || deplacement.substring(2,3).equals(" "))){

            posI1 = deplacement.charAt(0) - 'a';
            posI2 = (Character.getNumericValue(deplacement.charAt(1)));
            posF1 = deplacement.charAt(3) - 'a';
            posF2 = (Character.getNumericValue(deplacement.charAt(4)));

            etatEchiquier[posI2][posF2]=etatEchiquier[posI1][posF1];
            etatEchiquier[posI1][posF1]=' ';

            notifierObservateurs();
            res = true;

        } else {

            res = false;

        }

        return res;
    }

    @Override
    public String toString() {
        String s = "";
        for (byte i=0;i<8;i++) {
            s+=(byte)(8-i)+" ";
            for (int j=0;j<8;j++)
                s+=((etatEchiquier[i][j]==' ')?".":etatEchiquier[i][j])+" ";
            s+="\n";
        }
        s+="  ";
        for (char j='a';j<='h';j++)
            s+=j+" ";
        return s;
    }

    public char[][] getEtatEchiquier() {
        return etatEchiquier;
    }

    public void setEtatEchiquier(char[][] etatEchiquier) {
        this.etatEchiquier = etatEchiquier;
    }
}
