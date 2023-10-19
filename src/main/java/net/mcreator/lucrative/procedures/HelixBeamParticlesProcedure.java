package net.mcreator.lucrative.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class HelixBeamParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.GLOW_SQUID_INK, x, y, z, 2, 0.1, 0.1, 0.1, 0.1);
	}
}
