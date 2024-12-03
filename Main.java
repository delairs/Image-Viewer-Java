import javax.swing.SwingUtilities; // Tambahkan import SwingUtilities

public class Main {
    public static void main(String[] args) {
        // Menjalankan aplikasi ImageViewer
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageViewer().setVisible(true);
            }
        });
    }
}
