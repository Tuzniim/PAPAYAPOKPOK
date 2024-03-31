import javax.swing.*;
import java.awt.*;

public class LOGO extends JFrame {

    public LOGO() {
        // ตั้งค่า JFrame
        setTitle("PAPAYAPOKPOK");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // กำหนด icon ให้กับ JFrame
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:/Project/PAPAYAPOKPOK/LOGO/LOGO_PAPAYAPOKPOK.png"));

        // สามารถเพิ่ม components อื่นๆ ลงใน JFrame ได้ที่นี่

        // แสดง JFrame
        setVisible(true);
    }


}





