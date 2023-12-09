package telran.college;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.client.ExpectedCount;

import telran.college.dto.LecturerHours;
import telran.college.dto.LecturerPhone;
import telran.college.dto.StudentCity;
import telran.college.dto.StudentMark;
import telran.college.dto.StudentPhone;
import telran.college.dto.SubjectScores;
import telran.college.service.CollegeService;
@SpringBootTest
@Sql(scripts = {"db_test.sql"})
class CollegeServiceTest {
@Autowired
CollegeService collegeService;
	@Test
	void bestStudentsTypeTest() {
		List<String> students = collegeService.bestStudentsSubjectType("BACK_END", 2);
		String[] expected = {
				"David", "Yosef"
		};
		assertArrayEquals(expected, students.toArray(String[]::new));
	}
	@Test
	void studentAvgScoreTest() {
		List<StudentMark> studentMarks = collegeService.studentsAvgMarks();
		studentMarks.forEach(sm -> System.out.printf("student %s, avg score %d\n", 
				sm.getName(), sm.getScore()));
		String[] namesStudentMarks = (String[]) studentMarks.stream()
				.map(obj -> obj.getName()).toArray(String[]::new);
		Integer[] scoresStudentMarks = (Integer[]) studentMarks.stream()
				.map(obj -> obj.getScore()).toArray(Integer[]::new);
				
		String[] expectedNames = {"David", "Rivka", "Vasya", "Sara", "Yosef"};
		Integer[] expectedScores = {96, 95, 83, 80, 78}; 
		
		assertArrayEquals(expectedNames, namesStudentMarks);
		assertArrayEquals(expectedScores, scoresStudentMarks);
	}
	@Test
	void lecturersMostHoursTest() {
		List<LecturerHours> lecturerHours = collegeService.lecturersMostHours(2);
		lecturerHours.forEach(lh -> System.out.printf("lecturer: %s hours: %d ", 
				lh.getName(), lh.getHours()));
		
		String[] namesLecturerHours = lecturerHours.stream()
				.map(obj -> obj.getName()).toArray(String[]::new);
		Integer[] hoursLecturerHours = lecturerHours.stream()
				.map(obj -> obj.getHours()).toArray(Integer[]::new);
		
		String [] expectedLecturerNames = {"Abraham", "Mozes"};
		Integer[] expectedLecturesHours = {225, 130};
		
		assertArrayEquals(expectedLecturerNames, namesLecturerHours);
		assertArrayEquals(expectedLecturesHours, hoursLecturerHours);
	}
	@Test
	void studentsCityLessMarks() {
		List<StudentCity> studentCity = collegeService.studentsCityLessMarks(4);
		studentCity.forEach(sc -> System.out.printf("student: %s, city: %s ",
				sc.getName(), sc.getCity()));
		
		String[] names = studentCity.stream()
				.map(obj -> obj.getName()).toArray(String[]::new);
		String[] cities = studentCity.stream()
				.map(obj -> obj.getCity()).toArray(String[]::new);
				
		String[] expectedNames = {"Rivka", "Yosef"};
		String[] expectedCities = {"Lod", "Rehovot"};
		
		assertArrayEquals(expectedNames, names);
		assertArrayEquals(expectedCities, cities);
	}
	@Test
	void studentPhoneByBirthMonthTest() {
		List<StudentPhone> studentPhone = collegeService.studentByBirthMonth(5);
		studentPhone.forEach(sp -> System.out.printf("name: %s, phone: %s ", 
				sp.getName(), sp.getPhone()));
		
		String[] names = studentPhone.stream().map(obj -> obj.getName())
				.toArray(String[]::new);
		String[] phones = studentPhone.stream().map(obj -> obj.getPhone())
				.toArray(String[]::new);
		
		String[] expectedNames = {"David"};
		String[] expectedPhone = {"050-7334455"};
		
		assertArrayEquals(expectedNames, names);
		assertArrayEquals(expectedPhone, phones);
	}
	@Test
	void subjectScoreByStudentTest() {
		List<SubjectScores> subjectScore = collegeService.subjectScoreByStudentName("Vasya");
		subjectScore.forEach(ss -> System.out.printf("subject: %s, score: %d ", 
				ss.getName(), ss.getScore()));
		
		String[] subjectNames = subjectScore.stream().map(obj -> obj.getName())
				.toArray(String[]::new);
		Integer[] subjectScores = subjectScore.stream().map(obj -> obj.getScore())
				.toArray(Integer[]::new);
		
		String[] expectedSubjectNames = {"HTML/CSS", "Java Core", "Java Technologies", 
				"JavaScript", "React"};
		Integer[] expectedScores = {95, 75, 60, 85, 100};
		
		assertArrayEquals(expectedSubjectNames, subjectNames);
		assertArrayEquals(expectedScores, subjectScores);
	}
	@Test
	void lecturerPhoneByCity() {
		List<LecturerPhone> lecturerPhone = collegeService.lecturerPhoneByCity("Jerusalem");
		lecturerPhone.forEach(lp -> System.out.printf("lecturer: %s, phone: %s ", 
				lp.getName(), lp.getPhone()));
		
		String[] lecturerNames = lecturerPhone.stream()
				.map(obj -> obj.getName()).toArray(String[]::new);
		String[] lecturerPhones = lecturerPhone.stream()
				.map(obj -> obj.getPhone()).toArray(String[]::new);
		
		String[] expectedLecturerNames = {"Abraham", "Mozes"};
		String[] expectedLecturerPhones = {"050-1111122", "054-3334567"};
		
		assertArrayEquals(expectedLecturerNames, lecturerNames);
		assertArrayEquals(expectedLecturerPhones, lecturerPhones);
	}
	

}
