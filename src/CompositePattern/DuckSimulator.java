package CompositePattern;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckCountingFactory = new CountingDuckFactory();
        AbstractDuckFactory duckEchoFactory = new EchoDuckFactory();
//        System.out.println("----------- Factory ----------");
//        simulator.simulate(duckFactory);
//        System.out.println("---------- Counting ----------");
//        simulator.simulate(duckCountingFactory);
//        System.out.println("------------ Echo ------------");
//        simulator.simulate(duckEchoFactory);
        simulator.simulate(duckCountingFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

//        System.out.println("\nDuck Simulator: With Composite");

        Flock flockOfDuck = new Flock();
        flockOfDuck.add(redheadDuck);
        flockOfDuck.add(duckCall);
        flockOfDuck.add(rubberDuck);
        flockOfDuck.add(gooseDuck);
        flockOfDuck.add(pigeonDuck);

//        Flock flockOfMallards = new Flock();

//        flockOfMallards.add(new MallardDuck());
//        flockOfMallards.add(new MallardDuck());
//        flockOfMallards.add(new MallardDuck());
//        flockOfMallards.add(new MallardDuck());

//        flockOfDuck.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDuck);

//        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
//        simulate(flockOfMallards);

//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);
//        simulate(pigeonDuck);

        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times.");

    }

    void simulate(Quackable duck){
        duck.quack();
    }

}
