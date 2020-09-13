package school.model;

import java.util.Arrays;
import java.util.List;

public enum Specialization {
	INFORMATICS,
	ACCOUNTING,
	MANAGEMENT;
	
	private static List<Specialization> specialization=Arrays.asList(Specialization.values());

	public static List<Specialization> getSpecialization() {
		return specialization;
	}

}
