/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdFake;

import entidades.Confraternizacao;
import entidades.Iten;
import entidades.Pessoa;
import entidades.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class BancoFake
{

    private static final ArrayList<Pessoa> TB_CONVIDADO = new ArrayList<Pessoa>();
    private static final ArrayList<Confraternizacao> TB_EVENTO = new ArrayList<Confraternizacao>();
    private static final ArrayList<Iten> TB_ITEN = new ArrayList<Iten>();
    private static final ArrayList<Produto> TB_PRODUTO = new ArrayList<Produto>();

    public BancoFake()
    {
	seedTB_Convidado();
	seedTB_Produto();

    }

    //criar dados na tabela fake
    private static void seedTB_Convidado()
    {

	//criando elementos
	Pessoa convidado1 = new Pessoa(1, "Andre", "Masc", 37);
	Pessoa convidado2 = new Pessoa(2, "Maria", "Fem", 23);

	//Adiciona Elementos na lista
	TB_CONVIDADO.add(convidado1);
	TB_CONVIDADO.add(convidado2);

    }

    private static void seedTB_Produto()
    {
	//criando elementos
	Produto produto1 = new Produto(1, "Carvão", new BigDecimal(12.99));
	Produto produto2 = new Produto(2, "Costela", new BigDecimal(24.99));
	Produto produto3 = new Produto(2, "Linguiça", new BigDecimal(8.99));
	Produto produto4 = new Produto(4, "Frango", new BigDecimal(13.45));

	//Adiciona Elementos na lista
	TB_PRODUTO.add(produto1);
	TB_PRODUTO.add(produto2);
	TB_PRODUTO.add(produto3);
	TB_PRODUTO.add(produto4);

    }

    public static ArrayList<Pessoa> getTB_CONVIDADO()
    {
	return TB_CONVIDADO;
    }

    public static ArrayList<Confraternizacao> getTB_EVENTO()
    {
	return TB_EVENTO;
    }

    public static ArrayList<Iten> getTB_ITEN()
    {
	return TB_ITEN;
    }

    public static ArrayList<Produto> getTB_PRODUTO()
    {
	return TB_PRODUTO;
    }

}
