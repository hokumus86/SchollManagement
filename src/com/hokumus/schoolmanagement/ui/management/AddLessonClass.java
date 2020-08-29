package com.hokumus.schoolmanagement.ui.management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hokumus.schoolmanagement.dao.management.LessonClassDao;
import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.model.management.LessonClass;
import com.hokumus.schoolmanagement.model.user.Users;
import com.hokumus.schoolmanagement.utils.Util;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddLessonClass extends JFrame{
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtClassName;
	private JLabel lblSnfKodu;
	private JTextField txtClassCode;
	private JLabel lblKapasite;
	private JTextField txtCapasity;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JScrollPane scrollLessons;
	private JTable tblLessonClass;
	
	public AddLessonClass() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Sýnýf Ekleme Ekraný ");
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getScrollLessons());
		setSize(600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		tabloDoldur();
		
		
	}
	
	private void tabloDoldur() {
		LessonClassDao dao = new LessonClassDao();
		List<LessonClass> liste = dao.getir(new LessonClass());
		String[] columnNames = { "id", "Sýnýf Adý", "Sýnýf Kodu", "Kapasite"};
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = "" + liste.get(i).getId();
			data[i][1] = liste.get(i).getName();
			data[i][2] = liste.get(i).getCode();
			data[i][3] = ""+liste.get(i).getCapasity();
			

		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tblLessonClass.setModel(model);
	}


	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(10, 11, 417, 174);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTxtClassName());
			panel.add(getLblSnfKodu());
			panel.add(getTxtClassCode());
			panel.add(getLblKapasite());
			panel.add(getTxtCapasity());
			panel.add(getBtnAdd());
			panel.add(getBtnUpdate());
			panel.add(getBtnDelete());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("S\u0131n\u0131f Ad\u0131");
			lblNewLabel.setBounds(34, 26, 90, 14);
		}
		return lblNewLabel;
	}
	private JTextField getTxtClassName() {
		if (txtClassName == null) {
			txtClassName = new JTextField();
			txtClassName.setBounds(134, 23, 128, 20);
			txtClassName.setColumns(10);
		}
		return txtClassName;
	}
	private JLabel getLblSnfKodu() {
		if (lblSnfKodu == null) {
			lblSnfKodu = new JLabel("S\u0131n\u0131f Kodu");
			lblSnfKodu.setBounds(34, 83, 90, 14);
		}
		return lblSnfKodu;
	}
	private JTextField getTxtClassCode() {
		if (txtClassCode == null) {
			txtClassCode = new JTextField();
			txtClassCode.setColumns(10);
			txtClassCode.setBounds(134, 80, 128, 20);
		}
		return txtClassCode;
	}
	private JLabel getLblKapasite() {
		if (lblKapasite == null) {
			lblKapasite = new JLabel("Kapasite");
			lblKapasite.setBounds(34, 128, 90, 14);
		}
		return lblKapasite;
	}
	private JTextField getTxtCapasity() {
		if (txtCapasity == null) {
			txtCapasity = new JTextField();
			txtCapasity.setColumns(10);
			txtCapasity.setBounds(134, 125, 128, 20);
		}
		return txtCapasity;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Ekle");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LessonClassDao dao = new LessonClassDao();
					LessonClass temp = new LessonClass();
					temp.setName(txtClassName.getText());
					temp.setCode(txtClassCode.getText());
					temp.setCapasity(Integer.parseInt(txtCapasity.getText()));
					temp.setCreatedBy(Util.loginedUser.getUsername());
					temp.setCreatedDate(new Date());
					dao.kaydet(temp);
					tabloDoldur();
				}
			});
			btnAdd.setBounds(298, 23, 91, 23);
		}
		return btnAdd;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("G\u00FCncelle");
			btnUpdate.setBounds(298, 77, 91, 23);
			btnUpdate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					LessonClassDao dao = new LessonClassDao();
					LessonClass temp = new LessonClass();
					Long id = Long.parseLong(tblLessonClass.getModel().getValueAt(tblLessonClass.getSelectedRow(),0).toString());
					temp.setId(id);
					temp.setName(txtClassName.getText());
					temp.setCode(txtClassCode.getText());
					temp.setCapasity(Integer.parseInt(txtCapasity.getText()));
					temp.setUpdatedBy(Util.loginedUser.getUsername());
					temp.setUpdatedDate(new Date());
					dao.guncelle(temp);
					tabloDoldur();
				}
			});
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Sil");
			btnDelete.setBounds(298, 122, 91, 23);
			btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					LessonClassDao dao = new LessonClassDao();
					LessonClass temp = new LessonClass();
					Long id = Long.parseLong(tblLessonClass.getModel().getValueAt(tblLessonClass.getSelectedRow(),0).toString());
					temp.setId(id);
					dao.sil(temp);
					tabloDoldur();
				}
			});
		}
		return btnDelete;
	}
	private JScrollPane getScrollLessons() {
		if (scrollLessons == null) {
			scrollLessons = new JScrollPane();
			scrollLessons.setBounds(10, 214, 417, 245);
			scrollLessons.setViewportView(getTblLessonClass());
		}
		return scrollLessons;
	}
	private JTable getTblLessonClass() {
		if (tblLessonClass == null) {
			tblLessonClass = new JTable();
			tblLessonClass.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String id = (String) tblLessonClass.getModel().getValueAt(tblLessonClass.getSelectedRow(), 0);
					txtClassName.setText((String) tblLessonClass.getModel().getValueAt(tblLessonClass.getSelectedRow(), 1));
					txtClassCode.setText((String) tblLessonClass.getModel().getValueAt(tblLessonClass.getSelectedRow(), 2));
					txtCapasity.setText((String) tblLessonClass.getModel().getValueAt(tblLessonClass.getSelectedRow(), 3));
					
				}
			});
		}
		return tblLessonClass;
	}
}
