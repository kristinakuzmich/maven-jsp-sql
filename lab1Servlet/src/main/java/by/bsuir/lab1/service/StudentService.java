package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.StudentDao;
import by.bsuir.lab1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    public int saveStudent(String firstName, String secondName,
                           String faculty, int course) {
        return studentDao.saveStudent(new Student()
                .setFirstName(firstName)
                .setSecondName(secondName)
                .setFaculty(faculty)
                .setCourse(course));
    }

    public String getReversedString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

}
