package gui;

import domain.controller.Controller;
import java.util.Vector;
import javax.swing.JFrame;

public class SystemManagement extends JFrame {
    private Controller _controller;
    private JFrame _parent;
    private int[] _usersId;
    private int[] _moviesId;
    private String[] _usersNames;
    private String[] _moviesNames;
    
    public SystemManagement(Controller controller, JFrame parent) {
        _controller = controller;
        _parent = parent;
        initComponents();
        setUsersModel();
        setMoviesModel();
    }
    @Override
    public void setVisible(boolean b){
        GeneralJFrame.setFrameAtCenter(this);
        super.setVisible(b);
    }    
    public void setMoviesModel(){
        _moviesId = _controller.getMoviesIds();
        _moviesNames = _controller.getMoviesNamesById(_moviesId);
        jComboBoxMovie.setModel(new javax.swing.DefaultComboBoxModel(_moviesNames));
        validate();
    }
    // sets users model with all ids excluding administrator's id
    public void setUsersModel(){
        _usersId = _controller.getUsersIds();
        Vector<Integer> tmp = new Vector<Integer>();
        for (int i = 0; i < _usersId.length; i++) {
            tmp.addElement(new Integer(_usersId[i]));
        }
        // next line removes the administrator from the list of users that he can remove
        tmp.removeElement(new Integer(_controller.getCurrentUser().getId()));
        Object _usersIdAsInteger[] = tmp.toArray();
        _usersId = new int[_usersIdAsInteger.length];
        for (int i = 0; i < _usersId.length; i++) {
            _usersId[i] = ((Integer)_usersIdAsInteger[i]).intValue();
        }
        _usersNames = _controller.getUsersNamesById(_usersId);
        jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel(_usersNames));
        validate();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonDeleteUser = new javax.swing.JButton();
        jComboBoxUser = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButtonDeleteMovie = new javax.swing.JButton();
        jComboBoxMovie = new javax.swing.JComboBox();
        jButtonAddMovie = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(gui.GeneralJFrame.backgroundColor);

        jPanel2.setBackground(GeneralJFrame.backgroundColor);
        jPanel2.setForeground(new java.awt.Color(212, 208, 200));

        jPanel1.setBackground(GeneralJFrame.backgroundColor);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), GeneralJFrame.headersFontColor)); // NOI18N

        jLabel3.setForeground(GeneralJFrame.regularFontColor);
        jLabel3.setText("Delete User");

        jButtonDeleteUser.setText("Delete");
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "item1" }));
        jComboBoxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .add(63, 63, 63)
                .add(jComboBoxUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButtonDeleteUser)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jComboBoxUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonDeleteUser))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(GeneralJFrame.headerColor);
        jLabel1.setText("System Management");

        jPanel3.setBackground(GeneralJFrame.backgroundColor);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movies Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), GeneralJFrame.headersFontColor)); // NOI18N

        jLabel4.setForeground(GeneralJFrame.regularFontColor);
        jLabel4.setText("Delete Movie");

        jButtonDeleteMovie.setText("Delete");
        jButtonDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteMovieActionPerformed(evt);
            }
        });

        jComboBoxMovie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "movie1", "movie2", "movie3" }));

        jButtonAddMovie.setText("Add");
        jButtonAddMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMovieActionPerformed(evt);
            }
        });

        jLabel6.setForeground(GeneralJFrame.regularFontColor);
        jLabel6.setText("Add Movie");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(jLabel6))
                .add(56, 56, 56)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jComboBoxMovie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonDeleteMovie, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                    .add(jButtonAddMovie, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jComboBoxMovie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonDeleteMovie))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jButtonAddMovie))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(jPanel2Layout.createSequentialGroup()
                .add(141, 141, 141)
                .add(jButton5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(247, 247, 247))
            .add(jPanel2Layout.createSequentialGroup()
                .add(78, 78, 78)
                .add(jLabel1)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton5)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 354, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    this.setVisible(false);
    _parent.setVisible(true);
    _parent.setEnabled(true);
}//GEN-LAST:event_jButton5ActionPerformed

private void jComboBoxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserActionPerformed

}//GEN-LAST:event_jComboBoxUserActionPerformed

private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
    int selectItemToDel =  jComboBoxUser.getSelectedIndex();
    _controller.removeUser(_usersId[selectItemToDel]);
    
      _usersId=_controller.getUsersIds();
         _usersNames=_controller.getUsersNamesById(_usersId);
         _moviesNames=_controller.getMoviesNamesById(_moviesId);
        jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel(_usersNames));
        jComboBoxMovie.setModel(new javax.swing.DefaultComboBoxModel(_moviesNames));
        if (jComboBoxUser.getModel().getSize() == 0){
            jButtonDeleteUser.setEnabled(false);
        }
        this.validate();
}//GEN-LAST:event_jButtonDeleteUserActionPerformed

private void jButtonDeleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteMovieActionPerformed
    int selectItemToDel =   jComboBoxMovie.getSelectedIndex();//GEN-LAST:event_jButtonDeleteMovieActionPerformed
    _controller.removeMovie(_moviesId[selectItemToDel]);
    
    _moviesId=_controller.getMoviesIds();
    _moviesNames=_controller.getMoviesNamesById(_moviesId);
    _usersNames=_controller.getUsersNamesById(_usersId);
    jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel(_usersNames));
    jComboBoxMovie.setModel(new javax.swing.DefaultComboBoxModel(_moviesNames));
    
     if (jComboBoxMovie.getModel().getSize() == 0){
            jButtonDeleteMovie.setEnabled(false);
     }
     this.validate();
     ((MainFrame)this._parent).setMostRecommendedMovies();
}                                                  

private void jButtonAddMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMovieActionPerformed
    this.setEnabled(false);
    new AddMovie(_controller, this).setVisible(true);
}//GEN-LAST:event_jButtonAddMovieActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAddMovie;
    private javax.swing.JButton jButtonDeleteMovie;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JComboBox jComboBoxMovie;
    private javax.swing.JComboBox jComboBoxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
   
    
}
