
import java.awt.Color;

public class JButtonDesignReturnHome extends JButtonDesign {

    private static final long serialVersionUID = 1L;

    public JButtonDesignReturnHome(String text) {
        super(text);
        this.setBorder(new RoundBtn(10)); // 10 is the radius
        this.setBackground(new Color(242, 238, 245));
    }

}
