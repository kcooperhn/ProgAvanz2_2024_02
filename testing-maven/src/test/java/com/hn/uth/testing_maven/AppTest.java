package com.hn.uth.testing_maven;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	double num1;
	double num2;
	
	@Before
	public void metodoSetup() {
		//SE EJECUTA UNA VEZ POR CADA TEST QUE EXISTE, ANTES DEL TEST
		System.out.println("Ejecutando metodo setup");
		Random r = new Random();
		num1 = r.nextDouble();
		num2 = r.nextDouble();
	}
	
	@BeforeClass
	public static void metodoSetupClass() {
		//SE EJECUTA UNA SOLA VEZ AL INICIO DE TODAS LAS PRUEBAS
		System.out.println("Iniciando mis pruebas automatizadas");
	}
	
	@Test
	public void pruebaSuma1() {
		System.out.println("Ejecutando suma1 ("+num1+","+num2+")");
		assertTrue(App.sumar(num1,num2) == (num1+num2));
	}
	
	@Test
	public void pruebaSuma2() {
		System.out.println("Ejecutando suma2 ("+num1+","+num2+")");
		assertTrue(App.sumar(0,3) == 3);
	}
	
	@Test
	public void pruebaSuma3() {
		System.out.println("Ejecutando suma3");
		assertTrue(App.sumar(-1,4) == 3);
	}
	
	@Test
	public void pruebaSuma4() {
		System.out.println("Ejecutando suma4");
		assertTrue(App.sumar(0.5,0.3) == 0.8);
	}
	
	@Test
	public void pruebaSuma5() {
		System.out.println("Ejecutando suma5");
		assertTrue(App.sumar(9999999,888888) == 10888887);
	}
	
	@Test
	public void pruebaResta1() {
		System.out.println("Ejecutando resta1");
		assertEquals(App.restar(2,1), 1, 0.01);
	}
	
	@Test
	public void pruebaResta2() {
		System.out.println("Ejecutando resta2");
		assertTrue(App.restar(1,5)== -4);
	}
	
	@Test
	public void pruebaResta3() {
		System.out.println("Ejecutando resta3");
		assertTrue(App.restar(0.0,1.0)== -1.0);
	}
	
	@Test
	public void pruebaResta4() {
		System.out.println("Ejecutando resta4");
		assertEquals(App.restar(3.0,0.0), 3.0, 0.01);
	}
	
	@Test
	public void pruebaResta5() {
		System.out.println("Ejecutando resta5");
		assertEquals(App.restar(-1.0,1.0), -2, 0.0001);
	}
	
	@Test
	public void pruebaMulti1() {
		assertEquals(App.multiplicar(1.0,1.0), 1, 0.0001);
	}
	
	@Test
	public void pruebaMulti2() {
		assertEquals(App.multiplicar(-2.0,1.0), -2, 0.0001);
	}
	
	@Test
	public void pruebaMulti3() {
		assertEquals(App.multiplicar(5.0,7.0), 35, 0.0001);
	}
	
	@Test
	public void pruebaDivi1() {
		assertEquals(App.dividir(6.0,3.0), 2, 0.0001);
	}
	
	@Test
	public void pruebaDivi2() {
		assertEquals(App.dividir(6,-1.0), -6, 0.0001);
	}
	
	@Test
	public void pruebaDivi3() {
		assertEquals(App.dividir(5.0,5.0), 1, 0.0001);
	}
	
	@Test
	public void pruebaDivisionCero() {
		assertNull(App.dividir(4.0,0.0));
	}
	
	@Test
	public void pruebaDivisionCero2() {
		assertNull(App.dividir(10000.0,0.0));
	}
	
	@After
	public void metodoTearDown() {
		//SE EJECUTA AL FINALIZAR CADA TEST
		System.out.println("Ejecutando metodo TearDown");
	}
	
	@AfterClass
	public static void metodoTearDownClass() {
		//SE EJECUTA AL FINALIZAR TODOS LOS TEST
		System.out.println("Pruebas automatizadas terminadas");
	}
	
	
	public void metodoAuxiliar() {
		//METODO QUE NO TIENE ANOTACIÓN (ARROBA)
		System.out.println("Esto es un metodo auxiliar");
	}
}
