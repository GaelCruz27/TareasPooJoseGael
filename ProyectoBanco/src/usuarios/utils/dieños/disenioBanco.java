package usuarios.utils.dieños;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class disenioBanco {

    public static void drawBancoPony(Graphics2D g2d) {
        // Edificio del banco
        g2d.setColor(Color.WHITE);
        g2d.fill(new Rectangle2D.Double(50, 50, 300, 200));

        // Columnas
        g2d.fill(new Rectangle2D.Double(100, 75, 30, 150));
        g2d.fill(new Rectangle2D.Double(270, 75, 30, 150));

        // Techo
        GeneralPath roof = new GeneralPath();
        roof.moveTo(50, 50);
        roof.lineTo(350, 50);
        roof.lineTo(400, 100);
        roof.lineTo(0, 100);
        roof.closePath();
        g2d.fill(roof);

        // Logotipo del "Banco Pony"
        g2d.setColor(Color.BLACK);
        g2d.fill(new Ellipse2D.Double(175, 25, 50, 50));
        g2d.drawString("Banco", 185, 55);
        g2d.drawString("Pony", 190, 75);
    }
}
