package com.java.guessoutput;

import java.util.HashMap;
import java.util.Map;

public class GuessOutputMain {
    public static void main(String[] args) {
        MapGuessOutput mapGuessOutput = new MapGuessOutput("Kunal", 29);
        Map<MapGuessOutput, String> map1 = new HashMap<>();

        map1.put(mapGuessOutput, "Verified");
        //mapGuessOutput.setName("LANUK");

        System.out.println(map1.get(mapGuessOutput));

        /*We have implemented Employee’s hashcode and equals method using name and age attributes,
         so when you put emp1 as key in hashmap, it will use hashcode and equals method and will be put in HashMap.
        After putting emp1 in HashMop, we have changed name of the employee, so when you will try
        to retrieve element from HashMap using hm.get(emp1), you won’t be able to get object which we have put
        earlier and it will return null.
*/
    }
}
