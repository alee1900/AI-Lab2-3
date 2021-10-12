import Exceptions.InvalidTransition;

public class Main {
    public static void main(String[] args) throws InvalidTransition {
        State state1 = new State();
        state1 = state1.initializeState(3);

        System.out.println(state1);

        State state2 = new State();
        state2 = state2.finalState(3);
        System.out.println(state2);
        System.out.println(state2.testIfFinalState(state2));

        Transition transition = new Transition();
        transition.doTransition(state1, new int[]{0, 1}, new String[]{"female", "male"});
    }
}
