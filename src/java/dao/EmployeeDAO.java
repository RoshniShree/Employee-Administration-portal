package com.ems.dao;

import com.ems.model.Employee;
import com.ems.util.DBConnection;
import java.sql.*;

public class EmployeeDAO {
    public boolean validateAdmin(String username, String password) {
        String sql = "SELECT username FROM admin WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean addEmployee(Employee e) {
        String sql = "INSERT INTO employees(name,email,department,salary) VALUES(?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getName()); ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment()); ps.setDouble(4, e.getSalary());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }

    // Uses a normal array instead of ArrayList or another Collection Framework class.
    public Employee[] getAllEmployees() {
        String countSql = "SELECT COUNT(*) FROM employees";
        String dataSql = "SELECT * FROM employees ORDER BY id";
        try (Connection con = DBConnection.getConnection();
             Statement countSt = con.createStatement();
             ResultSet countRs = countSt.executeQuery(countSql)) {
            int count = countRs.next() ? countRs.getInt(1) : 0;
            Employee[] employees = new Employee[count];
            try (Statement dataSt = con.createStatement();
                 ResultSet rs = dataSt.executeQuery(dataSql)) {
                int i = 0;
                while (rs.next() && i < employees.length) {
                    employees[i++] = mapEmployee(rs);
                }
            }
            return employees;
        } catch (SQLException e) { e.printStackTrace(); return new Employee[0]; }
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? mapEmployee(rs) : null; }
        } catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public boolean updateEmployee(Employee e) {
        String sql = "UPDATE employees SET name=?, email=?, department=?, salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getName()); ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment()); ps.setDouble(4, e.getSalary());
            ps.setInt(5, e.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }

    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    private Employee mapEmployee(ResultSet rs) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                rs.getString("department"), rs.getDouble("salary"));
    }
}
