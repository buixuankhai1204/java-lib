package qltv.SuKien.PhieuMuon.ThemSach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThemSachView extends JFrame{
	JTextField txtMaPM, txtTinhTrangSach, txtMaSach;
	public JTextField getTxtMaPM() {
		return txtMaPM;
	}

	public void setTxtMaPM(JTextField txtMaPM) {
		this.txtMaPM = txtMaPM;
	}

	public JTextField getTxtTinhTrangSach() {
		return txtTinhTrangSach;
	}

	public void setTxtTinhTrangSach(JTextField txtTinhTrangSach) {
		this.txtTinhTrangSach = txtTinhTrangSach;
	}

	public JTextField getTxtMaSach() {
		return txtMaSach;
	}

	public void setTxtMaSach(JTextField txtMaSach) {
		this.txtMaSach = txtMaSach;
	}

	JButton btnThem;
	public String MaPM="";
	Connection conn = qltv.dao.ConnectMySQL.connect;
	public String user="";
	
	public ThemSachView(String tieude) {
		this.setTitle(tieude);
		addControls();
		if(MaPM.length() != 0) {
			hienThi();
		}
	}
	
	public void hienThi() {
		txtMaPM.setText(MaPM);
	}
	
	public void addControls() {
		Container con = getContentPane();
		
		JPanel pnThemPhieuMuon = new JPanel();
		pnThemPhieuMuon.setLayout(new BorderLayout());
		con.add(pnThemPhieuMuon);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe = new JLabel("THÊM THÔNG TIN SÁCH");
		pnTieuDe.add(lblTieuDe);
		pnThemPhieuMuon.add(pnTieuDe,BorderLayout.NORTH);
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe = new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemPhieuMuon.add(pnLienHe,BorderLayout.SOUTH);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15); 
		lblLienHe.setFont(font4);
		
		JPanel pnHienThiThemPM = new JPanel();
		pnHienThiThemPM.setLayout(new BoxLayout(pnHienThiThemPM, BoxLayout.Y_AXIS));
		pnThemPhieuMuon.add(pnHienThiThemPM,BorderLayout.CENTER);
		
		JPanel pnMaPM = new JPanel();
		pnMaPM.setLayout(new FlowLayout());
		JLabel lblMaPM = new JLabel("Mã Phiếu: ");
		txtMaPM = new JTextField();
		txtMaPM.setPreferredSize(new Dimension(340,30));
		pnMaPM.add(lblMaPM);
		pnMaPM.add(txtMaPM);
		lblMaPM.setFont(font4);
		txtMaPM.setFont(font4);
		
		JPanel pnMaSach = new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		JLabel lblMaSach = new JLabel("Mã sách: ");
		txtMaSach= new JTextField("MS");
		txtMaSach.setPreferredSize(new Dimension(340, 30));
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);
		lblMaSach.setFont(font4);
		txtMaSach.setFont(font4);
		
		JPanel pnTinhTrang = new JPanel();
		pnTinhTrang.setLayout(new FlowLayout());
		JLabel lblTinhTrang = new JLabel("Tình trạng sách: ");
		txtTinhTrangSach = new JTextField();
		txtTinhTrangSach.setPreferredSize(new Dimension(340, 30));
		pnTinhTrang.add(lblTinhTrang);
		pnTinhTrang.add(txtTinhTrangSach);
		lblTinhTrang.setFont(font4);
		txtTinhTrangSach.setFont(font4);
		
		pnHienThiThemPM.add(pnMaPM);
		pnHienThiThemPM.add(pnMaSach);
		pnHienThiThemPM.add(pnTinhTrang);
		
		JPanel pnThaoTac = new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiThemPM.add(pnThaoTac);
		btnThem = new JButton("THÊM");
		btnThem.setPreferredSize(new Dimension(110,35));
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		btnThem.setFont(font5);
		btnThem.setBackground(new java.awt.Color(255, 177, 66));
		btnThem.setForeground(Color.white);
		btnThem.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		pnThaoTac.add(btnThem);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		pnMaPM.setBackground(new java.awt.Color(241, 242, 246));
		pnMaSach.setBackground(new java.awt.Color(241, 242, 246));
		pnTinhTrang.setBackground(new java.awt.Color(241, 242, 246));
		
		
		lblMaSach.setPreferredSize(lblTinhTrang.getPreferredSize());
		lblMaPM.setPreferredSize(lblTinhTrang.getPreferredSize());
		
		txtMaPM.setEditable(false);
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void addListener(ActionListener listener) {
		btnThem.addActionListener(listener);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
