package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField lu_TextField;
	private JTextField apellido_TextField;
	private JTextField nombre_TextField;
	private JTextField email_TextField;
	private JTextField gh_TextField;
	private JLabel horario_Label;
	private JLabel foto_Label;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 284));
		setResizable(false);
		setContentPane(contentPane);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tdp.png")));
		init(studentData);
	}
	
	private void init(Student stu) {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel lu_Label = new JLabel("LU");
		
		JLabel apellido_Label = new JLabel("Apellido");
		
		JLabel nombre_Label = new JLabel("Nombre");
		
		JLabel email_Label = new JLabel("Email");
		
		JLabel gh_Label = new JLabel("Github URL");
		
		lu_TextField = new JTextField();
		lu_TextField.setEditable(false);
		lu_TextField.setText(Integer.toString(stu.getId()));
		lu_TextField.setColumns(10);
		
		apellido_TextField = new JTextField();
		apellido_TextField.setEditable(false);
		apellido_TextField.setText(stu.getLastName());
		apellido_TextField.setColumns(10);
		
		nombre_TextField = new JTextField();
		nombre_TextField.setEditable(false);
		nombre_TextField.setText(stu.getFirstName());
		nombre_TextField.setColumns(10);
		
		email_TextField = new JTextField();
		email_TextField.setEditable(false);
		email_TextField.setText(stu.getMail());
		email_TextField.setColumns(10);
		
		gh_TextField = new JTextField();
		gh_TextField.setEditable(false);
		gh_TextField.setText(stu.getGithubURL());
		gh_TextField.setColumns(10);
		
		horario_Label = new JLabel("Esta ventana fue generada el:");
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(gh_Label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(gh_TextField, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
								.addComponent(nombre_Label)
								.addComponent(email_Label)
								.addComponent(apellido_Label)
								.addComponent(lu_Label))
							.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lu_TextField)
								.addComponent(apellido_TextField)
								.addComponent(nombre_TextField)
								.addComponent(email_TextField, 351, 351, Short.MAX_VALUE)))
						.addComponent(horario_Label))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lu_Label)
						.addComponent(lu_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(apellido_Label)
						.addComponent(apellido_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(nombre_Label)
						.addComponent(nombre_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(email_Label)
						.addComponent(email_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(gh_Label)
						.addComponent(gh_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(horario_Label)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		
		foto_Label = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(foto_Label, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(foto_Label, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		foto_Label.setPreferredSize(new Dimension(50, 5));
		ImageIcon img = new ImageIcon(this.getClass().getResource(stu.getPathPhoto()));
		foto_Label.setIcon(img);
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime actual = LocalDateTime.now();
		horario_Label.setText("Esta ventana fue generada el: " + formato.format(actual));
	}
}
