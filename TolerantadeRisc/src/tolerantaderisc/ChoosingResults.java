package tolerantaderisc;

public class ChoosingResults {
    static protected int[] optiuni=new int[15];
    static protected double randament=(double)2/3;//probabilitatea sa fie verde corect;

    public ChoosingResults(){
        int i;
        int aux;
  
        for(i=0;i<optiuni.length;i++){
            if(i%(1/randament)==0)
            optiuni[i]=1;//rosu
            else
            optiuni[i]=2;//verde
        } 
        
        for(i=0;i<optiuni.length;i++){
            if((int)(Math.random()*2)==1){
             aux=optiuni[i];
            optiuni[i]=optiuni[optiuni.length-i-1];
            optiuni[optiuni.length-i-1]=aux;}
        }
    
    }
    
    static public int[] getOptiuni(){
        return optiuni;
    }
    
    static double getRandament(){
        return (randament*100);
    }
}
