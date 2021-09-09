package qltv.SuKien.PhieuTra.TraSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import qltv.dao.ConnectMySQL;


public class TraSachController {
	private TraSachView traSachView;
	JDateChooser choosedate;
	public String MaPM="", MaSach="", NgayHenTra="", TinhTrangSach="", tentk="", MaDG="";
	public TraSachController(TraSachView traSachView) {
		this.traSachView = traSachView;
		traSachView.addListener(new TraSach());
	}
	
	public void showTraSachView() {
		traSachView.setMoDal(true);
		traSachView.setVisible(true);
	}
	
	class TraSach implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			  DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		        String datetra=df.format(choosedate.getDate());
		      
			try
			{
				String sql="Update ctpm set NgayTra=?, TinhTrangTra=?, GhiChu=?,User=? where MaPM=? and MaSach=?";
				PreparedStatement pre=ConnectMySQL.connect.prepareStatement(sql);
				pre.setString(1, datetra);
				pre.setString(2, traSachView.getTxtTTSachTra().getText());
				pre.setString(3, traSachView.getTxtGhiChu().getText());
				pre.setString(4, tentk);
				pre.setString(5, traSachView.getTxtMaPhieu().getText());
				pre.setString(6, traSachView.getTxtMaSach().getText());
				
				int x=pre.executeUpdate();
				if(x>0)
				{
					
				
					// tinh phan tram hư sách
					int muon=Integer.parseInt(traSachView.getTxtTTSachMuon().getText());
					int tra=Integer.parseInt(traSachView.getTxtTTSachTra().getText());
					int hieu=muon-tra;
					
					double SoTien=0;
					int soluong=0;
					if( tra == 0)
					{
						try
						{
							String sqldocgia1="Select MatSach from docgia where MaDG=?";
							PreparedStatement prex=ConnectMySQL.connect.prepareStatement(sqldocgia1);
							prex.setString(1, MaDG);
							ResultSet b=prex.executeQuery();
							while(b.next())
							{
								soluong=b.getInt(1);
							}
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
						try
						{
							String sqlsach="Select GiaTien from sach where MaSach=?";
							PreparedStatement presach=ConnectMySQL.connect.prepareStatement(sqlsach);
							presach.setString(1, traSachView.getTxtMaSach().getText());
							ResultSet rs1=presach.executeQuery();
							while(rs1.next())
							{
								SoTien=rs1.getDouble(1);
							}
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Bạn làm mất sách.Tiền Sách: "+SoTien);
						soluong++;
						try
						{
							String sqldocgia="update docgia set MatSach=? where MaDG=?";
							PreparedStatement pre1=ConnectMySQL.connect.prepareStatement(sqldocgia);
							pre1.setInt(1, soluong);
							pre1.setString(2, MaDG);
							int a=pre1.executeUpdate();
							if(a>0)
							{
								JOptionPane.showMessageDialog(null, "Đã cập nhật số lần mất sách của độc giả");
								traSachView.dispose();
								return;
							}
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					
					
					
					JOptionPane.showMessageDialog(null, "Trả sách thành công");
					
					//cap nhat so luong sach
					int soluongsach=0;
					try
					{
						String sqlss="Select SoLuong from sach where MaSach=?";
						PreparedStatement presach=ConnectMySQL.connect.prepareStatement(sqlss);
						presach.setString(1, MaSach);
						ResultSet rssach=presach.executeQuery();
						while(rssach.next())
						{
							soluongsach=rssach.getInt(1);
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					soluongsach++;
					try
					{
						String sqlss1="update sach set SoLuong=? where MaSach=?";
						PreparedStatement presach1=ConnectMySQL.connect.prepareStatement(sqlss1);
						presach1.setInt(1, soluongsach);
						presach1.setString(2, MaSach);
						int c=presach1.executeUpdate();
						if(c>0)
						{
							JOptionPane.showMessageDialog(null, "Cập nhật số lượng sách thành công");
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					// tru date
					String date1=NgayHenTra;
					String date2=datetra;
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date d1 = null;
					Date d2 = null;
					long diffDays=0;
					try {
						d1 =format.parse(date1);
						d2 =format.parse(date2);
						//in milliseconds
						long diff = d2.getTime() - d1.getTime();					
						diffDays = diff / (24 * 60 * 60 * 1000);
						}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}	
					//
					if( hieu > 0 && diffDays <= 0 )
					{
						JOptionPane.showMessageDialog(null, "Bạn làm hao tổn sách: "+hieu+"%. Bạn bị phạt: "+hieu*1000+" VND");
					}
					if ( hieu > 0 && diffDays > 0)
					{
						JOptionPane.showMessageDialog(null, "Bạn làm hao tổn sách: "+hieu+"%. Và bạn trễ hạn: "+diffDays+" ngày. Bạn bị phạt: "+(hieu*1000+diffDays*10000));
					}
					if(hieu == 0 && diffDays > 0)
					{
						JOptionPane.showMessageDialog(null, "Bạn trễ hạn "+diffDays+" ngày. Bạn bị phạt: "+diffDays*10000);
					}	
					
					traSachView.dispose();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
	}
}
