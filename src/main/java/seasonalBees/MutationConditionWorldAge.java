package seasonalBees;

import forestry.api.climate.IClimateProvider;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutationCondition;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MutationConditionWorldAge implements IMutationCondition{

	int day;
	public MutationConditionWorldAge(int day) {
		this.day=day;
	}
	
	@Override
	public float getChance(World world, BlockPos pos, IAllele allele0, IAllele allele1, IGenome genome0,
			IGenome genome1, IClimateProvider climate) {
		//get amount of days passed
		int date=(int)(world.getWorldTime()/Config.dayLenght);
		//get day of the year
		date%=Config.yearlenght;
		if(date==day){
			return 1F;
		}else
			return 0F;
	}

	@Override
	public String getDescription() {
		return "Only during the "+day+"th day of the year (of "+Config.yearlenght+ "days)";
	}

}
