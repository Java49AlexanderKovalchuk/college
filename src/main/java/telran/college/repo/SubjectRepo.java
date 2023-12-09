package telran.college.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.college.dto.SubjectScores;
import telran.college.entities.*;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
	String JOIN_STUDENTS_MARKS = "FROM students_lecturers st join marks m on stid = st.id ";
	String JOIN_ALL = JOIN_STUDENTS_MARKS + "join subjects sb on sb.id = suid ";
	@Query(value = "select sb.name as name, score " + JOIN_ALL +
			"group by st.name, sb.name, score having st.name = :stName"
			, nativeQuery = true)
	List<SubjectScores> findSubjectScoresByStudent(String stName);
}
