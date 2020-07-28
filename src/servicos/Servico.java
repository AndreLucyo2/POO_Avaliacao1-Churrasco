/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import entidades.Confraternizacao;
import entidades.Iten;
import entidades.Pessoa;
import entidades.Produto;
import entidades.dao.ProdutoDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andre
 */
public class Servico
{

    public static ArrayList<Iten> listaDeItens(ArrayList<Iten> lista)
    {
	Scanner scan = new Scanner(System.in);
	String continuar = "N";

	System.out.println("\nDEFININDO LISTA DE ITENS ...");

	do
	{

	    //ITEM:
	    Iten item = new Iten();

	    item.setProduto(produtoNovo());

	    System.out.print("Informe a Quantidade:");
	    item.setQuantidade(new BigDecimal(scan.next()));

	    item.setPreco(item.getProduto().getPreco());

	    lista.add(item);

	    System.out.print("adicionar mais produtos? S/N ");
	    continuar = scan.next().toUpperCase();
	}
	while (continuar.equals("S"));

	return lista;

    }

    public static Produto produtoNovo()
    {
	Scanner scan = new Scanner(System.in);

	//DEFINIR PRODUTO:
	Produto produto = new Produto();

	System.out.println("\nCADASTRANDO NOVO PRODUTO ...");
	System.out.print("Informe Nome:");

	produto.setNome(scan.next());

	System.out.print("Informe Preço:");
	produto.setPreco(new BigDecimal(scan.nextDouble()));

	//GRAVA:
	ProdutoDAO.add(produto);

	return produto;

    }

    public static Confraternizacao novoEvento()
    {
	Scanner scan = new Scanner(System.in);

	//CRIAR O EVENTO:
	Confraternizacao evento = new Confraternizacao();

	System.out.println("\nCADASTRANDO NOVO EVENTO ...");

	System.out.print("Informe Nome:");
	evento.setNome(scan.nextLine());

	System.out.print("Informe a Data no Formato dd/MM/yyyy HH:mm : ");
	String dt = scan.nextLine();
	//System.out.print(">>>>>>>>>>> "+ dt);
	evento.setData(dt);

	//TESTE:
	//Confraternizacao eventoT = new Confraternizacao("Cgurrasco","12/12/2020 00:00");
	return evento;

    }

    public static ArrayList<Pessoa> listaDeCovidados(ArrayList<Pessoa> lista)
    {
	Scanner scan = new Scanner(System.in);
	String continuar = "N";

	System.out.println("\nDEFININDO LISTA DE CONVIDADOS ...");

	do
	{
	    //CONVIDADOS:
	    Pessoa novaPessoa = new Pessoa();

	    System.out.print("Informe Nome:");
	    novaPessoa.setNome(scan.next());

	    System.out.print("Informe sexo:");
	    novaPessoa.setSexo(scan.next());

	    System.out.print("Informe Idade:");
	    novaPessoa.setIdade(scan.nextInt());

	    lista.add(novaPessoa);

	    //+CONVIDADOS?:
	    System.out.print("Convidar mais pessoas? S/N ");
	    continuar = scan.next().toUpperCase();
	}
	while (continuar.equals("S"));

	return lista;

    }

    public void printCabecalho(int cont)
    {
	if (cont <= 1)
	{
	    System.out.println("#########################################################");
	    System.out.println("#              ORGANIZANDO EVENTO                       #");
	    System.out.println("#########################################################");
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("            INICIO EVENTO " + cont + "                     ");
	    System.out.println("-----------------------------------------------------------");

	}
	else
	{
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("            INICIO EVENTO " + cont + "                     ");
	    System.out.println("-----------------------------------------------------------");

	}

    }

    public static void mostraEvento(Confraternizacao evento)
    {
	System.out.println("================================================================");
	System.out.println("============              EVENTO             ===================");
	System.out.println("================================================================");

	System.out.println("----------------------------------------------------------------");
	System.out.println("                       DADOS DO EVENDO                          ");
	System.out.println("----------------------------------------------------------------");

	System.out.println("NOME DO EVENTO       :" + evento.getNome());
	System.out.println("DATA DO EVENTO       :" + evento.getData().toString());
	System.out.println("QTDE. DE CONVIDADOS  :" + evento.getQtdeConvidados());
	System.out.println("QTDE. DE ITENS       :" + evento.getQtdItens());

	System.out.println("\n");
	System.out.println("----------------------------------------------------------------");
	System.out.println("                       LISTA DE CONVIDADOS                       ");
	System.out.println("----------------------------------------------------------------");

	//DADOS DOS INTENS:
	for (Pessoa pes : evento.getConvidados())
	{
	    System.out.println("NOME       :" + pes.getNome());
	    System.out.println("IDADE      :" + pes.getIdade());
	    System.out.println("SEXO       :" + pes.getSexo());
	    System.out.println("===================================");
	}

	System.out.println("\n");
	System.out.println("----------------------------------------------------------------");
	System.out.println("                       LISTA DE COMPRAS                         ");
	System.out.println("----------------------------------------------------------------");

	//DADOS DOS INTENS:
	for (Iten item : evento.getItems())
	{
	    System.out.println("PRODUTO       :" + item.getProduto().getNome());
	    System.out.println("QUANTIDADE    :" + item.getQuantidade().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	    System.out.println("PREÇO UNIT.   :R$" + item.getPreco().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	    System.out.println("");
	    System.out.println("TOTAL DO ITEM :R$" + item.getSubTotal().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	    System.out.println("===================================");
	}
	System.out.println("CUSTO TOTAL          :R$" + evento.getTotal().setScale(2, BigDecimal.ROUND_HALF_EVEN));
	System.out.println("\n");
    }

}
