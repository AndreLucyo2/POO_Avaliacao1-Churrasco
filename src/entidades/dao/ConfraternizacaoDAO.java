/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.dao;

import bdFake.BancoFake;
import entidades.Confraternizacao;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class ConfraternizacaoDAO
{
    //CRUD PESSOA ============================================================== 
    public static Confraternizacao findByID(int id)
    {
	//percorre a lista se encontrar :
	for (Confraternizacao evnt : BancoFake.getTB_EVENTO())
	{
	    if (evnt.getId() == id)
	    {
		return evnt;
	    }
	    else
	    {
		//System.out.println("Confraternizacao " + id + " não encontrada!");
	    }
	}
	return null;
    }

    public static boolean add(Confraternizacao confraternizacao)
    {
	try
	{
	    BancoFake.getTB_EVENTO().add(confraternizacao);
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
	    for (Confraternizacao evnt : BancoFake.getTB_EVENTO())
	    {
		if (evnt.getId() == id)
		{
		    BancoFake.getTB_EVENTO().remove(evnt);
		    return true;
		}
	    }
	    
	   System.out.println("Confraternizacao " + id + " não encontrada!");
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static boolean update(Confraternizacao confraternizacao)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Confraternizacao evnt : BancoFake.getTB_EVENTO())
	    {
		if (evnt.getId() == confraternizacao.getId())
		{
		    //remove a confraternizacao OLD
		    BancoFake.getTB_EVENTO().remove(evnt);

		    //Adiciona a confraternizacao Nova com mesmo id
		    BancoFake.getTB_EVENTO().add(confraternizacao);

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

    public static void printAll(ArrayList<Confraternizacao> lista)
    {
	if (lista != null)
	{
	    System.out.println("\nTABELA EVENTO =====================================================");

	    //percorre a lista
	    for (Confraternizacao evnt : BancoFake.getTB_EVENTO())
	    {
		System.out.println(evnt.toString());
	    }

	    System.out.println("===================================================================");

	    return;
	}
	System.out.println("Lsta Vazia!");

    }

}
