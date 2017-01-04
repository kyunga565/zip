package zipcode.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import zipcode.dto.ZipcodeDto;
import zipcode.util.Jdbc;
import zipcode.util.ZipcodeUtil;

public class ZipcodeDao {
	private List<String>list;
	private static final ZipcodeDao instance = new ZipcodeDao();

	public static ZipcodeDao getInstance() {
		return instance;
	}
	private ZipcodeDao(){}
/*	public List<zipcodeDto> selectInfoByAll(){
		List<zipcodeDto> list = new ArrayList<zipcodeDto>();
		zipcodeDto zip = null;
		String sql = "SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = zipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()){
				list.add(getObject(rs));
			//	zip = new zipcodeDto(rs.getString("zipcode"), rs.getString("sido")
			//			, rs.getString("sigungu"), rs.getString("doro"), rs.getInt("building1"), rs.getInt("building2"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<zipcodeDto> selectInfoBycode(){
		List<zipcodeDto> List =  new ArrayList<zipcodeDto>();
		String sql = "SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode where zipcode=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = zipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				List.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}*/
	public List<ZipcodeDto> selectsido(){
		List<ZipcodeDto> List =  new ArrayList<ZipcodeDto>();
		String sql = "SELECT DISTINCT sido from zipcode";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = ZipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				List.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}

//select zipcode,sido,sigungu,doro,building1,building2 from zipcode where doro = '임곡로' and sido='강원도';	
	
	public List<ZipcodeDto> selectdoro() {
		List<ZipcodeDto> List =  new ArrayList<ZipcodeDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try {
             String sql = "select zipcode,sido,sigungu,doro,building1,building2 from zipcode where doro = ?";
             pstmt = ZipcodeUtil.getConnection().prepareStatement(sql);
 		   	 rs = pstmt.executeQuery();
             while(rs.next()){
 				List.add(getObject(rs));
             }
        }catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;       
}
	public List<ZipcodeDto> selectdorosido() {
		List<ZipcodeDto> List =  new ArrayList<ZipcodeDto>();
		list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try {
             String sql = "select zipcode,sido,sigungu,doro from zipcode where doro like ? and sido = ?";
             pstmt = ZipcodeUtil.getConnection().prepareStatement(sql);
 		   	 rs = pstmt.executeQuery();
             while(rs.next()){
 				list.add(rs.getString("zipcode"));
             }
        }catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;       
}	

	
/*	private zipcodeDto getObject(ResultSet rs) throws SQLException {
		return new zipcodeDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
	}*/
	private ZipcodeDto getObject(ResultSet rs) throws SQLException {
		return new ZipcodeDto(rs.getString("sido"));
	}
}
