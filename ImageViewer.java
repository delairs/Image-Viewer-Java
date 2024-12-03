import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageViewer extends JFrame {

    private JLabel imageLabel;
    private JButton openButton;

    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Membuat label untuk menampilkan gambar
        imageLabel = new JLabel("No Image", JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(600, 300));

        // Membuat tombol untuk membuka gambar
        openButton = new JButton("Open Image");

        // Aksi saat tombol dibuka diklik
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });

        // Menambahkan komponen ke frame
        add(imageLabel, BorderLayout.CENTER);
        add(openButton, BorderLayout.SOUTH);
    }

    private void openImage() {
        // Membuka dialog untuk memilih file gambar
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Image");

        // Filter hanya file gambar
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));

        int result = fileChooser.showOpenDialog(this);

        // Jika pengguna memilih file
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(selectedFile);
                ImageIcon imageIcon = new ImageIcon(img);
                imageLabel.setIcon(imageIcon);
                imageLabel.setText(""); // Menghapus teks "No Image"
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageViewer().setVisible(true);
            }
        });
    }
}
