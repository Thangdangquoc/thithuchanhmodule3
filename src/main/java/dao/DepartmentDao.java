package dao;

import connectMySQL.ConnectMySQL;

import model.PhongBan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements  CRUD{

        @Override
        public List<PhongBan> getAll() {
            String SELECT_ALL_PHONG_BAN = "select * from phongban";
            List<PhongBan> phongBans = new ArrayList<>();
            try (Connection connection = ConnectMySQL.getConnect()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL_PHONG_BAN);

                while (resultSet.next()) {
                    int idPhongban = resultSet.getInt(1);
                    String namePhongBan = resultSet.getString(2);
                   phongBans.add(new PhongBan(idPhongban, namePhongBan));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return phongBans;
        }

    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public boolean edit(int id, Object o) {
        return false;
    }

    @Override
        public boolean delete(int id) {
            return false;
        }

        @Override
        public PhongBan findById(int id) {
            String sql = "select * from quanlinhanvien where idClass = ?";
            try (Connection connection = ConnectMySQL.getConnect()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                resultSet.next();
                int idPB = resultSet.getInt(1);
                String namePB = resultSet.getString(2);
                PhongBan phongBan = new PhongBan(idPB, namePB);
                return phongBan;


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return null;
        }
    }


