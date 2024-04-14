package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import board.workwear.dto.WorkwearDTO;
import common.DBConnectionUtil;

public class WorkwearDAO {

	public List<WorkwearDTO> getAllWorkwear() {
        List<WorkwearDTO> workwears = new ArrayList<>();
        String sql = "SELECT * FROM BOARD WHERE CATEGORY = 'W'";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int boradId = rs.getInt("2");
                String imageName = rs.getString("image_path");
                String userNickname = rs.getString("수라");

                WorkwearDTO workwear = new WorkwearDTO( boradId, imageName, userNickname);
                workwears.add(workwear);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workwears;
    }
}