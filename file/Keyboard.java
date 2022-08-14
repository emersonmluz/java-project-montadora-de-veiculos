import java.util.Scanner;

public class Keyboard {
    private Scanner input = new Scanner(System.in);
    private String teclado;

    public String getTeclado() {
        return teclado;
    }

    public void input() {
        System.out.print(">> ");
        this.teclado = input.nextLine();
    }
}
