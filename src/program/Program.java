/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import bdFake.BancoFake;
import entidades.Confraternizacao;
import entidades.Iten;
import entidades.Pessoa;
import entidades.dao.ConfraternizacaoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import servicos.Servico;

/**
 *
 * @author Andre
 */
public class Program
{

    public static void main(String[] args)
    {
	//+++++++++++++++++++++++++++++++++++++++++++
	//BANCO KAKE:
	BancoFake bd = new BancoFake();
	//+++++++++++++++++++++++++++++++++++++++++++
	Scanner scan = new Scanner(System.in);
	String continuar = "";
	int contEvent = 1;

	do
	{
	    //CABEÇALHO:
	    new Servico().printCabecalho(contEvent);

	    //NOVO EVENTO:
	    Confraternizacao evento = new Confraternizacao();

	    if (contEvent != 1)
	    {
		//EVENTO:
		System.out.print("Organizar novo evento? S/N ");
		String novoEvnt = scan.next().toUpperCase();
		if (novoEvnt.equals("S"))
		{
		    evento = new Servico().novoEvento();
		}
	    }
	    else
	    {
		evento = new Servico().novoEvento();
	    }

	    //CRIA LISTA DE CONVIDADOS:
	    ArrayList<Pessoa> convidados = new ArrayList<Pessoa>();
	    convidados = new Servico().listaDeCovidados(convidados);
	    //VINCULO EVENTO NO CONVIDADO
	    for (Pessoa convidado : convidados)
	    {
		convidado.getEventos().add(evento);
	    }

	    //VINCULO CONVIDADO NO EVENTO
	    for (Pessoa convidado : convidados)
	    {
		evento.getConvidados().add(convidado);
	    }    
	       
	    //CRIA LISTA DE ITENS:
	    
	    ArrayList<Iten> itens = new ArrayList<Iten>();
	    itens = new Servico().listaDeItens(itens);
	    
	    //VINCULO ITENS NO EVENTO
	    for (Iten item : itens)
	    {
		evento.getItems().add(item);
	    }
	    	    

	    //SALVA EVENTO NO BDFAKE:
	    ConfraternizacaoDAO.add(evento);
	    
	    mostraEvento(evento);
	    

	    System.out.println("\n\nDeseja organizar um novo evento? S/N ");
	    continuar = scan.next().toUpperCase();

	    contEvent += contEvent;

	}
	while (continuar.equals("S"));

	//Mostra tabela dos Eventos:
	//ConfraternizacaoDAO.printAll(bd.getTB_EVENTO());
	
	
	

    }
    
    
    public static void mostraEvento(Confraternizacao evento)
    {
        System.out.println("\n\n\n");
	System.out.println("================================================================");
	System.out.println("============              EVENTO             ===================");
	System.out.println("================================================================");
		
	String nome = evento.getNome();
	String data = evento.getData().toString();
	String qtdConv = evento.getQtdeConvidados()+"";
	String qtdItens = evento.getQtdItens()+"";
	String strTotal = String.format("%10.10s", evento.getTotal() + "");
	
	
	System.out.println("================================================================");
			
	System.out.print(String.format("|%-8.8s|", " NOMEDO EVENTO:"));
	System.out.print(String.format("|%-8.8s|", nome));
	
	
	
	
	
	
    }

}
