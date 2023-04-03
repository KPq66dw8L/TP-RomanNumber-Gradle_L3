package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		//TDD (Test Driver Development). Cela signifie que nous allons écrire les tests avant d'écrire le code. C'est un principe mis en oeuvre dans les méthodes agiles.
		for (int i = 1; i <= 3999; i++)
		{
			assertThat(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)), equalTo(i));
		}
	}
	@Test
	public void testConverter2(){
		assertThat(RomanConverter.getNumberFromRoman("X"), equalTo(10));
	}
	@Test
	public void testConvertersError(){
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(5000)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("LXLX")), instanceOf(IllegalArgumentException.class));
	}
	@Test 
	public void testBasics(){
		RomanNumber rn = new RomanNumber("X");
		assertThat(rn.toString(), equalTo("X")); 
	}

    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
			System.out.println(t); //J'ai ajoute ca, lie a la condition dans getRomanFromNumber()
            return t;
        }
    }
}
