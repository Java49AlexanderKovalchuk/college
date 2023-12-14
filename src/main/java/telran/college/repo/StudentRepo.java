package telran.college.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.college.dto.*;

import telran.college.entities.*;

public interface StudentRepo extends JpaRepository<Student, Long> {
	String JOIN_STUDENTS_MARKS = "FROM students_lecturers st join marks m on stid = st.id ";
	String JOIN_ALL =  JOIN_STUDENTS_MARKS +
			"join subjects sb on sb.id = suid ";
	
	@Query("SELECT student.name from Mark where subject.type=:type "
			+ "group by student.name order by avg(score) desc limit :nStudents")
	List<String> findBestStudentsSubjectType(SubjectType type, int nStudents);
	/***************************************************/
	@Query(value = "SELECT student.name as studentName, round(avg(score)) as score " + 
			"FROM Mark group by student.name order by avg(score) desc") 
	List<NameScore> studentsMarks();
	 /*************************************************/
	@Query("SELECT student.name as studentName, student.city as studentCity "
			+ "from Mark mark "
			+ "right join mark.student student "
			+ "group by student.name, student.city having count(mark.score) < :scoresThreshold")
	List<StudentCity> findStudentsScoresLess(int scoresThreshold);
	/**************************************************/
	@Query("SELECT st.name as name, st.phone as phone from Student st "
			+ "where EXTRACT (MONTH FROM birthDate) = :month")
	List<NamePhone> findStudentsBornMonth(int month);
	/**************************************************/
}
