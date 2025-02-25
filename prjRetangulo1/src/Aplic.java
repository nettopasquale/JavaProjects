 import fatec.poo.model.Retangulo;
         
public class Aplic {
    
    public static void main(String[] args) {
        // Descrição do ponteiro para o objeto
        Retangulo objRet, objRet1;
        
        //Instânciação de um novo objeto
        objRet = new Retangulo();
        objRet = new Retangulo();
        
        //Exemplo 1
        objRet.setAltura(5.0);
        objRet.setBase(8.0);
        
        System.out.println("Medida da altura: " + objRet.getAltura());
        System.out.println("Medida da base: " + objRet.getBase());
        System.out.println("Medida da área: " + objRet.calcArea());
        System.out.println("Medida do perímetro: " + objRet.calcPer());
        System.out.println("Medida da diagonal: " + objRet.calcDiag());
        
        System.out.println("\n");
        
        // Exemplo 2
        objRet.setAltura(7.0);
        objRet.setBase(5.0);
        
        System.out.println("Medida da altura: " + objRet.getAltura());
        System.out.println("Medida da base: " + objRet.getBase());
        System.out.println("Medida da área: " + objRet.calcArea());
        System.out.println("Medida do perímetro: " + objRet.calcPer());
        System.out.println("Medida da diagonal: " + objRet.calcDiag());        
        
        
    }
    
}
