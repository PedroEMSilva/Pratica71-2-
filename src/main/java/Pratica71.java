
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.Jogador;
import utfpr.ct.dainf.if62c.pratica.JogadorComparator;

/**
 * IF62C Fundamentos de Programação 2 Exercício de programação em Java.
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica71 {

    public static void main(String[] args) {
        int numero = 0;
        int valido = 1;
        int quer = 0;
        int pos;
        ArrayList<Jogador> timeco = new ArrayList<Jogador>();

        Scanner scanner = new Scanner(System.in);
        String nome1 = null;
        int numJogadores = 0;
        System.out.print("Numero de Jogadores: ");
        if (scanner.hasNextInt()) {
            numJogadores = scanner.nextInt();
        } else {
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um numero!");
                scanner.next();
            }
            numJogadores = scanner.nextInt();
        }
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite a posicao do " + (i + 1) + " jogador:  ");
            
                nome1 = scanner.next();
           
            System.out.println("Digite o numero do " + (i + 1) + " jogador:  ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
            } else {

                while (!scanner.hasNextInt()) {
                    System.out.println("Digite um numero!");
                    scanner.next();
                }
                numero = scanner.nextInt();
            }
            timeco.add(new Jogador(numero, nome1));

        }
        timeco.sort(new JogadorComparator(true, true, true));

        String format = "%3d %-20s";
        System.out.println("Time ordenado por número (asc) e nome (desc)");
        System.out.println("Num Nome");
        for (Jogador j : timeco) {
            System.out.println(String.format(format, j.getNumero(), j.getNome()));
        }

        System.out.println("se deseja incluir mais jogadore digite 1, caso contrario digite 0");
        if (scanner.hasNextInt()) {
            quer = scanner.nextInt();
        } else {
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um numero!");
                scanner.next();
            }
            quer = scanner.nextInt();
        }
        while (quer == 1) {
            System.out.println("Digite o numero do  jogador:  ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
            } else {
                while (!scanner.hasNextInt()) {
                    System.out.println("Digite um numero!");
                    scanner.next();
                }
                numero = scanner.nextInt();
            }
            if (numero == 0) {
                break;
            }

            System.out.println("Digite a posicao do jogador:  ");
            if (scanner.hasNext()) {
                nome1 = scanner.next();
            } else {
                System.out.println("Digite um nome!");
            }
            pos = Collections.binarySearch(timeco, new Jogador(numero, nome1), new JogadorComparator(true, true, true));
            if (pos >= 0) {
                timeco.set(pos, new Jogador(numero, nome1));
            } else {
                timeco.add(new Jogador(numero, nome1));
            }

            timeco.sort(new JogadorComparator(true, true, true));
            System.out.println("Time ordenado por número (asc) e nome (desc)");
            System.out.println("Num Nome");
            for (Jogador j : timeco) {
                System.out.println(String.format(format, j.getNumero(), j.getNome()));
            }
        }

    }
}
