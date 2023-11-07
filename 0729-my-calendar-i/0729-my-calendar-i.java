// class MyCalendar {
//     TreeMap<Integer, Integer> map;

//     public MyCalendar() {
//         map = new TreeMap<>();
//     }
    
//     public boolean book(int start, int end) {
//         map.put(start, map.getOrDefault(start, 0)+1);
//         map.put(end, map.getOrDefault(end, 0)-1);

//         int count=0;

//         for(int entry: map.keySet()){
//             count += map.get(entry);

//             if(count > 1){
//                 map.put(start, map.get(start)-1);
//                 map.put(end, map.get(end)+1);
//                 return false;
//             }
//         }
//         return true;
//     }
// }

public class MyCalendar {
    private final TreeMap<Integer, Integer> pairs;

    public MyCalendar() {
        pairs = new TreeMap<>();
    }

    // Method to book events
    public boolean book(int start, int end) {
        // Check for the closest event that ends before the new event starts
        Integer lower = pairs.lowerKey(end);   
        /**
        [10, 20], [15, 25] => here lower = pairs.lowerKey(25) => 20 & 20 <= 15(false) so conflict will happen
         */
        // Check for conflicts and book the event if no conflict exists
        if (lower == null || pairs.get(lower) <= start) {
            pairs.put(start, end); // Book the event
            return true; // Event booked successfully
        }
        return false; // There is a conflict, and the event cannot be booked
    }

}