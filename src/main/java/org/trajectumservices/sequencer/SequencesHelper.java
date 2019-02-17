package org.trajectumservices.sequencer;

import org.javatuples.Pair;
import java.util.*;

public class SequencesHelper {

    List<List<Integer>> findSequences(List<Integer> input) {

        Hashtable<Pair<Integer, Integer>, Integer> listOfEntries = createListOfEntries(input);

        LinkedHashMap<Integer, Pair<Integer, Integer>> result = createResult(listOfEntries);

        List<List<Integer>> sequences = convert(input, result);

        return sequences;
    }

    private Hashtable<Pair<Integer, Integer>, Integer> createListOfEntries(List<Integer> input) {
        Hashtable<Pair<Integer, Integer>, Integer> mp = new Hashtable<>();

        Integer listLength = input.size();
        for (int index = 2; index < listLength; index++) {
            int max = Math.min(index, ((input.size()-1)/2) + 1);
            for (int n = 2; n <= max; n++) {
                if (input.get(index) == 0) break;

                int previousIndex = index-n;
                if ((previousIndex >= 0) && (input.get(previousIndex) * n == input.get(index))) {
                    Pair<Integer, Integer> t = Pair.with(index, n);

                    int length = 1;
                    Pair<Integer, Integer> previousPair = new Pair(index-n, n);
                    if (mp.containsKey(previousPair)) {
                        length = mp.get(previousPair);
                        mp.remove(previousPair);
                    }
                    mp.put(t, length + 1);
                }
            }
        }
        return mp;
    }

    private LinkedHashMap<Integer, Pair<Integer, Integer>> createResult(Hashtable<Pair<Integer, Integer>, Integer> mp) {
        LinkedHashMap<Integer, Pair<Integer, Integer>> result = new LinkedHashMap<>();

        mp.keySet().forEach(key -> {
            int n = key.getValue1();
            int length = mp.get(key);
            int endingIndex = key.getValue0();

            if (result.containsKey(n)) {
                if (result.get(n).getValue0() < length) {
                    result.replace(n, new Pair(length, endingIndex));
                }
            } else {
                result.put(n, new Pair(length, endingIndex));
            }
        });

        return result;
    }

    private List<List<Integer>> convert(List<Integer> input, LinkedHashMap<Integer, Pair<Integer, Integer>> result) {
        List<List<Integer>> sequences = new ArrayList<>();

        result.keySet().forEach(n -> {
            List<Integer> sequence = new ArrayList<>();

            Pair<Integer, Integer> pair = result.get(n);
            int length = pair.getValue0();
            int endingIndex = pair.getValue1();
            for (int i = endingIndex - (length-1) * n; i <= endingIndex; i += n) {
                int value = input.get(i);
                sequence.add(value);
            }
            if (sequence.size() > 2) {
                sequences.add(sequence);
            }
        });

        return sequences;
    }

}
