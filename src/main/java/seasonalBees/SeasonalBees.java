package seasonalBees;

import java.io.File;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.genetics.AlleleManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=SeasonalBees.MODID, name=SeasonalBees.NAME, version=SeasonalBees.VERSION, dependencies="after:forestry")
public class SeasonalBees {

	public static final String MODID = "seasonal_bees";
    public static final String NAME = "Seasonal Bees";
    public static final String VERSION = "1.0";
	
    public static Configuration config;
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent e){
    	File file=e.getModConfigurationDirectory();
    	config=new Configuration(new File(file.getPath(),"seasonal_bees.cfg"));
    	Config.readcfg();
    }
    @EventHandler
    public static void init(FMLInitializationEvent e){
    	BeeManager.beeMutationFactory.createMutation((IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesWintry"), (IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesMeadows"), BeeManager.beeRoot.getTemplate("forestry.speciesTipsy"), 10).addMutationCondition(new MutationConditionWorldAge(Config.newYear));
    	BeeManager.beeMutationFactory.createMutation((IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesMeadows"), (IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesForest"), BeeManager.beeRoot.getTemplate("forestry.speciesLeporine"), 10).addMutationCondition(new MutationConditionWorldAge(Config.easter));
    	BeeManager.beeMutationFactory.createMutation((IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesSinister"), (IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesCommon"), BeeManager.beeRoot.getTemplate("forestry.speciesTricky"), 10).addMutationCondition(new MutationConditionWorldAge(Config.halloween));
    	BeeManager.beeMutationFactory.createMutation((IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesWintry"), (IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele("forestry.speciesForest"), BeeManager.beeRoot.getTemplate("forestry.speciesMerry"), 10).addMutationCondition(new MutationConditionWorldAge(Config.xmas));
    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent e){
    	if(config.hasChanged()){
			config.save();
		}
    }
    
}
