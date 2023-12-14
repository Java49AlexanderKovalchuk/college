package telran.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.college.entities.*;
import telran.college.dto.*;
import java.util.*;

public interface MarkRepo extends JpaRepository<Mark, Long> {
List<SubjectNameScore> findByStudentName(String studentName);
/*********************************************************/

/*********************************/

}