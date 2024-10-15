import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        int a =0, b =1;
        boolean pertence = (numero == 0 || numero == 1);
        while (b < numero) {
            int temp = b;
            b = a+b;
            a = temp;
        //Verificar
            if( b == numero){
                pertence = true;
        
            }
        }
        //pertence ou não à sequência 

            if(pertence) {
                System.out.println(numero + " pertence a sequência de Fibonacci");
            } else {
                System.out.println("O número "+ numero + " não pertence a sequência de Fibonacci");
            }
    }
}
