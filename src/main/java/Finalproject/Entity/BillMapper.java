package Finalproject.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BillMapper implements RowMapper<Bill> {

    @Override
    public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bill bill = new Bill();
        bill.setIdbill(rs.getInt("idbill"));
        bill.setEmail(rs.getString("email"));
        bill.setPhone(rs.getString("phone"));
        bill.setFullname(rs.getString("fullname"));
        bill.setAddress(rs.getString("address"));
        bill.setTotal(rs.getDouble("total"));
        bill.setQuantity(rs.getInt("quantity"));
        bill.setNote(rs.getString("note"));
        bill.setUserid(rs.getInt("userid"));
        bill.setStatus(rs.getBoolean("status"));
        return bill;
    }
}
