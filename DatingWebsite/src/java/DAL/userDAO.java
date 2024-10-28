package DAL;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import java.sql.*;

public class userDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private static final Logger logger = Logger.getLogger(userDAO.class.getName());

    public List<userAccount> getAllUsers(String us) {
        List<userAccount> list = new ArrayList<>();
        String sql = "SELECT * FROM user_account WHERE user_type_id = 0 and username not in (?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToUser(rs));
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    public List<likedUser> getAllUserLiked(String username) {
        List<likedUser> list = new ArrayList<>();
        String sql = "select a.full_name\n"
                + "from user_account a\n"
                + "inner join like_user b on b.username_liked = a.username\n"
                + "where b.username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("full_name");
//                userAccount user = new userAccount(username, fullName);
                likedUser like = new likedUser(username, fullName);
                if (checkDup1(list, like)) {
                    list.add(like);
                }

            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    private boolean checkDup1(List<likedUser> list, likedUser a) {
        for (likedUser c : list) {
            if (c.getUsername().equals(a.getUsername()) && c.getUsername_liked().equalsIgnoreCase(a.getUsername_liked())) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDup2(List<likedUser> list, likedUser a) {
        for (likedUser c : list) {
            if (c.getUsername().equals(a.getUsername()) && c.getUsername_liked().equalsIgnoreCase(a.getUsername_liked())) {
                return false;
            }
        }
        return true;
    }

    public List<userAccount> getAllUserMatch(String username) {
        List<userAccount> list = new ArrayList<>();
        String sql = "select a.full_name, a.facebook, a.username, a.avatar\n"
                + "from user_account a\n"
                + "inner join match_user b on b.user_2 = a.username\n"
                + "where b.user_1 = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("full_name");
                String username1 = rs.getString("username");
                String facebook = rs.getString("facebook");
                String avatar = rs.getString("avatar");
                userAccount user = new userAccount(username1, fullName, avatar, facebook);
                if (checkDup2(list, user)) {
                    list.add(user);
                }

            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    public List<userAccount> getAllLikeYou(String username) {
        List<userAccount> list = new ArrayList<>();
        String sql = "select a.full_name, a.username\n"
                + "from user_account a\n"
                + "inner join like_user b on b.username = a.username\n"
                + "where b.username_liked = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("full_name");
                String us = rs.getString("username");
                userAccount user = new userAccount(us, fullName);
                if (checkDup2(list, user)) {
                    list.add(user);
                }

            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    private boolean checkDup2(List<userAccount> list, userAccount a) {
        for (userAccount c : list) {
            if (c.getUsername().equals(a.getUsername()) && c.getFullName().equals(a.getFullName())) {
                return false;
            }
        }
        return true;
    }

    public List<message> getMessage(String usersend, String userreceive) {
        List<message> list = new ArrayList<>();
        String sql = "select content, time_send\n"
                + "from conversation_mes\n"
                + "where user_send = ? and user_receive = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usersend);
            ps.setString(2, userreceive);
            rs = ps.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                Timestamp timestamp = rs.getTimestamp("time_send");
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                message ms = new message(usersend, userreceive, content, localDateTime);
                list.add(ms);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    public List<message> getMessage1(String usersend, String userreceive) {
        List<message> list = new ArrayList<>();
        String sql = "select content, time_send\n"
                + "from conversation_mes\n"
                + "where user_send = ? and user_receive = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usersend);
            ps.setString(2, userreceive);
            rs = ps.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                Timestamp timestamp = rs.getTimestamp("time_send");
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                message ms = new message(usersend, userreceive, content, localDateTime);
                list.add(ms);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    public userAccount getUserByUserId(int userId) {
        try {
            String query = "SELECT * FROM user_account WHERE id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return null;
    }

    public userAccount checkUser(String username, String password) {
        try {
            String query = "select * from user_account where username = ? and password = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closeResources(conn, ps, rs);
        }
        return null;
    }

    public userAccount getUserByUserName(String userName) {
        try {
            String query = "SELECT * FROM user_account WHERE username = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return null;
    }

    public userAccount getUserByEmail(String email) {
        try {
            String query = "SELECT * FROM user_account WHERE email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return null;
    }

    public String getUserNameByEmail(String email) throws Exception {
        conn = new DBContext().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT username FROM user_account WHERE email=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("userName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ khác nếu cần
        }

        return null;
    }

    public void addUser(String userName, String password, String email) {
        String sql = "INSERT INTO user_account (username,password,user_type_id, gender_id, email, address,full_name,detais) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setNull(4, java.sql.Types.VARCHAR);
            ps.setInt(3, 0);
            ps.setNull(8, java.sql.Types.VARCHAR);
            ps.setNull(7, java.sql.Types.VARCHAR);
            ps.setString(5, email);
            ps.setString(6, "fill here");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public void addUserLiked(String userName, List<String> lovedUsers) {
        String sql = "INSERT INTO like_user (username,username_liked) "
                + "VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            for (String us : lovedUsers) {
                ps.setString(1, userName);
                ps.setString(2, us);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public void addUserMatch(String userName, String usermatch) {
        String sql = "INSERT INTO match_user (user_1,user_2) "
                + "VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, usermatch);
            ps.setString(1, userName);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public void addMessage(String usersend, String userreceive, String content, LocalDateTime dateTime) {
        String sql = "INSERT INTO conversation_mes ([content]\n"
                + "      ,[time_send]\n"
                + "      ,[user_send]\n"
                + "      ,[user_receive]) "
                + "VALUES (?, ?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, content);
            ps.setObject(2, dateTime);
            ps.setString(3, usersend);
            ps.setString(4, userreceive);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public void blockUser(String userName, String userBlock) {
        String sql1 = "DELETE FROM match_user WHERE user_1 = ? and user_2 = ?";
        String sql2 = "DELETE FROM like_user WHERE username = ? and username_liked = ?";
        try {
            conn = new DBContext().getConnection();

            // Execute the first delete statement
            ps = conn.prepareStatement(sql1);
            ps.setString(1, userName);
            ps.setString(2, userBlock);
            ps.executeUpdate();
            ps.close();

            // Execute the second delete statement
            ps = conn.prepareStatement(sql2);
            ps.setString(1, userName);
            ps.setString(2, userBlock);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, null);
        }
    }

    public void DeleteUser(String userdel) {
        String sql1 = "DELETE FROM user_account WHERE username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql1);
            ps.setString(1, userdel);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, null);
        }
    }

    public void updateUserPassword(int userId, String password) {
        String sql = "UPDATE user_account SET password = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public void updateUserStatus(String us) {
        String sql = "UPDATE user_account SET status = 'warning' WHERE username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, us);
            ps.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public int getIdByUserName(String us) throws Exception {
        conn = new DBContext().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT id FROM user_account WHERE username=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, us);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("userId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ khác nếu cần
        }

        return 0;
    }

    public String getUserNameById(int id) throws Exception {
        conn = new DBContext().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT username FROM user_account WHERE userid=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("userName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ khác nếu cần
        }

        return null;
    }

    public boolean checkExistedUserByEmail(String email) {
        boolean isExisted = false;
        String sql = "select email from user_account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(email)) {
                    isExisted = true;
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            return isExisted;
        }
        return isExisted;
    }

    public boolean checkExistUserName(String userName) {
        boolean check = false;
        try {
            String query = "SELECT * FROM user_account WHERE username = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            check = rs.next();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return check;
    }

    public boolean checkPassword(int userId, String password) {
        String sql = "SELECT password from user_account where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            return false;
        } finally {
            closeResources(conn, ps, rs);
        }
        return false;
    }

    public void updatePassword(String username, String newPassword) throws Exception {
        conn = new DBContext().getConnection();
        String query = "UPDATE user_account SET password = ? WHERE email = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUser(int userId) {

        String sql = "DELETE FROM user_account WHERE id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Check if any rows were affected by the delete operation
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "An error occurred while deleting the user.", ex);
            System.out.println(ex);
            return false;
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Database driver class not found.", ex);
            System.out.println(ex);
            return false;
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public boolean updateUserProfile(userAccount user) throws Exception {
        conn = new DBContext().getConnection();
        String updateUserAccountQuery = "UPDATE user_account "
                + "SET full_name = ?, gender_id = ?, address = ?, detais = ?, avatar =?, facebook = ? "
                + "WHERE username = ?";
        boolean success = false;

        try (PreparedStatement preparedStatement = conn.prepareStatement(updateUserAccountQuery)) {

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setInt(2, user.getGenderId());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getDetails());
            preparedStatement.setString(5, user.getAvatar());
            preparedStatement.setString(6, user.getFacebook());
            preparedStatement.setString(7, user.getUsername());
            int rowsUpdated = preparedStatement.executeUpdate();
            success = (rowsUpdated > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    private userAccount mapResultSetToUser(ResultSet rs) throws SQLException {
        userAccount user = new userAccount();
        user.setFullName(rs.getString("full_name"));
        user.setUsername(rs.getString("username"));;
        user.setGenderId(rs.getByte("gender_id"));
        user.setEmail(rs.getString("email"));
        user.setFacebook(rs.getString("facebook"));
        user.setAvatar(rs.getString("avatar"));
        user.setDetails(rs.getString("detais"));
        user.setAddress("address");
        user.setUserTypeId(rs.getInt("user_type_id"));
        user.setStatus(rs.getString("status"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    private likedUser mapResultSetToUserLike(ResultSet rs) throws SQLException {
        likedUser user = new likedUser();
        user.setUsername(rs.getString("username"));
        user.setUsername_liked(rs.getString("username_liked"));
        return user;
    }

    public void updatePasswordwithUserName(String username, String newPassword) throws Exception {
        conn = new DBContext().getConnection();
        String query = "UPDATE [dbo].[user_account]\n"
                + "   SET [password] = ?\n"
                + " WHERE username = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close database resources (connection, statement, and result set)
    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while closing resources", e);
        }
    }

    public List<Report> getAllReport() {
        List<Report> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[username_reported]\n"
                + "      ,[reason]\n"
                + "  FROM [dbo].[report]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(report);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    public List<Report> getReportByUser(String username) {
        List<Report> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[username_reported]\n"
                + "      ,[reason]\n"
                + "  FROM [dbo].[report]\n"
                + "  WHERE username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(report);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    public void addReport(Report report) {
        String sql = "INSERT INTO [dbo].[report]\n"
                + "           ([username]\n"
                + "           ,[username_reported]\n"
                + "           ,[reason])\n"
                + "     VALUES (?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, report.getUsername());
            ps.setString(2, report.getUsername_reported());
            ps.setString(3, report.getReason());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public void deleteReport(String user1, String user2) {
        String sql = "DELETE FROM [dbo].[report]\n"
                + "      WHERE username = ? AND username_reported = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user1);
            ps.setString(2, user2);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
    }

    public String getReason(String username) {
        
        String sql = "SELECT [reason]\n"
                + "  FROM [dbo].[report]\n"
                + "  WHERE username_reported = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                String reason = rs.getString("reason");
                return reason;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return "non";
    }

}
