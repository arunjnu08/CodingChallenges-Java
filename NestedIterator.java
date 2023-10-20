/*
https://leetcode.com/problems/flatten-nested-list-iterator/?envType=daily-question&envId=2023-10-20
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int curInx;

    private void fillList(List<NestedInteger> nestedList) {
        for(NestedInteger node : nestedList) {
            if(node.isInteger()) list.add(node.getInteger());
            else fillList(node.getList());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        fillList(nestedList);
        curInx = 0;
    }

    @Override
    public Integer next() {
        return list.get(curInx++);
    }

    @Override
    public boolean hasNext() {
        return curInx < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
