package zipcode.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zipcode.dto.ZipcodeDto;
import zipcode.util.ZipcodeUtil;

public class ZipcodeDao {
	private static final ZipcodeDao instance = new ZipcodeDao();

	public static ZipcodeDao getInstance() {
		return instance;
	}

	private ZipcodeDao() {
	}

	public List<ZipcodeDto> selectsido() {
		List<ZipcodeDto> List = new ArrayList<ZipcodeDto>();
		String sql = "SELECT DISTINCT sido from zipcode";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = ZipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				List.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}

	// select zipcode,sido,sigungu,doro,building1,building2 from zipcode where
	// doro = '임곡로' and sido='강원도';

	public List<ZipcodeDto> selectdoro() {
		List<ZipcodeDto> List = new ArrayList<ZipcodeDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select zipcode,sido,sigungu,doro,building1,building2 from zipcode where doro = ?";
			pstmt = ZipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				List.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}

	public List<ZipcodeDto> selectdorosido(ZipcodeDto zip) {
		List<ZipcodeDto> List = new ArrayList<ZipcodeDto>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String forSql = "%" + zip.getDoro() + "%";
			String sql = "select zipcode,sido,sigungu,doro,building1,building2 from zipcode where doro like ? and sido = ?";
			pstmt = ZipcodeUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, forSql);
			pstmt.setString(2, zip.getSido());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				List.add(new ZipcodeDto(rs.getString("zipcode"), rs.getString("sido"), rs.getString("sigungu"),
						rs.getString("doro"), rs.getInt("building1"), rs.getInt("building2")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}
	private ZipcodeDto getObject(ResultSet rs) throws SQLException {
		return new ZipcodeDto(rs.getString("sido"));
	}
}
