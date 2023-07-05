package tolerantaderisc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultsFrame extends JFrame{
    private JLabel titlu,text;
    private JButton finalizare;
    private ControlRezultate RFC=new ControlRezultate();
    
    public ResultsFrame(double obtinut,double necesar){
        super("Rezultat:");
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(3,1,10,10));
        if(obtinut>=necesar){
            titlu=new JLabel("              Felicitari!");
            text=new JLabel("Ai ales corect la " + obtinut*100 + "%" + " din cazuri!");
        }else{
            titlu=new JLabel("              Scuze!");
            text=new JLabel("Ai ales corect doar la " + obtinut*100 + "%" + " din cazuri!");
        }
        finalizare=new JButton("Sfarsit");
        finalizare.addActionListener(RFC);
        
        p.add(titlu);
        p.add(text);
        p.add(finalizare);
        add(p);
    }
    
    public class ControlRezultate implements ActionListener{        
      @Override
      public void actionPerformed(ActionEvent e){
      if(e.getSource()==finalizare)
          System.exit(0);
      }
    }
}
