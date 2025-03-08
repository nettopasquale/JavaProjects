
package fatec.poo.model;

public class Aluno {
    private int RA;
    private double NtPrv1, NtPrv2, NtTrab1, NtTrab2;
    
    public void setRA(int reg){
        RA = reg;
    }
    
    public void setNtPrv1(double np1){
        NtPrv1 = np1;
    }
    
    public void setNtPrv2(double np2){
        NtPrv2 = np2;
    }
    
    public void setNtTrab1(double nt1){
        NtTrab1 = nt1;
    }
    
    public void setNtTrab2(double nt2){
        NtTrab2 = nt2;
    }

    public int getRA(){
        return RA;
    }
    
    public double getNtPrv1(){
        return NtPrv1;
    }
    
    public double getNtPrv2(){
        return NtPrv2;
    }
    
    public double getNtTrab1(){
        return NtTrab1;
    }
    
    public double getNtTrab2(){
        return NtTrab2;
    }
    
    
    public double calcMediaProva(){
        return (0.75 * ((NtPrv1 + 2 * NtPrv2)/3));
    }
    
    public double calcMediaTrab(){
        return (0.25 * ((NtTrab1 + NtTrab2)/2));
    }
    
    public double calcMediaFinal(){
        return (calcMediaProva() + calcMediaTrab());
    }
    

}
