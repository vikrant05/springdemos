package com.vikrant.springboot.login.dao.impl;

import com.vikrant.springboot.login.dao.EmployeeDao;
import com.vikrant.springboot.login.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insertEmployee(Employee emplpoyee) throws Exception {
        String sql = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME) VALUES(?,?)";

        getJdbcTemplate().update(sql, new Object[]{emplpoyee.getEmpId(), emplpoyee.getEmpName()});
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        String sql = "INSERT INTO employee " + "(EMP_ID, EMP_NAME) VALUES (?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Employee employee = employees.get(i);
                ps.setString(1, employee.getEmpId());
                ps.setString(2, employee.getEmpName());
            }

            public int getBatchSize() {
                return employees.size();
            }
        });
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<Employee>();
        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setEmpId((String) row.get("EMP_ID"));
            emp.setEmpName((String) row.get("EMP_NAME"));
            result.add(emp);
        }

        return result;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        String sql = "SELECT * FROM employee WHERE EMP_ID = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("EMP_ID"));
                emp.setEmpName(rs.getString("EMP_NAME"));
                return emp;
            }
        });
    }
}
