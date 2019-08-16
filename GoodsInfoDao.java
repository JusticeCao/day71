package com.util.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsInfoDao extends BaseDao {
    public List<GoodsInfo> findGoodsInfo(GoodsInfo good){
        Connection conn = null;
        PreparedStatement pra =null;
        ResultSet rs=null;
        ArrayList<GoodsInfo> list = new ArrayList<>();
    try {
        conn = this.getConnection();
        List<Object>paraList=new ArrayList();
        StringBuffer sf = new StringBuffer();
        sf.append("select *  from GoodsInfo where 1=1");
        if (good!=null){
            if (good.getId()>0){
                sf.append(" and id = ? ");
                paraList.add(good.getId());
            }
            if (good.getGoodsInfo_name()!= null){
                sf.append("and goodsInfo_name like ?");
                paraList.add("%" + good.getGoodsInfo_name()+ "%");
            }
            if (good.getGoodsInfo_pic()!= null){
                sf.append(" and goodsInfo_pic like ?");
                paraList.add("%" + good.getGoodsInfo_pic()+ "%");
            }
            if (good.getGoodsInfo_price()!= null){
                sf.append( " and goodsInfo_price like ?");
                paraList.add("%" +good.getGoodsInfo_price()+"%");
            }
            if (good.getGoodsInfo_description()!=null){
                sf.append( "and goodsInfo_description like ? ");
                paraList.add("%" + good.getGoodsInfo_description()+ "%");
            }
            if (good.getGoods_stock()!= null){
                sf.append("and goods_stock like ?");
                paraList.add("%" + good.getGoods_stock()+ "%");
            }
            if (good.getFlag()!=null){
                sf.append("and flag like ?");
                paraList.add("%" + good.getFlag()+ "%");
                }

            if (good.getCreated()!=null){
                sf.append("and created like ?");
                paraList.add("%"+good.getCreated()+"%");
            }
            if (good.getCreated_date()!=null){
                sf.append("and created_date like ?");
                paraList.add("%"+good.getCreated_date()+"%");
                }
            }

            pra=conn.prepareStatement(sf.toString());
            if (paraList!=null&&paraList.size()>0){
                for (int i=0;i<paraList.size();i++){
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            rs=pra.executeQuery();

            while (rs.next()){
                GoodsInfo entity = new GoodsInfo();
                entity.setId(rs.getInt("id"));
                entity.setGoodsInfo_name(rs.getString("goodsInfo_name"));
                entity.setGoodsInfo_pic(rs.getString("goodsInfo_pic"));
                entity.setGoodsInfo_price(rs.getString("goodsInfo_price"));
                entity.setGoodsInfo_description(rs.getString("goodsInfo_description"));
                entity.setGoods_stock(rs.getString("goods_stock"));
                entity.setFlag(rs.getString("flag"));
                entity.setCreated(rs.getString("created"));
                entity.setCreated_date(rs.getString("created_date"));
                list.add(entity);

            }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.closeAll(conn,pra,rs);
            }
        return list;
    }

    public int addGoods(GoodsInfo good){
        StringBuffer sf = new StringBuffer();
        sf.append("insert into GoodsInfo(goodsInfo_name,goodsInfo_pic,goodsInfo_price,goodsInfo_description,goods_stock,flag,created,created_date)values(?,?,?,?,?,?,?,?)");
        ArrayList<Object> list = new ArrayList<>();
        list.add(good.getGoodsInfo_name());
        list.add(good.getGoodsInfo_pic());
        list.add(good.getGoodsInfo_price());
        list.add(good.getGoodsInfo_description());
        list.add(good.getGoods_stock());
        list.add(good.getFlag());
        list.add(good.getCreated());
        list.add(good.getCreated_date());

        return this.executeUpdate(sf.toString(),list);
    }

    public int deleteGoods(GoodsInfo good){
        String sql="delete from GoodsInfo where id = ?";
        ArrayList<Object> list = new ArrayList<>();
        list.add(good.getId());

        return this.executeUpdate(sql,list);
    }

    public int UpdateGoods(GoodsInfo good){
        StringBuffer sf = new StringBuffer();
        sf.append("update GoodsInfo set");
        sf.append(" goodsInfo_name = ?");
        sf.append(" , goodsInfo_pic = ?");
        sf.append(" , goodsInfo_price = ?");
        sf.append(" , goodsInfo_description = ?");
        sf.append(" , goods_stock = ?");
        sf.append(" , flag = ?");
        sf.append(" , created = ?");
        sf.append(" , created_date = ?");
        sf.append(" where id = ?");

        ArrayList<Object> list = new ArrayList<>();
        list.add(good.getGoodsInfo_name());
        list.add(good.getGoodsInfo_pic());
        list.add(good.getGoodsInfo_price());
        list.add(good.getGoodsInfo_description());
        list.add(good.getGoods_stock());
        list.add(good.getFlag());
        list.add(good.getCreated());
        list.add(good.getCreated_date());
        list.add(good.getId());

        return this.executeUpdate(sf.toString(),list);
    }
}
