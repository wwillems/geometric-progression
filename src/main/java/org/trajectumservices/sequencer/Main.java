package org.trajectumservices.sequencer;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SequencesHelper sequencesHelper = new SequencesHelper();

        List<Integer> inputList = Arrays.asList(
                2, 10, 4, 3, 8, 6, 9, 9, 18, 27, 1, 52, 81, 10, 1, 0, 2, 0, 4, 0, 8, 0, 16,
                0, 32, 0, 64, 0, 128, 2, 10, 4, 3, 8, 6, 9, 9, 1, 8, 27, 1, 52, 81, 10, 100,
                50, 0, 0, 0, 0, 0, 0);

        List<List<Integer>> listOfSequences = sequencesHelper.findSequences(inputList);
        for (List<Integer> sequence : listOfSequences) {
            System.out.println(sequence);
        }

    }

}
