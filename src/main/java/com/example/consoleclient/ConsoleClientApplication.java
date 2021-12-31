package com.example.consoleclient;

import com.example.consoleclient.model.Book;
import com.example.consoleclient.model.Bookmark;
import com.example.consoleclient.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@SpringBootApplication
public class ConsoleClientApplication {

	Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(ConsoleClientApplication.class, args);
	}

	private final String URL = "http://localhost:8080/";
	private String readerName;
	private int id;


	@Bean
	public CommandLineRunner run(){
		return (args) -> {
			login();
			executeCommand();
		};
	}

	private String readLine(){
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			result = reader.readLine();
			System.out.println(result);
		}catch (IOException io){
			logger.error(io.getMessage());
		}
		return result;
	}


	private void login(){
		System.out.println("Enter you name:");
		postReader(readLine());
	}


	private void writeDescription(){
		System.out.println("====================================");
		System.out.println("addBook");
		System.out.println("setBookMark");
		System.out.println("getBooks");
		System.out.println("====================================");

	}

	private void executeCommand(){
		writeDescription();

		for (;;){
			System.out.println("Enter you command: ");
			String []command = readLine().split(" ");

			switch (command[0]){
				case "addBook":
					addBook(command[1], command[2]);
					continue;
				case "setBookMark":
					setBook(command[1], command[2]);
					continue;
				case "getBooks":
					getBooks();
					continue;
				case "exit":
					break;
			}
		}
	}

	private void postReader(String name){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Reader> request = new HttpEntity<>(new Reader(name));
		ResponseEntity<Reader> response = restTemplate.exchange(
				URL + "reader/", HttpMethod.POST, request, Reader.class);
		int statusCode = response.getStatusCode().value();
		System.out.println(String.valueOf(statusCode));
		if (statusCode == 201 || statusCode == 200){
			id = response.getBody().getId();
			readerName = response.getBody().getReaderName();
			System.out.println("You id is: " + id);
			System.out.println("You name is: " + readerName);
		}
	}


	private void addBook(String bookName, String count){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Book> request = new HttpEntity<>(new Book(bookName, Integer.valueOf(count)));
		ResponseEntity<HttpStatus> response = restTemplate.exchange(
				URL + "addBook/" + id, HttpMethod.POST, request, HttpStatus.class);
		System.out.println(String.valueOf(response.getStatusCode().value()));
	}

	private void setBook(String bookName, String pageNumber){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				URL + "setBookMark/" + id + "/" + bookName + "/" + pageNumber, String.class);
		System.out.println(String.valueOf(response.getStatusCode().value()));
	}

	private void getBooks(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				URL + "getAllBooks/" + id, String.class);
		System.out.println(String.valueOf(response.getStatusCode().value()));
		System.out.println(response.getBody());
	}
}
