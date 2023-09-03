package com.michellebalducci.WebAPIChallenge;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import static com.michellebalducci.WebAPIChallenge.entity.Customer.CalculatePointsPerMonth;
//import static com.michellebalducci.WebAPIChallenge.entity.Order.CalculatePointsPerOrder;

@SpringBootApplication
public class WebApiChallengeApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebApiChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<Order> arrOrders =new ArrayList<>();

		Customer c1= new Customer("Jefferson","Thomas");
		Customer c2= new Customer("Kennedy","Jackie");
		Customer c3= new Customer("Washington","George");

		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);

		Order order1= new Order(c1.getCustomerID(), 500.00, "01-02-2022");
		Order order2= new Order(c1.getCustomerID(), 55.00, "01-03-2022");
//		Order order3= new Order(c1.getCustomerID(), 75.00, "02-15-2022");
//		Order order4= new Order(c1.getCustomerID(), 55.00, "02-20-2022");
//		Order order5= new Order(c1.getCustomerID(), 4.00, "03-08-2022");
//		Order order6= new Order(c1.getCustomerID(), 77.00, "03-27-2022");

		orderRepository.save(order1);
		orderRepository.save(order2);
//		orderRepository.save(order3);
//		orderRepository.save(order4);
//		orderRepository.save(order5);
//		orderRepository.save(order6);

		order1.setPointsEarnedForOrder(order1.getTotalAmount());
		System.out.println(order1.getPointsEarnedForOrder());

//		CalculatePointsPerOrder(order2.getTotalAmount());
//		System.out.println(order2.getPointsEarnedForOrder());
//
//		CalculatePointsPerOrder(order3.getTotalAmount());
//		System.out.println(order3.getPointsEarnedForOrder());
//
//		CalculatePointsPerOrder(order4.getTotalAmount());
//		System.out.println(order4.getPointsEarnedForOrder());
//
//		CalculatePointsPerOrder(order5.getTotalAmount());
//		System.out.println(order5.getPointsEarnedForOrder());
//
//		CalculatePointsPerOrder(order6.getTotalAmount());
//		System.out.println(order6.getPointsEarnedForOrder());

		arrOrders.add(order1);
		arrOrders.add(order2);
//		arrOrders.add(order3);
//		arrOrders.add(order4);
//		arrOrders.add(order5);
//		arrOrders.add(order6);

		c1.setOrders(arrOrders);
//		CalculatePointsPerMonth(c1.getOrders());
//		System.out.println(c1.getPointsEarnedJan());
	}
}
