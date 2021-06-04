package com.iut.as2021.controller;

import static com.iut.as2021.config.BeanManager.getNewBean;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.facade.CalculatriceManager;

@Controller
public class CalculatriceControllerForSpring {

	private static final long serialVersionUID = 1L;

	private String expression;

	private String resultat;

	private static final String MANAGER_NAME = "calculatriceManager";

	private String message;

	@Autowired
	private CalculatriceManager manager;

	@GetMapping("/")
	public String homeInit(Model model) {
		return "home";
	}

	public CalculatriceControllerForSpring() {
		if (this.manager == null) {
			System.out.println("CalculatriceControllerForSpring() - Injection manuelle ...");
			this.manager = (CalculatriceManager) getNewBean(MANAGER_NAME);
		} else {
			System.out.println("CalculatriceControllerForSpring() ******** SPRING INIT *******");
		}
	}

	@PostMapping("/calculer")
	public String calculer(HttpServletResponse response, String expression) throws SQLException {
		System.out.println("expression " + expression);
		try {
			resultat = manager.calculer(expression);
			manager.saveResult();
			return "/yes";
		} catch (MathsExceptions e) {
			System.out.println("Il y a une erreur ..");
			message = e.getMessage();
			return "/no";
		}
	}
}
