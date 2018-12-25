package seasonalBees;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static int dayLenght=24000, yearlenght=96, newYear=0, easter=25, halloween=79, xmas=93;
	
	public static void readcfg(){
		Configuration cfg=SeasonalBees.config;
		try{
			cfg.load();
			initCfg(cfg);
		} catch(Exception e){
			System.out.println("Seasonal Bees mod could not load configs");
		} finally{
			if(cfg.hasChanged()){
				cfg.save();
			}
		}
	}
	
	public static void initCfg(Configuration cfg){
		cfg.addCustomCategoryComment("DATES", "time config");
		dayLenght=cfg.getInt("DayLenght", "DATES", 24000, 1, Integer.MAX_VALUE, "The duration of 1 minecraft day in case you have a mod that changes it");
		yearlenght=cfg.getInt("YearLenght", "DATES", 96, 1, Integer.MAX_VALUE, "The amount of days in a year. Default is 8 days * 12 months. Make sure it matches with your season mod");
		newYear=cfg.getInt("NewYear", "DATES", 0, 0, Integer.MAX_VALUE, "The date of the New Year. By definition this should be 0 but the minecraft day begins at sunrise rather than midnight so you might want to set it to the last day");
		easter=cfg.getInt("Easter", "DATES", 25, 0, Integer.MAX_VALUE, "The date of Easter. If your month lenght does not match the moon cycle then good luck setting this");
		halloween=cfg.getInt("Halloween", "DATES", 79, 0, Integer.MAX_VALUE, "The date of halloween");
		xmas=cfg.getInt("Christmas", "DATES", 93, 0, Integer.MAX_VALUE, "The date of Christmas [also known as Coke Cola day for pagans(which is ironic since bad kids get coal but Coke Cola is made from coal)]");
	}

}
