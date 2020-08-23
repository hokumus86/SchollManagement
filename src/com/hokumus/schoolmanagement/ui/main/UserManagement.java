package com.hokumus.schoolmanagement.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.dao.util.MyHibernateUtil;
import com.hokumus.schoolmanagement.model.user.Users;

public class UserManagement extends JFrame {

	private JScrollPane scrollUser;
	private JTable tblUser;
	private JMenuBar menuBar;
	private JMenu mnfile;
	private JMenuItem mnFileAddUser;
	private JButton btnGetUser;
	private JMenuItem mnýtmNewMenuItem_1;
	private JButton btnUserDelete;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtSurname;
	private JButton btnUpdate;

	public UserManagement() {
		initialize();
		tabloDoldur();
	}

	private void initialize() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ana Ekran");
		setSize(532, 500);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollUser());
		getContentPane().add(getMenuBar_1());
		getContentPane().add(getBtnGetUser());
		getContentPane().add(getBtnUserDelete());
		getContentPane().add(getTxtUserName());
		getContentPane().add(getTxtPassword());
		getContentPane().add(getTxtName());
		getContentPane().add(getTxtSurname());
		getContentPane().add(getBtnUpdate());
	}

	private JScrollPane getScrollUser() {
		if (scrollUser == null) {
			scrollUser = new JScrollPane();
			scrollUser.setBounds(50, 106, 286, 231);
			scrollUser.setViewportView(getTblUser());
		}
		return scrollUser;
	}

	private JTable getTblUser() {
		if (tblUser == null) {
			tblUser = new JTable();
			tblUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String id = (String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 0);
					txtUserName.setText((String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 1));
					txtPassword.setText((String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 2));
					txtName.setText((String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 3));
					txtSurname.setText((String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 4));
				}
			});
		}
		return tblUser;
	}

	private void tabloDoldur() {
		UserDao dao = new UserDao();
		List<Users> liste = dao.getir(new Users());
		String[] columnNames = { "id", "Kullanýcý Adý", "Þifre", "Adý", "Soyadý" };
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = "" + liste.get(i).getId();
			data[i][1] = liste.get(i).getUsername();
			data[i][2] = liste.get(i).getPassword();
			data[i][3] = liste.get(i).getName();
			data[i][4] = liste.get(i).getSurname();

		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tblUser.setModel(model);

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 442, 21);
			menuBar.add(getMnfile());
		}
		return menuBar;
	}

	private JMenu getMnfile() {
		if (mnfile == null) {
			mnfile = new JMenu("File");
			mnfile.add(getMnFileAddUser());
			mnfile.add(getMnýtmNewMenuItem_1());
		}
		return mnfile;
	}

	private JMenuItem getMnFileAddUser() {
		if (mnFileAddUser == null) {
			mnFileAddUser = new JMenuItem("Kullan\u0131c\u0131 Ekle");
			mnFileAddUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					new AddUser().setVisible(true);
				}
			});
		}
		return mnFileAddUser;
	}

	private JButton getBtnGetUser() {
		if (btnGetUser == null) {
			btnGetUser = new JButton("Kullan\u0131c\u0131lar\u0131 Getir");
			btnGetUser.setBounds(50, 348, 286, 23);
			btnGetUser.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tabloDoldur();

				}
			});
		}
		return btnGetUser;
	}

	private JMenuItem getMnýtmNewMenuItem_1() {
		if (mnýtmNewMenuItem_1 == null) {
			mnýtmNewMenuItem_1 = new JMenuItem("Bilmiyorum");
		}
		return mnýtmNewMenuItem_1;
	}

	private JButton getBtnUserDelete() {
		if (btnUserDelete == null) {
			btnUserDelete = new JButton("Kullan\u0131c Sil");
			btnUserDelete.setBounds(50, 375, 286, 23);
			btnUserDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (tblUser.getSelectedRow() < 0) {
						return;
					}
					String id = (String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 0);
					
					Users temp = new Users();
					temp.setId(Long.parseLong(id));
					UserDao dao = new UserDao();
					dao.sil(temp);
					
					tabloDoldur();

				}
			});
		}
		return btnUserDelete;
	}

	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setBounds(346, 107, 86, 20);
			txtUserName.setColumns(10);
		}
		return txtUserName;
	}

	private JTextField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JTextField();
			txtPassword.setBounds(346, 138, 86, 20);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(346, 177, 86, 20);
			txtName.setColumns(10);
		}
		return txtName;
	}

	private JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setBounds(346, 225, 86, 20);
			txtSurname.setColumns(10);
		}
		return txtSurname;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("G\u00FCncelle");
			btnUpdate.setBounds(346, 280, 91, 23);
			btnUpdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					UserDao dao = new UserDao();
					String id = (String) tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 0);
					Users temp = new Users();
					temp.setId(Long.parseLong(id));
					temp.setUsername(txtUserName.getText());
					temp.setPassword(txtPassword.getText());
					temp.setName(txtName.getText());
					temp.setSurname(txtSurname.getText());
					dao.guncelle(temp);
					tabloDoldur();
				}
			});
		}
		return btnUpdate;
	}
}
