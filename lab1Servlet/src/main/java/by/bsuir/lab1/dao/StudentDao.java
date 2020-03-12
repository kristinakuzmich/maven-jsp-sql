package by.bsuir.lab1.dao;


import by.bsuir.lab1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDao {

    private static final String SELECT_STUDENTS =
            "SELECT ID, FIRST_NAME, SECOND_NAME, COURSE, FACULTY FROM  STUDENT";


    private static final StudentMapper MAPPER = new StudentMapper();

    @Autowired
    private DataSource dataSource;


    public List<Student> getStudents() {
        return new JdbcTemplate(dataSource).query(SELECT_STUDENTS, MAPPER);
    }

    public int saveStudent(Student student) {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("FIRST_NAME", student.getFirstName());
        parameterMap.put("SECOND_NAME", student.getSecondName());
        parameterMap.put("COURSE", student.getCourse());
        parameterMap.put("FACULTY", student.getFaculty());
        return new SimpleJdbcInsert(dataSource)
                .withTableName("STUDENT")
                .usingGeneratedKeyColumns("ID")
                .execute(parameterMap);
    }

    public StudentDao setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }


    private static class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student()
                    .setId(rs.getLong("ID"))
                    .setCourse(rs.getInt("COURSE"))
                    .setFaculty(rs.getString("FACULTY"))
                    .setFirstName(rs.getString("FIRST_NAME"))
                    .setSecondName(rs.getString("SECOND_NAME"));
        }
    }
}

