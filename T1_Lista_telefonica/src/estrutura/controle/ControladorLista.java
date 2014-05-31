package controle;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import modelo.Agenda;
import modelo.Pessoa;


public class ControladorLista {

	private static Scanner scan;
	
	public static String caminhoArquivo = "Lista\\lista.txt";
	
	public static void main(String[] args){

		Agenda agenda = new Agenda();
		int op;
		
		ControladorLista.readFile(agenda);
		ControladorLista.scan = new Scanner(System.in);
		ControladorLista.printComandos();
		op = ControladorLista.getOp();
		
		while(op != 7){
			
			switch(op){
				case 1:
					Pessoa p2 = ControladorLista.inserirPessoa();
					agenda.insertPessoa(p2);
					ControladorLista.writeFile(p2);
					System.out.println("Contado inserido com sucesso!\n");
					System.out.println("\n");
					
					break;
				case 2:
					agenda.printList();
					System.out.println("\n");
					break;
				case 3:
					agenda.listByChar(ControladorLista.getTermoBusca());
					System.out.println("\n");
					break;
				case 4:
					agenda.next();
					Pessoa p = agenda.getContatoAtual();
					if(p != null){
						System.out.println(p);
					} else {
						System.out.println("Nenhum contato na lista");
					}
					System.out.println("\n");
					break;
				case 5:
					agenda.prev();
					 Pessoa p1 = agenda.getContatoAtual();
					if(p1 != null){
						System.out.println(p1);
					} else {
						System.out.println("Sem contatos na lista!");
					}
					System.out.println("\n");
					break;
				
					
				case 6:
					Pessoa p3 = ControladorLista.excluirPessoa();
					 agenda.excluir();
					   ControladorLista.writeFile(p3);
					  System.out.println("Contato deletado!\n");
					 System.out.println("\n");
										
					break;
				default:
					System.out.println("opção invalida.");
					break;
			}
			
			ControladorLista.printComandos();
			op = ControladorLista.getOp();
		}
		
		scan.close();
	}
	
	public static void printComandos(){
		System.out.println("Menu de opções\n" +
				"1 - Adicionar contato na lista.\n" +
				"2 - Listar.\n" +
				"3 - Localizar contato por letra ex: A, B, C.\n" +
				"4 - Proximo.\n" +
				"5 - Anterior.\n" +
				"6 - Excluir.\n" +
				"7 - Sair.\n");
	}
	
	public static int getOp(){
		
		int retorno = 0;
		
		String op = ControladorLista.scan.next();
		
		if(op.equalsIgnoreCase("1")){
			retorno = 1;
			
		} else if (op.equalsIgnoreCase("2")){
			retorno = 2;
			
		} else if (op.equalsIgnoreCase("3")){
			retorno = 3;
			
		} else if (op.equalsIgnoreCase("4")){
			retorno = 4;
			
		} else if (op.equalsIgnoreCase("5")){
			retorno = 5;
			
		} else if (op.equalsIgnoreCase("6")){
			retorno = 6;
			
		} else if (op.equalsIgnoreCase("7")){
			retorno = 7;
		}
				
		return retorno;
	}
	
	
	public static Pessoa inserirPessoa(){
		Pessoa p = new Pessoa();
		System.out.print("Nome: ");
		String nome = ControladorLista.scan.next();
		p.setNome(nome);
		
		System.out.print("Telefone: ");
		String telefone = ControladorLista.scan.next();
		p.setTelefone(telefone);
		
		
		return p;
	}
	
	
	public static Pessoa excluirPessoa(){
		Pessoa p3 = new Pessoa();
		System.out.print("Nome: ");
		p3.getNome().replace(null, null);
		return p3;
	}
	
	public static String getTermoBusca(){
		System.out.print("Buscar contatos pela letra: ");
		String termo = ControladorLista.scan.next();
		return termo;
	}
	
	
	
	
	
	
	
	public static void readFile(Agenda agenda){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ControladorLista.caminhoArquivo));
			
			String nome;
			String telefone;
			
			while (reader.ready()) {
				nome = reader.readLine();
				telefone = reader.readLine();
				Pessoa p = new Pessoa(nome,telefone);
				agenda.insertPessoa(p);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void writeFile(Pessoa p){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(ControladorLista.caminhoArquivo,true));
			writer.newLine();
			writer.write(p.getNome());
			writer.newLine();
			writer.write(p.getTelefone());
			writer.flush();
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
