//package encapsulation;
//
//import encapsulation.api.Buttons;
//import encapsulation.api.Circuit;
//import encapsulation.service.SingnalSender;
//
//import java.util.List;
//
//public class Remote implements IRemote {
//    private List<Buttons> buttons;
//    private Circuit circuit;
//    private SingnalSender signalSender;
//
//    @Override
//    public int volumeUp() {
//        getPower();
//        int vol = circuit.trigger();
//        signalSender.sendSignal();
//        return vol;
//    }
//
//    @Override
//    public int volumeDown() {
//        return 0;
//    }
//
//    @Override
//    public boolean powerOff() {
//        return false;
//    }
//
//    @Override
//    public int changeChannelUp() {
//        return 0;
//    }
//
//    @Override
//    public int changeChannelDown() {
//        return 0;
//    }
//
//    public List<Buttons> getButtons() {
//        return buttons;
//    }
//    private void getPower() {
//        //Getting power
//        System.out.println("Getting power");
//    }
//}
