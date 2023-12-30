package com.javaprofessional.desafio1;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaprofessional.desafio1.entities.Order;
import com.javaprofessional.desafio1.services.OrderService;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	
	@Autowired
	private OrderService os;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira os dados da ordem de pedido");
		System.out.print("Código: ");
		int code = sc.nextInt();
		System.out.print("Base: ");
		double base = sc.nextDouble();
		System.out.print("Desconto(%): ");
		double discount = sc.nextDouble();
		
		Order order = new Order(code, base, discount);
		
		System.out.println("Pedido código: " + order.getCode() );
		System.out.printf("Total: R$ %.2f", os.total(order));
		
		sc.close();
		
	}

}
