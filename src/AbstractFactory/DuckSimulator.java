package AbstractFactory;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckCountingFactory = new CountingDuckFactory();
        AbstractDuckFactory duckEchoFactory = new EchoDuckFactory();
        System.out.println("----------- Factory ----------");
        simulator.simulate(duckFactory);
        System.out.println("---------- Counting ----------");
        simulator.simulate(duckCountingFactory);
        System.out.println("------------ Echo ------------");
        simulator.simulate(duckEchoFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator: With Factory");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);


        // 4 times for CountingDuckFactory
        // 8 times for EchoDuckFactory [12 - 4(CountingDuckFactory)]
        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times.");

    }

    void simulate(Quackable duck){
        duck.quack();
    }

}
