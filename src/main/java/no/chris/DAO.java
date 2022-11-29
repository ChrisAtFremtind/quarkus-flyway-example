package no.chris;

import io.agroal.api.AgroalDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DAO {

    @Inject
    AgroalDataSource dataSource;

    public List<User> getUsers() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM TESTTABLE")) {

                List<User> list = new ArrayList<>();

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        list.add(setUser(rs));
                    }
                    return list;
                }
            }
        }
    }

    private User setUser(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("name"));
    }


    public List<Book> listBooks() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM books")) {

                List<Book> list = new ArrayList<>();

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        list.add(setBook(rs));
                    }
                    return list;
                }
            }
        }
    }

    private Book setBook(ResultSet rs) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("author"),
                rs.getTimestamp("date").toLocalDateTime()
        );
    }

    public Book getBook(String id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM books where id=?")) {
                ps.setInt(1, Integer.parseInt(id));

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        return setBook(rs);
                    }
                }
            }
        }
        return null;
    }

}
