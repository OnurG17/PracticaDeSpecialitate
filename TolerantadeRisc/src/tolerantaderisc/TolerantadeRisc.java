package tolerantaderisc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.*;
//import java.util.*;

public class TolerantadeRisc extends JFrame{
    private JButton incepe;
    private JLabel text;
    private ControlInceput ci=new ControlInceput();;

    public TolerantadeRisc(){
        super("Test");
       JPanel p=new JPanel();
       p.setLayout(new GridLayout(3,1,0,0));
       //adaugaretext(p,text);
       
       text=new JLabel("    În aceasta aplicatie ai de ales dintre un buton rosu si un buton verde,care vor fi corecte la nimereala.");
       p.add(text);
       text=new JLabel("    Aproximativ " + String.format("%.2f",ChoosingResults.getRandament()) + "% din cazuri alegerea corecta va fi verde si " + String.format("%.2f",100-ChoosingResults.getRandament()) + "% din cazuri va fi rosu.");
       p.add(text);
       
       
       incepe=new JButton("Incepe");
       p.add(incepe);
       incepe.addActionListener(ci);
       add(p);
    }

    /*public void adaugaretext(JPanel p,JLabel text){
        int i=0;
        
        try{
         File in=new File("Introducere.txt");
         Scanner out=new Scanner(in);
        while(out.hasNextLine()){
            i++;
            text= new JLabel(out.nextLine());
            p.add(text);}
        }catch (IOException io){} 
        p.setLayout(new GridLayout(i+1,1,0,0));
    }
    */
    
    public class ControlInceput implements ActionListener{
        JFrame alegere;
        
        @Override
        public void actionPerformed(ActionEvent e){
        if(e.getSource()==incepe){
            if(alegere==null){
        /*ChoosingFrame*/ alegere=new ChoosingFrame();
        alegere.setSize(180,120);
        alegere.setLocation(680,200);
        alegere.setVisible(true);
        alegere.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //alegere.i=0;
            }
        alegere.setVisible(true);
        }
        }
    }
    
    public static void main(String[] args) {
    TolerantadeRisc s=new TolerantadeRisc();        
    s.pack();
    s.setLocationRelativeTo(null);
    s.setVisible(true);
    s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
