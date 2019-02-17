package org.trajectumservices.sequencer;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class SequencesHelperTest {

    @Test
    public void testListContainingZeroes() {
        SequencesHelper sequencesHelper = new SequencesHelper();

        List<List<Integer>> actualSequenceList = sequencesHelper.findSequences(
                Arrays.asList(0, 0, 0, 0, 0)
        );

        assertThat(actualSequenceList, IsEmptyCollection.empty());
    }

    @Test
    public void testListContainingShortSequence() {
        SequencesHelper sequencesHelper = new SequencesHelper();

        List<List<Integer>> actualSequenceList = sequencesHelper.findSequences(
                Arrays.asList(2, 1, 4)
        );

        assertThat(actualSequenceList, IsEmptyCollection.empty());
    }

    @Test
    public void testValueOfN() {
        SequencesHelper sequencesHelper = new SequencesHelper();

        List<List<Integer>> expectedSequenceList = Arrays.asList(
                Arrays.asList(2, 10, 50)
        );

        List<List<Integer>> actualSequenceList = sequencesHelper.findSequences(
                Arrays.asList(2, 1, 1 , 1, 1, 10, 1, 1, 1, 1, 50)
        );

        assertThat(actualSequenceList, hasSize(1));
        assertThat(actualSequenceList, is(expectedSequenceList));
    }

    @Test
    public void testListWithTwoSequences() {
        SequencesHelper sequencesHelper = new SequencesHelper();

        List<List<Integer>> expectedSequenceList = Arrays.asList(
                Arrays.asList(2, 4, 8),
                Arrays.asList(3, 9, 27));

        List<List<Integer>> actualSequenceList = sequencesHelper.findSequences(
                Arrays.asList(2, 10, 4, 3, 8, 6, 9, 9, 18, 27)
        );

        assertThat(actualSequenceList, hasSize(2));
        assertThat(actualSequenceList, is(expectedSequenceList));
    }

    @Test
    public void testFinalList() {
        SequencesHelper sequencesHelper = new SequencesHelper();

        List<List<Integer>> expectedSequenceList = Arrays.asList(
                Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128),
                Arrays.asList(3, 9, 27, 81),
                Arrays.asList(1, 4, 16, 64));

        List<List<Integer>> actualSequenceList = sequencesHelper.findSequences(
                Arrays.asList(
                        2, 10, 4, 3, 8, 6, 9, 9, 18, 27, 1, 52, 81, 10, 1, 0, 2, 0, 4, 0, 8, 0, 16,
                        0, 32, 0, 64, 0, 128, 2, 10, 4, 3, 8, 6, 9, 9, 1, 8, 27, 1, 52, 81, 10, 100,
                        50, 0, 0, 0, 0, 0, 0)
        );

        assertThat(actualSequenceList, hasSize(3));
        assertThat(actualSequenceList, is(expectedSequenceList));
    }

}
