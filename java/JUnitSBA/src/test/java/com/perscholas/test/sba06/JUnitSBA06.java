package com.perscholas.test.sba06;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.main.sba05.User;
import com.perscholas.main.sba06.InvalidPasswordException;

@RunWith(Parameterized.class)
public class JUnitSBA06 {
	private static User testUser;
	private Integer userId;
	private String name;
	private String password;
	private Double javaScore;
	private Double sqlScore;
	
	public JUnitSBA06(Integer userId, String name, String password, Double javaScore, Double sqlScore) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
	}
	
	@Parameters()
	public static Collection<Object[]> data(){
		return Arrays.asList(
				new Object[][] {
					{15, "Brian", "brian123", 100.0, 100.0},
					{20, "Jack", "jack1234", 94.2, 68.4},
					{22, "Jill", "jill1234", 46.8, 58.0}
				});
	}
	
	@BeforeClass
	public static void setup() {
		testUser = new User();
	}
	
	@Test
	public void testCalcCredits() {
		int expectedCredits = 0;
		testUser.setUserId(userId);
		testUser.setName(name);
		testUser.setPassword(password);
		testUser.setJavaScore(javaScore);
		testUser.setSqlScore(sqlScore);
		
		if(testUser.getJavaScore() >= 70)
			expectedCredits++;
		if(testUser.getSqlScore() >= 70)
			expectedCredits++;
		
		assertThat(testUser.calculateCredits(), is(expectedCredits));
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testSetPass() {
		testUser.setPassword("1234567891011121314151617181920");
		testUser.setPassword("1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testJavaScore() {
		testUser.setJavaScore(100.1);
		testUser.setJavaScore(-0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSqlScore() {
		testUser.setSqlScore(100.1);
		testUser.setSqlScore(-0.1);
	}
}
