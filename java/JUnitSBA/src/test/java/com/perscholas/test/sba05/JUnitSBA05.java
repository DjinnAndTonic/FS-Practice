package com.perscholas.test.sba05;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.main.sba05.ListMapClass;
import com.perscholas.main.sba05.User;
import com.perscholas.main.sba06.InvalidPasswordException;

public class JUnitSBA05 {
	private static ListMapClass lmc;
	
	@BeforeClass
	public static void setup() {
		lmc = new ListMapClass();
	}
	
	@Test
	public void testCities() {
		List<String> cityList = lmc.cities();
		
		assertThat(cityList, not(IsEmptyCollection.empty()));
		assertThat(cityList, contains("Dallas", "Irving", "Boston", "New York", "Philadelphia", "Detriot"));
		assertThat(cityList, containsInAnyOrder("Irving", "Dallas", "New York", "Boston", "Philadelphia", "Detriot"));
	}
	
	@Test
	public void testUserList() throws InvalidPasswordException {
		List<User> userList = lmc.getUserList();
		
		assertThat(userList.get(0).getName(), is("John"));
		assertThat(userList.get(1).getName(), is("Jane"));
		assertThat(userList.get(2).getName(), is("Joan"));
	}
	
	@Test
	public void testCoursesMap() {
		Map<String, String> courses = lmc.getCoursesMap();
		
		assertNotNull(courses);
		assertThat(courses.size(), is(4));
		assertThat(courses, hasEntry("ASM", "Application Support Management"));
		assertThat(courses, hasEntry("DE", "Data Engineering"));
		assertThat(courses, hasEntry("JD", "Java Developer"));
		assertThat(courses, hasEntry("QEA", "Quality Engineering and Assurance"));
	}
	
	@Test
	public void testUserMap() throws InvalidPasswordException {
		Map<Integer, User> userMap = lmc.getUserMap();
		
		assertNotNull(userMap);
		assertThat(userMap.size(), is(3));
		assertThat(userMap, hasKey(10));
		assertThat(userMap, hasKey(11));
		assertThat(userMap, hasKey(12));
	}
}