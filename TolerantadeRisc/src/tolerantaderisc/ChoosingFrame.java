package tolerantaderisc;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChoosingFrame extends JFrame{
    private JButton verde,rosu;
    private JLabel text;
    private ControlAlegeri CC=new ControlAlegeri();

    public ChoosingFrame(){
       super("");
        JPanel p=new JPanel();
        
        text=new JLabel("Alege un buton.");
        p.add(text);
        verde=new JButton("Verde");
        verde.setBackground(Color.green);
        verde.addActionListener(CC);
        p.add(verde);
        rosu=new JButton("Rosu");
        rosu.setBackground(Color.red);
        rosu.addActionListener(CC);
        p.add(rosu);
        add(p);
    }
    
    public class ControlAlegeri implements ActionListener{
        public static int i=0;
        private int timp=1;//in secunde
        private int score=0;
        private ChoosingResults CR=new ChoosingResults(); 
        double rezultat;
   
      public void CorectChoice(int i){
      setVisible(false); 
      
      JLabel corect=new JLabel("Ai ales corect!\nAlege din nou in " + timp + " secunde.");
      corect.setForeground(Color.green);
      JOptionPane.showMessageDialog(null,corect,"Rezultat",JOptionPane.INFORMATION_MESSAGE);
                 
      try{ Thread.sleep(timp*1000);
          } catch (InterruptedException ex) {}
     
      }
      
      public void WrongChoice(int i){
      setVisible(false);
      
      JLabel gresit=new JLabel("Ai ales gresit!\nAlege din nou in " + timp + " secunde.");
      gresit.setForeground(Color.red);
      JOptionPane.showMessageDialog(null,gresit,"Rezultat",JOptionPane.INFORMATION_MESSAGE);
                 
      try{ Thread.sleep(timp*1000);
          } catch (InterruptedException ex) {} 
      
      }  
            
      @Override
      public void actionPerformed(ActionEvent e){
        if(i<=CR.optiuni.length-1){
    
          if(e.getSource()==verde){
              if(CR.optiuni[i]==2){
              CorectChoice(i);
              score++;
              }else{
              WrongChoice(i);
              }
          }
          
          if(e.getSource()==rosu){
              if(CR.optiuni[i]==1){
              CorectChoice(i);
              score++;
              }else{
              WrongChoice(i);
              } 
          }
          i++;
          setVisible(true);
        }
        if(i==CR.optiuni.length){
        setVisible(false);           
        rezultat=(double)score/CR.optiuni.length;
        JFrame rezultate=new ResultsFrame(rezultat,CR.randament);
        rezultate.pack();
        rezultate.setLocationRelativeTo(null);
        rezultate.setVisible(true);
        }
      }
    }
}
