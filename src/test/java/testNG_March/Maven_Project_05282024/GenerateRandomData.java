package testNG_March.Maven_Project_05282024;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomData {

	Random random = new Random();

	int index;

	public String getFirstName() {

		List<String> firstNameList = new ArrayList<String>();

		firstNameList.add("Arsh");

		firstNameList.add("John");

		firstNameList.add("Keisha");

		firstNameList.add("Renee");

		index = random.nextInt(firstNameList.size());

		return firstNameList.get(index);

	}

	public String getLastName() {

		List<String> lastNameList = new ArrayList<String>();

		lastNameList.add("kaur");

		lastNameList.add("Adams");

		lastNameList.add("Adams");

		lastNameList.add("warrington");

		index = random.nextInt(lastNameList.size());

		return lastNameList.get(index);

	}

	public String getEmail() {

		List<String> domainList = new ArrayList<String>();

		domainList.add("@gmail.com");

		domainList.add("@yahoo.com");

		domainList.add("@cashmoney.ca");

		index = random.nextInt(domainList.size());

		return "user" + random.nextInt(1000) + domainList.get(index);
	}

	public String getPassword() {

		return "Password" + random.nextInt(200) + ".";
	}

	public String getUsername() {

		return "firstname" + random.nextInt(99);

	}

}
