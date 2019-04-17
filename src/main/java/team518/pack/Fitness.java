package team518.pack;
import java.util.*;

public class Fitness {
	public static double fit(Individual individual, Mine mine){
		double fitness;
		double d;
		double x = individual.getxPosition(), y = individual.getyPosition(),z=individual.getzPosition (),
				X = mine.getxPosition(), Y = mine.getyPosition(), Z=mine.getzPosition ();
		double x_d = X-x;
		double y_d = Y-y;
		double z_d = Z-z;
		d = Math.sqrt (Math.pow (x_d,2)+Math.pow (y_d,2)+Math.pow (z_d,2));
		fitness = 1/(mine.getRadiation ()/(d*d)); //Smallest is the best fitted
		//!!!!! ----- Also change the direction in selecting step if apply the next line ----- !!!!!
		//fitness = mine.getRadiation ()/(d*d); //Largest is the best fitted
		return fitness;
	}

	public static double fit(Individual individual, Mine[] mine){
		List<Double> fitness = new ArrayList<> ();
		for(Mine m:mine) {
//			System.out.println (fit (individual, m));
			fitness.add (fit (individual, m));

		}
		//Collections.sort (fitness,(Double a, Double b)->{return Double.compare (b,a);});
		Collections.sort(fitness);
		//individual.setFitness (fitness.get (0));
		return fitness.get(0);
	}

}
