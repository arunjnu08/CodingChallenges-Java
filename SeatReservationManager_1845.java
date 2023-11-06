// https://leetcode.com/problems/seat-reservation-manager/description/?envType=daily-question&envId=2023-11-06

class SeatManager {
    PriorityQueue<Integer> pq;
    int last;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        last = 0;
    }
    
    public int reserve() {
        if(!pq.isEmpty()) {
            return pq.poll();
        }
        return ++last;
    }
    
    public void unreserve(int seatNumber) {
        if(seatNumber == last) {
            last--;
        } else {
            pq.offer(seatNumber);
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
