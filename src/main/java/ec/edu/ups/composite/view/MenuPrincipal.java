package ec.edu.ups.composite.view;

import javax.swing.JOptionPane;

import ec.edu.ups.composite.controller.CarpetaArchivoController;

/**
 *
 * @author Grupo 3
 */
public class MenuPrincipal extends javax.swing.JFrame {

	CarpetaArchivoController carpetaArchivoController;
	String pathCarpeta = "";
	String pathArchivo = "";

	public MenuPrincipal() {
		initComponents();
		carpetaArchivoController = new CarpetaArchivoController();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		cmb_tipo_archivo = new javax.swing.JComboBox<>();
		txt_nombre_archivo = new javax.swing.JTextField();
		lblNombreArchivo = new javax.swing.JLabel();
		btn_agregar_archivo = new javax.swing.JButton();
		lblTipoArchivo = new javax.swing.JLabel();
		btn_eliminar_archivo = new javax.swing.JButton();
		bnt_salir = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		tre_arbolArchivo = new javax.swing.JTree();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		cmb_tipo_archivo
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF", "XLSX", "DOCX", "Subcarpeta" }));

		lblNombreArchivo.setText("Nombre Archivo / Carpeta");

		btn_agregar_archivo.setText("Agregar Archivo");
		btn_agregar_archivo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_agregar_archivoActionPerformed(evt);
			}
		});

		lblTipoArchivo.setText("Tipo Archivo");

		btn_eliminar_archivo.setText("Eliminar Archivo");
		btn_eliminar_archivo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_eliminar_archivoActionPerformed(evt);
			}
		});

		bnt_salir.setText("Salir");
		bnt_salir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bnt_salirActionPerformed(evt);
			}
		});

		javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
		tre_arbolArchivo.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
		tre_arbolArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tre_arbolArchivoMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tre_arbolArchivo);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblTipoArchivo)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cmb_tipo_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addComponent(
										jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(6, 6, 6)
												.addComponent(btn_agregar_archivo)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btn_eliminar_archivo)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(bnt_salir))
										.addGroup(layout.createSequentialGroup().addComponent(lblNombreArchivo)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txt_nombre_archivo,
														javax.swing.GroupLayout.PREFERRED_SIZE, 295,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cmb_tipo_archivo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipoArchivo))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_nombre_archivo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_agregar_archivo).addComponent(btn_eliminar_archivo)
								.addComponent(bnt_salir))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20)));

		pack();
	}

	private void btn_eliminar_archivoActionPerformed(java.awt.event.ActionEvent evt) {
		if (pathArchivo.equals("")) {
			carpetaArchivoController.eliminarCarpeta(pathCarpeta);

		} else {
			carpetaArchivoController.eliminarArchivo(pathCarpeta, pathArchivo);
		}

		this.tre_arbolArchivo.setModel(carpetaArchivoController.mostrar());

	}

	private void bnt_salirActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void btn_agregar_archivoActionPerformed(java.awt.event.ActionEvent evt) {
		if (txt_nombre_archivo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un nombre al Archivo");
			txt_nombre_archivo.requestFocus();
			return;
		}
		carpetaArchivoController.agregarArchivo(pathCarpeta + txt_nombre_archivo.getText(),
				cmb_tipo_archivo.getSelectedItem().toString());
		this.tre_arbolArchivo.setModel(carpetaArchivoController.mostrar());
		txt_nombre_archivo.setText("");
	}

	private void tre_arbolArchivoMouseClicked(java.awt.event.MouseEvent evt) {
		if (tre_arbolArchivo.getSelectionModel().getSelectionPath() == null) {
			return;
		}

		System.out.println(tre_arbolArchivo.getSelectionModel().getSelectionPath().toString());
		String valor[] = tre_arbolArchivo.getSelectionModel().getSelectionPath().toString().split(",");
		pathCarpeta = "";
		pathArchivo = "";
		if (valor.length > 1) {
			for (int i = 1; i < valor.length; i++) {
				System.out.println("Hijos " + valor[i]);
				if (!valor[i].contains(".")) {
					pathCarpeta += (valor[i].split("-")[0]).trim() + "/";

					System.out.println("Path Carpeta " + pathCarpeta);
				} else {
					pathArchivo = (valor[i].split("-")[0]).trim();
				}
			}
		}
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MenuPrincipal().setVisible(true);
			}
		});
	}

	private javax.swing.JButton bnt_salir;
	private javax.swing.JButton btn_agregar_archivo;
	private javax.swing.JButton btn_eliminar_archivo;
	private javax.swing.JComboBox<String> cmb_tipo_archivo;
	private javax.swing.JLabel lblNombreArchivo;
	private javax.swing.JLabel lblTipoArchivo;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTree tre_arbolArchivo;
	private javax.swing.JTextField txt_nombre_archivo;
}
