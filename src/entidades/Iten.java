/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Andre
 */
public class Iten
{

    private int id;
    private BigDecimal quantidade;
    //Para fins de historico
    private BigDecimal preco;

    //Associação
    private Produto produto;

    //Associação
    private Confraternizacao churrasco;

    public Iten()
    {
    }

    public Iten(int id, BigDecimal quantidade, BigDecimal preco, Produto produto, Confraternizacao churrasco)
    {
	this.id = id;
	this.quantidade = quantidade;
	this.preco = preco;
	this.produto = produto;
	this.churrasco = churrasco;
    }

    public int getId()
    {
	return id;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public BigDecimal getQuantidade()
    {
	return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade)
    {
	this.quantidade = quantidade;
    }

    public BigDecimal getPreco()
    {
	return preco;
    }

    public void setPreco(BigDecimal preco)
    {
	this.preco = preco;
    }

    public Produto getProduto()
    {
	return produto;
    }

    public void setProduto(Produto produto)
    {
	this.produto = produto;
    }

    public Confraternizacao getChurrasco()
    {
	return churrasco;
    }

    public void setChurrasco(Confraternizacao churrasco)
    {
	this.churrasco = churrasco;
    }

    public BigDecimal getSubTotal()
    {
	BigDecimal bd = getPreco().multiply((getQuantidade()));

	return bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);

    }

    @Override
    public String toString()
    {
	return "Itens{" + "id=" + id + ", quantidade=" + quantidade + ", preco=" + preco + ", produto=" + produto + ", churrasco=" + churrasco + '}';
    }

}
