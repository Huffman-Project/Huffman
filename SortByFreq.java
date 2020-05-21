import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortByFreq {
	Map<Character,Integer> map ;

	public SortByFreq(Map<Character, Integer> map) {
		this.map = map;
	}
	
	
	
	public Map<Character, Integer> sortByValue() {

        //on va convertir notre map
        List< Map.Entry<Character, Integer> > list = new LinkedList< Map.Entry<Character, Integer> > ( map.entrySet() );


        //apres on faire le tri
        Collections.sort( list, new Comparator< Map.Entry<Character, Integer> >() {
            public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return ( o1.getValue() ).compareTo( o2.getValue() );
            }
        });

        //creer nouveau map
        Map<Character, Integer> newMap = new LinkedHashMap<Character, Integer>();
        
        for (Map.Entry<Character, Integer> entry : list) {
        	newMap.put(entry.getKey(), entry.getValue());
        }


        return newMap;
    }
	
}
