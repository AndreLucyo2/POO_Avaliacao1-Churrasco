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
public class Program2
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
	    //VINCULO CONVIDADO NO EVENTO
	    for (Pessoa convidado : convidados)
	    {
		evento.getConvidados().add(convidado);
	    }

	    //VINCULO EVENTO NO CONVIDADO
	    for (Pessoa convidado : convidados)
	    {
		convidado.getEventos().add(evento);
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

	    //Mostra evento:
	    new Servico().mostraEvento(evento);

	    System.out.println("\n\nDeseja organizar um novo evento? S/N ");
	    continuar = scan.next().toUpperCase();

	    contEvent += contEvent;

	}
	while (continuar.equals("S"));

	//Mostra tabela dos Eventos:
	//ConfraternizacaoDAO.printAll(bd.getTB_EVENTO());
    }

}
