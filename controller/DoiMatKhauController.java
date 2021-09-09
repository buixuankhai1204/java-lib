package qltv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import qltv.view.DoiMatKhauView;
import qltv.view.LoGinView;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyThuThuView;
import qltv.entity.TaiKhoan;
import qltv.dao.ConnectMySQL;
import qltv.dao.TaiKhoanDao;

public class DoiMatKhauController {
	private DoiMatKhauView doiMatKhauView;
	public String tentk="";
	Connection con=ConnectMySQL.connect;
	
	public DoiMatKhauController(DoiMatKhauView doiMatKhauView) {
		this.doiMatKhauView = doiMatKhauView;
		doiMatKhauView.addListener(new Back());
		doiMatKhauView.addListener1(new Luu());
		doiMatKhauView.addListener2(new LamLaiMK());
		doiMatKhauView.addListener3(new PwdMatKhauCu());
		doiMatKhauView.addListener4(new PwdMatKhauMoi());
		doiMatKhauView.addListener5(new PwdNhapLaiMKM());
	}
	
	public void showDoiMatKhauView() {
		doiMatKhauView.setModal(true);
		doiMatKhauView.setVisible(true);
	}
	
	class Back implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e){
            int phanquyen=0;
            try
            {
                String sql="select PhanQuyen from taikhoan where User=?";
                PreparedStatement pre=ConnectMySQL.connect.prepareStatement(sql);
                pre.setString(1, tentk);
                ResultSet rs=pre.executeQuery();
                while(rs.next()){
                    phanquyen=rs.getInt(1);
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            if(phanquyen==1){
            	QuanLyAdminView qladv = new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
				QuanLyAdminController qladc = new QuanLyAdminController(qladv);
				qladc.tentk = tentk;
				qladc.showQuanlyAdminView();
				doiMatKhauView.dispose();
            }
            if(phanquyen==2){
            	QuanLyThuThuView qladv = new QuanLyThuThuView("Thủ thư:" + tentk);
				QuanLyThuThuController qladc = new QuanLyThuThuController(qladv);
				qladc.tentk = tentk;
				qladc.showQuanLyThuThuView();;
				doiMatKhauView.dispose();
            }
        }
	}
	class Luu implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			TaiKhoanDao tksv = new TaiKhoanDao();
			ArrayList<TaiKhoan> dstk=new ArrayList<TaiKhoan>();
			dstk= tksv.layTaiKhoan();
			for(TaiKhoan tk: dstk)
			{
				if(doiMatKhauView.gettxtTaiKhoan().getText().equals(tk.getUser()) && doiMatKhauView.gettxtMatKhauCu().getText().equals(tk.getPass()))
				{
					if(doiMatKhauView.gettxtMatKhauMoi().getText().equals(doiMatKhauView.gettxtNhapLaiMKM().getText()))
					{
						try
						{
							String sql="Update taikhoan set password=? where user=?";
							PreparedStatement pre=con.prepareStatement(sql);
							pre.setString(1, doiMatKhauView.getpwdNhapLaiMKM().getText());
							pre.setString(2, doiMatKhauView.gettxtTaiKhoan().getText());
							int x=pre.executeUpdate();
							if(x>0)
							{
								JOptionPane.showMessageDialog(null,"�?ổi mật khẩu thành công");
								doiMatKhauView.getpwdMatKhauCu().setText(null);
								doiMatKhauView.getpwdMatKhauMoi().setText(null);
								doiMatKhauView.getpwdNhapLaiMKM().setText(null);
								return;
							}
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Mật khẩu mới chưa trùng khớp");
						doiMatKhauView.getpwdMatKhauMoi().setText(null);
						doiMatKhauView.getpwdNhapLaiMKM().setText(null);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Mật khẩu cũ chưa đúng. M�?i nhập lại!");
			doiMatKhauView.getpwdMatKhauCu().setText(null);
			doiMatKhauView.getpwdMatKhauMoi().setText(null);
			doiMatKhauView.getpwdNhapLaiMKM().setText(null);
		}
	}
	class LamLaiMK implements ActionListener{
		 public void actionPerformed(ActionEvent e){
			 doiMatKhauView.getpwdMatKhauCu().setText(null);
			 doiMatKhauView.getpwdMatKhauMoi().setText(null);
			 doiMatKhauView.getpwdNhapLaiMKM().setText(null);
         }
	}
	class PwdMatKhauCu implements MouseListener{
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			doiMatKhauView.getpwdMatKhauCu().setEchoChar('*');
			doiMatKhauView.getpwdMatKhauCu().setText(null);
			
		}
	}
	class PwdMatKhauMoi implements MouseListener{
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			doiMatKhauView.getpwdMatKhauMoi().setEchoChar('*');
			doiMatKhauView.getpwdMatKhauMoi().setText(null);
			
		}
	}
	class PwdNhapLaiMKM implements MouseListener{
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			doiMatKhauView.getpwdNhapLaiMKM().setEchoChar('*');
			doiMatKhauView.getpwdNhapLaiMKM().setText(null);
			
		}
	}
}
