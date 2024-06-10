package Finalproject.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BillDetailMapper implements RowMapper<BillDetail> {

    @Override
    public BillDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        BillDetail billDetail = new BillDetail();
        billDetail.setIdbillDetail(rs.getInt("idbillDetail"));
        billDetail.setProductid(rs.getInt("productid"));
        billDetail.setIdbill(rs.getInt("idbill"));
        billDetail.setQuantity(rs.getInt("quantity"));
        billDetail.setTotal(rs.getDouble("total"));
        return billDetail;
    }
}
