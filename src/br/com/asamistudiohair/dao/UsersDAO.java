package br.com.asamistudiohair.dao;

import br.com.asamistudiohair.factory.ConnectionFactory;
import br.com.asamistudiohair.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    public void createUsers(Users user) {
        String sql = "INSERT INTO users(name, email, pwd) VALUES(?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPwd());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Users> readUsers() {
        String sql = "SELECT * FROM Users";
        List<Users> users = new ArrayList<Users>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Users user = new Users();
                user.setId(rst.getInt("id"));
                user.setName(rst.getString("name"));
                user.setEmail(rst.getString("email"));
                user.setPwd(rst.getString("pwd"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    public List<Users> readUsersByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        List<Users> users = new ArrayList<Users>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, email);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Users user = new Users();
                user.setId(rst.getInt("id"));
                user.setName(rst.getString("name"));
                user.setEmail(rst.getString("email"));
                user.setPwd(rst.getString("pwd"));
                user.setUserType(rst.getInt("user_type"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public List<Users> readUsersByName(String name) {
        String sql = "SELECT * FROM Users WHERE name = ?";
        List<Users> users = new ArrayList<Users>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Users user = new Users();
                user.setId(rst.getInt("id"));
                user.setName(rst.getString("name"));
                user.setEmail(rst.getString("email"));
                user.setPwd(rst.getString("pwd"));
                user.setUserType(rst.getInt("user_type"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public List<Users> readUsersByType(int type) {
        String sql = "SELECT * FROM Users WHERE user_type = ?";
        List<Users> users = new ArrayList<Users>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, type);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Users user = new Users();
                user.setId(rst.getInt("id"));
                user.setName(rst.getString("name"));
                user.setEmail(rst.getString("email"));
                user.setPwd(rst.getString("pwd"));
                user.setUserType(rst.getInt("user_type"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public List<Users> readUsersById(int id) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        List<Users> users = new ArrayList<Users>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Users user = new Users();
                user.setId(rst.getInt("id"));
                user.setName(rst.getString("name"));
                user.setEmail(rst.getString("email"));
                user.setPwd(rst.getString("pwd"));
                user.setUserType(rst.getInt("user_type"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public void updateUsers(Users user) {

        String sql = "UPDATE users SET name = ?, email = ?, pwd = ?, user_type = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPwd());
            pstm.setInt(4, user.getUserType());
            pstm.setInt(5, user.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUsersByEmail(String email) {
        String sql = "DELETE FROM users WHERE email = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

