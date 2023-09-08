package com.michellebalducci.WebAPIChallenge;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



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

		Calendar date1= Calendar.getInstance();
		Calendar date2= Calendar.getInstance();
		Calendar date3= Calendar.getInstance();
		Calendar date4= Calendar.getInstance();
		Calendar date5= Calendar.getInstance();
		Calendar date6= Calendar.getInstance();
		Calendar date7= Calendar.getInstance();
		Calendar date8= Calendar.getInstance();
		Calendar date9= Calendar.getInstance();
		Calendar date10= Calendar.getInstance();
		Calendar date11= Calendar.getInstance();
		Calendar date12= Calendar.getInstance();
		Calendar date13= Calendar.getInstance();
		Calendar date14= Calendar.getInstance();
		Calendar date15= Calendar.getInstance();
		Calendar date16= Calendar.getInstance();
		Calendar date17= Calendar.getInstance();
		Calendar date18= Calendar.getInstance();
		Calendar date19= Calendar.getInstance();
		Calendar date20= Calendar.getInstance();

		date1.set(2023,Calendar.JANUARY,15);
		date2.set(2023,Calendar.JANUARY,05);
		date3.set(2023,Calendar.FEBRUARY,20);
		date4.set(2023,Calendar.FEBRUARY,01);
		date5.set(2023,Calendar.MARCH,7);
		date6.set(2023,Calendar.MARCH,14);
		date7.set(2023,Calendar.MARCH,10);
		date8.set(2023,Calendar.MARCH,26);
		date9.set(2023,Calendar.JANUARY,03);
		date10.set(2023,Calendar.JANUARY,9);
		date11.set(2023,Calendar.JANUARY,28);
		date12.set(2023,Calendar.FEBRUARY,05);
		date13.set(2023,Calendar.FEBRUARY,25);
		date14.set(2023,Calendar.MARCH,31);
		date15.set(2023,Calendar.JANUARY,02);
		date16.set(2023,Calendar.FEBRUARY,05);
		date17.set(2023,Calendar.FEBRUARY,15);
		date18.set(2023,Calendar.FEBRUARY,16);
		date19.set(2023,Calendar.MARCH,15);
		date20.set(2023,Calendar.MARCH,22);

		Order order1= new Order(c1.getCustomerID(), 500.00, date1);
		Order order2= new Order(c1.getCustomerID(), 55.00, date2);
		Order order3= new Order(c1.getCustomerID(), 75.00, date3);
		Order order4= new Order(c1.getCustomerID(), 90.00, date4);
		Order order5= new Order(c1.getCustomerID(), 4.00, date5);
		Order order6= new Order(c1.getCustomerID(), 234.00, date6);
		Order order7= new Order(c1.getCustomerID(), 278.00, date7);
		Order order8= new Order(c1.getCustomerID(), 15.00, date8);

		Order order9= new Order(c2.getCustomerID(), 1000.00, date9);
		Order order10= new Order(c2.getCustomerID(), 63.00, date10);
		Order order11= new Order(c2.getCustomerID(), 7.00, date11);
		Order order12= new Order(c2.getCustomerID(), 3.00, date12);
		Order order13= new Order(c2.getCustomerID(), 347.00, date13);
		Order order14= new Order(c2.getCustomerID(), 86.00, date14);

		Order order15= new Order(c3.getCustomerID(), 49.00, date15);
		Order order16= new Order(c3.getCustomerID(), 446.00, date16);
		Order order17= new Order(c3.getCustomerID(), 94.00, date17);
		Order order18= new Order(c3.getCustomerID(), 79.00, date18);
		Order order19= new Order(c3.getCustomerID(), 273.00, date19);
		Order order20= new Order(c3.getCustomerID(), 116.00, date20);

		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);
		orderRepository.save(order4);
		orderRepository.save(order5);
		orderRepository.save(order6);
		orderRepository.save(order7);
		orderRepository.save(order8);
		orderRepository.save(order9);
		orderRepository.save(order10);
		orderRepository.save(order11);
		orderRepository.save(order12);
		orderRepository.save(order13);
		orderRepository.save(order14);
		orderRepository.save(order15);
		orderRepository.save(order16);
		orderRepository.save(order17);
		orderRepository.save(order18);
		orderRepository.save(order19);
		orderRepository.save(order20);

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
//		calculatePointsPerMonth(c1.getOrders());
//		System.out.println(c1.getPointsEarnedJan());
	}
}
