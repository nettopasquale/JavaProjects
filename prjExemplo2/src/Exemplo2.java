
public class Exemplo2 {

    public static void main(String[] args) {
        int x;
        
        // (int) vai ser um cast do x, um modificador de acesso.
        x = (int) (Math.random() * 100);
        
        if(x < 50){
            System.out.println("O valor " + x + " eh menor que 50");
        }
        else{
            System.out.println("O valor " + x + " eh maior ou igual que 50");
        }
    }
}
