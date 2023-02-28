package Controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

    public KillController(){
        super();
    }

    public String os(){
        String os= System.getProperty("os.name");
        String arch= System.getProperty("os.arch");
        String version= System.getProperty("os.version");
        return os + " V. " + version + " - arch. " + arch;
    }

    public void listaProcessos(String process){
        if (os().contains("Windows")){
            try {
                Process p= Runtime.getRuntime().exec(process);
                InputStream fluxo= p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer= new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null){
                    System.out.println(linha);
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                Process p= Runtime.getRuntime().exec(process);
                InputStream fluxo= p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer= new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null){
                    System.out.println(linha);
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void matapid(){
        int pid= Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo"));
        if (os().contains("Windows")){
            try {
                StringBuffer buffer= new StringBuffer();
                buffer.append("TASKKILL /PID");
                buffer.append(" ");
                buffer.append(pid);
                Runtime.getRuntime().exec(buffer.toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                StringBuffer buffer= new StringBuffer();
                buffer.append("kill -9");
                buffer.append(" ");
                buffer.append(pid);
                Runtime.getRuntime().exec(buffer.toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void matanome(){
        String nome= JOptionPane.showInputDialog("Digite o nome do processo");
        if (os().contains("Windows")){
            try {
                StringBuffer buffer= new StringBuffer();
                buffer.append("TASKKILL /IM");
                buffer.append(" ");
                buffer.append(nome);
                Runtime.getRuntime().exec(buffer.toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                StringBuffer buffer= new StringBuffer();
                buffer.append("pkill -f");
                buffer.append(" ");
                buffer.append(nome);
                Runtime.getRuntime().exec(buffer.toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
