import java.util.ArrayList;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.Jogador;
import utfpr.ct.dainf.if62c.pratica.JogadorComparator;

/**
 * IF62C Fundamentos de Programação 2
 * Exercício de programação em Java.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica71 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        ArrayList<Jogador> Time  = new ArrayList<>();
        
        System.out.println("Digite o número de jogadores a serem lidos");
        
        int n1=0;
        boolean valido = false;
        
        while(!valido){
            
            if(scanner.hasNextInt()){
                n1 = scanner.nextInt();
                valido = true;
            }
            
            else
                scanner.next();
            
        }
        valido = false;
        
        for(int i=0; i<n1; i++){
            String Nome;
            int Num = 0;
            
            System.out.println("Insira o numero e o nome de cada jogador");
            
        while(!valido){
            
            if(scanner.hasNextInt()){
                Num = scanner.nextInt();
                valido = true;
            }
            else
                scanner.next();
            
            
        }
        valido = false;    
  
            Nome = scanner.next();
            
            Jogador NovoJogador = new Jogador(Num, Nome);
            
            Time.add(NovoJogador);
            
        }

        Time.sort(new JogadorComparator(true, true, true));
        System.out.println(Time);
        
        while(true){
            String Nome;
            int Numero = 0;
            
            System.out.println("Insira o numero e o nome de cada jogador");
            
        while(!valido){
            
            if(scanner.hasNextInt()){
                Numero = scanner.nextInt();
                valido = true;
            }
            
            else
                scanner.next();
       
        }
        valido = false;  
  
            if(Numero==0)
                break;
                        
            Nome = scanner.next();
            
            Jogador NovoJogador = new Jogador(Numero, Nome);
            
            int IndiceExistente=0;
            
            for(int i=0; i<Time.size(); i++)
                if(NovoJogador.getNumero() == Time.get(i).getNumero())
                    IndiceExistente = i;
            
            if(IndiceExistente!=0){
                Time.remove(IndiceExistente);
                Time.add(IndiceExistente, NovoJogador);
                
            }
            
            else
                Time.add(NovoJogador);
        
            
        Time.sort(new JogadorComparator(true, true, true));
        System.out.println(Time);
            
        }
    }
    
}