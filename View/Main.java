package View;

import Controller.KillController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        KillController killcont = new KillController();
        String os= killcont.os();

        if (os.contains("Windows")){
            String process= "TASKLIST /FO TABLE";
            killcont.listaProcessos(process);
        }
        else {
            String process= "ps -ef";
            killcont.listaProcessos(process);
        }

        int opc= 0;

        opc= Integer.parseInt(JOptionPane.showInputDialog("Fechar Processo \n 1 - Fechar por PID \n 2 - Fechar por Nome"));
        switch (opc) {
            case 1:
                killcont.matapid();
                break;
            case 2:
                killcont.matanome();
                break;
            }




    }
}
