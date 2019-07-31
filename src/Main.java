import main.org.cegedim.test.echequier.presenter.CoupsPresenter;
import main.org.cegedim.test.echequier.presenter.CoupsPresenterImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CoupsPresenter coupsPresenter = new CoupsPresenterImpl();
        List<String> list = coupsPresenter.buildListCoups();
        for (String coup: list) {
            System.out.println(coup);
        }
    }
}
