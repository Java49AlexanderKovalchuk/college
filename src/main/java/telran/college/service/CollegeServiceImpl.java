package telran.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.college.dto.LecturerHours;
import telran.college.dto.LecturerPhone;
import telran.college.dto.StudentCity;
import telran.college.dto.StudentMark;
import telran.college.dto.StudentPhone;
import telran.college.dto.SubjectScores;
import telran.college.repo.*;
@Service
@RequiredArgsConstructor
public class CollegeServiceImpl implements CollegeService {
	final StudentRepo studentRepo;
	final LecturerRepo lecturerRepo;
	final SubjectRepo subjectRepo;
	final MarkRepo markRepo;
	@Override
	public List<String> bestStudentsSubjectType(String type, int nStudents) {
		
		return studentRepo.findBestStudentsSubjectType(type, nStudents);
	}
	@Override
	public List<StudentMark> studentsAvgMarks() {
		
		return studentRepo.studentsMarks();
	}
	@Override
	public List<LecturerHours> lecturersMostHours(int nLecturers) {
		
		return lecturerRepo.findLecturerNamesMostHours(nLecturers);
	}
	@Override
	public List<StudentCity> studentsCityLessMarks(int nScores) {
		
		return studentRepo.findStudentCityLessScores(nScores);
		
	}
	@Override
	public List<StudentPhone> studentByBirthMonth(int nMonth) {
		
		return studentRepo.findStudentsByBornMonth(nMonth);
	}
	@Override
	public List<SubjectScores> subjectScoreByStudentName(String stName) {
		
		return subjectRepo.findSubjectScoresByStudent(stName);
	}
	@Override
	public List<LecturerPhone> lecturerPhoneByCity(String city) {
		
		return lecturerRepo.findLecturerPhoneByCity(city);
	}
	
	

}
