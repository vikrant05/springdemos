package com.vikrant.springboot.login.dao.impl;

import com.vikrant.springboot.login.dao.UserDao;
import com.vikrant.springboot.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public User getUser(String userName) throws Exception {
        String sql = "SELECT * FROM USER_1 WHERE USER_NAME = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{userName}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("USER_PASSWORD"));
                return user;
            }
        });
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO USER_1 (USER_NAME, USER_PASSWORD) VALUES(?,?)";
        getJdbcTemplate().update(sql, user.getUserName(), user.getPassword());
    }
}
