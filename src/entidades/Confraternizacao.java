/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class Confraternizacao
{

    private int id;
    private String nome;
    private Date data;
    private BigDecimal total = new BigDecimal(0);

    //Associação UM-OU-MUITOS itens  
    private ArrayList<Iten> items = new ArrayList<Iten>();

    //Associação UM-OU-MUITOS convidados  
    private ArrayList<Pessoa> convidados = new ArrayList<Pessoa>();

    public Confraternizacao()
    {
    }

    public Confraternizacao(String nome, String data)
    {
	this.nome = nome;
	this.data = parseStringToDate(data);

    }

    public Confraternizacao(int id, String nome, String data)
    {
	this.id = id;
	this.nome = nome;
	this.data = parseStringToDate(data);
    }

    public int getId()
    {
	return id;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public Date getData()
    {
	return data;
    }

    public void setData(String data)
    {
	this.data = parseStringToDate(data);
    }

    public ArrayList<Iten> getItems()
    {
	return items;
    }

    public void setItems(ArrayList<Iten> items)
    {
	this.items = items;
    }

    public ArrayList<Pessoa> getConvidados()
    {
	return convidados;
    }

    private static Date parseStringToDate(String data)
    {
	try
	{
	    // Definindo formato da data:
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    //DateFormat sdf1 = DateFormat.getInstance();

	    //Formata a data do tipo String para o formato Date
	    Date da = sdf1.parse(data);

	    return da;
	}
	catch (ParseException ex)
	{
	    ex.printStackTrace();
	    Logger.getLogger(Confraternizacao.class.getName()).log(Level.SEVERE, null, ex);
	}

	return null;

    }
       
    public int getQtdeConvidados()
    {	
	return  this.getConvidados().size();
    }
            
    public int getQtdItens()
    {	
	return this.getItems().size();
    }

    public BigDecimal getTotal()
    {	
	
	for (Iten item : this.getItems())
	{
	  this.total = this.total.add(item.getSubTotal());
	}
	
	return this.total;
    }

    @Override
    public String toString()
    {
	return "Confraternizacao{" + "id=" + id + ", nome=" + nome + ", data=" + data + ", items=" + items + ", convidados=" + convidados + '}';
    }

    

}
