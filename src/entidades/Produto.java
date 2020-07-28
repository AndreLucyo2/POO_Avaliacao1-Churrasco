/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import bdFake.BancoFake;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class Produto
{

    private int id;
    private String nome;
    private BigDecimal preco;

    //Associação pode estar em ZERO-OU-MUITOS itens  
    private ArrayList<Iten> items = new ArrayList<Iten>();

    public Produto()
    {
    }

    public Produto(String nome, BigDecimal preco)
    {
	setId();
	this.nome = nome;
	this.preco = preco;
    }

    public Produto(int id, String nome, BigDecimal preco)
    {
	this.id = id;
	this.nome = nome;
	this.preco = preco;
    }

    public int getId()
    {
	return id;
    }

    public void setId()
    {
	this.id = ultimoID() + 1;
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public BigDecimal getPreco()
    {
	return preco;
    }

    public void setPreco(BigDecimal preco)
    {
	this.preco = preco;
    }

    public ArrayList<Iten> getItems()
    {
	return items;
    }

    //Descobre o maior id da lista no bancoFake
    public int ultimoID()
    {
	int id = 0;
	int cont = 0;
	//Carrega a tabela pessoa
	ArrayList<Pessoa> tb_pessoas = BancoFake.getTB_CONVIDADO();

	try
	{
	    //percorre a lista se encontrar o maios ID:
	    for (Pessoa pes : tb_pessoas)
	    {
		if (cont == 0)
		{
		    id = pes.getId();
		}

		if (pes.getId() > id)
		{
		    id = pes.getId();
		}

		cont += cont;

	    }
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return id;
    }

    @Override
    public String toString()
    {
	return "Produto{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + ", items=" + items + '}';
    }

}
