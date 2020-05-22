package encapsulation.model;

import encapsulation.service.SingnalSender;

import java.util.List;

public class Remote {
    private List<Buttons> buttons;
    private Circuit circuit;
    private SingnalSender signalSender;

    public List<Buttons> getButtons() {
        return buttons;
    }

    public void setButtons(List<Buttons> buttons) {
        this.buttons = buttons;
    }
}
