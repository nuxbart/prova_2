
/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int START = 1000;
	private static final int END = 2000;
	private static final int ADD_EL = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int READS = 10_000;
	
	private static final long AFRICA = 1_110_635_000;
	private static final long AMERICAS =  972_005_000;
	private static final long ANTARCTICA = 0;
	private static final long ASIA = 742_452_000;
	private static final long EUROPE = 742_452_000;
	private static final long OCEANIA = 38_304_000;
	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> a1 = new ArrayList<>();
    	for (int i = START; i < END; i++ ) {
    		a1.add(i);
    	}
    	/*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> l1 = new LinkedList<>(a1);
    	System.out.println(l1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	 final int el = a1.get(a1.size() -1);
    	 a1.set(a1.size() - 1, a1.get(0));
    	 a1.set(0, el);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (int i : a1) {
    		System.out.println(" n= " + i + ", ");
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	for (int i = 0; i < ADD_EL; i++) {
    		a1.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Inserting " + ADD_EL
    			+ " in the ArrayList a1 took " + time 
    			+ "ns(" + time / TO_MS + "ms)");
    	time = System.nanoTime();
    	for ( int i = 0; i < ADD_EL; i++) {
    		l1.add(0, i);
    	}
    	time = System.nanoTime() - time ;
    	System.out.println("Inserting " + ADD_EL + "into the List l1 took "
    			+ time +"ns ("+ time / TO_MS+"ms)");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	time = System.nanoTime();
    	for (int i = 0; i < READS; i++) {
    		a1.get(a1.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Reading " + READS + "times the element whose position is in te middle took " 
    	          + time + "ns(" + time / TO_MS + "ms)");
    	time = System.nanoTime();
    	for (int i = 0; i< READS; i++) {
    		l1.get(l1.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Reading " + READS + " times the element whose position is in the middle took "
    			   + time + "ns(" + time / TO_MS + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	final Map<String, Long> map= new HashMap<>();
    	map.put("Africa", AFRICA);
    	map.put("Americas", AMERICAS);
    	map.put("Antarctica", ANTARCTICA);
    	map.put("Asia",ASIA);
    	map.put("Europe", EUROPE);
    	map.put("Oceania", OCEANIA);
        /*
         * 8) Compute the population of the world
         */
    	//come ho fatto io => final long total_pop = AFRICA + AMERICAS + ANTARCTICA + ASIA + EUROPE +OCEANIA;
    	long tot_pop = 0;
    	for (final long population : map.values()) {
    		tot_pop += population;
    	}
    	System.out.println("The total amount of the popuation is " + tot_pop);
    }
}
