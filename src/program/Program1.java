/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import entidades.Confraternizacao;
import entidades.Iten;
import entidades.Pessoa;
import entidades.Produto;
import java.math.BigDecimal;
import servicos.Servico;

/**
 *
 * @author Andre
 */
public class Program1
{

    public static void main(String[] args)
    {

	//CABEÇALHO:
	new Servico().printCabecalho(1);

	//NOVO EVENTO:
	Confraternizacao evento = new Confraternizacao(1, "churrasco TEste", "12/12/2020 00:00");

	//CRIA LISTA DE CONVIDADOS:	
	Pessoa convidado1 = new Pessoa(1, "Andre", "Masc", 37);
	Pessoa convidado2 = new Pessoa(2, "Maria", "Fem", 23);
	
	convidado1.getEventos().add(evento);
	convidado2.getEventos().add(evento);
	
	evento.getConvidados().add(convidado1);
	evento.getConvidados().add(convidado2);

	//criando elementos
	Produto produto1 = new Produto(1, "Carvão", new BigDecimal(12.99));
	Produto produto2 = new Produto(2, "Costela", new BigDecimal(24.99));
	Produto produto3 = new Produto(2, "Linguiça", new BigDecimal(8.99));
	Produto produto4 = new Produto(4, "Frango", new BigDecimal(13.45));

	Iten item1 = new Iten(1, new BigDecimal("2.00"), produto1.getPreco(), produto1, evento);
	Iten item2 = new Iten(2, new BigDecimal("5.00"), produto2.getPreco(), produto2, evento);
	Iten item3 = new Iten(3, new BigDecimal("10.00"), produto3.getPreco(), produto3, evento);
	Iten item4 = new Iten(4, new BigDecimal("10.00"), produto3.getPreco(), produto3, evento);

	evento.getItems().add(item1);
	evento.getItems().add(item2);
	evento.getItems().add(item3);
	evento.getItems().add(item4);
	
	//Convidados no evento:
	
	


	//Mostra evento:
	new Servico().mostraEvento(evento);

    }
}
