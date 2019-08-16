package com.util.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
    public List<User> findUser(User user){
        Connection conn=null;
        PreparedStatement pra=null;
        ResultSet rs=null;
        ArrayList<User> list = new ArrayList<>();
    try {
        conn=this.getConnection();
        ArrayList<Object> paraList=new ArrayList();
        StringBuffer sf = new StringBuffer();
        sf.append("select * from user where 1=1");
        if (user!=null){
            if (user.getUid()>0){
                sf.append(" and uid = ?");
                paraList.add(user.getUid());
            }
            if (user.getUsername()!= null){
                sf.append(" and username like ?");
                paraList.add("%"+user.getUsername()+"%");
            }
            if (user.getPassword()!= null){
                sf.append(" and password like ?");
                paraList.add("%"+user.getPassword()+"%");
            }
            if (user.getConfirm_pwd()!= null){
                sf.append(" and confirm_pwd like ?");
                paraList.add("%"+user.getConfirm_pwd()+"%");
            }
            if (user.getSex()!= null){
                sf.append(" and sex like ?");
                paraList.add("%"+user.getSex()+"%");
            }
            if (user.getHobbys()!=null){
                sf.append(" and hobbys like ? ");
                paraList.add("%"+user.getHobbys()+"%");
            }
            if (user.getPhone()!= null){
                sf.append(" and phone like ?");
                paraList.add("%"+user.getPhone()+"%");
            }
            if (user.getEmail()!=null){
                sf.append(" and email like ? ");
                paraList.add("%"+user.getEmail()+"%");
            }
            if (user.getAddrs()!=null){
                sf.append("and addrs like ?");
                paraList.add("%"+user.getAddrs()+"%");
            }
            if (user.getFlag()!=null){
                sf.append("and flag like ?");
                paraList.add("%"+user.getFlag()+"%");
            }

        }

            pra=conn.prepareStatement(sf.toString());
            if (paraList!=null&&paraList.size()>0){
                for (int i=0;i<paraList.size();i++){
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            rs = pra.executeQuery();

            while (rs.next()){
                User entity = new User();
                entity.setUid(rs.getInt("uid"));
                entity.setUsername(rs.getString("username"));
                entity.setPassword(rs.getString("password"));
                entity.setConfirm_pwd(rs.getString("confirm_pwd"));
                entity.setSex(rs.getString("sex"));
                entity.setHobbys(rs.getString("hobbys"));
                entity.setPhone(rs.getString("phone"));
                entity.setEmail(rs.getString("email"));
                entity.setAddrs(rs.getString("addrs"));
                entity.setFlag(rs.getString("flag"));
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn,pra,rs);
        }
        return list;
    }


    public int addUser(User user){
        String sql="insert into user (username,password,confirm_pwd,sex,hobbys,phone,email,addrs,flag)values(?,?,?,?,?,?,?,?,?)";
        ArrayList<Object> list = new ArrayList<>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getConfirm_pwd());
        list.add(user.getSex());
        list.add(user.getHobbys());
        list.add(user.getPhone());
        list.add(user.getEmail());
        list.add(user.getEmail());
        list.add(user.getFlag());

        return this.executeUpdate(sql,list);
    }

    public int deleteUser(User user){
        String sql="delete from user where uid = ?";
        ArrayList<Object> list = new ArrayList<>();
        list.add(user.getUid());

        return this.executeUpdate(sql,list);
    }

    public int updateUer(User user){
        StringBuffer sf = new StringBuffer();
        sf.append("update user set ");
        sf.append(" username = ?");
        sf.append(" , password = ?");
        sf.append(" , confirm_pwd = ?");
        sf.append(" , sex = ?");
        sf.append(" , hobbys = ?");
        sf.append(" , phone = ?");
        sf.append(" , email = ?");
        sf.append(" , addrs = ?");
        sf.append(" , flag = ?");
        sf.append(" where uid = ?");
        ArrayList<Object> list = new ArrayList<>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getConfirm_pwd());
        list.add(user.getSex());
        list.add(user.getHobbys());
        list.add(user.getPhone());
        list.add(user.getEmail());
        list.add(user.getAddrs());
        list.add(user.getFlag());
        list.add(user.getUid());

        return this.executeUpdate(sf.toString(),list);
    }
}
