package AbstractFactory;

public class PigeonAdapter implements Quackable {
    Pigeon pegion;

    public PigeonAdapter(Pigeon pegion) {
        this.pegion = pegion;
    }

    @Override
    public void quack() {
        pegion.coo();
        pegion.coo();
    }
}
