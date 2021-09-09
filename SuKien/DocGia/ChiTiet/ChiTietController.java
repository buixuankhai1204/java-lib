package qltv.SuKien.DocGia.ChiTiet;

import java.sql.Connection;

public class ChiTietController {
	Connection conn=qltv.dao.ConnectMySQL.connect;
	private ChiTietView chiTietView;
	public ChiTietController(ChiTietView chiTietView) {
		// TODO Auto-generated constructor stub
		this.chiTietView = chiTietView;
	}
	public void showChiTietView() {
		chiTietView.setMoDal(true);
		chiTietView.setVisible(true);
	}
}
