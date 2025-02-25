
public class Exemplo6 {

    public static void main(String[] args) {
        int tabNum[]; //declaração
        int cont;
        
        tabNum = new int [3]; // Alocação
        
        tabNum[0] = 34;
        tabNum[1] = 18;
        tabNum[2] = 27;
        
        for(cont = 0; cont < 3; cont++){
            System.out.println("Conteudo de TabNum[" + cont + "] = ");
            System.out.println(tabNum[cont]);
        }
    }
}
