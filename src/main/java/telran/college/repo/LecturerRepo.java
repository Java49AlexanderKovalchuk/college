package telran.college.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.college.dto.LecturerHours;
import telran.college.dto.LecturerPhone;
import telran.college.entities.*;

public interface LecturerRepo extends JpaRepository<Lecturer, Long> {

	String JOIN_LECTURERS_SUBJECTS = "FROM students_lecturers lc join subjects sb"
			+ " on lc.id = sb.lecturer_id ";
	@Query(value="SELECT lc.name as name, sum(hours) as hours " + 
			JOIN_LECTURERS_SUBJECTS + 
			"group by lc.name order by sum(hours) desc limit :nLecturers", nativeQuery = true) 
	List<LecturerHours> findLecturerNamesMostHours(int nLecturers); 
	
	@Query(value = "select lc.name as name, lc.phone as phone from students_lecturers lc"
			+ " where lc.dtype = 'Lecturer' and lc.city = :city", nativeQuery = true)
	List<LecturerPhone> findLecturerPhoneByCity(String city);
}
