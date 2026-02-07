// Given a integer array of unknown size, where the numbers in the dictionary are sorted in ascending order, 
// determine if a given target integer is in the dictionary. Return the index of target in A, return -1 if 
// target is not in A.

// Assumptions
// UnknownSizeArray array is not null
// UnknownSizeArray.get(i) will return null(Java) if index i is out of bounds

// Examples
// A = {1, 2, 5, 9, ......}, T = 5, return 2
// A = {1, 2, 5, 9, 12, ......}, T = 7, return -1

import java.util.ArrayList;
import java.util.List;

public class SearchInUnknownSizeSortedArray {
    public int search(UnknownSizeArray array, int target) {
        return -1;
    }

    static class UnknownSizeArray {
        private List<Integer> _myList;
        
        public UnknownSizeArray(int size) {
            _myList = new ArrayList<>(size);
        }

        public Integer get(int index) {
            if (index >=  _myList.size()) {
                return null;
            }

            return _myList.get(index);
        }
    }
}