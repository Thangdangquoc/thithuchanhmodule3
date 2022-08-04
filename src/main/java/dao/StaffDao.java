package dao;

import connectMySQL.ConnectMySQL;
import model.NhanVien;
import model.PhongBan;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaffDao implements CRUD{
    DepartmentDao departmentDao = new DepartmentDao();

    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public boolean edit(int id, Object o) {
        return false;
    }

    @Override
    public List<NhanVien> getAll() {
        String sql = "select * from student";
        List<NhanVien> students = new ArrayList<>();
        try (Connection connection = ConnectMySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("idNV");
                String name = resultSet.getString("tenNV");
                Date date = resultSet.getDate("ngaysinh");
                LocalDate dateOfBirth = date.toLocalDate();
                String address = resultSet.getString("diachi");
                String phoneNumber = resultSet.getString("soDienThoai");
                String email = resultSet.getString("email");
                PhongBan phongBan = departmentDao.findById(resultSet.getInt("idPhongban"));
                students.add(new NhanVien(id,name,dateOfBirth, address, email, phoneNumber, phongBan));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }


    public List<NhanVien> getAllByName(String name) {
        String sql = "select * from student where name like concat('%',?,'%')";
        List<NhanVien> nhanViens = new ArrayList<>();
        try (Connection connection = ConnectMySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idNV");
                String nameS = resultSet.getString("tenNV");
                Date date = resultSet.getDate("ngaysinh");
                LocalDate dateOfBirth = date.toLocalDate();
                String address = resultSet.getString("diachi");
                String phoneNumber = resultSet.getString("soDienThoai");
                String email = resultSet.getString("Email");
                PhongBan phongBan = departmentDao.findById(resultSet.getInt("idPhongban"));
                nhanViens.add(new NhanVien(id, nameS, dateOfBirth, address, email, phoneNumber, phongBan));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nhanViens;
    }



    public boolean create(NhanVien nhanVien) {
        String sql = "insert into nhanvien value (?,?,?,?,?,?,?)";
        try (Connection connection = ConnectMySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanVien.getID());
            preparedStatement.setString(2, nhanVien.getTenNV());
            preparedStatement.setString(3, String.valueOf(nhanVien.getNgaysinh()));
            preparedStatement.setString(4, nhanVien.getDiachi());
            preparedStatement.setString(5, nhanVien.getEmail());
            preparedStatement.setString(6, nhanVien.getSoDienThoai());
            preparedStatement.setInt(7, nhanVien.getPhongban().getId());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }


    public boolean edit(int id, NhanVien nhanVien) {
        String sql = "UPDATE nhanvien SET name = ?,dateOfBirth = ?, " +
                "address = ?,email = ?,phoneNumber = ?, idClass=? WHERE (id = ?)";
        try (Connection connection = ConnectMySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(7, nhanVien.getID());
            preparedStatement.setString(1, nhanVien.getTenNV());
            preparedStatement.setString(2, String.valueOf(nhanVien.getNgaysinh()));
            preparedStatement.setString(3, nhanVien.getDiachi());
            preparedStatement.setString(4, nhanVien.getEmail());
            preparedStatement.setString(5, nhanVien.getSoDienThoai());
            preparedStatement.setInt(6,nhanVien.getPhongban().getId());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from nhanvien WHERE id = ?";
        try (Connection connection = ConnectMySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public NhanVien findById(int id) {
        String sql = "select * from nhanvien where id = " + id;
        try (Connection connection = ConnectMySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int idNV= resultSet.getInt("idNV");
            String nameS = resultSet.getString("tenNV");
            Date date = resultSet.getDate("ngaysinh");
            LocalDate dateOfBirth = date.toLocalDate();
            String address = resultSet.getString("diachi");
            String phoneNumber = resultSet.getString("soDienThoai");
            String email = resultSet.getString("Email");
            PhongBan phongBan = departmentDao.findById(resultSet.getInt("idPhongban"));
            return new NhanVien(idNV,nameS,dateOfBirth, address, email, phoneNumber, phongBan);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
