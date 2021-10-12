import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//0 - stanga, 1 - dreapta

public class State {
    private List<ArrayList<Integer>>
            pairs = new ArrayList<ArrayList<Integer>>();
    private int boat;

    public State() {

    }

    public State(int boat, List<ArrayList<Integer>> pairs) {
        this.pairs = pairs;
        this.boat = boat;
    }

    public State initializeState(int n) {
        List<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
        int boat = 0;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> pair = new ArrayList<Integer>();
            pair.add(0, 0);
            pair.add(1, 0);
            pairs.add(i, pair);
        }

        State initialState = new State();
        initialState.setBoat(boat);
        initialState.setPairs(pairs);
        return initialState;
    }

    public State finalState(int n) {
        List<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
        int boat = 1;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> pair = new ArrayList<Integer>();
            pair.add(0, 1);
            pair.add(1, 1);
            pairs.add(i, pair);
        }

        State finalState = new State();
        finalState.setBoat(boat);
        finalState.setPairs(pairs);
        return finalState;
    }

    public boolean testIfFinalState(State state) {
        if (state.equals(finalState(state.getPairs().size()))) {
            return true;
        }
        return false;
    }

    public List<ArrayList<Integer>> getPairs() {
        return pairs;
    }

    public int getBoat() {
        return boat;
    }

    public void setPairs(List<ArrayList<Integer>> pairs) {
        this.pairs = pairs;
    }

    public void setBoat(int boat) {
        this.boat = boat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return boat == state.boat && Objects.equals(pairs, state.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairs, boat);
    }

    @Override
    public String toString() {
        return "{" + boat + ", " + pairs + "}";
    }
}
