
public class BalController {

    private Bal bal;
    private BalView balView;
    private ValBewegingPaneel valBewegingPaneel;
    private ControlePaneelNoord noordpaneel;

    public BalController(Bal bal, BalView balview, ValBewegingPaneel valBewegingPaneel,
        ControlePaneelNoord noordpaneel) {
        this.bal = bal;
        this.balView = balview;
        this.valBewegingPaneel = valBewegingPaneel;
        this.noordpaneel = noordpaneel;
    }
}
