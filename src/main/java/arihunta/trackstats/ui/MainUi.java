package arihunta.trackstats.ui;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import arihunta.trackstats.Controller;
import arihunta.trackstats.model.Track;

/**
 *
 * @author arihu
 */
public class MainUi extends javax.swing.JFrame {

	private final Controller oController = new Controller();
	private final DefaultListModel<Track> mdl = new DefaultListModel<>();

	/**
	 * Creates new form MainUi
	 */
	public MainUi() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        pnlSide = new javax.swing.JPanel();
        scrlTracks = new javax.swing.JScrollPane();
        lstTracks = new javax.swing.JList<>();
        javax.swing.JPanel pnlTracks = new javax.swing.JPanel();
        lblSpace = new javax.swing.JLabel();
        btnStrava = new javax.swing.JButton();
        btnGarmin = new javax.swing.JButton();
        btnGpx = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        btnFlyBy = new javax.swing.JButton();

        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("GPX file", "gpx"));
        fileChooser.setMultiSelectionEnabled(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("arihunta/trackstats/ui/Bundle"); // NOI18N
        setTitle(bundle.getString("MainUi.title")); // NOI18N

        pnlSide.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("MainUi.pnlSide.border.title"))); // NOI18N
        pnlSide.setLayout(new java.awt.BorderLayout());

        lstTracks.setModel(mdl);
        scrlTracks.setViewportView(lstTracks);

        pnlSide.add(scrlTracks, java.awt.BorderLayout.CENTER);

        pnlTracks.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlTracks.add(lblSpace, gridBagConstraints);

        btnStrava.setText(bundle.getString("MainUi.btnStrava.text")); // NOI18N
        btnStrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStravaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlTracks.add(btnStrava, gridBagConstraints);

        btnGarmin.setText(bundle.getString("MainUi.btnGarmin.text")); // NOI18N
        btnGarmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGarminActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlTracks.add(btnGarmin, gridBagConstraints);

        btnGpx.setText(bundle.getString("MainUi.btnGpx.text")); // NOI18N
        btnGpx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGpxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlTracks.add(btnGpx, gridBagConstraints);

        pnlSide.add(pnlTracks, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlSide, java.awt.BorderLayout.WEST);

        pnlCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("MainUi.pnlCenter.border.title"))); // NOI18N
        pnlCenter.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnFlyBy.setText(bundle.getString("MainUi.btnFlyBy.text")); // NOI18N
        btnFlyBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlyByActionPerformed(evt);
            }
        });
        pnlBottom.add(btnFlyBy);

        getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnStravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStravaActionPerformed
	}//GEN-LAST:event_btnStravaActionPerformed

	private void btnGarminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGarminActionPerformed
	}//GEN-LAST:event_btnGarminActionPerformed

	private void btnGpxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGpxActionPerformed
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			for (File file : fileChooser.getSelectedFiles()) {
				oController.loadGpxFile(file.toPath());
			}
			mdl.clear();
			oController.getLoadedTracks().stream().forEach(trk -> mdl.addElement(trk));
		}
	}//GEN-LAST:event_btnGpxActionPerformed

	private void btnFlyByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlyByActionPerformed
		if (lstTracks.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "");
		}
		else {
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				oController.createFlyBy(lstTracks.getSelectedValuesList(), fileChooser.getSelectedFile().toPath());
			}
		}
	}//GEN-LAST:event_btnFlyByActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFlyBy;
    private javax.swing.JButton btnGarmin;
    private javax.swing.JButton btnGpx;
    private javax.swing.JButton btnStrava;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel lblSpace;
    private javax.swing.JList<Track> lstTracks;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JScrollPane scrlTracks;
    // End of variables declaration//GEN-END:variables

}