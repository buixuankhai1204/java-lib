package qltv.SuKien.DocGia.ChiTiet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ChiTietView extends JFrame{
	DefaultTableModel dtmCTPM;
	JTable tblCTPM;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String ma="";
	
	public ChiTietView (String title) 
	{
		this.setTitle(title);
		addControls();
		if(ma.length() != 0)
		{
			hienThi();
		}
	}
	
	public void hienThi() 
	{
		try 
		{
			String sql = "select * from ctpm where mapm=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, ma);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				String mapm = rs.getString(1);
				String masach = rs.getString(2);
				String ngaytra = rs.getString(3);
				String tinhtrangsach = rs.getString(4);
				String tinhtrangtra = rs.getString(5);
				String ghichu=rs.getString(7);
				
				Vector<String> vec = new Vector<String>();
				vec.add(mapm);
				vec.add(masach);
				vec.add(ngaytra);
				vec.add(tinhtrangsach);
				vec.add(tinhtrangtra);
				vec.add(ghichu);
				
				dtmCTPM.addRow(vec);
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	private void addControls() 
	{
		Container con = getContentPane();
		JPanel pnCTPM= new JPanel();
		pnCTPM.setLayout(new BorderLayout());
		con.add(pnCTPM);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("BẢNG THỐNG KÊ CHI TIẾT PHIẾU MƯỢN");
		pnTieuDe.add(lblTieuDe);
		pnCTPM.add(pnTieuDe, BorderLayout.NORTH);
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		dtmCTPM = new DefaultTableModel();
		dtmCTPM.addColumn("Mã phiếu");
		dtmCTPM.addColumn("Mã sách");
		dtmCTPM.addColumn("Ngày trả");
		dtmCTPM.addColumn("Tình trạng sách");
		dtmCTPM.addColumn("Tình trạng trả");
		dtmCTPM.addColumn("Ghi chú");
		
		tblCTPM = new JTable(dtmCTPM);
		JScrollPane scCTPM = new JScrollPane(tblCTPM, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCTPM.add(scCTPM, BorderLayout.CENTER);
		
		this.setSize(1200,750);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
