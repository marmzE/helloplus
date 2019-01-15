package hello;

import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class App {
	private static final Logger LOG= Logger.getLogger(App.class.getName());
	
	public static void main(String[] args){
		String filename = null;
		//options
		
		Options options = new Options();
		Option input = new Option("i","input", true,"nom du fichier .csv contenant la liste des données");
		input.setRequired(true);
		options.addOption(input);
		//parser une ligne de commande
		CommandLineParser parser = new DefaultParser();
		try{
			CommandLine line = parser.parse(options, args);
			if(line.hasOption("i")){
				filename = line.getOptionValue("i");
			}
		}
		catch(ParseException exp){
			LOG.severe("Erreur dans la ligne de commande");
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("App",options);
			System.exit(1);
		}
		
		
		
		
	}
}
