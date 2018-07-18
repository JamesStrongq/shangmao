package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.vo.OutProduct;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class ContractDaoImpl extends BaseDaoImpl<ContractC> implements ContractDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void deleteBatch(String[] contractId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < contractId.length;i++){
            if(i == contractId.length - 1){
                sb.append(contractId[i] + "\"");
                break;
            }
            sb.append("\"" + contractId[i]);
            sb.append("\",\"");

        }
        String sql = "delete from contract_c where contract_id in (" + sb.toString() +")" ;
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
        transaction.commit();

    }

    public BigInteger[] getNum(String contractId) {
        System.out.println("合同号为" + contractId);
        BigInteger[] str = new BigInteger[2];
        String sql = "SELECT\n" +
                "(\n" +
                "\tSELECT COUNT(*) FROM contract_product_c WHERE contract_id=?1\n" +
                ")\n" +
                "cpnum,\n" +
                "(\n" +
                "\tSELECT COUNT(*) FROM ext_cproduct_c WHERE contract_product_id IN\n" +
                "\t\t\t(\n" +
                "\t\t\t\t\tSELECT contract_product_id FROM contract_product_c\n" +
                "\t\t\t\t\tWHERE contract_id=?2\n" +
                "\t\t\t)\n" +
                ")\n" +
                "epnum\n" +
                "FROM contract_c";
        SQLQuery query = sessionFactory.openSession().createSQLQuery(sql);
        query.setString(1,contractId);
        query.setString(2,contractId);
        List list = query.list();

        for(Object obj : list){
            Object[] ob = (Object[])obj;
            str[0] = (BigInteger) ob[0];
            str[1] = (BigInteger) ob[1];
        }
        return str;
    }

    public void changeState(Integer state, String[] contractId) {
        Session session = sessionFactory.openSession().getSession();
        Transaction transaction = session.beginTransaction();

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < contractId.length;i++){
            if(i == contractId.length - 1){
                sb.append(contractId[i] + "\"");
                break;
            }
            sb.append("\"" + contractId[i]);
            sb.append("\",\"");

        }
        System.out.println("转换后的StringBuffer=" + sb.toString());
        String sql = "update constract_c set state=" + state + "where constract_id in (" + sb.toString() + ")";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.executeUpdate();
        transaction.commit();
    }

    public List<OutProduct> findOutProduct(String inputDate) {
        Session session = sessionFactory.openSession().getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT\n" +
                "\tc.custom_name,c.contract_no,c.delivery_period,c.ship_time,c.trade_terms,\n" +
                "\tt.factory_name,t.product_no,t.cnumber\n" +
                "FROM\n" +
                "(\n" +
                "select contract_id,custom_name,contract_no,delivery_period,ship_time,trade_terms from contract_c\n" +
                ") c\n" +
                "LEFT JOIN\n" +
                "(\n" +
                "\tSELECT \n" +
                "\t\tcp.contract_id,\n" +
                "\t\tf.factory_name,\n" +
                "\t\tcp.product_no,cp.cnumber\n" +
                "\tFROM\n" +
                "\t(\n" +
                "\tSELECT\n" +
                "\tcontract_id,factory_id,product_no,concat(cnumber,packing_unit) as cnumber\n" +
                "\tFROM contract_product_c\n" +
                "\t) cp\n" +
                "\tleft JOIN\n" +
                "\t(\n" +
                "\tselect factory_id,factory_name from factory_c\n" +
                "\t) f\n" +
                "\ton cp.factory_id = f.factory_id\n" +
                ") t\n" +
                "on c.contract_id=t.contract_id\n" +
                "where c.ship_time like ?1";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setString(1,inputDate);
        List list = sqlQuery.getResultList();
        List<OutProduct> resultList = new ArrayList<OutProduct>();
        for(Object obj : list){
            Object[] objects = (Object[])obj;
                OutProduct outProduct = new OutProduct();
                outProduct.setCustomName((String) objects[0]);
                outProduct.setContractNo((String) objects[1]);
                outProduct.setDeliveryPeriod((Date) objects[2]);
                outProduct.setShipTime((Date) objects[3]);
                outProduct.setTradeTerms((String) objects[4]);
                outProduct.setFactoryName((String)objects[5]);
                outProduct.setProductNo((String)objects[6]);
                outProduct.setCnumber((String)objects[7]);
                resultList.add(outProduct);
        }
        return resultList;
    }
}
