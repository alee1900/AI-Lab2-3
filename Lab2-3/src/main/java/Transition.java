import Exceptions.InvalidTransition;

public class Transition {
    public Transition() {
    }

    public State doTransition(State state, int[] index, String[] maleOrFemale) throws InvalidTransition {
        if (validateTransition(state, index, maleOrFemale) == true) {
            int[] personSex = new int[2]; // 0 - male, 1 - female
            for (int i = 0; i < maleOrFemale.length; i++) {
                if (maleOrFemale[i].equals("male")) {
                    personSex[i] = 0;
                } else {
                    if (maleOrFemale[i].equals("female")) {
                        personSex[i] = 1;
                    }
                }
            }
            for (int i = 0; i < index.length; i++) {
                state.getPairs().get(index[i]).set(personSex[i], (state.getPairs().get(index[i]).get(personSex[i]) + 1) % 2);
            }
            printTransition(state);
        }
        return state;
    }

    public boolean validateTransition(State state, int[] index, String[] maleOrFemale) throws InvalidTransition {
        if (index.length > 2 || maleOrFemale.length > 2) {
            throw new InvalidTransition("Too many people in the boat!");
        }
        return true;
    }

    public void printTransition(State state) {
        System.out.println(state);
    }
}
