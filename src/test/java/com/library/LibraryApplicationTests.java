package com.library;

import com.library.implementations.EffectuerAbonnementImpl;
import com.library.implementations.EmpruntImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryApplicationTests {

	@Autowired
	EffectuerAbonnementImpl effectuerAbonnementService;

	@Autowired
	EmpruntImpl empruntService;

	@Test
	void contextLoads() {
		System.out.println("started test");
		//effectuerAbonnementService.sAbonner(1,2);
		//empruntService.emprunterLivre(1111,2);
		empruntService.nonRemis(1111,2);
	}

}
