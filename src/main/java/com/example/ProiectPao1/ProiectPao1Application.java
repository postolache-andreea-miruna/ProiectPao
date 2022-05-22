package com.example.ProiectPao1;

import com.example.ProiectPao1.model.Administrator;
import com.example.ProiectPao1.repository.AdministratorRepository;
import com.example.ProiectPao1.service.AdministratorService;
import org.hibernate.dialect.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class ProiectPao1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProiectPao1Application.class, args);
//		AdministratorService administratorService = new AdministratorService();
//		List<Administrator>admini = administratorService.getAllAdministratori();
//		System.out.println(admini);
	}


}
