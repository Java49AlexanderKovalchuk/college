package telran.college.service;

import java.util.List;

import telran.college.dto.StudentMark;
import telran.college.dto.StudentPhone;
import telran.college.dto.SubjectScores;
import telran.college.dto.LecturerHours;
import telran.college.dto.LecturerPhone;
import telran.college.dto.StudentCity;

public interface CollegeService {
	List<String> bestStudentsSubjectType(String type, int nStudents);
	List<StudentMark> studentsAvgMarks();
	List<LecturerHours> lecturersMostHours(int nLecturers);
	List<StudentCity> studentsCityLessMarks(int nScores);
	List<StudentPhone> studentByBirthMonth(int nMonth);
	List<SubjectScores> subjectScoreByStudentName(String stName);
	List<LecturerPhone> lecturerPhoneByCity(String city);
}
