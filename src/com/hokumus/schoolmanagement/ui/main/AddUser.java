package com.hokumus.schoolmanagement.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.model.user.Users;

public class AddUser extends JFrame{
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtSurname;
	private JButton btnCancel;
	private JButton btnSave;
	
	public AddUser() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Kullanýcý Ekle");
		setSize(450, 305);
		getContentPane().setLayout(null);
		getContentPane().add(getTxtUserName());
		getContentPane().add(getTxtPassword());
		getContentPane().add(getTxtName());
		getContentPane().add(getTxtSurname());
		getContentPane().add(getBtnCancel());
		getContentPane().add(getBtnSave());
	}
	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setBounds(61, 44, 86, 20);
			txtUserName.setColumns(10);
		}
		return txtUserName;
	}
	private JTextField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JTextField();
			txtPassword.setBounds(237, 44, 86, 20);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(61, 112, 86, 20);
			txtName.setColumns(10);
		}
		return txtName;
	}
	private JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setBounds(237, 112, 86, 20);
			txtSurname.setColumns(10);
		}
		return txtSurname;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("\u0130ptal");
			btnCancel.setBounds(61, 201, 91, 23);
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddUser.this.dispose();
					
				}
			});
		}
		return btnCancel;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Kaydet");
			btnSave.setBounds(237, 201, 91, 23);
			btnSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					UserDao dao = new UserDao();
					Users temp = new Users();
					temp.setUsername(txtUserName.getText());
					temp.setPassword(txtPassword.getText());
					temp.setSurname(txtName.getText());
					temp.setName(txtSurname.getText());
					dao.kaydet(temp);
					
				}
			});
		}
		return btnSave;
	}
}
