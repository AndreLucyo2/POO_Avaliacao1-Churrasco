/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.dao;

import bdFake.BancoFake;
import entidades.Produto;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class ProdutoDAO
{
    //CRUD PESSOA ============================================================== 
    public static Produto findByID(int id)
    {
	//percorre a lista se encontrar :
	for (Produto prod : BancoFake.getTB_PRODUTO())
	{
	    if (prod.getId() == id)
	    {
		return prod;
	    }
	    else
	    {
		//System.out.println("Produto " + id + " não encontrada!");
	    }
	}
	return null;
    }

    public static boolean add(Produto produto)
    {
	try
	{
	    BancoFake.getTB_PRODUTO().add(produto);
	    return true;
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean remove(int id)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Produto prod : BancoFake.getTB_PRODUTO())
	    {
		if (prod.getId() == id)
		{
		    BancoFake.getTB_PRODUTO().remove(prod);
		    return true;
		}
	    }
	    
	   System.out.println("Produto " + id + " não encontrada!");
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static boolean update(Produto produto)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Produto prod : BancoFake.getTB_PRODUTO())
	    {
		if (prod.getId() == produto.getId())
		{
		    //remove a produto OLD
		    BancoFake.getTB_PRODUTO().remove(prod);

		    //Adiciona a produto Nova com mesmo id
		    BancoFake.getTB_PRODUTO().add(produto);

		    return true;
		}
	    }
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static void printAll(ArrayList<Produto> lista)
    {
	if (lista != null)
	{
	    System.out.println("\nTABELA PRODUTO =====================================================");

	    //percorre a lista
	    for (Produto prod : BancoFake.getTB_PRODUTO())
	    {
		System.out.println(prod.toString());
	    }

	    System.out.println("===================================================================");

	    return;
	}
	System.out.println("Lista Vazia!");

    }

}
