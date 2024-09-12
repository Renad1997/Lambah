package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Club;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Repository.ClubRepository;
import com.example.finalproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;
    private final StudentRepository studentRepository;

    public List<Club> getAllClubs(){
        return clubRepository.findAll();
    }

    public void addClub(Club club){
        clubRepository.save(club);
    }

    public void updateClub(Integer id,Club club){
        Club club1=clubRepository.findClubById(id);
        if(club1==null){
            throw new ApiException("Club not found");
        }
        club1.setName(club.getName());
        club1.setLocation(club.getLocation());
        club1.setDescription(club.getDescription());
        club1.setCapacity(club.getCapacity());
        clubRepository.save(club1);
    }

    public void deleteClub(Integer id){
        Club club1=clubRepository.findClubById(id);
        if(club1==null){
            throw new ApiException("Club not found");
        }
        clubRepository.delete(club1);
    }

    /*Renad*/
    public void joinClub(Integer club_id,Integer student_id){
        Club club=clubRepository.findClubById(club_id);
        Student student=studentRepository.findStudentById(student_id);
        if(club==null || student==null){
            throw new ApiException("Club not assign");
        }
        club.getStudents().add(student);
        student.getClubs().add(club);

        clubRepository.save(club);
        studentRepository.save(student);
    }

}
