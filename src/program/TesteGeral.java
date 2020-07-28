/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.util.Scanner;

/**
 *
 * @author Andre
 */
public class TesteGeral
{

    public static void main(String[] args)
    {
	Scanner scan = new Scanner(System.in);
	
	System.out.print("Informe uma  Data no Formato dd/MM/yyyy HH:mm: ");

	String dt = scan.nextLine();
	
	System.out.println(dt);

    }
}
