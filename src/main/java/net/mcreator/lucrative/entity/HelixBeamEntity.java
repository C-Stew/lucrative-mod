
package net.mcreator.lucrative.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.lucrative.procedures.HelixBeamParticlesProcedure;
import net.mcreator.lucrative.procedures.HelixBeamEffectProcedure;
import net.mcreator.lucrative.init.LucrativeModItems;
import net.mcreator.lucrative.init.LucrativeModEntities;

import java.util.Random;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class HelixBeamEntity extends AbstractArrow implements ItemSupplier {
	public HelixBeamEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(LucrativeModEntities.HELIX_BEAM.get(), world);
	}

	public HelixBeamEntity(EntityType<? extends HelixBeamEntity> type, Level world) {
		super(type, world);
	}

	public HelixBeamEntity(EntityType<? extends HelixBeamEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public HelixBeamEntity(EntityType<? extends HelixBeamEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(LucrativeModItems.HELIX_BEAM.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		HelixBeamEffectProcedure.execute(entityHitResult.getEntity());
	}

	@Override
	public void tick() {
		super.tick();
		HelixBeamParticlesProcedure.execute(this.level, this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static HelixBeamEntity shoot(Level world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		HelixBeamEntity entityarrow = new HelixBeamEntity(LucrativeModEntities.HELIX_BEAM.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static HelixBeamEntity shoot(LivingEntity entity, LivingEntity target) {
		HelixBeamEntity entityarrow = new HelixBeamEntity(LucrativeModEntities.HELIX_BEAM.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 4f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(1);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
