package com.company.Module;

import java.util.ArrayList;

public class State {
    final private Dot pawn1, pawn2;
    ArrayList<State> neighbours = new ArrayList<>();
    public State(Dot pawn1,Dot pawn2){
        this.pawn1 = pawn1;
        this.pawn2 = pawn2;
    }

    public Dot getPawn1() {
        return pawn1;
    }
    public int getPawn1Num() {
        return pawn1.getSerialNum();
    }
    public Dot getPawn2() {
        return pawn2;
    }
    public int getPawn2Num() {
        return pawn2.getSerialNum();
    }



    /**
     * Get the neighbors of the state.
     * @param state state (pawn1 location , pawn2 location).
     * @return arraylist (neighbors of the state).
     */
    public ArrayList<State> getNeighbours(State state) {
        /**
         * s1 gets the first pawn's neighbor.
         *If the first pawn has neighbors, add the status to neighbors.
         */
        ArrayList<Dot> s1 = state.getPawn1().getAvailableDots(state.getPawn2().getColor());
            for (Dot e: s1) {
                State state1 = new State(e,state.pawn2);
                neighbours.add(state1);
            }
            s1.clear();
        /**
         * s2 gets the second pawn's neighbor.
         *If the second pawn has neighbors, add the status to neighbors.
         */
        ArrayList<Dot> s2 = state.getPawn2().getAvailableDots(state.getPawn1().getColor());
            for (Dot e: s2) {
                State state2 = new State(state.pawn1,e);
                neighbours.add(state2);
            }
            s2.clear();

        return  neighbours;
    }

    @Override
    public String toString() {
        return "( "+pawn1.getSerialNum()+" , "+pawn2.getSerialNum()+" )\n";
    }
}
