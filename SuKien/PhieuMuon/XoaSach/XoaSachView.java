package qltv.SuKien.PhieuMuon.XoaSach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import groovyjarjarantlr.ActionTransInfo;

public class XoaSachView extends JFrame{
	JTextField txtMaPM;
	public JTextField getTxtMaPM() {
		return txtMaPM;
	}

	public void setTxtMaPM(JTextField txtMaPM) {
		this.txtMaPM = txtMaPM;
	}

	JComboBox<Object> cbMaSach;
	public JComboBox<Object> getCbMaSach() {
		return cbMaSach;
	}

	public void setCbMaSach(JComboBox<Object> cbMaSach) {
		this.cbMaSach = cbMaSach;
	}

	JButton btnXoa;
	public String MaPM="";
	Connection conn = qltv.dao.ConnectMySQL.connect;
	public String user="";
	
	public XoaSachView(String tieude) {
		this.setTitle(tieude);
		addControls();
		if(MaPM.length() != 0) {
			hienThi();
		}
	}
	
	public void hienThi() 
	{
		try {
			String sql0="Select MaSach from ctpm where MaPM=?";
			PreparedStatement pre0=conn.prepareStatement(sql0);
			pre0.setString(1, MaPM);
			ResultSet rs0=pre0.executeQuery();
			while(rs0.next())
			{
				
				//String ms=rs0.getString(1)
				cbMaSach.addItem(rs0.getObject(1));

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		txtMaPM.setText(MaPM);
	}
	
	public void addControls()
	{
		Container con = getContentPane();
		
		JPanel pnThemPhieuMuon = new JPanel();
		pnThemPhieuMuon.setLayout(new BorderLayout());
		con.add(pnThemPhieuMuon);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("THÊM THÔNG TIN SÁCH");
		pnTieuDe.add(lblTieuDe);
		pnThemPhieuMuon.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemPhieuMuon.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemPM = new JPanel();
		pnHienThiThemPM.setLayout(new BoxLayout(pnHienThiThemPM, BoxLayout.Y_AXIS));
		pnThemPhieuMuon.add(pnHienThiThemPM, BorderLayout.CENTER);
		
		JPanel pnMaPM = new JPanel();
		pnMaPM.setLayout(new FlowLayout());
		JLabel lblMaPM = new JLabel("Mã phiếu: ");
		txtMaPM= new JTextField();
		txtMaPM.setPreferredSize(new Dimension(340, 30));
		pnMaPM.add(lblMaPM);
		pnMaPM.add(txtMaPM);
		
		JPanel pnMaSach = new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		JLabel lblMaSach = new JLabel("Mã sách: ");
		cbMaSach=new JComboBox();
		//txtMaSach= new JTextField();
		cbMaSach.setPreferredSize(new Dimension(340, 30));
		pnMaSach.add(lblMaSach);
		pnMaSach.add(cbMaSach);
		
	
		
		pnHienThiThemPM.add(pnMaPM);
		pnHienThiThemPM.add(pnMaSach);
	
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiThemPM.add(pnThaoTac);
		btnXoa= new JButton("XÓA");
		btnXoa.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnXoa);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		btnXoa.setFont(font5);
		
		btnXoa.setBackground(new java.awt.Color(255, 177, 66));
		btnXoa.setForeground(Color.white);
		btnXoa.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		
		lblTieuDe.setFont(font1);
		lblLienHe.setFont(font4);
		
		lblMaPM.setFont(font4);
		lblMaSach.setFont(font4);
		
		txtMaPM.setFont(font4);
		cbMaSach.setFont(font4);
		
		pnMaPM.setBackground(new java.awt.Color(241, 242, 246));
		pnMaSach.setBackground(new java.awt.Color(241, 242, 246));
		
		lblMaSach.setPreferredSize(lblMaPM.getPreferredSize());
		
		txtMaPM.setEditable(false);
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
